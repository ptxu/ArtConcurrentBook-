package chapter08;import java.util.concurrent.CountDownLatch;import java.util.concurrent.TimeUnit;/** *  * @author tengfei.fangtf * @version $Id: CountDownLatchTest.java, v 0.1 2015-8-1 ����12:08:52 tengfei.fangtf Exp $ */public class CountDownLatchTest {    static CountDownLatch c = new CountDownLatch(2);    public static void main(String[] args) throws InterruptedException {        new Thread(new Runnable() {            @Override            public void run() {                System.out.println(1);                try {                    Thread.sleep(1);                }                catch (InterruptedException e) {                    // TODO Auto-generated catch block                    e.printStackTrace();                }                c.countDown();                System.out.println(2);                c.countDown();            }        }).start();        System.out.println(c.getCount());        c.await(1, TimeUnit.MICROSECONDS);        System.out.println("3");    }}