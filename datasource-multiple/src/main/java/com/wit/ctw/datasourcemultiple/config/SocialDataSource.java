package com.wit.ctw.datasourcemultiple.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 *
 * social数据源
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
entityManagerFactoryRef = "entityManagerFactorySocial",
transactionManagerRef = "transactionManagerSocial",
// 设置Repository所在位置
basePackages = {"com.wit.ctw.datasourcemultiple.web.repository.social" })
public class SocialDataSource {
	
	@Resource
	private JpaProperties jpaProperties;

	@Autowired
	@Qualifier("social")
	private DataSource socialDataSource;

	@Primary
	@Bean(name = "entityManagerSocial")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactorySocial(builder).getObject().createEntityManager();
	}

	@Primary
	@Bean(name = "entityManagerFactorySocial")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySocial(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(socialDataSource).properties(getVendorProperties(socialDataSource))
				// 设置实体类所在位置
				.packages("com.wit.ctw.datasourcemultiple.web.entity.social")
				//可用socialPersistenceUnit进行自定义sql查询
				.persistenceUnit("socialPersistenceUnit").build();
	}

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}

	@Primary
	@Bean(name = "transactionManagerSocial")
	public PlatformTransactionManager transactionFactorySocial(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactorySocial(builder).getObject());
	}
}
