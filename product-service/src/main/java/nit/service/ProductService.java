package nit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import nit.entity.Product;
import nit.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepo;
	
	public List<Product> getAll(){
		return productRepo.findAll();
	}
	
	public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProductById(String id) {
        return productRepo.findById(id).orElse(null);
    }
	
}
