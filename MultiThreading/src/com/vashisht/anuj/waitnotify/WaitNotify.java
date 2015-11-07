package com.vashisht.anuj.waitnotify;

import java.util.Scanner;

public class WaitNotify {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		final Producer producer = new Producer();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					producer.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					producer.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	
	
	

}

class Producer{
	
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Thread 1 Starting");
			wait();
			System.out.println("Thread 1 resuming");
		}
	}
	
	
	public void consumer() throws InterruptedException{
		
		Thread.sleep(5000);
		synchronized (this) {
			System.out.println("Thread 2 starting");
			System.out.println("Please return key to resume");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			notify();
			System.out.println("Thread 2 resuming");
		}
	}
}
