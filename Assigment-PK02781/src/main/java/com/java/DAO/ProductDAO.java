package com.java.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.entity.Products;
import com.java.entity.Report;

public interface ProductDAO extends JpaRepository<Products, Integer> {
	@Query("SELECT p FROM Products p WHERE p.price BETWEEN ?1 AND ?2")
	List<Products> findByPrice(Double min, Double max);
	
	@Query("SELECT p FROM Products p WHERE p.name LIKE ?1")
	Page<Products> findByNamePage(String name, Pageable pageable);
	
	@Query("SELECT new Report(p.category, sum(p.price), count(p)) FROM Products p GROUP BY p.category ORDER BY sum(p.price) DESC")
	List<Report> getInventoryByCategory();
}
