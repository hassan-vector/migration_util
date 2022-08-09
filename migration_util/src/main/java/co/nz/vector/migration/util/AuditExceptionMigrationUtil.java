package co.nz.vector.migration.util;

import co.nz.vector.migration.entity.AuditException;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.time.OffsetDateTime;
import java.util.*;

public class AuditExceptionMigrationUtil {

    static final String DEVICE_ID_VALUE = "999999999-vector-30-min-electricity";

    public static void main(String[] args) {

        final String usage = "\n" +
                "Usage:\n" +
                "    <tableName>\n\n" +
                "Where:\n" +
                "    tableName - The Amazon DynamoDB table to get information from (for example, Music3).\n\n" ;

        if (args.length != 1) {
            System.out.println(usage);
            System.exit(1);
        }

        String tableName = args[0];


        ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create();
        Region region = Region.AP_SOUTHEAST_2;
        DynamoDbClient ddbClient = DynamoDbClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(region)
                .build();

        System.out.println("---- START TIME:" + new Date());
        List<AuditException> records = scanItems(ddbClient,tableName);

        System.out.println ("The total records fetched : "+ records.size());
        System.out.println ("Updating Now, Please wait for end ...");

       records.forEach(i -> updateTableItem(ddbClient, tableName,"AuditId",
                i.getAuditId(),new String[]{"UnitOfWorkDate", "UnitOfWorkDateTime"},
                 getUnitOfWorkDate(i.getUnitOfWorkDateTime())));

        ddbClient.close();
        System.out.println("---- END TIME:" + new Date());
    }

    // snippet-start:[dynamodb.java2.dynamoDB_scan.main]
    public static List<AuditException> scanItems(DynamoDbClient ddb, String tableName ) {

        List<AuditException> exceptions = new ArrayList<>();
        Map<String, AttributeValue> lastKeyEvaluated = null;

        try {
            Map<String, AttributeValue> deviceAttributeVal = new HashMap<String, AttributeValue>();
            deviceAttributeVal.put(":id", AttributeValue.builder().s(DEVICE_ID_VALUE).build());

            do {
                ScanRequest scanRequest = ScanRequest.builder()
                        .tableName(tableName)
                        .filterExpression("attribute_not_exists(UnitOfWorkDateTime)")
                        //.filterExpression("DeviceId = :id")
                        //.expressionAttributeValues(deviceAttributeVal)
                        .exclusiveStartKey(lastKeyEvaluated)
                        .build();

                ScanResponse response = ddb.scan(scanRequest);

                for (Map<String, AttributeValue> item : response.items()) {
                    Set<String> keys = item.keySet();

                    for (String key : keys) {
                        if ("ActionDescription".equals(key)) {
                            AuditException exception = new ObjectMapper().readValue(item.get(key).s(), AuditException.class);
                          //  System.out.println("The audit id , unit of work datetime is: " + item.get("AuditId").s() + " : " + exception.getUnitOfWorkDateTime());
                            exception.setAuditId(item.get("AuditId").s());
                            exceptions.add(exception);
                        }
                    }
                }
                lastKeyEvaluated = response.lastEvaluatedKey();
            }while (!(lastKeyEvaluated == null || lastKeyEvaluated.isEmpty()));

        } catch (DynamoDbException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Exception:" + e.getMessage());
        }

        return exceptions;
    }

    public static void updateTableItem(DynamoDbClient ddb,
                                       String tableName,
                                       String key,
                                       String keyVal,
                                       String[] name,
                                       String updateVal){

        HashMap<String,AttributeValue> itemKey = new HashMap<>();
        itemKey.put(key, AttributeValue.builder()
                .s(keyVal)
                .build());

        HashMap<String,AttributeValueUpdate> updatedValues = new HashMap<>();
        updatedValues.put(name[0], AttributeValueUpdate.builder()
                .value(AttributeValue.builder().s(updateVal).build())
                .action(AttributeAction.PUT)
                .build());

        updatedValues.put(name[1], AttributeValueUpdate.builder()
                .value(AttributeValue.builder().s(updateVal).build())
                .action(AttributeAction.PUT)
                .build());

        UpdateItemRequest request = UpdateItemRequest.builder()
                .tableName(tableName)
                .key(itemKey)
                .attributeUpdates(updatedValues)
                .build();

        try {
            ddb.updateItem(request);
        } catch (Exception e) {
            System.err.println("The Amazon DynamoDB table failed on update auditId=" + key);
        }

    }

    private static String getUnitOfWorkDate(String date) {
        OffsetDateTimeConverter converter = new OffsetDateTimeConverter();
        OffsetDateTime offsetDate = converter.unconvert(date);
        String resultDate = converter.convert( offsetDate);
        return resultDate;
    }
}