/*
 * Accounting API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 2.3.0
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

/** Overpayments */
public class Overpayments {
  StringUtil util = new StringUtil();

  @JsonProperty("Overpayments")
  private List<Overpayment> overpayments = new ArrayList<Overpayment>();

  public Overpayments overpayments(List<Overpayment> overpayments) {
    this.overpayments = overpayments;
    return this;
  }

  public Overpayments addOverpaymentsItem(Overpayment overpaymentsItem) {
    if (this.overpayments == null) {
      this.overpayments = new ArrayList<Overpayment>();
    }
    this.overpayments.add(overpaymentsItem);
    return this;
  }

  /**
   * Get overpayments
   *
   * @return overpayments
   */
  @ApiModelProperty(value = "")
  public List<Overpayment> getOverpayments() {
    return overpayments;
  }

  public void setOverpayments(List<Overpayment> overpayments) {
    this.overpayments = overpayments;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Overpayments overpayments = (Overpayments) o;
    return Objects.equals(this.overpayments, overpayments.overpayments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(overpayments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Overpayments {\n");
    sb.append("    overpayments: ").append(toIndentedString(overpayments)).append("\n");
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
