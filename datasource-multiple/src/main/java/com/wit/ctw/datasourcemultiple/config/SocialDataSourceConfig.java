package com.wit.ctw.datasourcemultiple.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * social数据源配置
 */
@Configuration
public class SocialDataSourceConfig {

	/**
	 * 基础数据源、默认数据源
	 * 数据源名称不要太长、太长会导致数据源初始化失败
	 * @return
	 */
	@Primary
	@Qualifier("social")
	@Bean(name = "social")
	@ConfigurationProperties(prefix = "datasource.social")
	public DataSource dataSource() {
		DataSource dataSource = DataSourceBuilder.create().build();
		return dataSource;
	}

}
