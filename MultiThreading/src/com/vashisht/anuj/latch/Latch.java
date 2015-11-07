package com.vashisht.anuj.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 class Processor implements Runnable{

		CountDownLatch countDownLatch ;
		public Processor(		CountDownLatch countDownLatch ){
			this.countDownLatch = countDownLatch;
		}
	@Override
	public void run() {
		
		System.out.println("Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		countDownLatch.countDown();
	}
	
}
public class Latch {

	public static void main(String[] args) {
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		Processor processor = new Processor(countDownLatch);
		
		ExecutorService executor  = Executors.newFixedThreadPool(3);
		for(int i =0 ;i<3;i++){
			executor.submit(processor);
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Countdown Released");

	}

}
