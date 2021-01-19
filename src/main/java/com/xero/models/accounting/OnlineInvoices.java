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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** OnlineInvoices */
public class OnlineInvoices {
  StringUtil util = new StringUtil();

  @JsonProperty("OnlineInvoices")
  private List<OnlineInvoice> onlineInvoices = new ArrayList<OnlineInvoice>();

  public OnlineInvoices onlineInvoices(List<OnlineInvoice> onlineInvoices) {
    this.onlineInvoices = onlineInvoices;
    return this;
  }

  public OnlineInvoices addOnlineInvoicesItem(OnlineInvoice onlineInvoicesItem) {
    if (this.onlineInvoices == null) {
      this.onlineInvoices = new ArrayList<OnlineInvoice>();
    }
    this.onlineInvoices.add(onlineInvoicesItem);
    return this;
  }

  /**
   * Get onlineInvoices
   *
   * @return onlineInvoices
   */
  @ApiModelProperty(value = "")
  public List<OnlineInvoice> getOnlineInvoices() {
    return onlineInvoices;
  }

  public void setOnlineInvoices(List<OnlineInvoice> onlineInvoices) {
    this.onlineInvoices = onlineInvoices;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnlineInvoices onlineInvoices = (OnlineInvoices) o;
    return Objects.equals(this.onlineInvoices, onlineInvoices.onlineInvoices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(onlineInvoices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OnlineInvoices {\n");
    sb.append("    onlineInvoices: ").append(toIndentedString(onlineInvoices)).append("\n");
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
