package tmn.cpg.wut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tmn.cpg.wut.dao.UserProfileDao;
import tmn.cpg.wut.model.UserProfile;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileDao userProfileDao;
	
	@Transactional
	public UserProfile getUserProfile(String name){
		UserProfile userProfile = userProfileDao.findByUserName(name);
		return userProfile;
	}
	
}
