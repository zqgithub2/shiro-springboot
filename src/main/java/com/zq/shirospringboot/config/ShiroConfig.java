package com.zq.shirospringboot.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zq
 * @create 2020-12-14 22:48
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        System.out.println("执行=>getShiroFilterFactoryBean");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /*
        anon:无需认证就可以访问
        authc:必需认证才可以访问
        user:必需拥有记住我功能才能用
        perms:拥有对某个资源的权限才能访问
        role:拥有某个角色权限才能访问
        */
        Map<String, String> filterMap = new LinkedHashMap<>();
        //filterMap.put("/user/*","authc"); 注意如果使用*这种方式使用，下面的perms也要使用这种方式
        //即不能filterMap.put("/user/*","authc"); filterMap.put("/user/add","perms[user:add]");
        //如果要使用*号就都使用
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        //有user:add权限才可以访问/user/add,没有授权会跳转到授权页面
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");
        return shiroFilterFactoryBean;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        System.out.println("执行=>getDefaultWebSecurityManager");
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public UserRealm userRealm() {
        System.out.println("执行=>userRealm");
        return new UserRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
