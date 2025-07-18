package services;

public class FastDelivery implements DeliveryService {
	public double calculateFee(double baseAmount) {
		return baseAmount  + 5 + baseAmount*0.015;
	}
}
