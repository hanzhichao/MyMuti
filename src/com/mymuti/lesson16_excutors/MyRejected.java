package com.mymuti.lesson16_excutors;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler {
	
	public MyRejected(){
		
	}
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("�Զ��崦��..");
		System.out.println("��ǰ���ܾ�������Ϊ�� " + r.toString());
	}

}