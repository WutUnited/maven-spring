package tmn.cpg.wut.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestUserProfile {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void getWutEmail(){
		
		String name = "wut";
		UserProfile userProfile = new UserProfile();
		assertEquals("wut@mail.com", userProfile.getEmail(name));
		
	}
	
	@Test
	public void getNutEmail(){
		
		String name = "nut";
		UserProfile userProfile = new UserProfile();
		assertEquals("nut@mail.com", userProfile.getEmail(name));
		
	}
	
	@Test
	public void getOtherEmail(){
		
		String name = "jee";
		UserProfile userProfile = new UserProfile();
		assertEquals(null, userProfile.getEmail(name));
		
	}
	
	@Test
	public void getNullEmail(){
		
		String name = null;
		UserProfile userProfile = new UserProfile();
		assertEquals(null, userProfile.getEmail(name));
		
	}

}
