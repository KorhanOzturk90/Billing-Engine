package com.uk.dell.billingengine.model.service;

public class ECG implements HealthService {
  private static final double price = 200.40;

  public double getCost() {
    return price;
  }
}
