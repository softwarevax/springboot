package com.wit.ctw.basic.configure.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author twcao
 * @description 数据源sb配置
 * @project boot-basic
 * @classname DataSource2Configure
 * @date 2019/11/25 11:16
 */
@Configuration
@MapperScan(basePackages = "com.wit.ctw.basic.web.mapper.sb", sqlSessionFactoryRef = "sbSqlSessionFactory")
public class DataSource2Configure {

    @Value("${spring.datasource.sb.type}")
    private Class<? extends DataSource> dataSourceType;

    @Value("${mybatis.sb.type-aliases-package}")
    private String typeAliasesPackage;

    @Bean(name = "sbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sb")
    public DataSource getDateSource() {
        DataSource dataSource = DataSourceBuilder.create().type(dataSourceType).build();
        return dataSource;
    }

    @Bean(name = "sbSqlSessionFactory")
    public SqlSessionFactory sbSqlSessionFactory(@Qualifier("sbDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        // 实体包路径
        bean.setTypeAliasesPackage(typeAliasesPackage);
        // *Mapper.xml文件路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/sb/*.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager sbBusinessTransctionManager(@Qualifier("sbDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sbSqlSessionTemplate")
    public SqlSessionTemplate sbSqlSessionTemplate(@Qualifier("sbSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
