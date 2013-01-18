package tmn.cpg.wut.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tmn.cpg.wut.model.UserProfile;

public class UserProfileRowMapper implements RowMapper<UserProfile>{

	public UserProfile mapRow(ResultSet rs, int numRow) throws SQLException {
		UserProfile userProfile = new UserProfile();
		userProfile.setUserProfileId(rs.getString("USER_PROFILE_ID"));
		userProfile.setUserName(rs.getString("NAME"));
		userProfile.setEmail(rs.getString("EMAIL"));
		return userProfile;
	}

}
