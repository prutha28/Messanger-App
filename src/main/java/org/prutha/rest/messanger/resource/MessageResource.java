package org.prutha.rest.messanger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.prutha.rest.messanger.model.Message;
import org.prutha.rest.messanger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService service = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return service.getAllMessages();
	}
}
