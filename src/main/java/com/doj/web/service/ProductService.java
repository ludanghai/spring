package com.doj.web.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doj.web.model.Product;
import com.doj.web.utils.ProductRowMapper;

@Service
public class ProductService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return jdbcTemplate.query("select * from products", new ProductRowMapper());
	}

	@Transactional(readOnly = true)
	public Product findProductById(int id) {
		return jdbcTemplate.queryForObject("select * from products where id=?", new Object[] { id },
				new ProductRowMapper());
	}

	public Product create(final Product product) {
		final String sql = "insert into products(id,name,price,code) values(?,?,?,?)";

		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, product.getId());
				ps.setString(2, product.getName());
				ps.setInt(3, product.getPrice());
				ps.setString(4, product.getCode());
				return ps;
			}
		}, holder);

		int newProductId = holder.getKey().intValue();
		product.setId(newProductId);
		return product;
	}
	
	public void update(String name, int id) {
		jdbcTemplate.update("update products set name = ? WHERE id = ?", name, id);
	}
}
