/*
 * Accounting API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 2.2.9
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.accounting;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** BankTransfers */
public class BankTransfers {
  StringUtil util = new StringUtil();

  @JsonProperty("BankTransfers")
  private List<BankTransfer> bankTransfers = new ArrayList<BankTransfer>();

  public BankTransfers bankTransfers(List<BankTransfer> bankTransfers) {
    this.bankTransfers = bankTransfers;
    return this;
  }

  public BankTransfers addBankTransfersItem(BankTransfer bankTransfersItem) {
    if (this.bankTransfers == null) {
      this.bankTransfers = new ArrayList<BankTransfer>();
    }
    this.bankTransfers.add(bankTransfersItem);
    return this;
  }

  /**
   * Get bankTransfers
   *
   * @return bankTransfers
   */
  @ApiModelProperty(value = "")
  public List<BankTransfer> getBankTransfers() {
    return bankTransfers;
  }

  public void setBankTransfers(List<BankTransfer> bankTransfers) {
    this.bankTransfers = bankTransfers;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankTransfers bankTransfers = (BankTransfers) o;
    return Objects.equals(this.bankTransfers, bankTransfers.bankTransfers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankTransfers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankTransfers {\n");
    sb.append("    bankTransfers: ").append(toIndentedString(bankTransfers)).append("\n");
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
