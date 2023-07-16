package 设计模式考题.生产者消费者模型;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * @author Wu
 * @date 2023年07月16日 18:57
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue q = new MyBlockingQueue();
        new Thread(() -> {
            while (true){
                q.add(1);
                System.out.println("生产者生产1");
            }
        }).start();
        new Thread(() -> {
            while (true){
                q.pop();
                System.out.println("消费者消费1");
            }
        }).start();

    }
}

class MyBlockingQueue {
    Queue<Integer> q;
    Semaphore fullCount = new Semaphore(0);
    Semaphore emptyCount = new Semaphore(10);
    Semaphore isUse = new Semaphore(1);

    public MyBlockingQueue() {
        q = new ArrayDeque<>();
    }

    public void add(int num) {
        try {
            emptyCount.acquire();
            isUse.acquire();
            q.add(num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fullCount.release();
            isUse.release();
        }
    }

    public void pop() {
        try {
            fullCount.acquire();
            isUse.acquire();
            q.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            emptyCount.release();
            isUse.release();
        }
    }
}
