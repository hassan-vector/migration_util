package co.nz.vector.migration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class AuditException {

  @JsonIgnore
  private String auditId;

  @JsonIgnore
  private String version;

  @JsonIgnore
  private String actionDetails;

  private String exceptionId;

  private String deviceId;

  private String serialNumber;

  private String connectionPointId;

  private String unitOfWorkId;

  private String exceptionType;

  private String exceptionMessage;

  private String raisedDateTime;

  private String unitOfWorkDateTime;

  private String dataDay;

  private String resolved;

  private String resolutionReason;

  private String status;

  private String manufacturer;

  private String commodity;

  private String intent;

  private String assignedTo;

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getActionDetails() {
    return actionDetails;
  }

  public String getAuditId() {
    return auditId;
  }

  public void setAuditId(String auditId) {
    this.auditId = auditId;
  }

  public void setActionDetails(String actionDetails) {
    this.actionDetails = actionDetails;
  }

  /**
   **/
  @JsonProperty("exceptionId")
  public String getExceptionId() {
    return exceptionId;
  }
  public void setExceptionId(String exceptionId) {
    this.exceptionId = exceptionId;
  }

  /**
   **/
  
  @JsonProperty("deviceId")
  public String getDeviceId() {
    return deviceId;
  }
  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  /**
   **/
  
  @JsonProperty("serialNumber")
  public String getSerialNumber() {
    return serialNumber;
  }
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   **/
  
  @JsonProperty("connectionPointId")
  public String getConnectionPointId() {
    return connectionPointId;
  }
  public void setConnectionPointId(String connectionPointId) {
    this.connectionPointId = connectionPointId;
  }

  /**
   **/
  
  @JsonProperty("unitOfWorkId")
  public String getUnitOfWorkId() {
    return unitOfWorkId;
  }
  public void setUnitOfWorkId(String unitOfWorkId) {
    this.unitOfWorkId = unitOfWorkId;
  }

  /**
   **/
  
  @JsonProperty("exceptionType")
  public String getExceptionType() {
    return exceptionType;
  }
  public void setExceptionType(String exceptionType) {
    this.exceptionType = exceptionType;
  }

  /**
   **/
  
  @JsonProperty("exceptionMessage")
  public String getExceptionMessage() {
    return exceptionMessage;
  }
  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  /**
   **/
  
  @JsonProperty("raisedDateTime")
  public String getRaisedDateTime() {
    return raisedDateTime;
  }
  public void setRaisedDateTime(String raisedDateTime) {
    this.raisedDateTime = raisedDateTime;
  }

  /**
   **/
  
  @JsonProperty("unitOfWorkDateTime")
  public String getUnitOfWorkDateTime() {
    return unitOfWorkDateTime;
  }
  public void setUnitOfWorkDateTime(String unitOfWorkDateTime) {
    this.unitOfWorkDateTime = unitOfWorkDateTime;
  }

  /**
   **/
  
  @JsonProperty("dataDay")
  public String getDataDay() {
    return dataDay;
  }
  public void setDataDay(String dataDay) {
    this.dataDay = dataDay;
  }

  /**
   **/
  
  @JsonProperty("resolved")
  public String getResolved() {
    return resolved;
  }
  public void setResolved(String resolved) {
    this.resolved = resolved;
  }

  /**
   **/
  
  @JsonProperty("resolutionReason")
  public String getResolutionReason() {
    return resolutionReason;
  }
  public void setResolutionReason(String resolutionReason) {
    this.resolutionReason = resolutionReason;
  }

  /**
   **/
  
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   **/
  
  @JsonProperty("manufacturer")
  public String getManufacturer() {
    return manufacturer;
  }
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   **/
  
  @JsonProperty("commodity")
  public String getCommodity() {
    return commodity;
  }
  public void setCommodity(String commodity) {
    this.commodity = commodity;
  }

  /**
   **/
  
  @JsonProperty("intent")
  public String getIntent() {
    return intent;
  }
  public void setIntent(String intent) {
    this.intent = intent;
  }

  /**
   **/
  
  @JsonProperty("assignedTo")
  public String getAssignedTo() {
    return assignedTo;
  }
  public void setAssignedTo(String assignedTo) {
    this.assignedTo = assignedTo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuditException exception = (AuditException) o;
    return Objects.equals(exceptionId, exception.exceptionId) &&
        Objects.equals(deviceId, exception.deviceId) &&
        Objects.equals(serialNumber, exception.serialNumber) &&
        Objects.equals(connectionPointId, exception.connectionPointId) &&
        Objects.equals(unitOfWorkId, exception.unitOfWorkId) &&
        Objects.equals(exceptionType, exception.exceptionType) &&
        Objects.equals(exceptionMessage, exception.exceptionMessage) &&
        Objects.equals(raisedDateTime, exception.raisedDateTime) &&
        Objects.equals(unitOfWorkDateTime, exception.unitOfWorkDateTime) &&
        Objects.equals(dataDay, exception.dataDay) &&
        Objects.equals(resolved, exception.resolved) &&
        Objects.equals(resolutionReason, exception.resolutionReason) &&
        Objects.equals(status, exception.status) &&
        Objects.equals(manufacturer, exception.manufacturer) &&
        Objects.equals(commodity, exception.commodity) &&
        Objects.equals(intent, exception.intent) &&
        Objects.equals(assignedTo, exception.assignedTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exceptionId, deviceId, serialNumber, connectionPointId, unitOfWorkId, exceptionType, exceptionMessage, raisedDateTime, unitOfWorkDateTime, dataDay, resolved, resolutionReason, status, manufacturer, commodity, intent, assignedTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Exception {\n");
    
    sb.append("    exceptionId: ").append(toIndentedString(exceptionId)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    connectionPointId: ").append(toIndentedString(connectionPointId)).append("\n");
    sb.append("    unitOfWorkId: ").append(toIndentedString(unitOfWorkId)).append("\n");
    sb.append("    exceptionType: ").append(toIndentedString(exceptionType)).append("\n");
    sb.append("    exceptionMessage: ").append(toIndentedString(exceptionMessage)).append("\n");
    sb.append("    raisedDateTime: ").append(toIndentedString(raisedDateTime)).append("\n");
    sb.append("    unitOfWorkDateTime: ").append(toIndentedString(unitOfWorkDateTime)).append("\n");
    sb.append("    dataDay: ").append(toIndentedString(dataDay)).append("\n");
    sb.append("    resolved: ").append(toIndentedString(resolved)).append("\n");
    sb.append("    resolutionReason: ").append(toIndentedString(resolutionReason)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
    sb.append("    commodity: ").append(toIndentedString(commodity)).append("\n");
    sb.append("    intent: ").append(toIndentedString(intent)).append("\n");
    sb.append("    assignedTo: ").append(toIndentedString(assignedTo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

