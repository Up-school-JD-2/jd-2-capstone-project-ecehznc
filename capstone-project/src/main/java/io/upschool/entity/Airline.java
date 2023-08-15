package io.upschool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "airline")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 100)
    private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_id", nullable = false)
	private Airport airport;
	
	


}
