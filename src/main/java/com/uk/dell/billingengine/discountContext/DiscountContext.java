package com.uk.dell.billingengine.discountContext;

import com.uk.dell.billingengine.model.discount.DiscountStrategy;

public class DiscountContext {

  private DiscountStrategy discountStrategy;

  public void setDiscountStrategy(DiscountStrategy discountStrategy) {
    this.discountStrategy = discountStrategy;
  }

  public void applyDiscountStrategy(double cost) {
    discountStrategy.applyDiscount(cost);
  }
}
