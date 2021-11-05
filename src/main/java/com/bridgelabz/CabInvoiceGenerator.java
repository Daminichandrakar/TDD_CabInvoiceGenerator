package com.bridgelabz;

/**
 * Purpose : To simulate Cab Service
 *
 * @author DAMINI CHANDRAKAR
 * @version 11.0.11
 * @since 2021-11-05
 */
public class CabInvoiceGenerator {

	RideRepository rideRepository;
	private CabSubscriptions cabSubscriptions;

	public CabInvoiceGenerator(CabSubscriptions cabSubscriptions) {
		this.rideRepository = new RideRepository();
		this.cabSubscriptions = cabSubscriptions;
	}

	/**
	 * Purpose : calculate totalFare and minimumFare
	 * 
	 * @param distance
	 * @param time
	 * @return double(totalFare & minimumFare)
	 */
	public double calculateFare(double distance, int time) {
		return cabSubscriptions.calculateFare(distance, time);
	}

	/**
	 * Purpose : To calculate the invoiceSummary for multiple rides
	 * 
	 * @param rides
	 * @return InvoiceSummary : return invoiceSummary object
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	/**
	 * Purpose : Add rides as per userId
	 * 
	 * @param userId
	 * @param rides
	 */
	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}

	/**
	 * Purpose : To get an invoiceSummary per userId
	 * 
	 * @param userId
	 * @return InvoiceSummary
	 */
	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

}
