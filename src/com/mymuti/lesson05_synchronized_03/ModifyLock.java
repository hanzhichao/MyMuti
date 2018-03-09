package com.mymuti.lesson05_synchronized_03;

public class ModifyLock {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge (int age){
		this.age = age;
	}
	
	public synchronized void changeAttributte(String name, int age){
		try {
			System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "��ʼ");
			this.setName(name);
			this.setAge(age);
			System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "�޸Ķ�������Ϊ��" + this.getName() + "," + this.getAge());
			Thread.sleep(2000);
			System.out.println("��ǰ�̣߳� " + Thread.currentThread().getName() + "����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ModifyLock modifyLock = new ModifyLock();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				modifyLock.changeAttributte("����",20);
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				modifyLock.changeAttributte("����",21);
			}
		},"t2");
		t1.start();
		t2.start();
	}

}
