/**
 * DruidDataSourceConfig.java
 * Created at 2018年4月20日
 * Created by FPM0302
 * Copyright (C) 2014-2018 FNConn, All rights reserved.
 */

package com.alan.config;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.util.StringUtils;

/**
 * <p>ClassName: DruidDataSourceConfig</p>
 * <p>Description: DruidDataSourceConfig</p>
 * <p>Author: FPM0302</p>
 * <p>Date: 2018年4月20日</p>
 */
@Configuration
public class DruidDataSourceConfig {
  /**
   * 
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(DruidDataSourceConfig.class);
  /**
   * 数据源配置的前缀
   */
  private static final String DS_PREFIX = "spring.datasource";
  /**
   * <p>Description: FilterRegistrationBean</p>
   * @return FilterRegistrationBean
   */
  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
    filterRegistrationBean.addUrlPatterns("/*");
    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    return filterRegistrationBean;
  }
  /**
   * <p>Description: ServletRegistrationBean</p>
   * @return ServletRegistrationBean
   */
  @Bean  
  public ServletRegistrationBean druidServlet() {  
      ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();  
      servletRegistrationBean.setServlet(new StatViewServlet());  
      servletRegistrationBean.addUrlMappings("/druid/*");  
      Map<String, String> initParameters = new HashMap<String, String>();  
      initParameters.put("loginUsername", "druid"); // 用户名  
      initParameters.put("loginPassword", "druid"); // 密码  
      initParameters.put("resetEnable", "false"); // 禁用HTML页面上的“Reset All”功能  
      initParameters.put("allow", "127.0.0.1"); // IP白名单 (没有配置或者为空，则允许所有访问)  
      // initParameters.put("deny", "192.168.20.38");// IP黑名单   (存在共同时，deny优先于allow) 
      servletRegistrationBean.setInitParameters(initParameters);  
      return servletRegistrationBean;  
  }  
  /**
   * 配置文件对应类，解决 spring.datasource.filters=stat,wall,log4j 无法正常注册进去
   * <p>ClassName: IDataSourceProperties</p>
   * <p>Description: TODO</p>
   * <p>Author: FPM0302</p>
   * <p>Date: 2018年4月24日</p>
   */
  @ConfigurationProperties(prefix = DS_PREFIX)
  class DataSourceProperties {
    /**
     * 
     */
    private String url;
    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;
    /**
     * 
     */
    private String driverClassName;
    /**
     * 
     */
    private int initialSize;
    /**
     * 
     */
    private int minIdle;
    /**
     * 
     */
    private int maxActive;
    /**
     * 
     */
    private int maxWait;
    /**
     * 
     */
    private int timeBetweenEvictionRunsMillis;
    /**
     * 
     */
    private int minEvictableIdleTimeMillis;
    /**
     * 
     */
    private String validationQuery;
    /**
     * 
     */
    private Boolean testWhileIdle;
    /**
     * 
     */
    private Boolean testOnBorrow;
    /**
     * 
     */
    private Boolean testOnReturn;
    /**
     * 
     */
    private Boolean poolPreparedStatements;
    /**
     * 
     */
    private int maxPoolPreparedStatementPerConnectionSize;
    /**
     * 
     */
    private String filters;
    /**
     * 
     */
    private String connectionProperties;
    /**
     * <p>Description: DataSource</p>
     * @return DataSource
     */
    @Bean
    @Primary
    public DataSource dataSource() {
      DruidDataSource datasource = new DruidDataSource();
      datasource.setUrl(url);
      datasource.setUsername(username);
      datasource.setPassword(password);
      datasource.setDriverClassName(driverClassName);
      
      //下面连接池的补充设置
      if (this.initialSize > 0) {
        datasource.setInitialSize(initialSize);
      }
      if (this.minIdle > 0) {
        datasource.setMinIdle(minIdle);
      }
      if (this.maxActive > 0) {
        datasource.setMaxActive(maxActive);
      }
      if (this.maxWait > 0) {
        datasource.setMaxWait(maxWait);
      }
      if (this.timeBetweenEvictionRunsMillis > 0) {
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
      }
      if (this.minEvictableIdleTimeMillis > 0) {
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
      }
      if (!StringUtils.isEmpty(validationQuery)) {
        datasource.setValidationQuery(validationQuery);
      }
      if (this.testWhileIdle != null) {
        datasource.setTestWhileIdle(testWhileIdle);
      }
      if (this.testOnBorrow != null) {
        datasource.setTestOnBorrow(testOnBorrow);
      }
      if (this.testOnReturn != null) {
        datasource.setTestOnReturn(testOnReturn);
      }
      if (this.poolPreparedStatements != null) {
        datasource.setPoolPreparedStatements(poolPreparedStatements);
      }
      if (maxPoolPreparedStatementPerConnectionSize > 0) {
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
      }
      try {
        if (!StringUtils.isEmpty(filters)) {
          datasource.setFilters(filters);
        }
      } catch (SQLException e) {
        LOGGER.error("druid configuration initialization filter: " + e);
      }
      if (!StringUtils.isEmpty(connectionProperties)) {
        datasource.setConnectionProperties(connectionProperties);
      }
      return datasource;
    }
    /**
     * <p>Description: TODO</p>
     * @return the url
     */
    public String getUrl() {
      return url;
    }
    /**
     * <p>Description: TODO</p>
     * @param url the url to set
     */
    public void setUrl(String url) {
      this.url = url;
    }
    /**
     * <p>Description: TODO</p>
     * @return the username
     */
    public String getUsername() {
      return username;
    }
    /**
     * <p>Description: TODO</p>
     * @param username the username to set
     */
    public void setUsername(String username) {
      this.username = username;
    }
    /**
     * <p>Description: TODO</p>
     * @return the password
     */
    public String getPassword() {
      return password;
    }
    /**
     * <p>Description: TODO</p>
     * @param password the password to set
     */
    public void setPassword(String password) {
      this.password = password;
    }
    /**
     * <p>Description: TODO</p>
     * @return the driverClassName
     */
    public String getDriverClassName() {
      return driverClassName;
    }
    /**
     * <p>Description: TODO</p>
     * @param driverClassName the driverClassName to set
     */
    public void setDriverClassName(String driverClassName) {
      this.driverClassName = driverClassName;
    }
    /**
     * <p>Description: TODO</p>
     * @return the initialSize
     */
    public int getInitialSize() {
      return initialSize;
    }
    /**
     * <p>Description: TODO</p>
     * @param initialSize the initialSize to set
     */
    public void setInitialSize(int initialSize) {
      this.initialSize = initialSize;
    }
    /**
     * <p>Description: TODO</p>
     * @return the minIdle
     */
    public int getMinIdle() {
      return minIdle;
    }
    /**
     * <p>Description: TODO</p>
     * @param minIdle the minIdle to set
     */
    public void setMinIdle(int minIdle) {
      this.minIdle = minIdle;
    }
    /**
     * <p>Description: TODO</p>
     * @return the maxActive
     */
    public int getMaxActive() {
      return maxActive;
    }
    /**
     * <p>Description: TODO</p>
     * @param maxActive the maxActive to set
     */
    public void setMaxActive(int maxActive) {
      this.maxActive = maxActive;
    }
    /**
     * <p>Description: TODO</p>
     * @return the maxWait
     */
    public int getMaxWait() {
      return maxWait;
    }
    /**
     * <p>Description: TODO</p>
     * @param maxWait the maxWait to set
     */
    public void setMaxWait(int maxWait) {
      this.maxWait = maxWait;
    }
    /**
     * <p>Description: TODO</p>
     * @return the timeBetweenEvictionRunsMillis
     */
    public int getTimeBetweenEvictionRunsMillis() {
      return timeBetweenEvictionRunsMillis;
    }
    /**
     * <p>Description: TODO</p>
     * @param timeBetweenEvictionRunsMillis the timeBetweenEvictionRunsMillis to set
     */
    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
      this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }
    /**
     * <p>Description: TODO</p>
     * @return the minEvictableIdleTimeMillis
     */
    public int getMinEvictableIdleTimeMillis() {
      return minEvictableIdleTimeMillis;
    }
    /**
     * <p>Description: TODO</p>
     * @param minEvictableIdleTimeMillis the minEvictableIdleTimeMillis to set
     */
    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
      this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }
    /**
     * <p>Description: TODO</p>
     * @return the validationQuery
     */
    public String getValidationQuery() {
      return validationQuery;
    }
    /**
     * <p>Description: TODO</p>
     * @param validationQuery the validationQuery to set
     */
    public void setValidationQuery(String validationQuery) {
      this.validationQuery = validationQuery;
    }
    /**
     * <p>Description: TODO</p>
     * @return the testWhileIdle
     */
    public boolean isTestWhileIdle() {
      return testWhileIdle;
    }
    /**
     * <p>Description: TODO</p>
     * @param testWhileIdle the testWhileIdle to set
     */
    public void setTestWhileIdle(boolean testWhileIdle) {
      this.testWhileIdle = testWhileIdle;
    }
    /**
     * <p>Description: TODO</p>
     * @return the testOnBorrow
     */
    public boolean isTestOnBorrow() {
      return testOnBorrow;
    }
    /**
     * <p>Description: TODO</p>
     * @param testOnBorrow the testOnBorrow to set
     */
    public void setTestOnBorrow(boolean testOnBorrow) {
      this.testOnBorrow = testOnBorrow;
    }
    /**
     * <p>Description: TODO</p>
     * @return the testOnReturn
     */
    public boolean isTestOnReturn() {
      return testOnReturn;
    }
    /**
     * <p>Description: TODO</p>
     * @param testOnReturn the testOnReturn to set
     */
    public void setTestOnReturn(boolean testOnReturn) {
      this.testOnReturn = testOnReturn;
    }
    /**
     * <p>Description: TODO</p>
     * @return the maxPoolPreparedStatementPerConnectionSize
     */
    public int getMaxPoolPreparedStatementPerConnectionSize() {
      return maxPoolPreparedStatementPerConnectionSize;
    }
    /**
     * <p>Description: TODO</p>
     * @param maxPoolPreparedStatementPerConnectionSize the maxPoolPreparedStatementPerConnectionSize to set
     */
    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
      this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }
    /**
     * <p>Description: TODO</p>
     * @return the filters
     */
    public String getFilters() {
      return filters;
    }
    /**
     * <p>Description: TODO</p>
     * @param filters the filters to set
     */
    public void setFilters(String filters) {
      this.filters = filters;
    }
    /**
     * <p>Description: TODO</p>
     * @return the connectionProperties
     */
    public String getConnectionProperties() {
      return connectionProperties;
    }
    /**
     * <p>Description: TODO</p>
     * @param connectionProperties the connectionProperties to set
     */
    public void setConnectionProperties(String connectionProperties) {
      this.connectionProperties = connectionProperties;
    }
    /**
     * <p>Description: TODO</p>
     * @return the poolPreparedStatements
     */
    public boolean isPoolPreparedStatements() {
      return poolPreparedStatements;
    }
    /**
     * <p>Description: TODO</p>
     * @param poolPreparedStatements the poolPreparedStatements to set
     */
    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
      this.poolPreparedStatements = poolPreparedStatements;
    }
    
    
    
    
  }
  
}
