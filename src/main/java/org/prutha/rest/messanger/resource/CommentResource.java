package org.prutha.rest.messanger.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.prutha.rest.messanger.model.Comment;
import org.prutha.rest.messanger.service.CommentService;

@Path("/")
public class CommentResource {

	private CommentService service = new CommentService();
	
	@GET
	public String getComments(){
		return "subresource";
	}
	
	@POST
	public Comment addComment( Comment comment){
		return service.addComment(comment);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@QueryParam("commentId") String commentId){
		return service.getComment(commentId);
	}
	
	@PUT
	@Path("/{commentid}")
	public Comment updateComment(@QueryParam("commentid") int commentId, Comment comment){
		comment.setId(commentId);
		return service.updateComment(comment);
	}
	
	@DELETE
	@Path("/{commentid}")
	public Comment deleteComment(@QueryParam("commentid") int commentId){
		return service.deleteComment(commentId);
	}
	
}
