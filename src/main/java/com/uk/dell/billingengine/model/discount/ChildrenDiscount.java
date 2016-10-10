package com.uk.dell.billingengine.model.discount;

public class ChildrenDiscount implements DiscountStrategy {

  public double applyDiscount(double cost) {
    return cost / 100 * 60; //40% discount
  }
}
