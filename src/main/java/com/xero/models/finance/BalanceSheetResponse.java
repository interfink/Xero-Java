/*
 * Xero Finance API
 * The Finance API is a collection of endpoints which customers can use in the course of a loan application, which may assist lenders to gain the confidence they need to provide capital.
 *
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import org.threeten.bp.LocalDate;

/** BalanceSheetResponse */
public class BalanceSheetResponse {
  StringUtil util = new StringUtil();

  @JsonProperty("balanceDate")
  private LocalDate balanceDate;

  @JsonProperty("asset")
  private BalanceSheetAccountGroup asset;

  @JsonProperty("liability")
  private BalanceSheetAccountGroup liability;

  @JsonProperty("equity")
  private BalanceSheetAccountGroup equity;
  /**
   * Balance date of the report
   *
   * @param balanceDate LocalDate
   * @return BalanceSheetResponse
   */
  public BalanceSheetResponse balanceDate(LocalDate balanceDate) {
    this.balanceDate = balanceDate;
    return this;
  }

  /**
   * Balance date of the report
   *
   * @return balanceDate
   */
  @ApiModelProperty(value = "Balance date of the report")
  /**
   * Balance date of the report
   *
   * @return balanceDate LocalDate
   */
  public LocalDate getBalanceDate() {
    return balanceDate;
  }

  /**
   * Balance date of the report
   *
   * @param balanceDate LocalDate
   */
  public void setBalanceDate(LocalDate balanceDate) {
    this.balanceDate = balanceDate;
  }

  /**
   * asset
   *
   * @param asset BalanceSheetAccountGroup
   * @return BalanceSheetResponse
   */
  public BalanceSheetResponse asset(BalanceSheetAccountGroup asset) {
    this.asset = asset;
    return this;
  }

  /**
   * Get asset
   *
   * @return asset
   */
  @ApiModelProperty(value = "")
  /**
   * asset
   *
   * @return asset BalanceSheetAccountGroup
   */
  public BalanceSheetAccountGroup getAsset() {
    return asset;
  }

  /**
   * asset
   *
   * @param asset BalanceSheetAccountGroup
   */
  public void setAsset(BalanceSheetAccountGroup asset) {
    this.asset = asset;
  }

  /**
   * liability
   *
   * @param liability BalanceSheetAccountGroup
   * @return BalanceSheetResponse
   */
  public BalanceSheetResponse liability(BalanceSheetAccountGroup liability) {
    this.liability = liability;
    return this;
  }

  /**
   * Get liability
   *
   * @return liability
   */
  @ApiModelProperty(value = "")
  /**
   * liability
   *
   * @return liability BalanceSheetAccountGroup
   */
  public BalanceSheetAccountGroup getLiability() {
    return liability;
  }

  /**
   * liability
   *
   * @param liability BalanceSheetAccountGroup
   */
  public void setLiability(BalanceSheetAccountGroup liability) {
    this.liability = liability;
  }

  /**
   * equity
   *
   * @param equity BalanceSheetAccountGroup
   * @return BalanceSheetResponse
   */
  public BalanceSheetResponse equity(BalanceSheetAccountGroup equity) {
    this.equity = equity;
    return this;
  }

  /**
   * Get equity
   *
   * @return equity
   */
  @ApiModelProperty(value = "")
  /**
   * equity
   *
   * @return equity BalanceSheetAccountGroup
   */
  public BalanceSheetAccountGroup getEquity() {
    return equity;
  }

  /**
   * equity
   *
   * @param equity BalanceSheetAccountGroup
   */
  public void setEquity(BalanceSheetAccountGroup equity) {
    this.equity = equity;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BalanceSheetResponse balanceSheetResponse = (BalanceSheetResponse) o;
    return Objects.equals(this.balanceDate, balanceSheetResponse.balanceDate)
        && Objects.equals(this.asset, balanceSheetResponse.asset)
        && Objects.equals(this.liability, balanceSheetResponse.liability)
        && Objects.equals(this.equity, balanceSheetResponse.equity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balanceDate, asset, liability, equity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BalanceSheetResponse {\n");
    sb.append("    balanceDate: ").append(toIndentedString(balanceDate)).append("\n");
    sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
    sb.append("    liability: ").append(toIndentedString(liability)).append("\n");
    sb.append("    equity: ").append(toIndentedString(equity)).append("\n");
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