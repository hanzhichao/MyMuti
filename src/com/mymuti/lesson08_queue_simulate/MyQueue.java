package com.mymuti.lesson08_queue_simulate;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
	
	//1. ��Ҫһ����װԪ�صļ���
	private final LinkedList<Object> list = new LinkedList<Object>();
	
	//2. ��Ҫһ��������
	private AtomicInteger count = new AtomicInteger(0);
	
	//3. ��Ҫ�ƶ����޺�����
	private int miniSize = 0;
	private int maxSize;
	
	//4. ���췽��
	public MyQueue(int size){
		this.maxSize = size;
	}
	
	//5. ��ʼ��һ���������ڼ���
	private final Object lock = new Object();
	
	//6. put ����
	public void put(Object obj){
		synchronized (lock) {
			while(count.get() == this.maxSize){
				try {
					lock.wait();    //��������ʱ��ʹ��wait�������߳�
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			//1. ����Ԫ��
			list.add(obj);
			//2.����������
			count.incrementAndGet();
			//3.֪ͨ��һ���߳�
			System.out.println("�¼����Ԫ��Ϊ��" + obj);
			lock.notify();     //����Ԫ�غ�㲥֪ͨ
		}
	}
	
	//7. take����
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
		
			//1. �Ƴ�Ԫ��
			ret = list.removeFirst();
			
			//2. �������ݼ�
			count.decrementAndGet();
			
			//3. ������һ���߳�
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
		
		System.out.println("��ǰ�������ȣ� " + mq.getSize());
		
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
				System.out.println("�Ƴ���Ԫ��Ϊ�� " + o1);
				Object o2 = mq.take();
				System.out.println("�Ƴ���Ԫ��Ϊ��" + o2);
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
