package com.freddiemac.datamanager.ws.dto;

import javax.xml.datatype.XMLGregorianCalendar;

import com.freddiemac.datamanager.ws.esafe.util.DateUtils;
import com.freddiemac.datamanager.ws.esafe.util.DurationUtils;
import com.freddiemac.datamanager.ws.model.RequestType;
import com.freddiemac.datamanager.ws.model.ResponseType;

public class ServiceParams {

	// input from client
	private RequestType request = null;

	// output to client
	private ResponseType response = null;

	// Possible Match Count for Submission and borrowers
	private int possibleSubmissionMatchCount = 0;
	private int possibleBorrowerMatchCount = 0;

	// Model Retry Count
	private int modelRetryCount = 0;

	// items to be loaded during service execution
	private DurationUtils serviceDuration = new DurationUtils();
	private DurationUtils loadCacheDuration = new DurationUtils();
	private DurationUtils modelServiceDuration = new DurationUtils();
	private DurationUtils processResponseDuration = new DurationUtils();
	private DurationUtils transactionCommitDuration = new DurationUtils();

	// timings
	private XMLGregorianCalendar currentTimeStamp = null;
	private java.sql.Timestamp beginProcessingTimestamp = null; // begin of service processing
	private java.sql.Timestamp endProcessingTimestamp = null; // time as of before saving to database

	private ClientInfo clientInfo = null;

	// srs splunk logging flag
	private boolean splunkLoggingEnabled = Boolean.FALSE;

	private String message = null;

	public ServiceParams() {
	}

	public ServiceParams(ClientInfo clientInfo, RequestType request) {

		this.request = request;
		this.response = null;
		this.possibleSubmissionMatchCount = 0;
		this.possibleBorrowerMatchCount = 0;
		this.modelRetryCount = 0;
		this.serviceDuration = new DurationUtils();
		this.loadCacheDuration = new DurationUtils();
		this.modelServiceDuration = new DurationUtils();
		this.processResponseDuration = new DurationUtils();
		this.transactionCommitDuration = new DurationUtils();
		this.currentTimeStamp = null;
		this.beginProcessingTimestamp = DateUtils.getCurrentTimestamp();
		this.endProcessingTimestamp = null;
		this.clientInfo = clientInfo;
		this.splunkLoggingEnabled = Boolean.FALSE;
		this.message = null;

	}

	public RequestType getRequest() {
		return request;
	}

	public void setRequest(RequestType request) {
		this.request = request;
	}

	public ResponseType getResponse() {
		return response;
	}

	public void setResponse(ResponseType response) {
		this.response = response;
	}

	public DurationUtils getLoadCacheDuration() {
		return loadCacheDuration;
	}

	public DurationUtils getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(DurationUtils serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public void setLoadCacheDuration(DurationUtils loadCacheDuration) {
		this.loadCacheDuration = loadCacheDuration;
	}

	public DurationUtils getModelServiceDuration() {
		return modelServiceDuration;
	}

	public void setModelServiceDuration(DurationUtils modelServiceDuration) {
		this.modelServiceDuration = modelServiceDuration;
	}

	public DurationUtils getProcessResponseDuration() {
		return processResponseDuration;
	}

	public void setProcessResponseDuration(DurationUtils processResponseDuration) {
		this.processResponseDuration = processResponseDuration;
	}

	public void setTransactionCommitDuration(DurationUtils transactionCommitDuration) {
		this.transactionCommitDuration = transactionCommitDuration;
	}

	public DurationUtils getTransactionCommitDuration() {
		return transactionCommitDuration;
	}

	public XMLGregorianCalendar getCurrentTimeStamp() {
		return DateUtils.cloneXMLGregorianCalendar(currentTimeStamp);
	}

	public void setCurrentTimeStamp(XMLGregorianCalendar currentTimeStamp) {
		this.currentTimeStamp = DateUtils.cloneXMLGregorianCalendar(currentTimeStamp);
	}

	public java.sql.Timestamp getBeginProcessingTimestamp() {
		return DateUtils.cloneTimestamp(beginProcessingTimestamp);
	}

	public java.sql.Timestamp getEndProcessingTimestamp() {
		return DateUtils.cloneTimestamp(endProcessingTimestamp);
	}

	public void setEndProcessingTimestamp(java.sql.Timestamp endProcessingTimestamp) {
		this.endProcessingTimestamp = DateUtils.cloneTimestamp(endProcessingTimestamp);
	}

	public int getPossibleSubmissionMatchCount() {
		return possibleSubmissionMatchCount;
	}

	public void setPossibleSubmissionMatchCount(int possibleSubmissionMatchCount) {
		this.possibleSubmissionMatchCount = possibleSubmissionMatchCount;
	}

	public int getPossibleBorrowerMatchCount() {
		return possibleBorrowerMatchCount;
	}

	public void setPossibleBorrowerMatchCount(int possibleBorrowerMatchCount) {
		this.possibleBorrowerMatchCount = possibleBorrowerMatchCount;
	}

	public int getModelRetryCount() {
		return modelRetryCount;
	}

	public void setModelRetryCount(int modelRetryCount) {
		this.modelRetryCount = modelRetryCount;
	}

	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	public boolean isSplunkLoggingEnabled() {
		return splunkLoggingEnabled;
	}

	public void setSplunkLoggingEnabled(boolean splunkLoggingEnabled) {
		this.splunkLoggingEnabled = splunkLoggingEnabled;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ServiceParams [request=" + request + ", response=" + response + ", possibleSubmissionMatchCount="
				+ possibleSubmissionMatchCount + ", possibleBorrowerMatchCount=" + possibleBorrowerMatchCount
				+ ", modelRetryCount=" + modelRetryCount + ", serviceDuration=" + serviceDuration
				+ ", loadCacheDuration=" + loadCacheDuration + ", modelServiceDuration=" + modelServiceDuration
				+ ", processResponseDuration=" + processResponseDuration + ", transactionCommitDuration="
				+ transactionCommitDuration + ", currentTimeStamp=" + currentTimeStamp + ", beginProcessingTimestamp="
				+ beginProcessingTimestamp + ", endProcessingTimestamp=" + endProcessingTimestamp + ", clientInfo="
				+ clientInfo + ", splunkLoggingEnabled=" + splunkLoggingEnabled + ", message=" + message + "]";
	}
}
