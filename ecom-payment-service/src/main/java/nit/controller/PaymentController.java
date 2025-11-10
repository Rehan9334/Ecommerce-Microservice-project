package nit.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final Random random=new Random();
	
	@PostMapping
	@CircuitBreaker(name = "paymentCB", fallbackMethod = "paymentFallback")
	public String processPayments(@RequestBody Object order) {
		
		System.out.println("Processing payment...");

        // Simulate random failure
        if (random.nextBoolean()) {
            throw new RuntimeException("Payment gateway timeout");
        }

        return "Payment successful for order";
	}
	
	public String paymentFallback(Object order, Throwable t) {
        System.out.println("⚠️ Payment fallback triggered: " + t.getMessage());
        return "Payment failed - circuit breaker active";
    }
	
}
