package com.example.demo.bean;/**
 * Created by Administrator on 2018/4/7.
 */
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * 在Spring Boot事务管理中，实现自接口PlatformTransactionManager。
 * 当我们使用了spring-boot-starter-jdbc依赖的时候，框 架会自动默认注入DataSourceTransactionManager。
 * 所以我们不需要任何额外 配置就可以用@Transactional注解进行事务的使用。
 * Jack.an
 */
@Configuration
//开启注解  和spring中的<tx:annotation-driven /> 效果是一样的
@EnableTransactionManagement
public class XATransactionManagerConfig {

    @Bean(name = "userTransaction")
    public UserTransaction userTransaction() throws Throwable {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(10000);
        return userTransactionImp;
    }

    @Bean(name = "atomikosTransactionManager", initMethod = "init", destroyMethod = "close")
    public TransactionManager atomikosTransactionManager() throws Throwable {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }

    @Bean(name = "transactionManager")
    @DependsOn({ "userTransaction", "atomikosTransactionManager" })
    public PlatformTransactionManager transactionManager() throws Throwable {
        return new JtaTransactionManager(userTransaction(),atomikosTransactionManager());
    }
}
