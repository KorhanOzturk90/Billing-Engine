package com.uk.dell.billingengine.model.service;

public class Vaccine implements HealthService {

  private double price = 27.5;
  private double quantity;

  public Vaccine(double quantity) {
    this.quantity = quantity;
  }

  public double getCost() {
    return price + quantity * 15;
  }
}
