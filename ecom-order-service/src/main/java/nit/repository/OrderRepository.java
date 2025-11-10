package nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nit.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
