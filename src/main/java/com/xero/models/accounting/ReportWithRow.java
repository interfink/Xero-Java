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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.threeten.bp.OffsetDateTime;

/** ReportWithRow */
public class ReportWithRow {
  StringUtil util = new StringUtil();

  @JsonProperty("ReportID")
  private String reportID;

  @JsonProperty("ReportName")
  private String reportName;

  @JsonProperty("ReportTitle")
  private String reportTitle;

  @JsonProperty("ReportType")
  private String reportType;

  @JsonProperty("ReportTitles")
  private List<String> reportTitles = new ArrayList<String>();

  @JsonProperty("ReportDate")
  private String reportDate;

  @JsonProperty("Rows")
  private List<ReportRows> rows = new ArrayList<ReportRows>();

  @JsonProperty("UpdatedDateUTC")
  private String updatedDateUTC;

  @JsonProperty("Fields")
  private List<ReportFields> fields = new ArrayList<ReportFields>();

  public ReportWithRow reportID(String reportID) {
    this.reportID = reportID;
    return this;
  }

  /**
   * Report id
   *
   * @return reportID
   */
  @ApiModelProperty(value = "Report id")
  public String getReportID() {
    return reportID;
  }

  public void setReportID(String reportID) {
    this.reportID = reportID;
  }

  public ReportWithRow reportName(String reportName) {
    this.reportName = reportName;
    return this;
  }

  /**
   * Name of the report
   *
   * @return reportName
   */
  @ApiModelProperty(value = "Name of the report")
  public String getReportName() {
    return reportName;
  }

  public void setReportName(String reportName) {
    this.reportName = reportName;
  }

  public ReportWithRow reportTitle(String reportTitle) {
    this.reportTitle = reportTitle;
    return this;
  }

  /**
   * Title of the report
   *
   * @return reportTitle
   */
  @ApiModelProperty(value = "Title of the report")
  public String getReportTitle() {
    return reportTitle;
  }

  public void setReportTitle(String reportTitle) {
    this.reportTitle = reportTitle;
  }

  public ReportWithRow reportType(String reportType) {
    this.reportType = reportType;
    return this;
  }

  /**
   * The type of report (BalanceSheet,ProfitLoss, etc)
   *
   * @return reportType
   */
  @ApiModelProperty(value = "The type of report (BalanceSheet,ProfitLoss, etc)")
  public String getReportType() {
    return reportType;
  }

  public void setReportType(String reportType) {
    this.reportType = reportType;
  }

  public ReportWithRow reportTitles(List<String> reportTitles) {
    this.reportTitles = reportTitles;
    return this;
  }

  public ReportWithRow addReportTitlesItem(String reportTitlesItem) {
    if (this.reportTitles == null) {
      this.reportTitles = new ArrayList<String>();
    }
    this.reportTitles.add(reportTitlesItem);
    return this;
  }

  /**
   * Report titles array (3 to 4 strings with the report name, orgnisation name and time frame of
   * report)
   *
   * @return reportTitles
   */
  @ApiModelProperty(
      value =
          "Report titles array (3 to 4 strings with the report name, orgnisation name and time"
              + " frame of report)")
  public List<String> getReportTitles() {
    return reportTitles;
  }

  public void setReportTitles(List<String> reportTitles) {
    this.reportTitles = reportTitles;
  }

  public ReportWithRow reportDate(String reportDate) {
    this.reportDate = reportDate;
    return this;
  }

  /**
   * Date of report
   *
   * @return reportDate
   */
  @ApiModelProperty(value = "Date of report")
  public String getReportDate() {
    return reportDate;
  }

  public void setReportDate(String reportDate) {
    this.reportDate = reportDate;
  }

  public ReportWithRow rows(List<ReportRows> rows) {
    this.rows = rows;
    return this;
  }

  public ReportWithRow addRowsItem(ReportRows rowsItem) {
    if (this.rows == null) {
      this.rows = new ArrayList<ReportRows>();
    }
    this.rows.add(rowsItem);
    return this;
  }

  /**
   * Get rows
   *
   * @return rows
   */
  @ApiModelProperty(value = "")
  public List<ReportRows> getRows() {
    return rows;
  }

  public void setRows(List<ReportRows> rows) {
    this.rows = rows;
  }

  /**
   * Updated Date
   *
   * @return updatedDateUTC
   */
  @ApiModelProperty(example = "/Date(1573755038314)/", value = "Updated Date")
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

  public ReportWithRow fields(List<ReportFields> fields) {
    this.fields = fields;
    return this;
  }

  public ReportWithRow addFieldsItem(ReportFields fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<ReportFields>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

  /**
   * Get fields
   *
   * @return fields
   */
  @ApiModelProperty(value = "")
  public List<ReportFields> getFields() {
    return fields;
  }

  public void setFields(List<ReportFields> fields) {
    this.fields = fields;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportWithRow reportWithRow = (ReportWithRow) o;
    return Objects.equals(this.reportID, reportWithRow.reportID)
        && Objects.equals(this.reportName, reportWithRow.reportName)
        && Objects.equals(this.reportTitle, reportWithRow.reportTitle)
        && Objects.equals(this.reportType, reportWithRow.reportType)
        && Objects.equals(this.reportTitles, reportWithRow.reportTitles)
        && Objects.equals(this.reportDate, reportWithRow.reportDate)
        && Objects.equals(this.rows, reportWithRow.rows)
        && Objects.equals(this.updatedDateUTC, reportWithRow.updatedDateUTC)
        && Objects.equals(this.fields, reportWithRow.fields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        reportID,
        reportName,
        reportTitle,
        reportType,
        reportTitles,
        reportDate,
        rows,
        updatedDateUTC,
        fields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportWithRow {\n");
    sb.append("    reportID: ").append(toIndentedString(reportID)).append("\n");
    sb.append("    reportName: ").append(toIndentedString(reportName)).append("\n");
    sb.append("    reportTitle: ").append(toIndentedString(reportTitle)).append("\n");
    sb.append("    reportType: ").append(toIndentedString(reportType)).append("\n");
    sb.append("    reportTitles: ").append(toIndentedString(reportTitles)).append("\n");
    sb.append("    reportDate: ").append(toIndentedString(reportDate)).append("\n");
    sb.append("    rows: ").append(toIndentedString(rows)).append("\n");
    sb.append("    updatedDateUTC: ").append(toIndentedString(updatedDateUTC)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
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
