/*
 * Xero Finance API
 * The Finance API is a collection of endpoints which customers can use in the course of a loan application, which may assist lenders to gain the confidence they need to provide capital.
 *
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.threeten.bp.LocalDate;

/** BankTransactionResponse */
public class BankTransactionResponse {
  StringUtil util = new StringUtil();

  @JsonProperty("bankTransactionId")
  private UUID bankTransactionId;

  @JsonProperty("batchPaymentId")
  private UUID batchPaymentId;

  @JsonProperty("contact")
  private ContactResponse contact;

  @JsonProperty("date")
  private LocalDate date;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("lineItems")
  private List<LineItemResponse> lineItems = new ArrayList<LineItemResponse>();
  /**
   * Xero Identifier of transaction
   *
   * @param bankTransactionId UUID
   * @return BankTransactionResponse
   */
  public BankTransactionResponse bankTransactionId(UUID bankTransactionId) {
    this.bankTransactionId = bankTransactionId;
    return this;
  }

  /**
   * Xero Identifier of transaction
   *
   * @return bankTransactionId
   */
  @ApiModelProperty(value = "Xero Identifier of transaction")
  /**
   * Xero Identifier of transaction
   *
   * @return bankTransactionId UUID
   */
  public UUID getBankTransactionId() {
    return bankTransactionId;
  }

  /**
   * Xero Identifier of transaction
   *
   * @param bankTransactionId UUID
   */
  public void setBankTransactionId(UUID bankTransactionId) {
    this.bankTransactionId = bankTransactionId;
  }

  /**
   * Xero Identifier of batch payment. Present if the transaction is part of a batch.
   *
   * @param batchPaymentId UUID
   * @return BankTransactionResponse
   */
  public BankTransactionResponse batchPaymentId(UUID batchPaymentId) {
    this.batchPaymentId = batchPaymentId;
    return this;
  }

  /**
   * Xero Identifier of batch payment. Present if the transaction is part of a batch.
   *
   * @return batchPaymentId
   */
  @ApiModelProperty(
      value = "Xero Identifier of batch payment. Present if the transaction is part of a batch.")
  /**
   * Xero Identifier of batch payment. Present if the transaction is part of a batch.
   *
   * @return batchPaymentId UUID
   */
  public UUID getBatchPaymentId() {
    return batchPaymentId;
  }

  /**
   * Xero Identifier of batch payment. Present if the transaction is part of a batch.
   *
   * @param batchPaymentId UUID
   */
  public void setBatchPaymentId(UUID batchPaymentId) {
    this.batchPaymentId = batchPaymentId;
  }

  /**
   * contact
   *
   * @param contact ContactResponse
   * @return BankTransactionResponse
   */
  public BankTransactionResponse contact(ContactResponse contact) {
    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   *
   * @return contact
   */
  @ApiModelProperty(value = "")
  /**
   * contact
   *
   * @return contact ContactResponse
   */
  public ContactResponse getContact() {
    return contact;
  }

  /**
   * contact
   *
   * @param contact ContactResponse
   */
  public void setContact(ContactResponse contact) {
    this.contact = contact;
  }

  /**
   * Date of transaction - YYYY-MM-DD
   *
   * @param date LocalDate
   * @return BankTransactionResponse
   */
  public BankTransactionResponse date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date of transaction - YYYY-MM-DD
   *
   * @return date
   */
  @ApiModelProperty(value = "Date of transaction - YYYY-MM-DD")
  /**
   * Date of transaction - YYYY-MM-DD
   *
   * @return date LocalDate
   */
  public LocalDate getDate() {
    return date;
  }

  /**
   * Date of transaction - YYYY-MM-DD
   *
   * @param date LocalDate
   */
  public void setDate(LocalDate date) {
    this.date = date;
  }

  /**
   * Amount of transaction
   *
   * @param amount Double
   * @return BankTransactionResponse
   */
  public BankTransactionResponse amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Amount of transaction
   *
   * @return amount
   */
  @ApiModelProperty(value = "Amount of transaction")
  /**
   * Amount of transaction
   *
   * @return amount Double
   */
  public Double getAmount() {
    return amount;
  }

  /**
   * Amount of transaction
   *
   * @param amount Double
   */
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  /**
   * The LineItems element can contain any number of individual LineItem sub-elements. Not included
   * in summary mode
   *
   * @param lineItems List&lt;LineItemResponse&gt;
   * @return BankTransactionResponse
   */
  public BankTransactionResponse lineItems(List<LineItemResponse> lineItems) {
    this.lineItems = lineItems;
    return this;
  }

  /**
   * The LineItems element can contain any number of individual LineItem sub-elements. Not included
   * in summary mode
   *
   * @param lineItemsItem LineItemResponse
   * @return BankTransactionResponse
   */
  public BankTransactionResponse addLineItemsItem(LineItemResponse lineItemsItem) {
    if (this.lineItems == null) {
      this.lineItems = new ArrayList<LineItemResponse>();
    }
    this.lineItems.add(lineItemsItem);
    return this;
  }

  /**
   * The LineItems element can contain any number of individual LineItem sub-elements. Not included
   * in summary mode
   *
   * @return lineItems
   */
  @ApiModelProperty(
      value =
          "The LineItems element can contain any number of individual LineItem sub-elements. Not"
              + " included in summary mode")
  /**
   * The LineItems element can contain any number of individual LineItem sub-elements. Not included
   * in summary mode
   *
   * @return lineItems List<LineItemResponse>
   */
  public List<LineItemResponse> getLineItems() {
    return lineItems;
  }

  /**
   * The LineItems element can contain any number of individual LineItem sub-elements. Not included
   * in summary mode
   *
   * @param lineItems List&lt;LineItemResponse&gt;
   */
  public void setLineItems(List<LineItemResponse> lineItems) {
    this.lineItems = lineItems;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankTransactionResponse bankTransactionResponse = (BankTransactionResponse) o;
    return Objects.equals(this.bankTransactionId, bankTransactionResponse.bankTransactionId)
        && Objects.equals(this.batchPaymentId, bankTransactionResponse.batchPaymentId)
        && Objects.equals(this.contact, bankTransactionResponse.contact)
        && Objects.equals(this.date, bankTransactionResponse.date)
        && Objects.equals(this.amount, bankTransactionResponse.amount)
        && Objects.equals(this.lineItems, bankTransactionResponse.lineItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankTransactionId, batchPaymentId, contact, date, amount, lineItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankTransactionResponse {\n");
    sb.append("    bankTransactionId: ").append(toIndentedString(bankTransactionId)).append("\n");
    sb.append("    batchPaymentId: ").append(toIndentedString(batchPaymentId)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
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