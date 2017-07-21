package com.doj.web.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.doj.web.model.Product;

public class ProductRowMapper implements RowMapper<Product>{

  @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	  Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        product.setCode(rs.getString("code"));
        return product;
    }

}