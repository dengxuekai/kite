package com.dxk.test.job;

import com.dxk.kite.rpc.annotation.DistributedJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author dengxuekai
 * @Date 2019-12-12 14:24
 */
@Slf4j
@Component
public class TestJob {

    @DistributedJob(expireSeconds = 20)
    @Scheduled(cron = "0/20 * * * * ?")
    public boolean test() {
        log.info("do something");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
