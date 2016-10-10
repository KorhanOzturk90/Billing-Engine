package com.uk.dell.billingengine.checkout;

import static org.junit.Assert.assertEquals;

import com.uk.dell.billingengine.model.Patient;
import com.uk.dell.billingengine.model.service.BloodTest;
import com.uk.dell.billingengine.model.service.Diagnosis;
import com.uk.dell.billingengine.model.service.ECG;
import com.uk.dell.billingengine.model.service.HealthService;
import com.uk.dell.billingengine.model.service.Vaccine;
import com.uk.dell.billingengine.model.service.XRay;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {
  private Checkout checkout;
  private HealthService treatment;
  private Patient patient;

  @Before
  public void setUp() {
    checkout = new Checkout();
  }

  @Test
  public void totalCostWithNoTreatment() {
    patient = new Patient(5, true);
    assertEquals(0d, checkout.calculateTotalCheckout(null, patient), 0);
  }

  @Test
  public void totalCostWithoutAnyDiscountForDiagnosis() {
    treatment = new Diagnosis();
    patient = new Patient(40, false);
    assertEquals(60d, checkout.calculateTotalCheckout(treatment, patient), 0);
  }

  @Test
  public void totalCostWithoutAnyDiscountForBloodTest() {
    treatment = new BloodTest();
    patient = new Patient(40, false);
    assertEquals(78d, checkout.calculateTotalCheckout(treatment, patient), 0);
  }

  @Test
  public void totalCostWithOnlyInsuranceDiscountForBloodTest() {
    treatment = new BloodTest();
    patient = new Patient(40, true);
    assertEquals(66.3, checkout.calculateTotalCheckout(treatment, patient), 0);
  }

  @Test
  public void totalCostWithInsuranceAndChildrenDiscount() {
    treatment = new BloodTest();
    patient = new Patient(5, true);
    assertEquals(39.779, checkout.calculateTotalCheckout(treatment, patient), 0.5);
  }

  @Test
  public void totalCostWithOver70DiscountForECG() {
    treatment = new ECG();
    patient = new Patient(75, true);
    assertEquals(20.04, checkout.calculateTotalCheckout(treatment, patient), 0.5);
  }

  @Test
  public void totalCostWithOver70DiscountForBloodTestNoInsurance() {
    treatment = new BloodTest();
    patient = new Patient(75, false);
    assertEquals(7.8, checkout.calculateTotalCheckout(treatment, patient), 0.1);
  }

  @Test
  public void totalCostWithOver70DiscountForBloodTestWithInsurance() {
    treatment = new BloodTest();
    patient = new Patient(75, true);
    assertEquals(6.63, checkout.calculateTotalCheckout(treatment, patient), 0.1);
  }

  @Test
  public void totalCostWithoutAnyDiscountForOneVaccine() {
    treatment = new Vaccine(1);
    patient = new Patient(40, false);
    assertEquals(42.5d, checkout.calculateTotalCheckout(treatment, patient), 0);
  }

  @Test
  public void totalCostWithoutAnyDiscountForTwoVaccines() {
    treatment = new Vaccine(2);
    patient = new Patient(40, false);
    assertEquals(57.5d, checkout.calculateTotalCheckout(treatment, patient), 0);
  }

  @Test
  public void totalCostOver65DiscountForTwoVaccines() {
    treatment = new Vaccine(2);
    patient = new Patient(67, false);
    assertEquals(23.0, checkout.calculateTotalCheckout(treatment, patient), 0);
  }

  @Test
  public void totalCostNoDiscountForXRay() {
    treatment = new XRay();
    patient = new Patient(64, false);
    assertEquals(150d, checkout.calculateTotalCheckout(treatment, patient), 0);
  }

  @Test
  public void totalCostOver65DiscountForXRay() {
    treatment = new XRay();
    patient = new Patient(65, false);
    assertEquals(60d, checkout.calculateTotalCheckout(treatment, patient), 0);
  }
}
