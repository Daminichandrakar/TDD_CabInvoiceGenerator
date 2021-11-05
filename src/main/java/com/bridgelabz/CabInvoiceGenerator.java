package com.bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.NestingKind;

/**
 * Purpose : To simulate Cab Service
 *
 * @author DAMINI CHANDRAKAR
 * @version 11.0.11
 * @since 2021-11-05
 */
public class CabInvoiceGenerator {

	private final int MINIMUM_FARE = 5;
	private final int COST_PER_KILOMETER = 10;
	private final int COST_PER_MINUTE = 1;
	
	RideRepository rideRepository = new RideRepository();

	/**
	 * Purpose : calculate totalFare and minimumFare
	 * 
	 * @param distance
	 * @param time
	 * @return double(totalFare & minimumFare)
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = COST_PER_KILOMETER * distance + COST_PER_MINUTE * time;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length , totalFare);
	}
	
	  public void addRides(String userId, Ride[] rides) {
	        rideRepository.addRides(userId, rides);
	    }

	    public InvoiceSummary getInvoiceSummary(String userId) {
	        return this.calculateFare(rideRepository.getRides(userId));
	    }

}
