package org.prutha.rest.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.prutha.rest.messanger.database.Database;
import org.prutha.rest.messanger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = Database.getAllProfiles();
	
	public ProfileService(){
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile( String profileName){
		return profiles.get(profileName);
	}
	
	public Profile updateProfile( Profile profile){
		if( profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void removeProfile( String profileName){
		profiles.remove(profileName);
	}
	
	public Profile addProfile( Profile profile){
		profile.setId(profiles.size() + 1 );
		profiles.put( profile.getProfileName(), profile);
		return profile;
	}
}
