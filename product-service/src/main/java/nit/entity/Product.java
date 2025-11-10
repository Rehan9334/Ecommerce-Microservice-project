package nit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    
	@Id
	private String id;        // MongoDB ObjectId
    private String name;      // ✅ Matches JSON "name"
    private String category;  // ✅ Matches JSON "category"
    private double price;     // ✅ Matches JSON "price"
    private int quantity;     // ✅ Matches JSON "quantity"
}
