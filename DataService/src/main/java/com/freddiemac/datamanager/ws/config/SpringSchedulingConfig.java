package com.freddiemac.datamanager.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.freddiemac.datamanager.ws.service.scheduler.PrintTimeByScheduler;

import static com.freddiemac.datamanager.ws.constant.ServiceConstants.SPRING_SCHEDULER_THREAD_PREFIX;;

/*
 * Config class to schedule Async spring schedulers with required thread pool
 */

@Configuration
@EnableAsync
@EnableScheduling
public class SpringSchedulingConfig {

	@Value("${SCHEDULER_THREAD_POOL_SIZE}")
	private int schedulerThreadPoolSize;

	@Bean
	public TaskScheduler poolScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix(SPRING_SCHEDULER_THREAD_PREFIX);
		scheduler.setPoolSize(schedulerThreadPoolSize);
		return scheduler;
	}

	@Bean
	public PrintTimeByScheduler printTimeUsingScheduler() {
		return new PrintTimeByScheduler();
	}
}
