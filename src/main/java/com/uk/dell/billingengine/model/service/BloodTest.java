package com.uk.dell.billingengine.model.service;

public class BloodTest implements HealthService {

  private static final double price = 78;
  public double getCost() {
    return price;
  }
}
