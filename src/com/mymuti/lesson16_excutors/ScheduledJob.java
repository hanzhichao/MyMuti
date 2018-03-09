package com.mymuti.lesson16_excutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Temp extends Thread {
	public void run(){
		System.out.println("run");
	}
}


public class ScheduledJob {

	public static void main(String[] args) throws Exception{
		Temp command = new Temp();
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		
		ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(command, 1, 3, TimeUnit.SECONDS);
		
		
		

	}

}
