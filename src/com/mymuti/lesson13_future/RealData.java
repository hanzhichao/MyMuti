package com.mymuti.lesson13_future;

public class RealData implements Data{
	private String result;
	
	public RealData (String queryStr){
		System.out.println("����"+queryStr+"���в�ѯ������һ���ܺ�ʱ�Ĳ���");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("������ϣ���ȡ���");
		result = "��ѯ�������ɺ";
	}
	
	@Override
	public String getRequest() {
		// TODO Auto-generated method stub
		return result;
	}

}
