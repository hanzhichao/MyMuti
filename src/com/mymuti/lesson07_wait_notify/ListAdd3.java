package com.mymuti.lesson07_wait_notify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch  ʵʱ֪ͨ
 * @author Administrator
 *
 */
public class ListAdd3 {
	private volatile static List list3 = new ArrayList();
	
	public void add(){
		list3.add("hello");
	}
	
	public int size(){
		return list3.size();
	}
	
	
	public static void main(String[] args) {
		final ListAdd3 list3 = new ListAdd3();
		final CountDownLatch countDownLatch = new CountDownLatch(2);   //�����2������Ҫ2��countDownLatch.coundown()
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i = 0; i< 10; i++){
					list3.add();
					System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "�����һ��Ԫ��..");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(list3.size() == 5){
						System.out.println("�Ѿ�����֪ͨ..");
						countDownLatch.countDown();
						countDownLatch.countDown();
						}
					}
				}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				if(list3.size() != 5){
					try {
						countDownLatch.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "�յ�֪ͨ���߳�ֹͣ");
				throw new RuntimeException();
			}
		},"t2");
		
		t2.start();
		t1.start();

	}

}
