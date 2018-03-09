package com.mymuti.lesson05_synchronized_03;

public class ObjectLock {
	public void method1(){
		synchronized (this){ //对象锁,this代表ObjectLock
			try {
				System.out.println("do method1..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void method2(){
		synchronized (ObjectLock.class) {
			try {
				Thread.sleep(2000);
				System.out.println("do method2..");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Object lock = new Object();
	public void method3(){ //任何对象锁
		synchronized (lock){
			try {
				System.out.println("do method3..");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectLock ol = new ObjectLock();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				ol.method3();
				ol.method1();
				ol.method2();
				
			}
		});
		t1.start();
	}

}
