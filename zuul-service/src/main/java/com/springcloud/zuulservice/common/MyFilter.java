package com.springcloud.zuulservice.common;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhanghuiyong
 * @创建时间 2018年12月14日
 * @描述: 自定义过滤器
 **/
@Component
public class MyFilter extends ZuulFilter {


    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *  pre：路由之前
     *  routing：路由之时
     *  post： 路由之后
     *  error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /** 过滤的顺序  */
    @Override
    public int filterOrder() {
        return 0;
    }

    /** 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。  */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /** 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。  */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println(request.getMethod());
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            System.out.println("token 为空");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        System.out.println("OK");
        return null;
    }
}
