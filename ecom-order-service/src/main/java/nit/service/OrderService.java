package nit.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import nit.entity.Order;
import nit.kafka.OrderEventProducer;
import nit.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepo;
	private final OrderEventProducer producer;
	private RestTemplate restTemplate;
	
	public Order placeOrder(Order order) {
		order.setStatus("PENDING");
		/*Order saved=orderRepo.save(order);*/
		
		
		try {
			String productServiceUrl="http://product-service/products/"+ order.getProductId();
			ProductResponse product=restTemplate.getForObject(productServiceUrl, ProductResponse.class);
			
			System.out.println("product fetch::"+product.getName()+ " | Price: " + product.getPrice());
			
		} catch (Exception ex) {
			System.out.println("Failed to fetch product details: " + ex.getMessage());
            order.setStatus("FAILED");
            return orderRepo.save(order);
		}
		
		
		try {
            String paymentUrl = "http://localhost:1035/payments";
            String response = restTemplate.postForObject(paymentUrl, order, String.class);
            System.out.println("Payment response: " + response);
            order.setStatus("SUCCESS");
        } catch (Exception ex) {
            System.out.println("Payment failed: " + ex.getMessage());
            order.setStatus("FAILED");
            producer.sendOrderStatus(order.getId(), "FAILED");
        }

        return orderRepo.save(order);
	}
	
	public List<Order> getAllOrders() {
        return orderRepo.findAll();
   }
}