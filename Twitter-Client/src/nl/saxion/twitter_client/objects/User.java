
package nl.saxion.twitter_client.objects;

public class User {
	private long userID;
	private String name;
	private String userName;
	private String profilePhotoUrl;
	
	public User (String userName, String name, String photo) {
		this.name = name;
		this.userName = userName;
		this.setProfilePhotoUrl(photo);
		this.userID = userID;
	}
	

	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the profilePhotoUrl
	 */
	public String getProfilePhotoUrl() {
		return profilePhotoUrl;
	}

	/**
	 * @param set the profilePhotoUrl
	 */
	public void setProfilePhotoUrl(String profilePhotoUrl) {
		this.profilePhotoUrl = profilePhotoUrl;
	}

}
