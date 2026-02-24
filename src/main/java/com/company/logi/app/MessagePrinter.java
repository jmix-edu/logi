package com.company.logi.app;

import org.flowable.engine.runtime.Execution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "messagePrinter")
public class MessagePrinter {

    private static final Logger log = LoggerFactory.getLogger(MessagePrinter.class);

    public void printMessage(String msg) {
        log.info("Message in bean: {}", msg);
    }
}