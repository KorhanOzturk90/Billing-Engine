package com.uk.dell.billingengine.model.discount;

public class InsuranceDiscount implements DiscountStrategy {
  public double applyDiscount(double cost) {
    return cost * 85 / 100; //Extra %15 discount
  }
}
