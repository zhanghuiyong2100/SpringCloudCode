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

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String index(@RequestBody User user) {
        List<String> clientServices = client.getServices();
        logger.info("hello接口" + clientServices +"端口号："+port);
        return "This is Eureka,Hello,"+user.getName()+";该接口的端口号是"+port;
    }


}
