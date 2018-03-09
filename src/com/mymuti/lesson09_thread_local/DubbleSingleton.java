package com.mymuti.lesson09_thread_local;

public class DubbleSingleton {
	private static DubbleSingleton ds;  //懒汉模式，懒加载模式
	
	public static DubbleSingleton getDs(){
		if(ds == null){
			//模拟初始化的准备时间
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (DubbleSingleton.class){
				if(ds == null){    // Double Check 双重检查
					ds = new DubbleSingleton();
				}
			}
		}
		return ds;
	}
	
	
	public static void main(String [] args){
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		},"t2");
		
		Thread t3 = new Thread(new Runnable(){
			@Override
			public void run(){
				System.out.println(DubbleSingleton.getDs().hashCode());
			}
		},"t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
