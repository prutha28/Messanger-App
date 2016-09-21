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
import javax.ws.rs.core.MediaType;

import org.prutha.rest.messanger.model.Profile;
import org.prutha.rest.messanger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {

	private ProfileService service = new ProfileService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles() {
		return service.getAllProfiles();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return service.addProfile(profile);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return service.getProfile(profileName);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return service.updateProfile(profile);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName) {
		service.removeProfile(profileName);
	}
}
