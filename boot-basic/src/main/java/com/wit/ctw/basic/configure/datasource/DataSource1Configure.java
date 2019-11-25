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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author twcao
 * @description sc数据源配置
 * @project boot-basic
 * @classname DataSourceConfigure
 * @date 2019/11/25 11:13
 */
@Configuration
@MapperScan(basePackages = "com.wit.ctw.basic.web.mapper.sc", sqlSessionFactoryRef = "scSqlSessionFactory")
public class DataSource1Configure {

    @Value("${spring.datasource.sc.type}")
    private Class<? extends DataSource> dataSourceType;

    @Value("${mybatis.sc.type-aliases-package}")
    private String typeAliasesPackage;

    @Primary
    @Bean(name = "scDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sc")
    public DataSource getDateSource() {
        DataSource dataSource = DataSourceBuilder.create().type(dataSourceType).build();
        return dataSource;
    }

    @Primary
    @Bean(name = "scSqlSessionFactory")
    public SqlSessionFactory scSqlSessionFactory(@Qualifier("scDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setTypeAliasesPackage(typeAliasesPackage);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/sc/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager scBusinessTransctionManager(@Qualifier("scDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean("scSqlSessionTemplate")
    public SqlSessionTemplate scSqlSessionTemplate(@Qualifier("scSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
