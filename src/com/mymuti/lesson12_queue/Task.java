package com.mymuti.lesson12_queue;

public class Task implements Comparable<Task>{
	private int id;
	private String name;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int compareTo(Task task){
		return this.id > task.id ? 1 : (this.id < task.id ? -1 : 0);
	}
}
