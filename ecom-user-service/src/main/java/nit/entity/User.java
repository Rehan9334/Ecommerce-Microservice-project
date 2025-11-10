package nit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="userdb")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
}
