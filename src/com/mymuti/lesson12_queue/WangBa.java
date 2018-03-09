package com.mymuti.lesson12_queue;

import java.util.concurrent.DelayQueue;

public class WangBa implements Runnable{
	DelayQueue<Wangmin> q = new DelayQueue<Wangmin>();
	public boolean yingye = true;
	
	public void shangji(String name,String id, int money){
		Wangmin man = new Wangmin(name, id, 1000*money+System.currentTimeMillis());
		System.out.println("����"+man.getName()+" ���֤"+man.getId()+"��Ǯ"+money+"�飬��ʼ�ϻ�...");;
		this.q.add(man);
	}
	
	public void xiaji(Wangmin man){
		System.out.println("����"+man.getName()+" ���֤"+man.getId()+"ʱ�䵽�»�..");
	}
	
	@Override
	public void run(){
		while(yingye){
			try {
				Wangmin man = q.take();
				xiaji(man);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("���ɿ�ʼӪҵ");
		WangBa siyu = new WangBa();
		Thread shangwang = new Thread(siyu);
		shangwang.start();
		
		siyu.shangji("·�˼�", "123", 1);
		siyu.shangji("·����", "234", 10);
		siyu.shangji("·�˱�", "345", 5);

	}

}
