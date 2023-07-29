package com.java.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="product")
public class Products implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	
	@NotNull(message= "ID is required")
	Integer id;
	
	@NotBlank(message = "Name is required")
	String name;
	
	@Column(name = "image")
	String image;
	
	@Min(value = 0, message = "Price must be a positive number")
	@NotNull(message = "Price is required")
	Double price;
	
	@NotBlank(message = "Description is required")
	String description;
	
	@ManyToOne 
	@JoinColumn(name = "Categoryid")
	Category category;
	
}
