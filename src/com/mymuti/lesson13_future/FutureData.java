package com.mymuti.lesson13_future;

public class FutureData implements Data{
	private RealData realData;
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realData){
		//如果已经加载完毕
		if(isReady){
			return;
		}
		//如果没有装载，进行装载真实对象
		this.realData = realData;
		isReady = true;
		//进行通知
		notify();
	}
	
	@Override
	public synchronized String getRequest(){
		//如果没有装载好 程序一直阻塞
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//装载好直接获取数据即可
		return this.realData.getRequest();
	}

}
