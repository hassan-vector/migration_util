/* Copyright Vector Technology Services LTD - All Rights Reserved
 *
 * Unauthorized copying of this file or derived binaries, via any medium, is strictly prohibited unless express written
 * consent is given
 *
 * All content is deemed proprietary and confidential
 *
 * Contact Vector LTD legal at "legalservices@vector.co.nz" for more information or to report a breach
 */
package co.nz.vector.migration.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAccessor;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class OffsetDateTimeConverter implements DynamoDBTypeConverter<String, OffsetDateTime> {

    @Override
    public String convert(
            final OffsetDateTime dateTime
    ) {
        return ISO_OFFSET_DATE_TIME.format(dateTime.withOffsetSameInstant(ZoneOffset.UTC));
    }

    @Override
    public OffsetDateTime unconvert(
            final String dateTime
    ) {
        final TemporalAccessor temporalAccessor = ISO_OFFSET_DATE_TIME.parse(dateTime);
        return OffsetDateTime.from(temporalAccessor);
    }


    public static void main(String[] args){
        OffsetDateTimeConverter converter = new OffsetDateTimeConverter();
        String date = "2022-06-15T12:00:00Z";
        OffsetDateTime offsetDate = converter.unconvert(date);
        String resultDate = converter.convert( offsetDate);
        System.out.println(resultDate);
        offsetDate = converter.unconvert(resultDate);
        System.out.println(offsetDate);
    }


}
