package com.freddiemac.datamanager.ws.service.impl;

import org.springframework.stereotype.Service;

import com.freddiemac.datamanager.ws.dto.ServiceParams;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeException;
import com.freddiemac.datamanager.ws.model.RequestType;
import com.freddiemac.datamanager.ws.model.ResponseMetaData;
import com.freddiemac.datamanager.ws.model.ResponseType;
import com.freddiemac.datamanager.ws.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	@Override
	public ResponseType getResponse(ServiceParams serviceParams) throws EsafeException {

		RequestType requestType = serviceParams.getRequest();

		ResponseType responseType = new ResponseType();

		ResponseMetaData responseMetaData = new ResponseMetaData();
		responseMetaData.setRequestIdentifier(requestType.getRequestMetadata().getRequestIdentifier());
		responseMetaData.setRequestRecordCount(requestType.getRequestMetadata().getRequestRecordCount());
		responseMetaData.setRequestSourceSystem(requestType.getRequestMetadata().getRequestSourceSystem());
		responseMetaData.setRequestTimeStamp(requestType.getRequestMetadata().getRequestTimeStamp());

		responseType.setResponseMetadata(responseMetaData);

		return responseType;
	}

}
