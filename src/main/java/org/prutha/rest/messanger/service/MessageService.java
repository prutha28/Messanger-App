package org.prutha.rest.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.prutha.rest.messanger.database.Database;
import org.prutha.rest.messanger.model.Message;

public class MessageService {

	private Map<Integer, Message> messages = Database.getAllMessages();

	public MessageService() {
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();

		for (Message message : messages.values()) {
			cal.setTime(message.getDate());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}

		return messagesForYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> paginatedMessages = new ArrayList<Message>(messages.values());

		if (start + size > paginatedMessages.size())
			return new ArrayList<Message>();
		return paginatedMessages.subList(start, start + size);
	}

	public Message getMessage(int id) {
		return messages.get(id);
	}

	public void deleteMessage(int id) {
		messages.remove(id);
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(1 + messages.size());
		messages.put(message.getId(), message);
		return message;
	}

}
