/*
 * Xero AppStore API
 * These endpoints are for Xero Partners to interact with the App Store Billing platform
 *
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.appstore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.UUID;
import org.threeten.bp.OffsetDateTime;

/** SubscriptionItem */
public class SubscriptionItem {
  StringUtil util = new StringUtil();

  @JsonProperty("endDate")
  private OffsetDateTime endDate;

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("price")
  private Price price;

  @JsonProperty("product")
  private Product product;

  @JsonProperty("startDate")
  private OffsetDateTime startDate;

  @JsonProperty("testMode")
  private Boolean testMode;
  /**
   * Date when the subscription to this product will end
   *
   * @param endDate OffsetDateTime
   * @return SubscriptionItem
   */
  public SubscriptionItem endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Date when the subscription to this product will end
   *
   * @return endDate
   */
  @ApiModelProperty(value = "Date when the subscription to this product will end")
  /**
   * Date when the subscription to this product will end
   *
   * @return endDate OffsetDateTime
   */
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  /**
   * Date when the subscription to this product will end
   *
   * @param endDate OffsetDateTime
   */
  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  /**
   * The unique identifier of the subscription item.
   *
   * @param id UUID
   * @return SubscriptionItem
   */
  public SubscriptionItem id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the subscription item.
   *
   * @return id
   */
  @ApiModelProperty(required = true, value = "The unique identifier of the subscription item.")
  /**
   * The unique identifier of the subscription item.
   *
   * @return id UUID
   */
  public UUID getId() {
    return id;
  }

  /**
   * The unique identifier of the subscription item.
   *
   * @param id UUID
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * price
   *
   * @param price Price
   * @return SubscriptionItem
   */
  public SubscriptionItem price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   *
   * @return price
   */
  @ApiModelProperty(required = true, value = "")
  /**
   * price
   *
   * @return price Price
   */
  public Price getPrice() {
    return price;
  }

  /**
   * price
   *
   * @param price Price
   */
  public void setPrice(Price price) {
    this.price = price;
  }

  /**
   * product
   *
   * @param product Product
   * @return SubscriptionItem
   */
  public SubscriptionItem product(Product product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   *
   * @return product
   */
  @ApiModelProperty(required = true, value = "")
  /**
   * product
   *
   * @return product Product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * product
   *
   * @param product Product
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  /**
   * Date the subscription started, or will start. Note: this could be in the future for downgrades
   * or reduced number of seats that haven&#39;t taken effect yet.
   *
   * @param startDate OffsetDateTime
   * @return SubscriptionItem
   */
  public SubscriptionItem startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Date the subscription started, or will start. Note: this could be in the future for downgrades
   * or reduced number of seats that haven&#39;t taken effect yet.
   *
   * @return startDate
   */
  @ApiModelProperty(
      required = true,
      value =
          "Date the subscription started, or will start. Note: this could be in the future for"
              + " downgrades or reduced number of seats that haven't taken effect yet. ")
  /**
   * Date the subscription started, or will start. Note: this could be in the future for downgrades
   * or reduced number of seats that haven&#39;t taken effect yet.
   *
   * @return startDate OffsetDateTime
   */
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  /**
   * Date the subscription started, or will start. Note: this could be in the future for downgrades
   * or reduced number of seats that haven&#39;t taken effect yet.
   *
   * @param startDate OffsetDateTime
   */
  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  /**
   * If the subscription is a test subscription
   *
   * @param testMode Boolean
   * @return SubscriptionItem
   */
  public SubscriptionItem testMode(Boolean testMode) {
    this.testMode = testMode;
    return this;
  }

  /**
   * If the subscription is a test subscription
   *
   * @return testMode
   */
  @ApiModelProperty(value = "If the subscription is a test subscription")
  /**
   * If the subscription is a test subscription
   *
   * @return testMode Boolean
   */
  public Boolean getTestMode() {
    return testMode;
  }

  /**
   * If the subscription is a test subscription
   *
   * @param testMode Boolean
   */
  public void setTestMode(Boolean testMode) {
    this.testMode = testMode;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionItem subscriptionItem = (SubscriptionItem) o;
    return Objects.equals(this.endDate, subscriptionItem.endDate)
        && Objects.equals(this.id, subscriptionItem.id)
        && Objects.equals(this.price, subscriptionItem.price)
        && Objects.equals(this.product, subscriptionItem.product)
        && Objects.equals(this.startDate, subscriptionItem.startDate)
        && Objects.equals(this.testMode, subscriptionItem.testMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endDate, id, price, product, startDate, testMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionItem {\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    testMode: ").append(toIndentedString(testMode)).append("\n");
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
