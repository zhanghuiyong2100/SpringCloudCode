package com.springcloud.feignservice.common;

import com.springcloud.feignservice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 章辉勇
 * @创建时间 2018年12月12日
 * @描述: feign接口
 **/
@FeignClient(value = "EUREKA-SERVICE-HELLO",fallback =SchedualServiceHelloHystric.class )
public interface SchedualServiceHello {

    /**
     * <p> 测试feign功能，主要是测试@RequestBody接收数据，用于对比 </p>
     *
     * @param
     * @return
     * @其它信息
     */
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    String sayHelloFromClientOne(@RequestBody User user);

    /**
     * <p> 测试get请求 </p>
     *
     * @param
     * @return
     * @其它信息 其中@RequestParam中的value一定要有值，要不然会报错，具体原因为何，暂时不知
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    String sayGetFromClientOne(@RequestParam(value = "name") String name);

    /**
     * <p> 测试post请求，和hello对比,主要测试@RequestParam和@RequestBody的区别 </p>
     *
     * @param
     * @return
     * @其它信息
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    String sayPostFromClientOne(@RequestParam(value = "name") String name);

}
