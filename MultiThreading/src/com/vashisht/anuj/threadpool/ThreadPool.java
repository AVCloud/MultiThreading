package com.vashisht.anuj.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	
	private int id;
	 static volatile int incree;
	public Processor (int id){
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("Starting: id"+id);
		System.out.println("Completed:id"+id);
		incree++;
	}
	
	
}
public class ThreadPool {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i = 0;i<1000;i++){
			executor.submit(new Processor(i));
		}
		
		
		executor.shutdown();
		
		try {
			System.out.println(executor.awaitTermination(10, TimeUnit.DAYS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("incree"+Processor.incree);
	}
}
