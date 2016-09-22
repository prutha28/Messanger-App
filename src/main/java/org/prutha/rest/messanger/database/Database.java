package org.prutha.rest.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.prutha.rest.messanger.model.Comment;
import org.prutha.rest.messanger.model.Like;
import org.prutha.rest.messanger.model.Message;
import org.prutha.rest.messanger.model.Profile;
import org.prutha.rest.messanger.model.Share;

/**
 * This is a dummy class that stores some hard-coded data. 
 */
public class Database {

	private static Map<Integer, Message> messages = new HashMap<Integer, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	private static Map<Integer, Comment> comments = new HashMap<Integer, Comment>();
	private static Map<Integer, Like> likes = new HashMap<Integer, Like>();
	private static Map<Integer, Share> shares = new HashMap<Integer, Share>();
	
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
	
	public static Map<Integer, Comment> getAllComments(){
		comments.put(1, new Comment(1, "Valar Morghulis", "Arya"));
		comments.put(2, new Comment(2, "Winter is comin'", "Ned"));
		return comments;
	}
}
