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

/** Account */
public class Account {
  StringUtil util = new StringUtil();

  @JsonProperty("accountID")
  private UUID accountID;
  /** The assigned AccountType */
  public enum TypeEnum {
    BANK("BANK"),

    EMPLOYERSNIC("EMPLOYERSNIC"),

    NICLIABILITY("NICLIABILITY"),

    PAYEECONTRIBUTION("PAYEECONTRIBUTION"),

    PAYELIABILITY("PAYELIABILITY"),

    WAGESPAYABLE("WAGESPAYABLE"),

    WAGESEXPENSE("WAGESEXPENSE");

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

  @JsonProperty("code")
  private String code;

  @JsonProperty("name")
  private String name;

  public Account accountID(UUID accountID) {
    this.accountID = accountID;
    return this;
  }

  /**
   * The Xero identifier for Settings.
   *
   * @return accountID
   */
  @ApiModelProperty(value = "The Xero identifier for Settings.")
  public UUID getAccountID() {
    return accountID;
  }

  public void setAccountID(UUID accountID) {
    this.accountID = accountID;
  }

  public Account type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The assigned AccountType
   *
   * @return type
   */
  @ApiModelProperty(value = "The assigned AccountType")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Account code(String code) {
    this.code = code;
    return this;
  }

  /**
   * A unique 3 digit number for each Account
   *
   * @return code
   */
  @ApiModelProperty(value = "A unique 3 digit number for each Account")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Account name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Account.
   *
   * @return name
   */
  @ApiModelProperty(value = "Name of the Account.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.accountID, account.accountID)
        && Objects.equals(this.type, account.type)
        && Objects.equals(this.code, account.code)
        && Objects.equals(this.name, account.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountID, type, code, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    sb.append("    accountID: ").append(toIndentedString(accountID)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
