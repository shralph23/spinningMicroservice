package com.freddiemac.datamanager.ws.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.freddiemac.datamanager.ws.esafe.constant.EsafeErrorCodes;
import com.freddiemac.datamanager.ws.esafe.exception.EsafeRuntimeException;
import com.freddiemac.datamanager.ws.esafe.util.OSUtils;
import com.freddiemac.datamanager.ws.model.RequestMetaData;

public class ApplicationLogger {

	private static final OSUtils osUtils = OSUtils.getInstance();
	private static final Logger LOGGER = ApplicationLogger.getLogger(ApplicationLogger.class);

	private ApplicationLogger() {
		LOGGER.info("In ApplicationLogger - constructor!!!!");
	}

	public static Logger getLogger(Class<?> z) {
		return getLogger(z.getName());
	}

	public static synchronized Logger getLogger(String className) {

		try {
			MDC.put("appHostName", osUtils.getHostName());
		} catch (Exception exception) {
			// handle the exception and continue
			String errorMessage = EsafeRuntimeException.getExceptionLoggingMessage(
					EsafeErrorCodes.EC_SRS_LOGGER_MDC_WARNING, exception.getClass().getName(),
					"Issue setting MDC value for HostName for logging!");
			LOGGER.warn(errorMessage, exception);
		}

		return LoggerFactory.getLogger(className);
	}

	public static void setLoggerMDC(RequestMetaData requestMetadata) {
		ApplicationLogger.setLoggerMDC(requestMetadata.getRequestIdentifier(),
				requestMetadata.getRequestSourceSystem());
	}

	public static synchronized void setLoggerMDC(String requestID, String requestSystem) {

		try {
			MDC.put("appHostName", osUtils.getHostName());
			MDC.put("appRequestID", requestID);
			MDC.put("appRequestSystem", requestSystem);
		} catch (Exception exception) {
			// handle the exception and continue
			String errorMessage = EsafeRuntimeException.getExceptionLoggingMessage(
					EsafeErrorCodes.EC_SRS_LOGGER_MDC_WARNING, exception.getClass().getName(),
					"Issue setting MDC value for hostName, requestId and requestSourceSystem for service logging!");
			LOGGER.warn(errorMessage, exception);
		}

	}

}
