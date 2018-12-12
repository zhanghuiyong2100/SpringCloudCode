package com.springcloud.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.ribbonconsumer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author 章辉勇
 * @创建时间 2018年12月06日
 * @描述: 测试消费
 **/
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    private User user = new User();

    /**
     * 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法helloError，
     * 熔断方法直接返回了一个字符串
     */
    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name) {
//        String getForEntity = getForEntity(name);
//        String getForObject = getForObject(name);
//        URI postForLocation = postForLocation(name);
        String postForObject = fostForObject(name);
        return postForObject;
    }

    private String helloError(String name){
        return "Hello接口调入错误,传入数据"+name;

    }

    private String fostForObject(String name) {
        user.setName(name);
        /**
         * <p>getForObject 函数说明  </p>
         *
         * @param String url 请求的路径
         * @param @Nullable Object request  post请求的参数
         * @param Class<T> responseType  返回结果集的类型，可为String或者实体
         * @param Object... uriVariables  可略，附加在url路径后面的参数，替换{1}中的数据
         * @return uri
         * @其它信息
         */
        String postForObject = restTemplate.postForObject("http://EUREKA-SERVICE-HELLO/hello", user, String.class);
        return postForObject;
    }

    private URI postForLocation(String name) {

        user.setName(name);
        URI uri = restTemplate.postForLocation("http://EUREKA-SERVICE-HELLO/hello", user, String.class);
        return uri;
    }

    private String getForObject(String name) {
        /**
         * <p>getForObject 函数说明  </p>
         *
         * @param String url 请求的路径
         * @param Class<T> responseType  返回结果集的类型，可为String或者实体
         * @param Object... uriVariables  可略，附加在url路径后面的参数，替换{1}中的数据
         * @return
         * @其它信息
         */
        String object = restTemplate.getForObject("http://EUREKA-SERVICE-HELLO/hello?name=" + name, String.class);
        return object;
    }

    private String getForEntity(String name) {
        /**
         * <p>getForEntity函数说明  </p>
         *
         * @param String url 请求的路径
         * @param Class<T> responseType  返回结果集的类型，可为String或者实体
         * @param Object... uriVariables  可略，附加在url路径后面的参数，替换{1}中的数据
         * @return
         * @其它信息
         */
        ResponseEntity<String> entity = restTemplate.getForEntity("http://EUREKA-SERVICE-HELLO/hello?name={1}", String.class, "上善若水");
        String entityBody = entity.getBody();
        return entityBody;
    }


}
