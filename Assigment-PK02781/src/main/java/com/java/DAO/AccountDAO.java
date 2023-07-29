package com.java.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
	
}
