package com.example.demo.bean;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 主数据源加载， 注入Atomikos的数据源Bean
 * Jack.an
 */

@Configuration
// 扫描dao或mapper接口
@MapperScan(basePackages = {"com.example.demo.mapper.one*"}, sqlSessionTemplateRef = "sqlSessionTemplateOne")
public class OneDBConfig {
    /**
     * 配置链接池  设置链接属性
     * @param oneDBConfig
     * @return
     */
    @Primary//多数据源配置的时候此注解只能有一个
    @Bean(name = "dataSourceOne")
    public DataSource dataSourceOne(OneDBProperties oneDBConfig){
        DruidXADataSource dataSource = new DruidXADataSource();
        BeanUtils.copyProperties(oneDBConfig,dataSource);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(dataSource);
        xaDataSource.setUniqueResourceName("dataSourceOne");
        return xaDataSource;
    }

    /**
     * 设置sqlsessionfactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactoryOne")
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("dataSourceOne") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //设置此属性可以不用包名，直接使用类型进行映射sql文件
        //bean.setTypeAliasesPackage("com.example.demo.entiy");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/one/*Mapper.xml"));
        return bean.getObject();
    }

    /**
     * 设置SqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionTemplateOne")
    public SqlSessionTemplate sqlSessionTemplateOne(
            @Qualifier("sqlSessionFactoryOne") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
