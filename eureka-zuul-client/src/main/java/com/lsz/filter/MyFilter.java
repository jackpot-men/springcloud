package com.lsz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.bouncycastle.cert.ocsp.Req;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 实现zuul的过滤器，只需要继承ZuulFilter 并实现filterType() 和 filterOrder() 两个抽象方法。以及
 * IZuulFilter的shuouldFilter() 和 Object run()两个方法
 * filterType()及时过滤器的类型，分为四种： pre，post，routing erro
 * filterOrder() 是过滤顺序， int类型值，值越小，越早执行。
 * shouldFilter() 表示该过滤器是否过滤逻辑，如果为true 则执行 run() 如果为false 则不执行run()
 * run() 具体过滤的逻辑。
 * 本例中检查参数是否传了token，如果没穿则不被路由请求到具体的服务直接返回响应 401
 */
@Component
public class MyFilter extends ZuulFilter {

    //private  static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run(){
         RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessTonken = request.getParameter("token");
        if(accessTonken == null){
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                return null;
            }
        }
        System.out.println("token is OK");
        return null;
    }
}
