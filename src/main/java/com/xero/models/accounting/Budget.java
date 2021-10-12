/*
 * Xero Accounting API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
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
import org.threeten.bp.OffsetDateTime;

/** Budget */
public class Budget {
  StringUtil util = new StringUtil();

  @JsonProperty("BudgetID")
  private UUID budgetID;
  /** Type of Budget. OVERALL or TRACKING */
  public enum TypeEnum {
    /** OVERALL */
    OVERALL("OVERALL"),

    /** TRACKING */
    TRACKING("TRACKING");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    /**
     * getValue
     *
     * @return String value
     */
    @JsonValue
    public String getValue() {
      return value;
    }

    /**
     * toString
     *
     * @return String value
     */
    @Override
    public String toString() {
      return String.valueOf(value);
    }

    /**
     * fromValue
     *
     * @param value String
     */
    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("Type")
  private TypeEnum type;

  @JsonProperty("Description")
  private String description;

  @JsonProperty("UpdatedDateUTC")
  private String updatedDateUTC;

  @JsonProperty("BudgetLines")
  private List<BudgetLine> budgetLines = new ArrayList<BudgetLine>();

  @JsonProperty("Tracking")
  private List<TrackingCategory> tracking = new ArrayList<TrackingCategory>();
  /**
   * Xero identifier
   *
   * @param budgetID UUID
   * @return Budget
   */
  public Budget budgetID(UUID budgetID) {
    this.budgetID = budgetID;
    return this;
  }

  /**
   * Xero identifier
   *
   * @return budgetID
   */
  @ApiModelProperty(value = "Xero identifier")
  /**
   * Xero identifier
   *
   * @return budgetID UUID
   */
  public UUID getBudgetID() {
    return budgetID;
  }

  /**
   * Xero identifier
   *
   * @param budgetID UUID
   */
  public void setBudgetID(UUID budgetID) {
    this.budgetID = budgetID;
  }

  /**
   * Type of Budget. OVERALL or TRACKING
   *
   * @param type TypeEnum
   * @return Budget
   */
  public Budget type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of Budget. OVERALL or TRACKING
   *
   * @return type
   */
  @ApiModelProperty(value = "Type of Budget. OVERALL or TRACKING")
  /**
   * Type of Budget. OVERALL or TRACKING
   *
   * @return type TypeEnum
   */
  public TypeEnum getType() {
    return type;
  }

  /**
   * Type of Budget. OVERALL or TRACKING
   *
   * @param type TypeEnum
   */
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /**
   * The Budget description
   *
   * @param description String
   * @return Budget
   */
  public Budget description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The Budget description
   *
   * @return description
   */
  @ApiModelProperty(value = "The Budget description")
  /**
   * The Budget description
   *
   * @return description String
   */
  public String getDescription() {
    return description;
  }

  /**
   * The Budget description
   *
   * @param description String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * UTC timestamp of last update to budget
   *
   * @return updatedDateUTC
   */
  @ApiModelProperty(
      example = "/Date(1573755038314)/",
      value = "UTC timestamp of last update to budget")
  /**
   * UTC timestamp of last update to budget
   *
   * @return updatedDateUTC String
   */
  public String getUpdatedDateUTC() {
    return updatedDateUTC;
  }
  /**
   * UTC timestamp of last update to budget
   *
   * @return OffsetDateTime
   */
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

  /**
   * budgetLines
   *
   * @param budgetLines List&lt;BudgetLine&gt;
   * @return Budget
   */
  public Budget budgetLines(List<BudgetLine> budgetLines) {
    this.budgetLines = budgetLines;
    return this;
  }

  /**
   * budgetLines
   *
   * @param budgetLinesItem BudgetLine
   * @return Budget
   */
  public Budget addBudgetLinesItem(BudgetLine budgetLinesItem) {
    if (this.budgetLines == null) {
      this.budgetLines = new ArrayList<BudgetLine>();
    }
    this.budgetLines.add(budgetLinesItem);
    return this;
  }

  /**
   * Get budgetLines
   *
   * @return budgetLines
   */
  @ApiModelProperty(value = "")
  /**
   * budgetLines
   *
   * @return budgetLines List<BudgetLine>
   */
  public List<BudgetLine> getBudgetLines() {
    return budgetLines;
  }

  /**
   * budgetLines
   *
   * @param budgetLines List&lt;BudgetLine&gt;
   */
  public void setBudgetLines(List<BudgetLine> budgetLines) {
    this.budgetLines = budgetLines;
  }

  /**
   * tracking
   *
   * @param tracking List&lt;TrackingCategory&gt;
   * @return Budget
   */
  public Budget tracking(List<TrackingCategory> tracking) {
    this.tracking = tracking;
    return this;
  }

  /**
   * tracking
   *
   * @param trackingItem TrackingCategory
   * @return Budget
   */
  public Budget addTrackingItem(TrackingCategory trackingItem) {
    if (this.tracking == null) {
      this.tracking = new ArrayList<TrackingCategory>();
    }
    this.tracking.add(trackingItem);
    return this;
  }

  /**
   * Get tracking
   *
   * @return tracking
   */
  @ApiModelProperty(value = "")
  /**
   * tracking
   *
   * @return tracking List<TrackingCategory>
   */
  public List<TrackingCategory> getTracking() {
    return tracking;
  }

  /**
   * tracking
   *
   * @param tracking List&lt;TrackingCategory&gt;
   */
  public void setTracking(List<TrackingCategory> tracking) {
    this.tracking = tracking;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Budget budget = (Budget) o;
    return Objects.equals(this.budgetID, budget.budgetID)
        && Objects.equals(this.type, budget.type)
        && Objects.equals(this.description, budget.description)
        && Objects.equals(this.updatedDateUTC, budget.updatedDateUTC)
        && Objects.equals(this.budgetLines, budget.budgetLines)
        && Objects.equals(this.tracking, budget.tracking);
  }

  @Override
  public int hashCode() {
    return Objects.hash(budgetID, type, description, updatedDateUTC, budgetLines, tracking);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Budget {\n");
    sb.append("    budgetID: ").append(toIndentedString(budgetID)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    updatedDateUTC: ").append(toIndentedString(updatedDateUTC)).append("\n");
    sb.append("    budgetLines: ").append(toIndentedString(budgetLines)).append("\n");
    sb.append("    tracking: ").append(toIndentedString(tracking)).append("\n");
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