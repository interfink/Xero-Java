/*
 * Xero Payroll UK
 * This is the Xero Payroll API for orgs in the UK region.
 *
 * The version of the OpenAPI document: 2.3.0
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
import java.util.UUID;
import org.threeten.bp.LocalDate;

/** TimesheetLine */
public class TimesheetLine {
  StringUtil util = new StringUtil();

  @JsonProperty("timesheetLineID")
  private UUID timesheetLineID;

  @JsonProperty("date")
  private LocalDate date;

  @JsonProperty("earningsRateID")
  private UUID earningsRateID;

  @JsonProperty("trackingItemID")
  private UUID trackingItemID;

  @JsonProperty("numberOfUnits")
  private Double numberOfUnits;

  public TimesheetLine timesheetLineID(UUID timesheetLineID) {
    this.timesheetLineID = timesheetLineID;
    return this;
  }

  /**
   * The Xero identifier for a Timesheet Line
   *
   * @return timesheetLineID
   */
  @ApiModelProperty(value = "The Xero identifier for a Timesheet Line")
  public UUID getTimesheetLineID() {
    return timesheetLineID;
  }

  public void setTimesheetLineID(UUID timesheetLineID) {
    this.timesheetLineID = timesheetLineID;
  }

  public TimesheetLine date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * The Date that this Timesheet Line is for (YYYY-MM-DD)
   *
   * @return date
   */
  @ApiModelProperty(
      required = true,
      value = "The Date that this Timesheet Line is for (YYYY-MM-DD)")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public TimesheetLine earningsRateID(UUID earningsRateID) {
    this.earningsRateID = earningsRateID;
    return this;
  }

  /**
   * The Xero identifier for the Earnings Rate that the Timesheet is for
   *
   * @return earningsRateID
   */
  @ApiModelProperty(
      required = true,
      value = "The Xero identifier for the Earnings Rate that the Timesheet is for")
  public UUID getEarningsRateID() {
    return earningsRateID;
  }

  public void setEarningsRateID(UUID earningsRateID) {
    this.earningsRateID = earningsRateID;
  }

  public TimesheetLine trackingItemID(UUID trackingItemID) {
    this.trackingItemID = trackingItemID;
    return this;
  }

  /**
   * The Xero identifier for the Tracking Item that the Timesheet is for
   *
   * @return trackingItemID
   */
  @ApiModelProperty(value = "The Xero identifier for the Tracking Item that the Timesheet is for")
  public UUID getTrackingItemID() {
    return trackingItemID;
  }

  public void setTrackingItemID(UUID trackingItemID) {
    this.trackingItemID = trackingItemID;
  }

  public TimesheetLine numberOfUnits(Double numberOfUnits) {
    this.numberOfUnits = numberOfUnits;
    return this;
  }

  /**
   * The Number of Units of the Timesheet Line
   *
   * @return numberOfUnits
   */
  @ApiModelProperty(required = true, value = "The Number of Units of the Timesheet Line")
  public Double getNumberOfUnits() {
    return numberOfUnits;
  }

  public void setNumberOfUnits(Double numberOfUnits) {
    this.numberOfUnits = numberOfUnits;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimesheetLine timesheetLine = (TimesheetLine) o;
    return Objects.equals(this.timesheetLineID, timesheetLine.timesheetLineID)
        && Objects.equals(this.date, timesheetLine.date)
        && Objects.equals(this.earningsRateID, timesheetLine.earningsRateID)
        && Objects.equals(this.trackingItemID, timesheetLine.trackingItemID)
        && Objects.equals(this.numberOfUnits, timesheetLine.numberOfUnits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timesheetLineID, date, earningsRateID, trackingItemID, numberOfUnits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimesheetLine {\n");
    sb.append("    timesheetLineID: ").append(toIndentedString(timesheetLineID)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    earningsRateID: ").append(toIndentedString(earningsRateID)).append("\n");
    sb.append("    trackingItemID: ").append(toIndentedString(trackingItemID)).append("\n");
    sb.append("    numberOfUnits: ").append(toIndentedString(numberOfUnits)).append("\n");
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
