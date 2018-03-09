package com.mymuti.lesson05_synchronized_03;

public class ChangeLock {
	private String lock = "lock";
	private void method(){
		synchronized (lock){
			try {
				System.out.println("当前线程： " + Thread.currentThread().getName() + "开始");
				lock = "change lock";  //尽量不要修改lock的内容
				Thread.sleep(6000);
				System.out.println("当前线程： " + Thread.currentThread().getName() + "结束");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ChangeLock changeLock = new ChangeLock();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				changeLock.method();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				changeLock.method();
			}
		},"t2");
		t1.start();
		t2.start();
	}

}
