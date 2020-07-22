package com.freddiemac.datamanager.ws.service;

import com.freddiemac.datamanager.ws.dto.ServiceParams;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeException;
import com.freddiemac.datamanager.ws.model.ResponseType;

public interface DataService {
	
	public ResponseType getResponse(ServiceParams serviceParams) throws EsafeException;

}
