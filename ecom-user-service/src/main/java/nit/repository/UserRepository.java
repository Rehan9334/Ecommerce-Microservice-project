package nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nit.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
