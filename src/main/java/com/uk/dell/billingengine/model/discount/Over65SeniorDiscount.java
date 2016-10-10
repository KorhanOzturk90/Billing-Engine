package com.uk.dell.billingengine.model.discount;

public class Over65SeniorDiscount implements DiscountStrategy {

  public double applyDiscount(double cost) {
    return cost / 100 * 40; //60% discount
  }
}
