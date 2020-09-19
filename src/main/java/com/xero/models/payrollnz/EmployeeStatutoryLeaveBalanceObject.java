/*
 * Xero Payroll NZ
 * This is the Xero Payroll API for orgs in the NZ region.
 *
 * The version of the OpenAPI document: 2.3.0
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.payrollnz;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** EmployeeStatutoryLeaveBalanceObject */
public class EmployeeStatutoryLeaveBalanceObject {
  StringUtil util = new StringUtil();

  @JsonProperty("pagination")
  private Pagination pagination;

  @JsonProperty("problem")
  private Problem problem;

  @JsonProperty("leaveBalance")
  private EmployeeStatutoryLeaveBalance leaveBalance;

  public EmployeeStatutoryLeaveBalanceObject pagination(Pagination pagination) {
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

  public EmployeeStatutoryLeaveBalanceObject problem(Problem problem) {
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

  public EmployeeStatutoryLeaveBalanceObject leaveBalance(
      EmployeeStatutoryLeaveBalance leaveBalance) {
    this.leaveBalance = leaveBalance;
    return this;
  }

  /**
   * Get leaveBalance
   *
   * @return leaveBalance
   */
  @ApiModelProperty(value = "")
  public EmployeeStatutoryLeaveBalance getLeaveBalance() {
    return leaveBalance;
  }

  public void setLeaveBalance(EmployeeStatutoryLeaveBalance leaveBalance) {
    this.leaveBalance = leaveBalance;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeStatutoryLeaveBalanceObject employeeStatutoryLeaveBalanceObject =
        (EmployeeStatutoryLeaveBalanceObject) o;
    return Objects.equals(this.pagination, employeeStatutoryLeaveBalanceObject.pagination)
        && Objects.equals(this.problem, employeeStatutoryLeaveBalanceObject.problem)
        && Objects.equals(this.leaveBalance, employeeStatutoryLeaveBalanceObject.leaveBalance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, problem, leaveBalance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeStatutoryLeaveBalanceObject {\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
    sb.append("    problem: ").append(toIndentedString(problem)).append("\n");
    sb.append("    leaveBalance: ").append(toIndentedString(leaveBalance)).append("\n");
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
