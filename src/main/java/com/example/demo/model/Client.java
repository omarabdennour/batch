package com.example.demo.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Builder(toBuilder=true)
@Data
@Entity
@Table(name = "Clients")
public class Client extends BaseEntity{
	
	@JsonIgnore
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true, nullable = false)
	private String email ;
	
	private String name ;
	
	private boolean isEnabled ;
	
	private boolean isProcessed ;
	
	

}
