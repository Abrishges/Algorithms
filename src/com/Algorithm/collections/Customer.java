/**
 *
 */
package com.Algorithm.collections;

/**
 * @author aberehamwodajie
 *
 *         Jun 17, 2017
 */
public class Customer {
  private String firstName;
  private String lastName;
  private Integer age;
  private String country;

  public Customer(final String firstName, final String lastName, final Integer age, final String country) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.country = country;

  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(final Integer age) {
    this.age = age;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(final String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "Customer [firstName=" + this.firstName + ", lastName=" + this.lastName + ", age=" + this.age + ", country="
        + this.country + "]";
  }
}
