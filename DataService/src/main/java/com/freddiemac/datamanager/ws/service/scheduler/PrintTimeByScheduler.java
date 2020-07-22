package com.freddiemac.datamanager.ws.service.scheduler;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import com.freddiemac.datamanager.ws.config.ApplicationLogger;

public class PrintTimeByScheduler {
	
	private static final Logger LOGGER = ApplicationLogger.getLogger( PrintTimeByScheduler.class );

	@Scheduled(cron = "${SCHEDULE_EXECUTION_CORN_EXPRESSION}")
	public void scheduleFixedRateTask() {
	    LOGGER.info( "Current Time in milliseconds " + System.currentTimeMillis() );
	}
}
