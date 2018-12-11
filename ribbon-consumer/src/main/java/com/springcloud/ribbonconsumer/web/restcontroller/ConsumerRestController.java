package com.springcloud.ribbonconsumer.web.restcontroller;

import com.springcloud.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 章辉勇
 * @创建时间 2018年12月06日
 * @描述: 消费服务测试Rest接口
 **/
@RestController
public class ConsumerRestController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String index(@RequestParam String name) {
        return helloService.helloService(name);
    }
}
