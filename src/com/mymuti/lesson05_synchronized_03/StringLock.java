package com.mymuti.lesson05_synchronized_03;

public class StringLock {
	public void method(){
		//new String("�ַ�������");
		//synchronized("�ַ�������"){
		synchronized(new String("�ַ�������")){
			while(true){
				try {
					System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "��ʼ");
					Thread.sleep(1000);
					System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "����");
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
