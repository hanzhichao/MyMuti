package com.mymuti.lesson09_thread_local;
/**
 * ��̬�ڲ���
 * @author Administrator
 *
 */
public class InnerSingleton {
	
	//��̬�ڲ���
	private static class Singletion {
		private static Singletion single = new Singletion();
	}
	
	
	//�ⲿ�ӿ�
	public static Singletion getInstance(){
		return Singletion.single;
	}
	

}
