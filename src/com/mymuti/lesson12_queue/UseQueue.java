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
//		//���������������У�ConcurrentLinkedQueue
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
//		//��������
//		LinkedBlockingQueue<String> q2= new LinkedBlockingQueue<String>(10);   //���Ӳ����޽磬�Ӳ����н�
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
//		System.out.println(q2.drainTo(list, 3));   // �����Ӷ�����ȥԪ�أ�����һ��������
//		System.out.println(list.size());
//		for (String string: list){
//			System.out.println(string);
//		}
		
//		
//		//�н����
//		ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);    //���봫�������н�
//		array.offer("a", 2, TimeUnit.SECONDS);
//		array.add("b");
//		array.put("c");
//		array.add("d");
//		array.add("e");
//		System.out.println(array.offer("f", 3, TimeUnit.SECONDS));
//		System.out.println(array.size());
		
		//û�л���Ķ���
		SynchronousQueue<String> q3 = new SynchronousQueue<String>();  //û�й�������������Գ�ʼ������
		q3.add("a");
		
		
	}

}
