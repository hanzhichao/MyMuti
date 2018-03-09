package com.mymuti.lesson07_wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * wait notify 方法， wait释放锁，notify不释放锁
 * @author Administrator
 *
 */
public class ListAdd2 {
	private volatile static List list = new ArrayList();
	
	public void add(){
		list.add("hello");
	}
	
	public int size(){
		return list.size();
	}

	public static void main(String[] args) {
		final ListAdd2 list2 = new ListAdd2();
		
		//1 实例化一个lock
		//当使用wait和notify的时候，一i的那个要配合着synchronized关键字去使用
		final Object lock = new Object();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				synchronized (lock) {
					for(int i = 0; i< 10; i++){
						list2.add();
						System.out.println("当前线程： " + Thread.currentThread().getName() + "添加了一个元素..");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(list2.size() == 5){
							System.out.println("已经发出通知..");
							lock.notify();
						}
					}
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				synchronized(lock){
					if(list.size() != 5){
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("当前线程：" + Thread.currentThread().getName() + "收到通知线程停止");
					throw new RuntimeException();
				}
			}
		},"t2");
		
		t2.start();
		t1.start();

	}

}
