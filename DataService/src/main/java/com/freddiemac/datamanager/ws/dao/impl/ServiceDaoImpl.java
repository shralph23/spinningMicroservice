package com.freddiemac.datamanager.ws.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freddiemac.datamanager.ws.dao.ServiceDao;

@Repository
public class ServiceDaoImpl implements ServiceDao {

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<String> retrieveDataFromDB() {
		// TODO Auto-generated method stub
		return null;
	}

}
