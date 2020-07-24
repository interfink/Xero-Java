/*
 * Accounting API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 2.2.9
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.accounting;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

/** ManualJournal */
public class ManualJournal {
  StringUtil util = new StringUtil();

  @JsonProperty("Narration")
  private String narration;

  @JsonProperty("JournalLines")
  private List<ManualJournalLine> journalLines = new ArrayList<ManualJournalLine>();

  @JsonProperty("Date")
  private String date;

  @JsonProperty("LineAmountTypes")
  private LineAmountTypes lineAmountTypes;
  /** See Manual Journal Status Codes */
  public enum StatusEnum {
    DRAFT("DRAFT"),

    POSTED("POSTED"),

    DELETED("DELETED"),

    VOIDED("VOIDED"),

    ARCHIVED("ARCHIVED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("Status")
  private StatusEnum status;

  @JsonProperty("Url")
  private String url;

  @JsonProperty("ShowOnCashBasisReports")
  private Boolean showOnCashBasisReports;

  @JsonProperty("HasAttachments")
  private Boolean hasAttachments = false;

  @JsonProperty("UpdatedDateUTC")
  private String updatedDateUTC;

  @JsonProperty("ManualJournalID")
  private UUID manualJournalID;

  @JsonProperty("StatusAttributeString")
  private String statusAttributeString;

  @JsonProperty("Warnings")
  private List<ValidationError> warnings = new ArrayList<ValidationError>();

  @JsonProperty("ValidationErrors")
  private List<ValidationError> validationErrors = new ArrayList<ValidationError>();

  @JsonProperty("Attachments")
  private List<Attachment> attachments = new ArrayList<Attachment>();

  public ManualJournal narration(String narration) {
    this.narration = narration;
    return this;
  }

  /**
   * Description of journal being posted
   *
   * @return narration
   */
  @ApiModelProperty(required = true, value = "Description of journal being posted")
  public String getNarration() {
    return narration;
  }

  public void setNarration(String narration) {
    this.narration = narration;
  }

  public ManualJournal journalLines(List<ManualJournalLine> journalLines) {
    this.journalLines = journalLines;
    return this;
  }

  public ManualJournal addJournalLinesItem(ManualJournalLine journalLinesItem) {
    if (this.journalLines == null) {
      this.journalLines = new ArrayList<ManualJournalLine>();
    }
    this.journalLines.add(journalLinesItem);
    return this;
  }

  /**
   * See JournalLines
   *
   * @return journalLines
   */
  @ApiModelProperty(value = "See JournalLines")
  public List<ManualJournalLine> getJournalLines() {
    return journalLines;
  }

  public void setJournalLines(List<ManualJournalLine> journalLines) {
    this.journalLines = journalLines;
  }

  public ManualJournal date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Date journal was posted – YYYY-MM-DD
   *
   * @return date
   */
  @ApiModelProperty(value = "Date journal was posted – YYYY-MM-DD")
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
    // CONVERT LocalDate args into MS DateFromat String
    Instant instant = date.atStartOfDay(ZoneId.of("UTC").normalized()).toInstant();
    long timeInMillis = instant.toEpochMilli();

    this.date = "/Date(" + Long.toString(timeInMillis) + "+0000)/";
  }

  public ManualJournal lineAmountTypes(LineAmountTypes lineAmountTypes) {
    this.lineAmountTypes = lineAmountTypes;
    return this;
  }

  /**
   * Get lineAmountTypes
   *
   * @return lineAmountTypes
   */
  @ApiModelProperty(value = "")
  public LineAmountTypes getLineAmountTypes() {
    return lineAmountTypes;
  }

  public void setLineAmountTypes(LineAmountTypes lineAmountTypes) {
    this.lineAmountTypes = lineAmountTypes;
  }

  public ManualJournal status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * See Manual Journal Status Codes
   *
   * @return status
   */
  @ApiModelProperty(value = "See Manual Journal Status Codes")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ManualJournal url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Url link to a source document – shown as “Go to [appName]” in the Xero app
   *
   * @return url
   */
  @ApiModelProperty(
      value = "Url link to a source document – shown as “Go to [appName]” in the Xero app")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ManualJournal showOnCashBasisReports(Boolean showOnCashBasisReports) {
    this.showOnCashBasisReports = showOnCashBasisReports;
    return this;
  }

  /**
   * Boolean – default is true if not specified
   *
   * @return showOnCashBasisReports
   */
  @ApiModelProperty(value = "Boolean – default is true if not specified")
  public Boolean getShowOnCashBasisReports() {
    return showOnCashBasisReports;
  }

  public void setShowOnCashBasisReports(Boolean showOnCashBasisReports) {
    this.showOnCashBasisReports = showOnCashBasisReports;
  }

  /**
   * Boolean to indicate if a manual journal has an attachment
   *
   * @return hasAttachments
   */
  @ApiModelProperty(
      example = "false",
      value = "Boolean to indicate if a manual journal has an attachment")
  public Boolean getHasAttachments() {
    return hasAttachments;
  }

  /**
   * Last modified date UTC format
   *
   * @return updatedDateUTC
   */
  @ApiModelProperty(example = "/Date(1573755038314)/", value = "Last modified date UTC format")
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

  public ManualJournal manualJournalID(UUID manualJournalID) {
    this.manualJournalID = manualJournalID;
    return this;
  }

  /**
   * The Xero identifier for a Manual Journal
   *
   * @return manualJournalID
   */
  @ApiModelProperty(value = "The Xero identifier for a Manual Journal")
  public UUID getManualJournalID() {
    return manualJournalID;
  }

  public void setManualJournalID(UUID manualJournalID) {
    this.manualJournalID = manualJournalID;
  }

  public ManualJournal statusAttributeString(String statusAttributeString) {
    this.statusAttributeString = statusAttributeString;
    return this;
  }

  /**
   * A string to indicate if a invoice status
   *
   * @return statusAttributeString
   */
  @ApiModelProperty(example = "ERROR", value = "A string to indicate if a invoice status")
  public String getStatusAttributeString() {
    return statusAttributeString;
  }

  public void setStatusAttributeString(String statusAttributeString) {
    this.statusAttributeString = statusAttributeString;
  }

  public ManualJournal warnings(List<ValidationError> warnings) {
    this.warnings = warnings;
    return this;
  }

  public ManualJournal addWarningsItem(ValidationError warningsItem) {
    if (this.warnings == null) {
      this.warnings = new ArrayList<ValidationError>();
    }
    this.warnings.add(warningsItem);
    return this;
  }

  /**
   * Displays array of warning messages from the API
   *
   * @return warnings
   */
  @ApiModelProperty(value = "Displays array of warning messages from the API")
  public List<ValidationError> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<ValidationError> warnings) {
    this.warnings = warnings;
  }

  public ManualJournal validationErrors(List<ValidationError> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }

  public ManualJournal addValidationErrorsItem(ValidationError validationErrorsItem) {
    if (this.validationErrors == null) {
      this.validationErrors = new ArrayList<ValidationError>();
    }
    this.validationErrors.add(validationErrorsItem);
    return this;
  }

  /**
   * Displays array of validation error messages from the API
   *
   * @return validationErrors
   */
  @ApiModelProperty(value = "Displays array of validation error messages from the API")
  public List<ValidationError> getValidationErrors() {
    return validationErrors;
  }

  public void setValidationErrors(List<ValidationError> validationErrors) {
    this.validationErrors = validationErrors;
  }

  public ManualJournal attachments(List<Attachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  public ManualJournal addAttachmentsItem(Attachment attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<Attachment>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

  /**
   * Displays array of attachments from the API
   *
   * @return attachments
   */
  @ApiModelProperty(value = "Displays array of attachments from the API")
  public List<Attachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
    this.attachments = attachments;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManualJournal manualJournal = (ManualJournal) o;
    return Objects.equals(this.narration, manualJournal.narration)
        && Objects.equals(this.journalLines, manualJournal.journalLines)
        && Objects.equals(this.date, manualJournal.date)
        && Objects.equals(this.lineAmountTypes, manualJournal.lineAmountTypes)
        && Objects.equals(this.status, manualJournal.status)
        && Objects.equals(this.url, manualJournal.url)
        && Objects.equals(this.showOnCashBasisReports, manualJournal.showOnCashBasisReports)
        && Objects.equals(this.hasAttachments, manualJournal.hasAttachments)
        && Objects.equals(this.updatedDateUTC, manualJournal.updatedDateUTC)
        && Objects.equals(this.manualJournalID, manualJournal.manualJournalID)
        && Objects.equals(this.statusAttributeString, manualJournal.statusAttributeString)
        && Objects.equals(this.warnings, manualJournal.warnings)
        && Objects.equals(this.validationErrors, manualJournal.validationErrors)
        && Objects.equals(this.attachments, manualJournal.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        narration,
        journalLines,
        date,
        lineAmountTypes,
        status,
        url,
        showOnCashBasisReports,
        hasAttachments,
        updatedDateUTC,
        manualJournalID,
        statusAttributeString,
        warnings,
        validationErrors,
        attachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManualJournal {\n");
    sb.append("    narration: ").append(toIndentedString(narration)).append("\n");
    sb.append("    journalLines: ").append(toIndentedString(journalLines)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    lineAmountTypes: ").append(toIndentedString(lineAmountTypes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    showOnCashBasisReports: ")
        .append(toIndentedString(showOnCashBasisReports))
        .append("\n");
    sb.append("    hasAttachments: ").append(toIndentedString(hasAttachments)).append("\n");
    sb.append("    updatedDateUTC: ").append(toIndentedString(updatedDateUTC)).append("\n");
    sb.append("    manualJournalID: ").append(toIndentedString(manualJournalID)).append("\n");
    sb.append("    statusAttributeString: ")
        .append(toIndentedString(statusAttributeString))
        .append("\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
    sb.append("    validationErrors: ").append(toIndentedString(validationErrors)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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
