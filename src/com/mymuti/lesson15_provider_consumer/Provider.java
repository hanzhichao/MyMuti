package com.mymuti.lesson15_provider_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable{
	//��������
	private BlockingQueue<Data> queue;
	//���̼߳䣬�Ƿ�������������ǿ�����ڴ���ˢ�µĹ��ܣ���ʱ�����̵߳�״̬
	private volatile boolean isRunning = true;
	//id������
	private static AtomicInteger count = new AtomicInteger();
	//�������
	private static Random r = new Random();
	
	//���췽��
	public Provider(BlockingQueue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(isRunning){
			//�������0-1000ms����ʾ��ȡ����(�������ݺ�ʱ)
			try {
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//��ȡ�����ݽ����ۼ�
			int id = count.incrementAndGet();
			//����ͨ����һ��getData������ȡ��
			Data data = new Data(Integer.toString(id), "����" + id);
			System.out.println("��ǰ�߳�:" + Thread.currentThread().getName()+", ��ȡ������,idΪ:" + id + ", ����װ�ص�����������...");
			try {
				if(!this.queue.offer(data, 3, TimeUnit.SECONDS)){
					System.out.println("�ύ����������ʧ��...");
					//do something ... ���������ύ
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void stop() {
		this.isRunning = false;
		
	}

}
