package com.uk.dell.billingengine.model.service;

public class XRay implements HealthService {

  private static final double price = 150;

  public double getCost() {
    return price;
  }
}
