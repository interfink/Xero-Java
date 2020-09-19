/*
 * Xero Projects API
 * This is the Xero Projects API
 *
 * The version of the OpenAPI document: 2.3.0
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** Pagination */
public class Pagination {
  StringUtil util = new StringUtil();

  @JsonProperty("page")
  private Integer page;

  @JsonProperty("pageSize")
  private Integer pageSize;

  @JsonProperty("pageCount")
  private Integer pageCount;

  @JsonProperty("itemCount")
  private Integer itemCount;

  public Pagination page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Set to 1 by default. The requested number of the page in paged response - Must be a number
   * greater than 0.
   *
   * @return page
   */
  @ApiModelProperty(
      example = "1",
      value =
          "Set to 1 by default. The requested number of the page in paged response - Must be a"
              + " number greater than 0.")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Pagination pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Optional, it is set to 50 by default. The number of items to return per page in a paged
   * response - Must be a number between 1 and 500.
   *
   * @return pageSize
   */
  @ApiModelProperty(
      example = "10",
      value =
          "Optional, it is set to 50 by default. The number of items to return per page in a paged"
              + " response - Must be a number between 1 and 500.")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Pagination pageCount(Integer pageCount) {
    this.pageCount = pageCount;
    return this;
  }

  /**
   * Number of pages available
   *
   * @return pageCount
   */
  @ApiModelProperty(example = "1", value = "Number of pages available")
  public Integer getPageCount() {
    return pageCount;
  }

  public void setPageCount(Integer pageCount) {
    this.pageCount = pageCount;
  }

  public Pagination itemCount(Integer itemCount) {
    this.itemCount = itemCount;
    return this;
  }

  /**
   * Number of items returned
   *
   * @return itemCount
   */
  @ApiModelProperty(example = "2", value = "Number of items returned")
  public Integer getItemCount() {
    return itemCount;
  }

  public void setItemCount(Integer itemCount) {
    this.itemCount = itemCount;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pagination pagination = (Pagination) o;
    return Objects.equals(this.page, pagination.page)
        && Objects.equals(this.pageSize, pagination.pageSize)
        && Objects.equals(this.pageCount, pagination.pageCount)
        && Objects.equals(this.itemCount, pagination.itemCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pageSize, pageCount, itemCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pagination {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageCount: ").append(toIndentedString(pageCount)).append("\n");
    sb.append("    itemCount: ").append(toIndentedString(itemCount)).append("\n");
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
