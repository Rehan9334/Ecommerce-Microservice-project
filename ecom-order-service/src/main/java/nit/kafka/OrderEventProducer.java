package nit.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderEventProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendOrderStatus(Long orderId,String status) {
		String event = orderId + ":" + status;
        kafkaTemplate.send("order-status", event);
        System.out.println("📤 Published Kafka event -> " + event);
	}
}
