package com.springcloud.eurekahello.web.restcontroller;

import com.springcloud.eurekahello.domain.User;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 章辉勇
 * @创建时间 2018年12月06日
 * @描述: eureka服务hello接口:注册服务提供者
 **/
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String index(@RequestBody User user) {
        List<String> clientServices = client.getServices();
        logger.info("hello接口" + clientServices + "端口号：" + port);
        return "This is Eureka,Hello," + user.getName() + ";该接口的端口号是" + port;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getFast(@RequestParam String name) {
        List<String> clientServices = client.getServices();
        logger.info("get接口" + clientServices + "端口号：" + port);
        return "这里是eureka-Hello服务，get请求接口,接收数据是" + name + ";该接口的端口号是" + port;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String PostFast(@RequestParam String name) {
        List<String> clientServices = client.getServices();
        logger.info("post接口" + clientServices + "端口号：" + port);
        return "这里是eureka-Hello服务，post请求接口,接收数据是" + name + ";该接口的端口号是" + port;
    }


}
