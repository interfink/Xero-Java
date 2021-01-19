/*
 * Xero Payroll AU
 * This is the Xero Payroll API for orgs in Australia region.
 *
 * The version of the OpenAPI document: 2.8.2
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.payrollau;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;

/** DeductionType */
public class DeductionType {
  StringUtil util = new StringUtil();

  @JsonProperty("Name")
  private String name;

  @JsonProperty("AccountCode")
  private String accountCode;

  @JsonProperty("ReducesTax")
  private Boolean reducesTax;

  @JsonProperty("ReducesSuper")
  private Boolean reducesSuper;

  @JsonProperty("IsExemptFromW1")
  private Boolean isExemptFromW1;

  @JsonProperty("DeductionTypeID")
  private UUID deductionTypeID;

  @JsonProperty("UpdatedDateUTC")
  private String updatedDateUTC;
  /** Gets or Sets deductionCategory */
  public enum DeductionCategoryEnum {
    NONE("NONE"),

    UNIONFEES("UNIONFEES"),

    WORKPLACEGIVING("WORKPLACEGIVING");

    private String value;

    DeductionCategoryEnum(String value) {
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
    public static DeductionCategoryEnum fromValue(String value) {
      for (DeductionCategoryEnum b : DeductionCategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("DeductionCategory")
  private DeductionCategoryEnum deductionCategory;

  @JsonProperty("CurrentRecord")
  private Boolean currentRecord;

  public DeductionType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the earnings rate (max length &#x3D; 100)
   *
   * @return name
   */
  @ApiModelProperty(example = "PTO", value = "Name of the earnings rate (max length = 100)")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeductionType accountCode(String accountCode) {
    this.accountCode = accountCode;
    return this;
  }

  /**
   * See Accounts
   *
   * @return accountCode
   */
  @ApiModelProperty(example = "720", value = "See Accounts")
  public String getAccountCode() {
    return accountCode;
  }

  public void setAccountCode(String accountCode) {
    this.accountCode = accountCode;
  }

  public DeductionType reducesTax(Boolean reducesTax) {
    this.reducesTax = reducesTax;
    return this;
  }

  /**
   * Indicates that this is a pre-tax deduction that will reduce the amount of tax you withhold from
   * an employee.
   *
   * @return reducesTax
   */
  @ApiModelProperty(
      example = "false",
      value =
          "Indicates that this is a pre-tax deduction that will reduce the amount of tax you"
              + " withhold from an employee.")
  public Boolean getReducesTax() {
    return reducesTax;
  }

  public void setReducesTax(Boolean reducesTax) {
    this.reducesTax = reducesTax;
  }

  public DeductionType reducesSuper(Boolean reducesSuper) {
    this.reducesSuper = reducesSuper;
    return this;
  }

  /**
   * Most deductions don’t reduce your superannuation guarantee contribution liability, so typically
   * you will not set any value for this.
   *
   * @return reducesSuper
   */
  @ApiModelProperty(
      example = "false",
      value =
          "Most deductions don’t reduce your superannuation guarantee contribution liability, so"
              + " typically you will not set any value for this.")
  public Boolean getReducesSuper() {
    return reducesSuper;
  }

  public void setReducesSuper(Boolean reducesSuper) {
    this.reducesSuper = reducesSuper;
  }

  public DeductionType isExemptFromW1(Boolean isExemptFromW1) {
    this.isExemptFromW1 = isExemptFromW1;
    return this;
  }

  /**
   * Boolean to determine if the deduction type is reportable or exempt from W1
   *
   * @return isExemptFromW1
   */
  @ApiModelProperty(
      example = "false",
      value = "Boolean to determine if the deduction type is reportable or exempt from W1")
  public Boolean getIsExemptFromW1() {
    return isExemptFromW1;
  }

  public void setIsExemptFromW1(Boolean isExemptFromW1) {
    this.isExemptFromW1 = isExemptFromW1;
  }

  public DeductionType deductionTypeID(UUID deductionTypeID) {
    this.deductionTypeID = deductionTypeID;
    return this;
  }

  /**
   * Xero identifier
   *
   * @return deductionTypeID
   */
  @ApiModelProperty(example = "e0eb6747-7c17-4075-b804-989f8d4e5d39", value = "Xero identifier")
  public UUID getDeductionTypeID() {
    return deductionTypeID;
  }

  public void setDeductionTypeID(UUID deductionTypeID) {
    this.deductionTypeID = deductionTypeID;
  }

  /**
   * Last modified timestamp
   *
   * @return updatedDateUTC
   */
  @ApiModelProperty(example = "/Date(1583967733054+0000)/", value = "Last modified timestamp")
  public String getUpdatedDateUTC() {
    return updatedDateUTC;
  }

  public OffsetDateTime getUpdatedDateUTCAsDate() {
    if (this.updatedDateUTC != null) {
      try {
        return util.convertStringToOffsetDateTime(this.updatedDateUTC);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public DeductionType deductionCategory(DeductionCategoryEnum deductionCategory) {
    this.deductionCategory = deductionCategory;
    return this;
  }

  /**
   * Get deductionCategory
   *
   * @return deductionCategory
   */
  @ApiModelProperty(value = "")
  public DeductionCategoryEnum getDeductionCategory() {
    return deductionCategory;
  }

  public void setDeductionCategory(DeductionCategoryEnum deductionCategory) {
    this.deductionCategory = deductionCategory;
  }

  public DeductionType currentRecord(Boolean currentRecord) {
    this.currentRecord = currentRecord;
    return this;
  }

  /**
   * Is the current record
   *
   * @return currentRecord
   */
  @ApiModelProperty(example = "true", value = "Is the current record")
  public Boolean getCurrentRecord() {
    return currentRecord;
  }

  public void setCurrentRecord(Boolean currentRecord) {
    this.currentRecord = currentRecord;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeductionType deductionType = (DeductionType) o;
    return Objects.equals(this.name, deductionType.name)
        && Objects.equals(this.accountCode, deductionType.accountCode)
        && Objects.equals(this.reducesTax, deductionType.reducesTax)
        && Objects.equals(this.reducesSuper, deductionType.reducesSuper)
        && Objects.equals(this.isExemptFromW1, deductionType.isExemptFromW1)
        && Objects.equals(this.deductionTypeID, deductionType.deductionTypeID)
        && Objects.equals(this.updatedDateUTC, deductionType.updatedDateUTC)
        && Objects.equals(this.deductionCategory, deductionType.deductionCategory)
        && Objects.equals(this.currentRecord, deductionType.currentRecord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name,
        accountCode,
        reducesTax,
        reducesSuper,
        isExemptFromW1,
        deductionTypeID,
        updatedDateUTC,
        deductionCategory,
        currentRecord);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeductionType {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
    sb.append("    reducesTax: ").append(toIndentedString(reducesTax)).append("\n");
    sb.append("    reducesSuper: ").append(toIndentedString(reducesSuper)).append("\n");
    sb.append("    isExemptFromW1: ").append(toIndentedString(isExemptFromW1)).append("\n");
    sb.append("    deductionTypeID: ").append(toIndentedString(deductionTypeID)).append("\n");
    sb.append("    updatedDateUTC: ").append(toIndentedString(updatedDateUTC)).append("\n");
    sb.append("    deductionCategory: ").append(toIndentedString(deductionCategory)).append("\n");
    sb.append("    currentRecord: ").append(toIndentedString(currentRecord)).append("\n");
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
