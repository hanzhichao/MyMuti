package com.mymuti.lesson12_queue;

import java.util.concurrent.DelayQueue;

public class WangBa implements Runnable{
	DelayQueue<Wangmin> q = new DelayQueue<Wangmin>();
	public boolean yingye = true;
	
	public void shangji(String name,String id, int money){
		Wangmin man = new Wangmin(name, id, 1000*money+System.currentTimeMillis());
		System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"交钱"+money+"块，开始上机...");;
		this.q.add(man);
	}
	
	public void xiaji(Wangmin man){
		System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"时间到下机..");
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
		System.out.println("网吧开始营业");
		WangBa siyu = new WangBa();
		Thread shangwang = new Thread(siyu);
		shangwang.start();
		
		siyu.shangji("路人甲", "123", 1);
		siyu.shangji("路人乙", "234", 10);
		siyu.shangji("路人丙", "345", 5);

	}

}
