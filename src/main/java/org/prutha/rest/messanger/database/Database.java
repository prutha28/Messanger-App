package org.prutha.rest.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.prutha.rest.messanger.model.Message;
import org.prutha.rest.messanger.model.Profile;

/**
 * This is a dummy class that stores some hard-coded data. 
 */
public class Database {

	private static Map<Integer, Message> messages = new HashMap<Integer, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Integer, Message> getAllMessages(){
		messages.put(1, new Message(1, "Valar Morghulis", "Arya"));
		messages.put(2, new Message(2, "Winter is comin'", "Ned"));
		return messages;
	}
	
	public static Map<String, Profile> getAllProfiles(){
		profiles.put("astark", new Profile(1, "arya", "stark", "astark"));
		profiles.put("astark", new Profile(1, "eddard", "stark", "nstark"));
		return profiles;
	}
}
