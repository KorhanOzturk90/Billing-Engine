package com.uk.dell.billingengine.model.service;

public class Diagnosis implements HealthService {
  private static final double price = 60;

  public double getCost() {
    return price;
  }
}
