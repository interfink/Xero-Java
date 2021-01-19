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

/** EmployeeTaxObject */
public class EmployeeTaxObject {
  StringUtil util = new StringUtil();

  @JsonProperty("pagination")
  private Pagination pagination;

  @JsonProperty("problem")
  private Problem problem;

  @JsonProperty("employeeTax")
  private EmployeeTax employeeTax;

  public EmployeeTaxObject pagination(Pagination pagination) {
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

  public EmployeeTaxObject problem(Problem problem) {
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

  public EmployeeTaxObject employeeTax(EmployeeTax employeeTax) {
    this.employeeTax = employeeTax;
    return this;
  }

  /**
   * Get employeeTax
   *
   * @return employeeTax
   */
  @ApiModelProperty(value = "")
  public EmployeeTax getEmployeeTax() {
    return employeeTax;
  }

  public void setEmployeeTax(EmployeeTax employeeTax) {
    this.employeeTax = employeeTax;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeTaxObject employeeTaxObject = (EmployeeTaxObject) o;
    return Objects.equals(this.pagination, employeeTaxObject.pagination)
        && Objects.equals(this.problem, employeeTaxObject.problem)
        && Objects.equals(this.employeeTax, employeeTaxObject.employeeTax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, problem, employeeTax);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeTaxObject {\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
    sb.append("    problem: ").append(toIndentedString(problem)).append("\n");
    sb.append("    employeeTax: ").append(toIndentedString(employeeTax)).append("\n");
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
