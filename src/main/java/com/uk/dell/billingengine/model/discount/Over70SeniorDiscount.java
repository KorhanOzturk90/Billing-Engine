package com.uk.dell.billingengine.model.discount;

public class Over70SeniorDiscount implements DiscountStrategy {

  public double applyDiscount(double cost) {
    return cost / 100 * 10 ; //90% discount
  }
}
