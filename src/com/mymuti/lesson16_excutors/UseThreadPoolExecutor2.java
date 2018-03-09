package com.mymuti.lesson16_excutors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class UseThreadPoolExecutor2 implements Runnable{
	
	private static AtomicInteger count = new AtomicInteger(0);
	
	@Override
	public void run() {
		int temp = count.incrementAndGet();
		System.out.println("����" + temp);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws Exception {
//		System.out.println(Runtime.getRuntime().availableProcessors());
//		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
		
		ExecutorService executor = new ThreadPoolExecutor(
				5,	    //core
				10,     //max
				120L,   //2min
				TimeUnit.SECONDS,
				queue);
		
		for (int i = 0; i < 20; i++ ){
			executor.execute(new UseThreadPoolExecutor2());	
		}
		Thread.sleep(1000);
		System.out.println("queue size: " + queue.size());
		Thread.sleep(2000);
	}
}
