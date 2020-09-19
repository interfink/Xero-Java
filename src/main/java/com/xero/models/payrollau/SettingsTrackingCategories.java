/*
 * Xero Payroll AU
 * This is the Xero Payroll API for orgs in Australia region.
 *
 * The version of the OpenAPI document: 2.3.0
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.payrollau;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** Tracking categories for Employees and Timesheets */
@ApiModel(description = "Tracking categories for Employees and Timesheets")
public class SettingsTrackingCategories {
  StringUtil util = new StringUtil();

  @JsonProperty("EmployeeGroups")
  private SettingsTrackingCategoriesEmployeeGroups employeeGroups;

  @JsonProperty("TimesheetCategories")
  private SettingsTrackingCategoriesTimesheetCategories timesheetCategories;

  public SettingsTrackingCategories employeeGroups(
      SettingsTrackingCategoriesEmployeeGroups employeeGroups) {
    this.employeeGroups = employeeGroups;
    return this;
  }

  /**
   * Get employeeGroups
   *
   * @return employeeGroups
   */
  @ApiModelProperty(value = "")
  public SettingsTrackingCategoriesEmployeeGroups getEmployeeGroups() {
    return employeeGroups;
  }

  public void setEmployeeGroups(SettingsTrackingCategoriesEmployeeGroups employeeGroups) {
    this.employeeGroups = employeeGroups;
  }

  public SettingsTrackingCategories timesheetCategories(
      SettingsTrackingCategoriesTimesheetCategories timesheetCategories) {
    this.timesheetCategories = timesheetCategories;
    return this;
  }

  /**
   * Get timesheetCategories
   *
   * @return timesheetCategories
   */
  @ApiModelProperty(value = "")
  public SettingsTrackingCategoriesTimesheetCategories getTimesheetCategories() {
    return timesheetCategories;
  }

  public void setTimesheetCategories(
      SettingsTrackingCategoriesTimesheetCategories timesheetCategories) {
    this.timesheetCategories = timesheetCategories;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettingsTrackingCategories settingsTrackingCategories = (SettingsTrackingCategories) o;
    return Objects.equals(this.employeeGroups, settingsTrackingCategories.employeeGroups)
        && Objects.equals(this.timesheetCategories, settingsTrackingCategories.timesheetCategories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeGroups, timesheetCategories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettingsTrackingCategories {\n");
    sb.append("    employeeGroups: ").append(toIndentedString(employeeGroups)).append("\n");
    sb.append("    timesheetCategories: ")
        .append(toIndentedString(timesheetCategories))
        .append("\n");
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
