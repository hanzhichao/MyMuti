package com.mymuti.lesson07_wait_notify;
import java.util.ArrayList;
import java.util.List;

public class ListAdd1 {
	public volatile static List list = new ArrayList();
//	public static List list = new ArrayList();
	
	public void add(){
		list.add("hello");
	}
	public int size(){
		return list.size();
	}
	public static void main(String[] args) {
		final ListAdd1 list1 = new ListAdd1();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i<10; i++){
					list1.add();
					System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				while(true){
					if(list.size() == 5){
						System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + " list size =5 线程停止..");
						throw new RuntimeException();
					}
				}
			}
		},"t2");
	
		t1.start();
		t2.start();
	}
	

}
