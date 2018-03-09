package com.mymuti.lesson07_wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * wait notify ������ wait�ͷ�����notify���ͷ���
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
		
		//1 ʵ����һ��lock
		//��ʹ��wait��notify��ʱ��һi���Ǹ�Ҫ�����synchronized�ؼ���ȥʹ��
		final Object lock = new Object();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				synchronized (lock) {
					for(int i = 0; i< 10; i++){
						list2.add();
						System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "�����һ��Ԫ��..");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(list2.size() == 5){
							System.out.println("�Ѿ�����֪ͨ..");
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
					System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + "�յ�֪ͨ�߳�ֹͣ");
					throw new RuntimeException();
				}
			}
		},"t2");
		
		t2.start();
		t1.start();

	}

}
