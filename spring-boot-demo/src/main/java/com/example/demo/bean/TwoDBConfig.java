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
@MapperScan(basePackages = {"com.example.demo.mapper.two*"}, sqlSessionTemplateRef = "sqlSessionTemplateTwo")
public class TwoDBConfig {

    @Bean(name = "dataSourceTwo")
    public DataSource dataSourceCar(TwoDBProperties oneDBConfig){
        DruidXADataSource dataSource = new DruidXADataSource();
        BeanUtils.copyProperties(oneDBConfig,dataSource);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(dataSource);
        xaDataSource.setUniqueResourceName("dataSourceTwo");
        return xaDataSource;
    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory sqlSessionFactoryCar(@Qualifier("dataSourceTwo") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //设置此属性可以不用包名，直接使用类型进行映射sql文件
        //bean.setTypeAliasesPackage("com.example.demo.entiy");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/two/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplateTwo")
    public SqlSessionTemplate sqlSessionTemplateCar(
            @Qualifier("sqlSessionFactoryTwo") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
