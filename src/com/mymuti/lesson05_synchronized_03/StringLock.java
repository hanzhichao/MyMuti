package com.mymuti.lesson05_synchronized_03;

public class StringLock {
	public void method(){
		//new String("字符串常量");
		//synchronized("字符串常量"){
		synchronized(new String("字符串常量")){
			while(true){
				try {
					System.out.println("当前线程： " + Thread.currentThread().getName() + "开始");
					Thread.sleep(1000);
					System.out.println("当前线程： " + Thread.currentThread().getName() + "结束");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final StringLock stringLock = new StringLock();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				stringLock.method();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				stringLock.method();
			}
		},"t2");
		t1.start();
		t2.start();
		
	}

}
