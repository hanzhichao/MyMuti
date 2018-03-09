package com.mymuti.lesson04_synchronized_02;
/**
 * synchronizedµÄÖØÈë
 * @author Administrator
 *
 */
public class SyncDubbo2 {
	static class Main{
		public int i = 10;
		public synchronized void operationSup(){
			try {
				i--;
				System.out.println("Main print i = " + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	static class Sub extends Main {
		public synchronized void operationSub(){
			try {
				while(i > 0){
					i--;
					System.out.println("Sub print i = " + i);
					Thread.sleep(100);
					this.operationSup();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Sub sub = new Sub();
				sub.operationSub();
			}
		});
		t1.start();

	}

}
