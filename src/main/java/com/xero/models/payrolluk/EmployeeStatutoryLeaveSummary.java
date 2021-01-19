/*
 * Xero Payroll UK
 * This is the Xero Payroll API for orgs in the UK region.
 *
 * The version of the OpenAPI document: 2.8.2
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.payrolluk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.UUID;
import org.threeten.bp.LocalDate;

/** EmployeeStatutoryLeaveSummary */
public class EmployeeStatutoryLeaveSummary {
  StringUtil util = new StringUtil();

  @JsonProperty("statutoryLeaveID")
  private UUID statutoryLeaveID;

  @JsonProperty("employeeID")
  private UUID employeeID;
  /** The category of statutory leave */
  public enum TypeEnum {
    SICK("Sick"),

    ADOPTION("Adoption"),

    MATERNITY("Maternity"),

    PATERNITY("Paternity"),

    SHAREDPARENTAL("Sharedparental");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  @JsonProperty("startDate")
  private LocalDate startDate;

  @JsonProperty("endDate")
  private LocalDate endDate;

  @JsonProperty("isEntitled")
  private Boolean isEntitled;
  /** The status of the leave */
  public enum StatusEnum {
    PENDING("Pending"),

    IN_PROGRESS("In-Progress"),

    COMPLETED("Completed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  public EmployeeStatutoryLeaveSummary statutoryLeaveID(UUID statutoryLeaveID) {
    this.statutoryLeaveID = statutoryLeaveID;
    return this;
  }

  /**
   * The unique identifier (guid) of a statutory leave.
   *
   * @return statutoryLeaveID
   */
  @ApiModelProperty(value = "The unique identifier (guid) of a statutory leave.")
  public UUID getStatutoryLeaveID() {
    return statutoryLeaveID;
  }

  public void setStatutoryLeaveID(UUID statutoryLeaveID) {
    this.statutoryLeaveID = statutoryLeaveID;
  }

  public EmployeeStatutoryLeaveSummary employeeID(UUID employeeID) {
    this.employeeID = employeeID;
    return this;
  }

  /**
   * The unique identifier (guid) of the employee
   *
   * @return employeeID
   */
  @ApiModelProperty(value = "The unique identifier (guid) of the employee")
  public UUID getEmployeeID() {
    return employeeID;
  }

  public void setEmployeeID(UUID employeeID) {
    this.employeeID = employeeID;
  }

  public EmployeeStatutoryLeaveSummary type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The category of statutory leave
   *
   * @return type
   */
  @ApiModelProperty(value = "The category of statutory leave")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public EmployeeStatutoryLeaveSummary startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The date when the leave starts
   *
   * @return startDate
   */
  @ApiModelProperty(value = "The date when the leave starts")
  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public EmployeeStatutoryLeaveSummary endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * The date when the leave ends
   *
   * @return endDate
   */
  @ApiModelProperty(value = "The date when the leave ends")
  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public EmployeeStatutoryLeaveSummary isEntitled(Boolean isEntitled) {
    this.isEntitled = isEntitled;
    return this;
  }

  /**
   * Whether the leave was entitled to receive payment
   *
   * @return isEntitled
   */
  @ApiModelProperty(value = "Whether the leave was entitled to receive payment")
  public Boolean getIsEntitled() {
    return isEntitled;
  }

  public void setIsEntitled(Boolean isEntitled) {
    this.isEntitled = isEntitled;
  }

  public EmployeeStatutoryLeaveSummary status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the leave
   *
   * @return status
   */
  @ApiModelProperty(value = "The status of the leave")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeStatutoryLeaveSummary employeeStatutoryLeaveSummary = (EmployeeStatutoryLeaveSummary) o;
    return Objects.equals(this.statutoryLeaveID, employeeStatutoryLeaveSummary.statutoryLeaveID)
        && Objects.equals(this.employeeID, employeeStatutoryLeaveSummary.employeeID)
        && Objects.equals(this.type, employeeStatutoryLeaveSummary.type)
        && Objects.equals(this.startDate, employeeStatutoryLeaveSummary.startDate)
        && Objects.equals(this.endDate, employeeStatutoryLeaveSummary.endDate)
        && Objects.equals(this.isEntitled, employeeStatutoryLeaveSummary.isEntitled)
        && Objects.equals(this.status, employeeStatutoryLeaveSummary.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statutoryLeaveID, employeeID, type, startDate, endDate, isEntitled, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeStatutoryLeaveSummary {\n");
    sb.append("    statutoryLeaveID: ").append(toIndentedString(statutoryLeaveID)).append("\n");
    sb.append("    employeeID: ").append(toIndentedString(employeeID)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    isEntitled: ").append(toIndentedString(isEntitled)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
