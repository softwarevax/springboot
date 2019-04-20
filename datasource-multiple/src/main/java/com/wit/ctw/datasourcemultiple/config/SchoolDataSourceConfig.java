package com.wit.ctw.datasourcemultiple.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * school数据眼部配置
 */
@Configuration
public class SchoolDataSourceConfig {

	/**
	 *
	 * school 数据源名称不要太长、太长会导致数据源初始化失败
	 */
	@Qualifier("school")
	@Bean(name = "school")
	//根据文件前缀，从属性文件中加载数据库配置
	@ConfigurationProperties(prefix = "datasource.school")
	public DataSource auditDataSource() {
		return DataSourceBuilder.create().build();
	}
}
