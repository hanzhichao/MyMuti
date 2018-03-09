package com.mymuti.lesson05_synchronized_03;

public class ChangeLock {
	private String lock = "lock";
	private void method(){
		synchronized (lock){
			try {
				System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "��ʼ");
				lock = "change lock";  //������Ҫ�޸�lock������
				Thread.sleep(6000);
				System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "����");
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
