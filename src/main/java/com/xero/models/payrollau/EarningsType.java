/*
 * Xero Payroll AU API
 * This is the Xero Payroll API for orgs in Australia region.
 *
 * Contact: api@xero.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.xero.models.payrollau;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Gets or Sets EarningsType */
public enum EarningsType {

  /** FIXED */
  FIXED("FIXED"),

  /** ORDINARYTIMEEARNINGS */
  ORDINARYTIMEEARNINGS("ORDINARYTIMEEARNINGS"),

  /** OVERTIMEEARNINGS */
  OVERTIMEEARNINGS("OVERTIMEEARNINGS"),

  /** ALLOWANCE */
  ALLOWANCE("ALLOWANCE"),

  /** LUMPSUMD */
  LUMPSUMD("LUMPSUMD"),

  /** EMPLOYMENTTERMINATIONPAYMENT */
  EMPLOYMENTTERMINATIONPAYMENT("EMPLOYMENTTERMINATIONPAYMENT"),

  /** LUMPSUMA */
  LUMPSUMA("LUMPSUMA"),

  /** LUMPSUMB */
  LUMPSUMB("LUMPSUMB"),

  /** BONUSESANDCOMMISSIONS */
  BONUSESANDCOMMISSIONS("BONUSESANDCOMMISSIONS"),

  /** LUMPSUME */
  LUMPSUME("LUMPSUME"),

  /** LUMPSUMW */
  LUMPSUMW("LUMPSUMW"),

  /** DIRECTORSFEES */
  DIRECTORSFEES("DIRECTORSFEES");

  private String value;

  EarningsType(String value) {
    this.value = value;
  }

  /** @return String value */
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
  public static EarningsType fromValue(String value) {
    for (EarningsType b : EarningsType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
