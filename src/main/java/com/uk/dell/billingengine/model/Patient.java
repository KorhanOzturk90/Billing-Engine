package com.uk.dell.billingengine.model;

public class Patient {

  private int age;
  private boolean isInsured;

  public Patient(int age, boolean isInsured) {
    this.age = age;
    this.isInsured = isInsured;
  }

  public int getAge() {
    return age;
  }

  public boolean isInsured() {
    return isInsured;
  }

}
