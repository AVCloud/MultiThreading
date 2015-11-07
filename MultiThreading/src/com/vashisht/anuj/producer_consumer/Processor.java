package com.vashisht.anuj.producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Processor {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
			
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
			
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});

		t1.start();
		t2.start();
	}

	
	public static void producer() throws InterruptedException{
		Random random = new Random();
		
		while(true){
			queue.put(random.nextInt(100));
		}
	}
	
	public static void consumer() throws InterruptedException{
		Random random = new Random();
		Integer val = 0;
		while(true){
			Thread.sleep(100);
			if(random.nextInt(10) == 0){
			 val = queue.take();
			
			System.out.println("Value taken="+val+"Queue size ="+queue.size());
			}
		}
	}
}
