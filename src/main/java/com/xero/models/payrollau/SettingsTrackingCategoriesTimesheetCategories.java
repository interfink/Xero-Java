/*
 * Xero Payroll AU
 * This is the Xero Payroll API for orgs in Australia region.
 *
 * The version of the OpenAPI document: 2.2.0
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.xero.models.payrollau;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import java.io.IOException;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import com.xero.api.StringUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * The tracking category used for timesheets
 */
@ApiModel(description = "The tracking category used for timesheets")

public class SettingsTrackingCategoriesTimesheetCategories {
  StringUtil util = new StringUtil();

  @JsonProperty("TrackingCategoryID")
  private UUID trackingCategoryID;

  @JsonProperty("TrackingCategoryName")
  private String trackingCategoryName;
  public SettingsTrackingCategoriesTimesheetCategories trackingCategoryID(UUID trackingCategoryID) {
    this.trackingCategoryID = trackingCategoryID;
    return this;
  }

   /**
   * The identifier for the tracking category
   * @return trackingCategoryID
  **/
  @ApiModelProperty(example = "e0eb6747-7c17-4075-b804-989f8d4e5d39", value = "The identifier for the tracking category")
  public UUID getTrackingCategoryID() {
    return trackingCategoryID;
  }

  public void setTrackingCategoryID(UUID trackingCategoryID) {
    this.trackingCategoryID = trackingCategoryID;
  }

  public SettingsTrackingCategoriesTimesheetCategories trackingCategoryName(String trackingCategoryName) {
    this.trackingCategoryName = trackingCategoryName;
    return this;
  }

   /**
   * Name of the tracking category
   * @return trackingCategoryName
  **/
  @ApiModelProperty(value = "Name of the tracking category")
  public String getTrackingCategoryName() {
    return trackingCategoryName;
  }

  public void setTrackingCategoryName(String trackingCategoryName) {
    this.trackingCategoryName = trackingCategoryName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettingsTrackingCategoriesTimesheetCategories settingsTrackingCategoriesTimesheetCategories = (SettingsTrackingCategoriesTimesheetCategories) o;
    return Objects.equals(this.trackingCategoryID, settingsTrackingCategoriesTimesheetCategories.trackingCategoryID) &&
        Objects.equals(this.trackingCategoryName, settingsTrackingCategoriesTimesheetCategories.trackingCategoryName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trackingCategoryID, trackingCategoryName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettingsTrackingCategoriesTimesheetCategories {\n");
    sb.append("    trackingCategoryID: ").append(toIndentedString(trackingCategoryID)).append("\n");
    sb.append("    trackingCategoryName: ").append(toIndentedString(trackingCategoryName)).append("\n");
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

