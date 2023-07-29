package com.java.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="account")
public class Account implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 String username;
	 String password;
	 String email;
	 Integer roles;
	
}
