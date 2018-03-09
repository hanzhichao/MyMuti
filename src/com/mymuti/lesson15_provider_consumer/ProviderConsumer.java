package com.mymuti.lesson15_provider_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class ProviderConsumer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//�ڴ滺����
		BlockingQueue<Data> queue = new LinkedBlockingQueue<Data>(10);
		//������
		Provider p1 = new Provider(queue);
		Provider p2 = new Provider(queue);
		Provider p3 = new Provider(queue);
		//������
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		
		//�����̳߳����У�����һ��������̴߳Σ����Դ����������̣߳�û������ʱ�������̣߳������̴߳��ʱ��Ϊ60s
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