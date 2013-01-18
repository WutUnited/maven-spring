package tmn.cpg.wut.model;

public class UserProfile {

	String userProFileId;
	String userName;
	String email;
	
	public String getEmail(String name) {
		if(name != null){
			if(name.equalsIgnoreCase("wut")){
				email = "wut@mail.com";
			}else if(name.equalsIgnoreCase("nut")){
				email = "nut@mail.com";
			}
		}
		return email;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserProfileId() {
		return this.userName;
	}
	
	public void setUserProfileId(String userProFileId) {
		this.userProFileId = userProFileId;
	}

	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
