package tmn.cpg.wut.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tmn.cpg.wut.model.UserProfile;
import tmn.cpg.wut.model.rowmapper.UserProfileRowMapper;

@Repository
public class UserProfileDao {

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	public boolean createUserProfile(String userId, String userName, String userEmail) {
		
		boolean result = false;
		
		String sql = "INSERT INTO USER_PROFILE (USER_PROFILE_ID, NAME, EMAIL) VALUES (?, ?, ?)";
		
		try {
			jdbcTemplate.update(sql, new Object[]{userId, userName, userEmail});
			result = true;
		} catch (Exception e) {
			result = false;
		}

		return result;
	}

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	public UserProfile findByUserName(String userName) {
		System.out.println("Query start.");
		String sql = "SELECT * FROM USER_PROFILE WHERE NAME = ?";
		try {
			UserProfile userProfile = (UserProfile) jdbcTemplate.queryForObject(
					sql, new Object[]{userName}, new UserProfileRowMapper());
			return userProfile;
		} catch (Exception e) {
			return null;
		}
		
	}

}
