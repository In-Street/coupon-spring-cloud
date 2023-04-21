package cn.cloud.customer.service.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-26 19:10
 **/
@Configuration
public class SeataConfig {

    @Bean(name="druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    @Bean(name="dataSource")
    @Primary
    public DataSource dataSource(){
        return new DataSourceProxy(druidDataSource());
    }
}
