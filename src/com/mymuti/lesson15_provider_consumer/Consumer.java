package com.mymuti.lesson15_provider_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<Data> queue;
	
	public Consumer(BlockingQueue queue){
		this.queue = queue;
	}
	//�������
	private static Random r = new Random();
	
	@Override
	public void run() {
		while(true){
			try {
				//��ȡ����
				Data data = this.queue.take();
				Thread.sleep(r.nextInt(1000));
				System.out.println("��ǰ�����߳�: " + Thread.currentThread().getName() + ", ���ѳɹ�����������" + data.toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
