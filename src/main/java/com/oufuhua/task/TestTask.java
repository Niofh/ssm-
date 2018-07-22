package com.oufuhua.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/7/10 17:34
 */
@Component("TestTask")
public class TestTask {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public void test() {
        logger.info("我是定时任务");
    }
}
