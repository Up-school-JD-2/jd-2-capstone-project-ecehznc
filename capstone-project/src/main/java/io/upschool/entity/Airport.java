package io.upschool.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Data
@Table(name="airport")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Airport {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

	@Column(name = "code", nullable = false, length = 100, unique = true)
    private String code;
	
	@Column(name = "is_active")
    private Boolean active;
	
	


}
