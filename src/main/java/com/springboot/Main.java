package com.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * Main
 *
 * @author zhougf
 * @date 2019/7/3
 */
public class Main {
    public static void main(String[] args) throws Exception{
        // 通过Java配置来实例化Spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 销毁该容器
        context.destroy();
    }

}

