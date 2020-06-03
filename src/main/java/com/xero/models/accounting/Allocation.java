/*
 * Accounting API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 2.2.0
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.xero.models.accounting;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xero.models.accounting.Invoice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import com.xero.api.StringUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Allocation
 */

public class Allocation {
  StringUtil util = new StringUtil();

  @JsonProperty("Invoice")
  private Invoice invoice;

  @JsonProperty("Amount")
  private Double amount;

  @JsonProperty("Date")
  private String date;
  public Allocation invoice(Invoice invoice) {
    this.invoice = invoice;
    return this;
  }

   /**
   * Get invoice
   * @return invoice
  **/
  @ApiModelProperty(required = true, value = "")
  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  public Allocation amount(Double amount) {
    this.amount = amount;
    return this;
  }

   /**
   * the amount being applied to the invoice
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "the amount being applied to the invoice")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Allocation date(String date) {
    this.date = date;
    return this;
  }

   /**
   * the date the allocation is applied YYYY-MM-DD.
   * @return date
  **/
  @ApiModelProperty(required = true, value = "the date the allocation is applied YYYY-MM-DD.")
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
    //CONVERT LocalDate args into MS DateFromat String
    Instant instant =  date.atStartOfDay(ZoneId.of("UTC").normalized()).toInstant();  
    long timeInMillis = instant.toEpochMilli();

    this.date = "/Date(" + Long.toString(timeInMillis) + "+0000)/";
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Allocation allocation = (Allocation) o;
    return Objects.equals(this.invoice, allocation.invoice) &&
        Objects.equals(this.amount, allocation.amount) &&
        Objects.equals(this.date, allocation.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(invoice, amount, date);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Allocation {\n");
    sb.append("    invoice: ").append(toIndentedString(invoice)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

