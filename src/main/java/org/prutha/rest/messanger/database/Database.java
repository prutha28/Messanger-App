package org.prutha.rest.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.prutha.rest.messanger.model.Message;
import org.prutha.rest.messanger.model.Profile;

/**
 * 
 * @author prutha
 * This is a dummy class that 
 */
public class Database {

	private static Map<Integer, Message> messages = new HashMap<Integer, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Integer, Message> getAllMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getAllProfiles(){
		return profiles;
	}
}
