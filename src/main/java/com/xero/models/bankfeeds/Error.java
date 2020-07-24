/*
 * Bank Feeds API
 * This specifing endpoints Xero Bank feeds API
 *
 * The version of the OpenAPI document: 2.2.9
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.bankfeeds;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xero.api.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * On error, the API consumer will receive an HTTP response with a HTTP Status Code of 4xx or 5xx
 * and a Content-Type of application/problem+json.
 */
@ApiModel(
    description =
        "On error, the API consumer will receive an HTTP response with a HTTP Status Code of 4xx"
            + " or 5xx and a Content-Type of application/problem+json.")
public class Error {
  StringUtil util = new StringUtil();

  @JsonProperty("title")
  private String title;

  @JsonProperty("status")
  private Integer status;

  @JsonProperty("detail")
  private String detail;
  /** Identifies the type of error. */
  public enum TypeEnum {
    INVALID_REQUEST("invalid-request"),

    INVALID_APPLICATION("invalid-application"),

    INVALID_FEED_CONNECTION("invalid-feed-connection"),

    DUPLICATE_STATEMENT("duplicate-statement"),

    INVALID_END_BALANCE("invalid-end-balance"),

    INVALID_START_AND_END_DATE("invalid-start-and-end-date"),

    INVALID_START_DATE("invalid-start-date"),

    INTERNAL_ERROR("internal-error"),

    FEED_ALREADY_CONNECTED_IN_CURRENT_ORGANISATION(
        "feed-already-connected-in-current-organisation");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  public Error title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Human readable high level error description. maximum: 255
   *
   * @return title
   */
  @ApiModelProperty(
      example = "Invalid Application",
      value = "Human readable high level error description.")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Error status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The numeric HTTP Status Code, e.g. 404
   *
   * @return status
   */
  @ApiModelProperty(example = "403", value = "The numeric HTTP Status Code, e.g. 404")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Error detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * Human readable detailed error description. maximum: 255
   *
   * @return detail
   */
  @ApiModelProperty(
      example = "The application has not been configured to use these API endpoints.",
      value = "Human readable detailed error description.")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Error type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Identifies the type of error.
   *
   * @return type
   */
  @ApiModelProperty(example = "invalid-application", value = "Identifies the type of error.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.title, error.title)
        && Objects.equals(this.status, error.status)
        && Objects.equals(this.detail, error.detail)
        && Objects.equals(this.type, error.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, status, detail, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
