package com.mymuti.lesson13_future;

public class FutureData implements Data{
	private RealData realData;
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realData){
		//����Ѿ��������
		if(isReady){
			return;
		}
		//���û��װ�أ�����װ����ʵ����
		this.realData = realData;
		isReady = true;
		//����֪ͨ
		notify();
	}
	
	@Override
	public synchronized String getRequest(){
		//���û��װ�غ� ����һֱ����
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//װ�غ�ֱ�ӻ�ȡ���ݼ���
		return this.realData.getRequest();
	}

}
