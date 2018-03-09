package com.mymuti.lesson13_future;

public class Main {

	public static void main(String[] args) {
		FutureClient fc = new FutureClient();
		Data data = fc.request("请求参数");
		System.out.println("请求发送成功!");
		System.out.println("请做其他的事情...");
		
		String result = data.getRequest();
		System.out.println(result);

	}

}
