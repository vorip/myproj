package com.paxnet.stock;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StockDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insert(StockDTO stockDTO) {
		mybatis.insert("stockDAO.insert",stockDTO);
	}
	public void select(String company) {
		mybatis.selectOne("stockDAO.select",company);
	}
	public void selectAll() {
		mybatis.selectList("stockDAO.selectAll");
	}
	public void update(StockDTO stockDTO) {
		mybatis.update("stockDAO.update",stockDTO);
	}
	public void delete(String company) {
		mybatis.delete("stockDAO.delete",company);
	}
	
	
	
}
