package com.wit.ctw.datasourcemultiple.config;

import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * school数据源
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
entityManagerFactoryRef = "entityManagerFactorySchool",
transactionManagerRef = "transactionManagerSchool",
basePackages = {"com.wit.ctw.datasourcemultiple.web.repository.school" }) // 设置Repository所在位置
public class SchoolDataSource {

	@Autowired
	@Qualifier("school")
	private DataSource schoolDataSource;

	@Resource
	private JpaProperties jpaProperties;

	@Bean(name = "entityManagerSchool")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactorySchool(builder).getObject().createEntityManager();
	}

	@Bean(name = "entityManagerFactorySchool")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySchool(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(schoolDataSource).properties(getVendorProperties(schoolDataSource))
				// 设置实体类所在位置
				.packages("com.wit.ctw.datasourcemultiple.web.entity.school")
				//可用schoolPersistenceUnit进行自定义sql查询
				.persistenceUnit("schoolPersistenceUnit").build();
	}

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}

	@Bean(name = "transactionManagerSchool")
	public PlatformTransactionManager transactionManagerSchool(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactorySchool(builder).getObject());
	}
}
