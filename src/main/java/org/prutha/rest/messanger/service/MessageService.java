package org.prutha.rest.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.prutha.rest.messanger.database.Database;
import org.prutha.rest.messanger.model.Message;

public class MessageService {

	private Map<Integer, Message> messages = Database.getAllMessages();
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage( int id ){
		return messages.get(id);
	}
	
	public Message deleteMessage( int id ){
		Message message = messages.get(id);
		messages.remove(message);
		return message;
	}
	
	public Message updateMessage( Message message ){
		if( message.getId() <= 0 ){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message addMessage( Message message ){
		message.setId(1 + messages.size());
		messages.put(message.getId(), message) ;
		return message;
	}
	
}
