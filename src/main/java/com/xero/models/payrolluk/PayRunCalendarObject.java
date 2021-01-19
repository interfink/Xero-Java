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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** PayRunCalendarObject */
public class PayRunCalendarObject {
  StringUtil util = new StringUtil();

  @JsonProperty("pagination")
  private Pagination pagination;

  @JsonProperty("problem")
  private Problem problem;

  @JsonProperty("payRunCalendar")
  private PayRunCalendar payRunCalendar;

  public PayRunCalendarObject pagination(Pagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   *
   * @return pagination
   */
  @ApiModelProperty(value = "")
  public Pagination getPagination() {
    return pagination;
  }

  public void setPagination(Pagination pagination) {
    this.pagination = pagination;
  }

  public PayRunCalendarObject problem(Problem problem) {
    this.problem = problem;
    return this;
  }

  /**
   * Get problem
   *
   * @return problem
   */
  @ApiModelProperty(value = "")
  public Problem getProblem() {
    return problem;
  }

  public void setProblem(Problem problem) {
    this.problem = problem;
  }

  public PayRunCalendarObject payRunCalendar(PayRunCalendar payRunCalendar) {
    this.payRunCalendar = payRunCalendar;
    return this;
  }

  /**
   * Get payRunCalendar
   *
   * @return payRunCalendar
   */
  @ApiModelProperty(value = "")
  public PayRunCalendar getPayRunCalendar() {
    return payRunCalendar;
  }

  public void setPayRunCalendar(PayRunCalendar payRunCalendar) {
    this.payRunCalendar = payRunCalendar;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayRunCalendarObject payRunCalendarObject = (PayRunCalendarObject) o;
    return Objects.equals(this.pagination, payRunCalendarObject.pagination)
        && Objects.equals(this.problem, payRunCalendarObject.problem)
        && Objects.equals(this.payRunCalendar, payRunCalendarObject.payRunCalendar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, problem, payRunCalendar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayRunCalendarObject {\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
    sb.append("    problem: ").append(toIndentedString(problem)).append("\n");
    sb.append("    payRunCalendar: ").append(toIndentedString(payRunCalendar)).append("\n");
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
