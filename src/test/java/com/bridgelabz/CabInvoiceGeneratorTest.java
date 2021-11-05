package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(CabSubscriptions.NORMAL);
		double result = cabInvoiceGenerator.calculateFare(15, 30);
		Assert.assertEquals(180, result, 0.0);
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnMinFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(CabSubscriptions.NORMAL);
		double result = cabInvoiceGenerator.calculateFare(0.1, 1);
		Assert.assertEquals(5, result, 0.0);

	}

	@Test
	public void givenMultipleDistanceAndTime_ShouldReturnInvoiceSummary() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(CabSubscriptions.NORMAL);
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInnoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInnoiceSummary, summary);
	}

	@Test
	public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(CabSubscriptions.NORMAL);
		String userId = "userOne";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		cabInvoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

	@Test
	public void givenDistanceAndTime_WhenPremiumSubscription_ShouldReturnTotalFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(CabSubscriptions.PREMIUM);
		double result = cabInvoiceGenerator.calculateFare(15, 30);
		Assert.assertEquals(285, result, 0.0);
	}

	@Test
	public void givenDistanceAndTime_WhenPremiumSubscription_ShouldReturnMinFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(CabSubscriptions.PREMIUM);
		double result = cabInvoiceGenerator.calculateFare(0.1, 1);
		Assert.assertEquals(20, result, 0.0);

	}

	@Test
	public void givenMultipleDistanceAndTime_WhenPremiumSubscription_ShouldReturnInvoiceSummary() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(CabSubscriptions.PREMIUM);
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInnoiceSummary = new InvoiceSummary(2, 60.0);
		Assert.assertEquals(expectedInnoiceSummary, summary);
	}

	@Test
	public void givenUserIdAndRides_WhenPremiumSubscription_shouldReturnInvoiceSummary() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator(CabSubscriptions.PREMIUM);
		String userId = "userOne";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		cabInvoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

}
