package com.mymuti.lesson09_thread_local;
/**
 * 静态内部类
 * @author Administrator
 *
 */
public class InnerSingleton {
	
	//静态内部类
	private static class Singletion {
		private static Singletion single = new Singletion();
	}
	
	
	//外部接口
	public static Singletion getInstance(){
		return Singletion.single;
	}
	

}
