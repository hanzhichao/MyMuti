package com.mymuti.lesson13_future;

public class FutureClient {

	public Data request(final String queryStr) {
		//1 ����Ҫһ����������Data�ӿڵ�ʵ���ࣩ�ȷ��ظ�����Ŀͻ��Σ����������յ�����
		final FutureData futureData = new FutureData();
		//2 ����һ���µ��̣߳�ȥ������ʵ�����ݣ����ݸ������������
	    new Thread(new Runnable() {
	    	@Override
	    	public void run() {
	    		//3 ����µ��߳̿���ȥ�����ļ�����ʵ����Ȼ�󴫵ݸ�����
	    		RealData realData = new RealData(queryStr);
	    		futureData.setRealData(realData);
	    	}
	    }).start();
	    
	    return futureData;
	}

}