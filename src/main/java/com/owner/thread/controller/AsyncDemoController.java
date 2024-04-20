package com.owner.thread.controller;

import com.owner.thread.service.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AsyncDemoController {

    @Autowired
    private DemoServiceImpl demoServiceImpl;

    @GetMapping("/synchronizedMethod")
    public void synchronizedMethod() {
        System.out.println("controller.synchronizedMethod，线程名称：" + Thread.currentThread().getName());
        demoServiceImpl.synchronizedMethod();
    }

    @GetMapping("/lockMethod")
    public void lockMethod() {
        System.out.println("controller.lockMethod，线程名称：" + Thread.currentThread().getName());
        demoServiceImpl.lockMethod();
    }


}
