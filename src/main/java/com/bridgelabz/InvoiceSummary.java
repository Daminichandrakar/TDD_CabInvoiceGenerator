package com.bridgelabz;

/**
 * Purpose : class create for invoiceSummary calculate
 * numberOfRides,totalFare,averageFare
 * 
 */
public class InvoiceSummary {

	private int numberOfRides;
	private double totalFare;
	private double averageFare;

	public InvoiceSummary(int numberOfRides, double totaleFare) {
		this.numberOfRides = numberOfRides;
		this.totalFare = totaleFare;
		this.averageFare = this.numberOfRides / this.averageFare;
	}

	/**
	 * Purpose : override the equals method
	 * 
	 * @param : Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		return Double.doubleToLongBits(averageFare) == Double.doubleToLongBits(other.averageFare)
				&& numberOfRides == other.numberOfRides
				&& Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(other.totalFare);
	}

}
