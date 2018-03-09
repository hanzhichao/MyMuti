package com.mymuti.lesson14_master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	
	//1.应该有个承装任务的集合
	private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<Task>();
	
	//2.是你用HashMap去承装所有worker对象
	private HashMap<String, Thread> workers = new HashMap<String,Thread>();
	
	//3.使用一个容器承装每一个worker执行任务的结果集合
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
	
	//4.构造方法
	public Master(Worker worker, int workerCount){
		//每一个worker对象都选哟由Master的引用workQueue用于任务的领取
		worker.setWorkerQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		
		for(int i = 0; i< workerCount; i++){
			//key表示每一个worker的名字，value表示线程执行对象
			workers.put("子节点" + Integer.toString(i), new Thread(worker));
		}
	}
	//5. 提交方法
	public void submit(Task task){
		this.workQueue.add(task);
	}
	//6.需要一个执行的方法
	public void execute(){
		for(Map.Entry<String, Thread>me: workers.entrySet()){
			me.getValue().start();
		}
	}
	
	//7.判断线程是否执行完毕
	public boolean isComplete() {
		for(Map.Entry<String, Thread>me: workers.entrySet()){
			if(me.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
			return true;
		}
		return false;
	}
	//8.返回结果集
	public int getResult(){
		int ret = 0;
		for(Map.Entry<String, Object>me: resultMap.entrySet()){
			ret +=(Integer)me.getValue();
		}
		return ret;
	}
	
	

}
