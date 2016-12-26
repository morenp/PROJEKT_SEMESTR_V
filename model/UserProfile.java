package model;

import controler.UserProfilePanelController;
import mainClasses.AppUser;

public class UserProfile extends Model {

	UserProfilePanelController userProfilePanelController;
	private AppUser appUser;

	public UserProfile(UserProfilePanelController controller) {
		userProfilePanelController = controller;
		System.out.println(" USERPROFILE CONT To NULL : " + Main.getMainController().getUserPanelController());
		setAppUser(Main.getMainController().getUserPanelController().getUser().appUser);

	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public void change(String Name, String SecondName, String Address, String PhoneNumber) {
		appUser.setName(Name);
		appUser.setSecondName(SecondName);
		appUser.setAddress(Address);
		appUser.setPhoneNumber(PhoneNumber);
		super.informObservers();
	}

}
