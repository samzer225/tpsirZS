package rest;

import java.util.Collection;

import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import dao.UserDao;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import system.User;


@Path("/user")
@Produces({"application/json"})
@Tag(name = "USER RESOURCE", description = "test")
public class UserResource {

	UserDao dao = new UserDao();

	@GET
	@Path("/{id}")
	public User getUserById(@PathParam("id") Long id)  {
		User user;
		try {
			user = dao.findOne(id);
		}catch (Exception e) {
			user = null;
		}
		
		return user;
	}
	
	@GET
	public Collection<User> getUser(){
		return dao.findAll();
	}
	
	@POST
	@Consumes("application/json")
	public Response addUser(
			@RequestBody(description = "Label object to add user", required = true) User user) {
		try {
			dao.save(user);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur! Les données ne sont pas correctes : " + user.toString()).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUserById(@PathParam("id") Long id) {
		try{
			dao.deleteById(id);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur lors de la suppression").build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@PATCH
	@Consumes("application/json")
	public Response updateUser(@Parameter(description = "Label properties to modify", required = true) User user) {
		try {
			User u = dao.findOne(user.getIdUser());
			if(user.getName() != null)
				u.setName(user.getName());
			if(user.getPseudo() != null)
				u.setPseudo(user.getPseudo());
			if(user.getEmail() != null)
				u.setEmail(user.getEmail());
			if(user.getListTickets() != null)
				u.setListTickets(user.getListTickets());
			if(user.getListCom()!= null)
				u.setListCom(user.getListCom());
			dao.update(u);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur! Les données ne sont pas correctes : " + user).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite : "+e.getMessage()).build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
}
