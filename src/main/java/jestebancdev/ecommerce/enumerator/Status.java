package jestebancdev.ecommerce.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
	PAID(0), PENDING(1), NONPAYMENT(2),DELETED(3);
	
	private final int status;
}
