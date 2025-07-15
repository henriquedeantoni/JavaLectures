package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, Integer months) {
		
		Double minimalQuota = contract.getTotalValue()/months;
		
		for (int i=1; i<=months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			Double interest = onlinePaymentService.interest(minimalQuota, i);
			Double fee = onlinePaymentService.paymentFee(minimalQuota + interest);
			Double quota = minimalQuota + fee + interest;
			
			contract.getInstallments().add(new Installment(dueDate, quota));
		}
	}
}
