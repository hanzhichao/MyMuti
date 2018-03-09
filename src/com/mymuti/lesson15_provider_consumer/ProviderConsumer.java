package com.mymuti.lesson15_provider_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class ProviderConsumer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//内存缓冲区
		BlockingQueue<Data> queue = new LinkedBlockingQueue<Data>(10);
		//生产者
		Provider p1 = new Provider(queue);
		Provider p2 = new Provider(queue);
		Provider p3 = new Provider(queue);
		//消费者
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		
		//创建线程池运行，这是一个缓存的线程次，可以创建无穷大的线程，没有任务时不创建线程，空闲线程存货时间为60s
		ExecutorService cachePool = Executors.newCachedThreadPool();
		cachePool.execute(p1);
		cachePool.execute(p2);
		cachePool.execute(p3);
		cachePool.execute(c1);
		cachePool.execute(c2);
		cachePool.execute(c3);
		
		Thread.sleep(3000);
		p1.stop();
		p2.stop();
		p3.stop();
		Thread.sleep(2000);
		//cachePool.shutdown();
		//cachePool.shutdownNow();
		

	}

}
