package com.example.demo.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -7519562280486632640L;
	
	@Id
	@GeneratedValue
	@GenericGenerator(name = "id")
	@Column(updatable = false, nullable = false)
	private UUID id;
	
	@CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

	@Column
    @UpdateTimestamp
    private Timestamp lastModifiedDate;

	public BaseEntity() {
		super();
	}

	public BaseEntity(UUID id) {
		super();
		this.id = id;
	}
	
	public boolean isNew() {
		return this.id == null;
	}

}
