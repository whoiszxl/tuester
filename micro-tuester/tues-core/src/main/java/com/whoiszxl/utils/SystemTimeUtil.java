package com.whoiszxl.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class SystemTimeUtil {
    private static final String THREAD_NAME = "system.clock";
    private static final SystemTimeUtil MILLIS_CLOCK = new SystemTimeUtil(1);
    private final long precision;
    private final AtomicLong now;

    private SystemTimeUtil(long precision) {
        this.precision = precision;
        now = new AtomicLong(System.currentTimeMillis());
        scheduleClockUpdating();
    }

    public static SystemTimeUtil millisClock() {
        return MILLIS_CLOCK;
    }

    private void scheduleClockUpdating() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, THREAD_NAME);
            thread.setDaemon(true);
            return thread;
        });
        scheduler.scheduleAtFixedRate(() ->
                        now.set(System.currentTimeMillis()),
                precision, precision, TimeUnit.MILLISECONDS);
    }

    public long now() {
        return now.get();
    }

    public static void main(String[] args) {
        System.out.println(SystemTimeUtil.millisClock().now());
    }
}
