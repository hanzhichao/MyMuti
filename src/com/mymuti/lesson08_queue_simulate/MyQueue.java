package com.mymuti.lesson08_queue_simulate;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
	
	//1. 需要一个承装元素的集合
	private final LinkedList<Object> list = new LinkedList<Object>();
	
	//2. 需要一个计数器
	private AtomicInteger count = new AtomicInteger(0);
	
	//3. 需要制定上限和下限
	private int miniSize = 0;
	private int maxSize;
	
	//4. 构造方法
	public MyQueue(int size){
		this.maxSize = size;
	}
	
	//5. 初始化一个对象用于加锁
	private final Object lock = new Object();
	
	//6. put 方法
	public void put(Object obj){
		synchronized (lock) {
			while(count.get() == this.maxSize){
				try {
					lock.wait();    //当长度满时，使用wait阻塞该线程
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			//1. 加入元素
			list.add(obj);
			//2.计数器增加
			count.incrementAndGet();
			//3.通知另一个线程
			System.out.println("新加入的元素为：" + obj);
			lock.notify();     //加入元素后广播通知
		}
	}
	
	//7. take方法
	public Object take(){
		Object ret = null;
		synchronized (lock){
			while(count.get() == this.miniSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			//1. 移除元素
			ret = list.removeFirst();
			
			//2. 计数器递减
			count.decrementAndGet();
			
			//3. 唤醒另一个线程
			lock.notify();
		}
		return ret;
	}
	
	public int getSize(){
		return this.count.get();
	}
	
	
	public static void main(String[] args) {
		MyQueue mq = new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		
		System.out.println("当前容器长度： " + mq.getSize());
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				mq.put("f");
				mq.put("g");
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				Object o1 = mq.take();
				System.out.println("移除的元素为： " + o1);
				Object o2 = mq.take();
				System.out.println("移除的元素为：" + o2);
			}
		},"t2");
		
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();

	}

}
