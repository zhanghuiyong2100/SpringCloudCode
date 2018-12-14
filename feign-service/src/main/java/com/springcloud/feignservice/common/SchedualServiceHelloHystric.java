package com.springcloud.feignservice.common;

import com.springcloud.feignservice.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author zhanghuiyong
 * @创建时间 2018年12月13日
 * @描述:   实现断路由报错功能
 **/
@Component
public class SchedualServiceHelloHystric implements SchedualServiceHello {
    @Override
    public String sayHelloFromClientOne(User user) {
        return "请求错误," + user.getName();
    }

    @Override
    public String sayGetFromClientOne(String name) {
        return "get请求错误," + name;
    }

    @Override
    public String sayPostFromClientOne(String name) {
        return "post请求错误," + name;
    }
}
