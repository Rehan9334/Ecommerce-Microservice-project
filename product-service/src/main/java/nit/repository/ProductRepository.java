package nit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import nit.entity.Product;

public interface ProductRepository extends MongoRepository<Product,String> {

}
