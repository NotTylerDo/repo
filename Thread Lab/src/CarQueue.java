import java.util.*;
import java.lang.Runnable;

public class CarQueue {

	Queue<Integer> queue;
	Random randomDirection;
	
	
	public CarQueue() {
		queue = new ArrayDeque<Integer>();
		randomDirection = new Random();
		queue.add(randomDirection.nextInt(4));
		queue.add(randomDirection.nextInt(4));
		queue.add(randomDirection.nextInt(4));
		queue.add(randomDirection.nextInt(4));
		queue.add(randomDirection.nextInt(4));
		queue.add(randomDirection.nextInt(4));
		
		
	}
	
	
	public static void main(String[] args) {
		
	}
	
	public void addToQueue() {
		class MyRunnable implements Runnable{
			@Override
			public void run() {
				try {
					for (int i = 0; i < 20; i++) {
						queue.add(randomDirection.nextInt(4));
						Thread.sleep(1000);
					}
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		MyRunnable r = new MyRunnable();
		Thread thread = new Thread(r);
		thread.start();
	}
	
	public int deleteQueue() {
		if (!queue.isEmpty())
			return queue.poll();
		else
			return -1;
		
	}
}
