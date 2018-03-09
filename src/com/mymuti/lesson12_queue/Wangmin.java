package com.mymuti.lesson12_queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Wangmin implements Delayed {
	private String name;
	private String id;
	private long endTime;
	private TimeUnit timeUnit = TimeUnit.SECONDS;
	
	public Wangmin(String name, String id, long endTime){
		this.name = name;
		this.id = id;
		this.endTime = endTime;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getId(){
		return this.id;
	}

	@Override
	public int compareTo(Delayed o) {
		Wangmin w = (Wangmin) o;
		return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1:0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return endTime - System.currentTimeMillis();
	}

}
