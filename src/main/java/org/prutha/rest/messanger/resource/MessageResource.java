package org.prutha.rest.messanger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.prutha.rest.messanger.model.Message;
import org.prutha.rest.messanger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService service = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size) {
		if (year > 0) {
			return service.getAllMessagesForYear(year);
		}

		if (start > 0 && size > 0)
			return service.getAllMessagesPaginated(start, size);

		return service.getAllMessages();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") int id) {
		return service.getMessage(id);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") int id, Message message) {
		message.setId(id);
		return service.updateMessage(message);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") int id) {
		service.deleteMessage(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return service.addMessage(message);
	}
}
