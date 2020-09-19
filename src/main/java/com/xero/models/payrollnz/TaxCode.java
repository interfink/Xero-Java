/*
 * Xero Payroll NZ
 * This is the Xero Payroll API for orgs in the NZ region.
 *
 * The version of the OpenAPI document: 2.3.0
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.payrollnz;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Tax codes used for employee tax */
public enum TaxCode {
  ND("ND"),

  M("M"),

  ME("ME"),

  MSL("MSL"),

  MESL("MESL"),

  SB("SB"),

  S("S"),

  SH("SH"),

  ST("ST"),

  SBSL("SBSL"),

  SSL("SSL"),

  SHSL("SHSL"),

  STSL("STSL"),

  WT("WT"),

  CAE("CAE"),

  EDW("EDW"),

  NSW("NSW"),

  STC("STC"),

  STCSL("STCSL");

  private String value;

  TaxCode(String value) {
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
  public static TaxCode fromValue(String value) {
    for (TaxCode b : TaxCode.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
