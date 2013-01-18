package tmn.cpg.wut.dao;

import javax.sql.DataSource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import tmn.cpg.wut.config.TestJdbcConfig;
import tmn.cpg.wut.config.TestWebConfig;
import tmn.cpg.wut.model.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestWebConfig.class, TestJdbcConfig.class })
public class TestUserProfileDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void TestCreateUserProfileSuccess(){
		
		String userId = "03";
		String userName = "wut";
		String userEmail = "wut@mail.com";
		
		UserProfileDao userProfileDao = new UserProfileDao();
		userProfileDao.setDataSource(dataSource);
		boolean result = userProfileDao.createUserProfile(userId, userName, userEmail);

		assertEquals(true, result);
		
	}
	
	@Test 
	public void TestCreateUserProfileAlreayExist(){
		String userId = "03";
		String userName = "wut";
		String userEmail = "wut@mail.com";
		
		UserProfileDao userProfileDao = new UserProfileDao();
		userProfileDao.setDataSource(dataSource);
		
		userProfileDao.createUserProfile(userId, userName, userEmail);
		boolean result = userProfileDao.createUserProfile(userId, userName, userEmail);

		assertEquals(false, result);
	}
	
	@Test
	public void TestFindUserByNameNutSuccess(){
		String userName = "nut";
		
		UserProfileDao userProfileDao = new UserProfileDao();
		userProfileDao.setDataSource(dataSource);

		UserProfile userProfile = userProfileDao.findByUserName(userName);
		assertEquals(userName, userProfile.getUserName());
	}
	
	@Test
	public void TestFindUserByNameOOSuccess(){
		String userName = "oo";
		
		UserProfileDao userProfileDao = new UserProfileDao();
		userProfileDao.setDataSource(dataSource);
		
		UserProfile userProfile = userProfileDao.findByUserName(userName);
		assertEquals(userName, userProfile.getUserName());
	}
	
	@Before
	public void beforeRunRest(){
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		
		String sql_drop_table = "DROP TABLE IF EXISTS USER_PROFILE;";
		jdbcTemplate.execute(sql_drop_table);
		
		StringBuilder sql_create_table = new StringBuilder();
		sql_create_table.append(" CREATE TABLE USER_PROFILE( ");
		sql_create_table.append(" USER_PROFILE_ID  VARCHAR(10) NOT NULL PRIMARY KEY, ");
		sql_create_table.append(" NAME VARCHAR(100), ");
		sql_create_table.append(" EMAIL VARCHAR(100) ");
		sql_create_table.append(" ); ");
		jdbcTemplate.execute(sql_create_table.toString());
		
		String sql_insert_nut_user = "INSERT INTO USER_PROFILE (USER_PROFILE_ID, NAME, EMAIL) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql_insert_nut_user, new Object[]{"01", "nut", "nut@mail.com"});
		
		String sql_insert_oo_user = "INSERT INTO USER_PROFILE (USER_PROFILE_ID, NAME, EMAIL) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql_insert_oo_user, new Object[]{"02", "oo", "00@mail.com"});
	}
	
}
