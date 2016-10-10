package com.uk.dell.billingengine.discountContext;

import com.uk.dell.billingengine.model.Patient;
import com.uk.dell.billingengine.model.discount.ChildrenDiscount;
import com.uk.dell.billingengine.model.discount.DiscountStrategy;
import com.uk.dell.billingengine.model.discount.InsuranceDiscount;
import com.uk.dell.billingengine.model.discount.Over65SeniorDiscount;
import com.uk.dell.billingengine.model.discount.Over70SeniorDiscount;
import com.uk.dell.billingengine.model.service.BloodTest;
import com.uk.dell.billingengine.model.service.HealthService;

import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {

  private Patient patient;
  private HealthService serviceReceived;
  List<DiscountStrategy> discounts = new ArrayList<DiscountStrategy>();

  public DiscountCalculator(Patient patient, HealthService serviceReceived) {
    this.patient = patient;
    this.serviceReceived = serviceReceived;
  }

  public List<DiscountStrategy> findSuitableStrategies() {
    if (patient.getAge() > 70) {
      discounts.add(new Over70SeniorDiscount());
    } else if (patient.getAge() <= 70 && patient.getAge() >= 65) {
      discounts.add(new Over65SeniorDiscount());
    } else if (patient.getAge() <= 5) {
      discounts.add(new ChildrenDiscount());
    }
    if (serviceReceived instanceof BloodTest && patient.isInsured()) {
      discounts.add(new InsuranceDiscount());
    }
    return discounts;
  }
}
