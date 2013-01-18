package tmn.cpg.wut.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import tmn.cpg.wut.dao.UserProfileDao;
import tmn.cpg.wut.service.UserProfileService;

@Configuration
public class TestJdbcConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:mem:aname");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}
	
	@Bean
	public UserProfileDao getUserProfileDao(){
		UserProfileDao userProfileDao = new UserProfileDao();
		return userProfileDao;
	}
	
	@Bean
	public UserProfileService getUserProfileService(){
		UserProfileService userProfileService = new UserProfileService();
		return userProfileService;
	}
}
