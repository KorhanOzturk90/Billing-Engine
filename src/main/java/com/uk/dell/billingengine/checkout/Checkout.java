package com.uk.dell.billingengine.checkout;

import com.uk.dell.billingengine.discountContext.DiscountCalculator;
import com.uk.dell.billingengine.model.Patient;
import com.uk.dell.billingengine.model.discount.DiscountStrategy;
import com.uk.dell.billingengine.model.service.HealthService;

import java.util.List;

class Checkout {

  double calculateTotalCheckout(HealthService serviceReceived, Patient patient) {
    if (serviceReceived == null ){
      return 0;
    }
    DiscountCalculator calculator = new DiscountCalculator(patient, serviceReceived);
    List<DiscountStrategy> suitableStrategies = calculator.findSuitableStrategies();
    double totalCost = serviceReceived.getCost();
    for (DiscountStrategy strategy : suitableStrategies) {
      totalCost = strategy.applyDiscount(totalCost);
    }
    return totalCost;
  }
}
