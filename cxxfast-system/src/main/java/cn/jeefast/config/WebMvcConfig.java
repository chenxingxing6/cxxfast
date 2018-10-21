package cn.jeefast.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
* @description MVC视图配置
*
* @author theodo
* @email 36780272@qq.com
* @date 2017年11月6日 下午5:14:52
*/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers( registry );
    } 
    
}
