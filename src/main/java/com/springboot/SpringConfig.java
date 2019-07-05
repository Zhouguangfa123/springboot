package com.springboot;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * com.springboot.SpringConfig
 *
 * @author zhougf
 * @date 2019/7/3
 */
//通过该注解来表明该类是一个Spring的配置，相当于一个xml文件
@Configuration
/**配置扫描包*/
@ComponentScan(basePackages = "com.springboot")
@PropertySource(value = {"classpath:mysql.properties"})
public class SpringConfig {
    @Value("${con.url}")
    private String jdbcUrl;

    @Value("${con.driverClass}")
    private String jdbcDriverClassName;

    @Value("${con.username}")
    private String userName;

    @Value("${con.password}")
    private String userPassword;

    /**会把方法名相当于bean id 所以不用getDataSource*/
    @Bean
    public DataSource dataSource(){
        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        boneCPDataSource.setDriverClass(jdbcDriverClassName);
        // 相应驱动的jdbcUrl
        boneCPDataSource.setJdbcUrl(jdbcUrl);
        // 数据库的用户名
        boneCPDataSource.setUsername(userName);
        // 数据库的密码
        boneCPDataSource.setPassword(userPassword);
        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        // 每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        // 每个分区最小的连接数
        boneCPDataSource.setMinConnectionsPerPartition(5);

        return boneCPDataSource;
    }

    /**通过该注解来表明是一个Bean对象，相当于xml中的<bean>*/
    @Bean()
    public UserDao getUserDAO(){
        // 直接new对象做演示
        return new UserDao();
    }

}
