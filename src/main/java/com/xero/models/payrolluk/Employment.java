/*
 * Xero Payroll UK
 * This is the Xero Payroll API for orgs in the UK region.
 *
 * The version of the OpenAPI document: 2.2.9
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

/** Employment */
public class Employment {
  StringUtil util = new StringUtil();

  @JsonProperty("payrollCalendarID")
  private UUID payrollCalendarID;

  @JsonProperty("startDate")
  private LocalDate startDate;

  @JsonProperty("employeeNumber")
  private String employeeNumber;
  /** The NI Category of the employee */
  public enum NiCategoryEnum {
    A("A"),

    B("B"),

    C("C"),

    H("H"),

    J("J"),

    M("M"),

    Z("Z"),

    X("X");

    private String value;

    NiCategoryEnum(String value) {
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
    public static NiCategoryEnum fromValue(String value) {
      for (NiCategoryEnum b : NiCategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("niCategory")
  private NiCategoryEnum niCategory;

  public Employment payrollCalendarID(UUID payrollCalendarID) {
    this.payrollCalendarID = payrollCalendarID;
    return this;
  }

  /**
   * Xero unique identifier for the payroll calendar of the employee
   *
   * @return payrollCalendarID
   */
  @ApiModelProperty(value = "Xero unique identifier for the payroll calendar of the employee")
  public UUID getPayrollCalendarID() {
    return payrollCalendarID;
  }

  public void setPayrollCalendarID(UUID payrollCalendarID) {
    this.payrollCalendarID = payrollCalendarID;
  }

  public Employment startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Start date of the employment (YYYY-MM-DD)
   *
   * @return startDate
   */
  @ApiModelProperty(value = "Start date of the employment (YYYY-MM-DD)")
  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public Employment employeeNumber(String employeeNumber) {
    this.employeeNumber = employeeNumber;
    return this;
  }

  /**
   * The employment number of the employee
   *
   * @return employeeNumber
   */
  @ApiModelProperty(example = "7", value = "The employment number of the employee")
  public String getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(String employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public Employment niCategory(NiCategoryEnum niCategory) {
    this.niCategory = niCategory;
    return this;
  }

  /**
   * The NI Category of the employee
   *
   * @return niCategory
   */
  @ApiModelProperty(example = "A", value = "The NI Category of the employee")
  public NiCategoryEnum getNiCategory() {
    return niCategory;
  }

  public void setNiCategory(NiCategoryEnum niCategory) {
    this.niCategory = niCategory;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employment employment = (Employment) o;
    return Objects.equals(this.payrollCalendarID, employment.payrollCalendarID)
        && Objects.equals(this.startDate, employment.startDate)
        && Objects.equals(this.employeeNumber, employment.employeeNumber)
        && Objects.equals(this.niCategory, employment.niCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payrollCalendarID, startDate, employeeNumber, niCategory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employment {\n");
    sb.append("    payrollCalendarID: ").append(toIndentedString(payrollCalendarID)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    employeeNumber: ").append(toIndentedString(employeeNumber)).append("\n");
    sb.append("    niCategory: ").append(toIndentedString(niCategory)).append("\n");
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
