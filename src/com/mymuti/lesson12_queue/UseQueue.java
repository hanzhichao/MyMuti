package com.mymuti.lesson12_queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class UseQueue {

	public static void main(String[] args) throws InterruptedException {
//		//高性能无阻塞队列：ConcurrentLinkedQueue
//		ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
//		q.offer("a");
//		q.offer("b");
//		q.offer("c");
//		q.offer("d");
//		
//		System.out.println(q.poll());
//		System.out.println(q.size());
//		System.out.println(q.peek());
//		System.out.println(q.size());
//		
//		//阻塞队列
//		LinkedBlockingQueue<String> q2= new LinkedBlockingQueue<String>(10);   //不加参数无界，加参数有界
//		q2.offer("a");
//		q2.offer("b");
//		q2.offer("c");
//		q2.offer("d");
//		q2.offer("e");
//		q2.offer("f");
//		System.out.println(q2.size());
//		for (Iterator iterator = q2.iterator(); iterator.hasNext();){
//			String string = (String) iterator.next();
//			System.out.println(string);
//		}
//		List<String> list = new ArrayList<String>();
//		System.out.println(q2.drainTo(list, 3));   // 批量从队列中去元素，放入一个集合中
//		System.out.println(list.size());
//		for (String string: list){
//			System.out.println(string);
//		}
		
//		
//		//有界队列
//		ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);    //必须传参数，有界
//		array.offer("a", 2, TimeUnit.SECONDS);
//		array.add("b");
//		array.put("c");
//		array.add("d");
//		array.add("e");
//		System.out.println(array.offer("f", 3, TimeUnit.SECONDS));
//		System.out.println(array.size());
		
		//没有缓冲的队列
		SynchronousQueue<String> q3 = new SynchronousQueue<String>();  //没有构造参数，不可以初始化个数
		q3.add("a");
		
		
	}

}
