package com.mymuti.lesson04_synchronized_02;
/**
 * synchronized“Ï≥£
 * @author Administrator
 *
 */
public class SyncException {
	private int i = 0;
	public synchronized void operation(){
		while(true){
			try {
				i++;
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName() + " , i = " + i);
				if(i==10){
					Integer.parseInt("a");
					//throw new RuntimeException();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(" log info i =" + i);
				//throw new RuntimeException();
				//continue;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SyncException se = new SyncException();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				se.operation();
			}
		},"t1");
		t1.start();
	}

}
