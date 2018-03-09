package com.mymuti.lesson12_queue;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class UsePriorityBlockingQueue {
	
	public static void main(String[] args) throws InterruptedException{
		PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();
		
		Task t1 = new Task();
		t1.setId(3);
		t1.setName("任务1");
	
		Task t2 = new Task();
		t2.setId(6);
		t2.setName("任务2");
	
		Task t3 = new Task();
		t3.setId(1);
		t3.setName("任务3");
		
		q.add(t1);
		q.add(t2);
		q.add(t3);
		
//		for(Iterator i = q.iterator(); i.hasNext();){
//			Task task = (Task) i.next();
//			System.out.println(task.getName());
//		}
		//调用take()方法时排序
		System.out.println(q.take().getName());
		System.out.println(q.take().getName());
		System.out.println(q.take().getName());
	
	}
}
