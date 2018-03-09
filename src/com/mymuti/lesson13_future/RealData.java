package com.mymuti.lesson13_future;

public class RealData implements Data{
	private String result;
	
	public RealData (String queryStr){
		System.out.println("根据"+queryStr+"进行查询，这是一个很耗时的操作");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("操作完毕，获取结果");
		result = "查询结果：张珊";
	}
	
	@Override
	public String getRequest() {
		// TODO Auto-generated method stub
		return result;
	}

}
