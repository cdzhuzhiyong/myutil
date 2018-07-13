package zzy.pressuretest;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ${接口压力测试}
 * cdzhuzhiyong
 * 2018/7/10 16:45
 **/
public class InterfacePressureTest {
    //runnables 任务集合 ; threadPoolType 线程池类型 ;  size  线程池定长 ; delayTime 延时时间 ； frequencyTime 多长时间执行一次 ； unit 时间单位
    public static void interfacePressureTest(List<Runnable> taskList ,String threadPoolType,Integer size, int delayTime, int frequencyTime, TimeUnit unit){
        switch (threadPoolType){
            case ThreadPoolType.CachedThreadPool:
                invokePressureTestByNewCachedThreadPool(taskList);
                 break;
            case ThreadPoolType.FixedThreadPool:
                invokePressureTestByFixedThreadPool(taskList,size);
                break;
            case ThreadPoolType.ScheduledThreadPool:
                invokePressureTestBycheduledThreadPool(taskList,size,delayTime,frequencyTime,unit);
                break;
            case ThreadPoolType.SingleThreadExecutor:
                invokePressureTestBySingleThreadExecutor(taskList);
                break;
        }
    }
    //newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
    private static void invokePressureTestByNewCachedThreadPool(List<Runnable> runnables){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<runnables.size();i++){
            executorService.execute(runnables.get(i));
        }
        executorService.shutdown();
    }

    //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
    private static void invokePressureTestByFixedThreadPool(List<Runnable> runnables,int nThreads){
         if (nThreads <= 0){
             throw new NullPointerException("线程最大并发数必须大于0");
         }
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        for (int i=0;i<runnables.size();i++){
            executorService.execute(runnables.get(i));
        }
        executorService.shutdown();
    }

    //创建一个定长线程池，支持定时及周期性任务执行
    private static void invokePressureTestBySingleThreadExecutor(List<Runnable> runnables){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0;i<runnables.size();i++){
            executorService.execute(runnables.get(i));
        }
        executorService.shutdown();
    }

    //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
    private static void invokePressureTestBycheduledThreadPool(List<Runnable> runnables, int corePoolSize, int delayTime, int frequencyTime, TimeUnit unit){
        if (corePoolSize <= 0){
            throw new NullPointerException("核心池大小必须大于0");
        }
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(corePoolSize);
        for (int i=0;i<runnables.size();i++){
            //延迟delayTime时间后每frequencyTime时间执行一次
            executorService.scheduleAtFixedRate(runnables.get(i),delayTime,frequencyTime,unit);
        }
        executorService.shutdown();
    }
}


