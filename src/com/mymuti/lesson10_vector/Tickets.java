package com.mymuti.lesson10_vector;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Tickets {

	public static void main(String[] args) {
		// 初始化火车票池并添加火车票： 编码线程同步可采用Vector替代ArrayList HashTable替代HashMap
		
		final Vector<String> tickets = new Vector<String>();
		

//		Map<String,String> map = Collections.synchronizedMap(new HashMap<String, String>());
		
		for(int i = 1; i <= 1000; i++){
			tickets.add("火车票"+i);
		}
		
		for(int i = 1; i <= 10; i++){
			new Thread("线程"+i){
				public void run(){
					while(true){
						if(tickets.isEmpty())  break;
						System.out.println(Thread.currentThread().getName() + "---" + tickets.remove(0));
					}
				}
			}.start();
		}
	}
}
