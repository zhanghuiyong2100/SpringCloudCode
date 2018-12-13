package com.springcloud.feignservice.web.restcontroller;

import com.springcloud.feignservice.common.SchedualServiceHello;
import com.springcloud.feignservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 章辉勇
 * @创建时间 2018年12月12日
 * @描述: feign测试rest接口
 **/
@RestController
public class FeignRestController {
    @Autowired
    private SchedualServiceHello schedualServiceHello;

    /**
     * @author 章辉勇
     * @创建时间 2018/12/12
     * @描述 测试feign功能，主要是测试@RequestBody接收数据，用于对比
     * @参数
     * @返回值
     */
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        String clientOne = schedualServiceHello.sayHelloFromClientOne(user);
        return clientOne;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getFast(@RequestParam String name) {
        String clientOne = schedualServiceHello.sayGetFromClientOne(name);
        return clientOne;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String postFast(@RequestParam String name) {
        String clientOne = schedualServiceHello.sayPostFromClientOne(name);
        return clientOne;
    }


}
