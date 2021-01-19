/*
 * Accounting API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 2.8.2
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.accounting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

/** Overpayment */
public class Overpayment {
  StringUtil util = new StringUtil();
  /** See Overpayment Types */
  public enum TypeEnum {
    RECEIVE_OVERPAYMENT("RECEIVE-OVERPAYMENT"),

    SPEND_OVERPAYMENT("SPEND-OVERPAYMENT"),

    AROVERPAYMENT("AROVERPAYMENT");

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

  @JsonProperty("Type")
  private TypeEnum type;

  @JsonProperty("Contact")
  private Contact contact;

  @JsonProperty("Date")
  private String date;
  /** See Overpayment Status Codes */
  public enum StatusEnum {
    AUTHORISED("AUTHORISED"),

    PAID("PAID"),

    VOIDED("VOIDED");

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

  @JsonProperty("Status")
  private StatusEnum status;

  @JsonProperty("LineAmountTypes")
  private LineAmountTypes lineAmountTypes;

  @JsonProperty("LineItems")
  private List<LineItem> lineItems = new ArrayList<LineItem>();

  @JsonProperty("SubTotal")
  private Double subTotal;

  @JsonProperty("TotalTax")
  private Double totalTax;

  @JsonProperty("Total")
  private Double total;

  @JsonProperty("UpdatedDateUTC")
  private String updatedDateUTC;

  @JsonProperty("CurrencyCode")
  private CurrencyCode currencyCode;

  @JsonProperty("OverpaymentID")
  private UUID overpaymentID;

  @JsonProperty("CurrencyRate")
  private Double currencyRate;

  @JsonProperty("RemainingCredit")
  private Double remainingCredit;

  @JsonProperty("Allocations")
  private List<Allocation> allocations = new ArrayList<Allocation>();

  @JsonProperty("AppliedAmount")
  private Double appliedAmount;

  @JsonProperty("Payments")
  private List<Payment> payments = new ArrayList<Payment>();

  @JsonProperty("HasAttachments")
  private Boolean hasAttachments = false;

  @JsonProperty("Attachments")
  private List<Attachment> attachments = new ArrayList<Attachment>();

  public Overpayment type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * See Overpayment Types
   *
   * @return type
   */
  @ApiModelProperty(value = "See Overpayment Types")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Overpayment contact(Contact contact) {
    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   *
   * @return contact
   */
  @ApiModelProperty(value = "")
  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Overpayment date(String date) {
    this.date = date;
    return this;
  }

  /**
   * The date the overpayment is created YYYY-MM-DD
   *
   * @return date
   */
  @ApiModelProperty(value = "The date the overpayment is created YYYY-MM-DD")
  public String getDate() {
    return date;
  }

  public LocalDate getDateAsDate() {
    if (this.date != null) {
      try {
        return util.convertStringToDate(this.date);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setDate(LocalDate date) {
    // CONVERT LocalDate args into MS DateFromat String
    Instant instant = date.atStartOfDay(ZoneId.of("UTC").normalized()).toInstant();
    long timeInMillis = instant.toEpochMilli();

    this.date = "/Date(" + Long.toString(timeInMillis) + "+0000)/";
  }

  public Overpayment status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * See Overpayment Status Codes
   *
   * @return status
   */
  @ApiModelProperty(value = "See Overpayment Status Codes")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Overpayment lineAmountTypes(LineAmountTypes lineAmountTypes) {
    this.lineAmountTypes = lineAmountTypes;
    return this;
  }

  /**
   * Get lineAmountTypes
   *
   * @return lineAmountTypes
   */
  @ApiModelProperty(value = "")
  public LineAmountTypes getLineAmountTypes() {
    return lineAmountTypes;
  }

  public void setLineAmountTypes(LineAmountTypes lineAmountTypes) {
    this.lineAmountTypes = lineAmountTypes;
  }

  public Overpayment lineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
    return this;
  }

  public Overpayment addLineItemsItem(LineItem lineItemsItem) {
    if (this.lineItems == null) {
      this.lineItems = new ArrayList<LineItem>();
    }
    this.lineItems.add(lineItemsItem);
    return this;
  }

  /**
   * See Overpayment Line Items
   *
   * @return lineItems
   */
  @ApiModelProperty(value = "See Overpayment Line Items")
  public List<LineItem> getLineItems() {
    return lineItems;
  }

  public void setLineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
  }

  public Overpayment subTotal(Double subTotal) {
    this.subTotal = subTotal;
    return this;
  }

  /**
   * The subtotal of the overpayment excluding taxes
   *
   * @return subTotal
   */
  @ApiModelProperty(value = "The subtotal of the overpayment excluding taxes")
  public Double getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(Double subTotal) {
    this.subTotal = subTotal;
  }

  public Overpayment totalTax(Double totalTax) {
    this.totalTax = totalTax;
    return this;
  }

  /**
   * The total tax on the overpayment
   *
   * @return totalTax
   */
  @ApiModelProperty(value = "The total tax on the overpayment")
  public Double getTotalTax() {
    return totalTax;
  }

  public void setTotalTax(Double totalTax) {
    this.totalTax = totalTax;
  }

  public Overpayment total(Double total) {
    this.total = total;
    return this;
  }

  /**
   * The total of the overpayment (subtotal + total tax)
   *
   * @return total
   */
  @ApiModelProperty(value = "The total of the overpayment (subtotal + total tax)")
  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  /**
   * UTC timestamp of last update to the overpayment
   *
   * @return updatedDateUTC
   */
  @ApiModelProperty(
      example = "/Date(1573755038314)/",
      value = "UTC timestamp of last update to the overpayment")
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

  public Overpayment currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * Get currencyCode
   *
   * @return currencyCode
   */
  @ApiModelProperty(value = "")
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Overpayment overpaymentID(UUID overpaymentID) {
    this.overpaymentID = overpaymentID;
    return this;
  }

  /**
   * Xero generated unique identifier
   *
   * @return overpaymentID
   */
  @ApiModelProperty(value = "Xero generated unique identifier")
  public UUID getOverpaymentID() {
    return overpaymentID;
  }

  public void setOverpaymentID(UUID overpaymentID) {
    this.overpaymentID = overpaymentID;
  }

  public Overpayment currencyRate(Double currencyRate) {
    this.currencyRate = currencyRate;
    return this;
  }

  /**
   * The currency rate for a multicurrency overpayment. If no rate is specified, the XE.com day rate
   * is used
   *
   * @return currencyRate
   */
  @ApiModelProperty(
      value =
          "The currency rate for a multicurrency overpayment. If no rate is specified, the XE.com"
              + " day rate is used")
  public Double getCurrencyRate() {
    return currencyRate;
  }

  public void setCurrencyRate(Double currencyRate) {
    this.currencyRate = currencyRate;
  }

  public Overpayment remainingCredit(Double remainingCredit) {
    this.remainingCredit = remainingCredit;
    return this;
  }

  /**
   * The remaining credit balance on the overpayment
   *
   * @return remainingCredit
   */
  @ApiModelProperty(value = "The remaining credit balance on the overpayment")
  public Double getRemainingCredit() {
    return remainingCredit;
  }

  public void setRemainingCredit(Double remainingCredit) {
    this.remainingCredit = remainingCredit;
  }

  public Overpayment allocations(List<Allocation> allocations) {
    this.allocations = allocations;
    return this;
  }

  public Overpayment addAllocationsItem(Allocation allocationsItem) {
    if (this.allocations == null) {
      this.allocations = new ArrayList<Allocation>();
    }
    this.allocations.add(allocationsItem);
    return this;
  }

  /**
   * See Allocations
   *
   * @return allocations
   */
  @ApiModelProperty(value = "See Allocations")
  public List<Allocation> getAllocations() {
    return allocations;
  }

  public void setAllocations(List<Allocation> allocations) {
    this.allocations = allocations;
  }

  public Overpayment appliedAmount(Double appliedAmount) {
    this.appliedAmount = appliedAmount;
    return this;
  }

  /**
   * The amount of applied to an invoice
   *
   * @return appliedAmount
   */
  @ApiModelProperty(example = "2.0", value = "The amount of applied to an invoice")
  public Double getAppliedAmount() {
    return appliedAmount;
  }

  public void setAppliedAmount(Double appliedAmount) {
    this.appliedAmount = appliedAmount;
  }

  public Overpayment payments(List<Payment> payments) {
    this.payments = payments;
    return this;
  }

  public Overpayment addPaymentsItem(Payment paymentsItem) {
    if (this.payments == null) {
      this.payments = new ArrayList<Payment>();
    }
    this.payments.add(paymentsItem);
    return this;
  }

  /**
   * See Payments
   *
   * @return payments
   */
  @ApiModelProperty(value = "See Payments")
  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  /**
   * boolean to indicate if a overpayment has an attachment
   *
   * @return hasAttachments
   */
  @ApiModelProperty(
      example = "false",
      value = "boolean to indicate if a overpayment has an attachment")
  public Boolean getHasAttachments() {
    return hasAttachments;
  }

  public Overpayment attachments(List<Attachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  public Overpayment addAttachmentsItem(Attachment attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<Attachment>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

  /**
   * See Attachments
   *
   * @return attachments
   */
  @ApiModelProperty(value = "See Attachments")
  public List<Attachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
    this.attachments = attachments;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Overpayment overpayment = (Overpayment) o;
    return Objects.equals(this.type, overpayment.type)
        && Objects.equals(this.contact, overpayment.contact)
        && Objects.equals(this.date, overpayment.date)
        && Objects.equals(this.status, overpayment.status)
        && Objects.equals(this.lineAmountTypes, overpayment.lineAmountTypes)
        && Objects.equals(this.lineItems, overpayment.lineItems)
        && Objects.equals(this.subTotal, overpayment.subTotal)
        && Objects.equals(this.totalTax, overpayment.totalTax)
        && Objects.equals(this.total, overpayment.total)
        && Objects.equals(this.updatedDateUTC, overpayment.updatedDateUTC)
        && Objects.equals(this.currencyCode, overpayment.currencyCode)
        && Objects.equals(this.overpaymentID, overpayment.overpaymentID)
        && Objects.equals(this.currencyRate, overpayment.currencyRate)
        && Objects.equals(this.remainingCredit, overpayment.remainingCredit)
        && Objects.equals(this.allocations, overpayment.allocations)
        && Objects.equals(this.appliedAmount, overpayment.appliedAmount)
        && Objects.equals(this.payments, overpayment.payments)
        && Objects.equals(this.hasAttachments, overpayment.hasAttachments)
        && Objects.equals(this.attachments, overpayment.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        type,
        contact,
        date,
        status,
        lineAmountTypes,
        lineItems,
        subTotal,
        totalTax,
        total,
        updatedDateUTC,
        currencyCode,
        overpaymentID,
        currencyRate,
        remainingCredit,
        allocations,
        appliedAmount,
        payments,
        hasAttachments,
        attachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Overpayment {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    lineAmountTypes: ").append(toIndentedString(lineAmountTypes)).append("\n");
    sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
    sb.append("    subTotal: ").append(toIndentedString(subTotal)).append("\n");
    sb.append("    totalTax: ").append(toIndentedString(totalTax)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    updatedDateUTC: ").append(toIndentedString(updatedDateUTC)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    overpaymentID: ").append(toIndentedString(overpaymentID)).append("\n");
    sb.append("    currencyRate: ").append(toIndentedString(currencyRate)).append("\n");
    sb.append("    remainingCredit: ").append(toIndentedString(remainingCredit)).append("\n");
    sb.append("    allocations: ").append(toIndentedString(allocations)).append("\n");
    sb.append("    appliedAmount: ").append(toIndentedString(appliedAmount)).append("\n");
    sb.append("    payments: ").append(toIndentedString(payments)).append("\n");
    sb.append("    hasAttachments: ").append(toIndentedString(hasAttachments)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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
