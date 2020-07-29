package com.imooc.thread;

/**
 * @author Lincoln
 * @classname TestThread4
 * @description 练习多个线程同时操作同一个对象
 * @params TODO
 * @return
 * @date 2020/7/12 22:31
 */
// 存在一个问题，在多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TestThread4 implements  Runnable{

    //
    private  int ticketNums = 10;
    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +"-->拿到了第"+ticketNums-- +"张票");
        }
    }


    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();

    }
}
