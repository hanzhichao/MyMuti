package com.mymuti.lesson06_volatile;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUse extends Thread {
	static AtomicInteger count = new AtomicInteger(0);
	private static void addCount(){
		for(int i =0; i<1000; i++){
			count.incrementAndGet();
		}
		System.out.println(count);
	}
	
	public void run() {
		addCount();
	}
	
	public static void main(String[] args) {

		AtomicUse[] arr = new AtomicUse[10];
		for(int i = 0; i < 10; i++){
			arr[i] = new AtomicUse();
		}
		
		for(int i = 0;i < 10; i++){
			arr[i].start();
		}
	}

}
