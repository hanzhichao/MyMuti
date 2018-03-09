package com.mymuti.lesson06_volatile;

public class RunThread extends Thread {
	//volatile
	//private boolean isRunning = true;
	private volatile boolean isRunning = true;
	
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	public void run(){
		System.out.println("����run����..");
		while(isRunning == true){
			//..
		}
		System.out.println("�߳���ֹ..");
	}
	public static void main(String[] args) throws InterruptedException {
		RunThread rt = new RunThread();
		rt.start();
		Thread.sleep(3000);
		rt.setRunning(false);
		System.out.println("isRunning��ֵ�Ѿ�������false");
		Thread.sleep(1000);
		System.out.println(rt.isRunning);
	}
}