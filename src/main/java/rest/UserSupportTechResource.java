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

import dao.UserSupportTechDao;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import system.User;
import system.UserSupportTech;


@Path("/userST")
@Produces({"application/json"})
@Tag(name = "USER SUPPORT TECH RESOURCE")
public class UserSupportTechResource extends UserResource {

	UserSupportTechDao dao = new UserSupportTechDao();
	
	@GET
	@Path("/{id}")
	public UserSupportTech getUserSTById(@PathParam("id") Long id)  {
		UserSupportTech userST;
		try {
			userST = dao.findOne(id);
		}catch (Exception e) {
			userST = null;
		}
		return userST;
	}
	
	@GET
	public Collection<UserSupportTech> getUserST(){
		return dao.findAll();
	}
	
	@POST
	@Consumes("application/json")
	public Response addUserST(
			@RequestBody(description = "Label object to add user st", required = true) UserSupportTech userST) {
		try {
			dao.save(userST);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur! Les données ne sont pas correctes : " + userST.toString()).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUserByIdST(@PathParam("id") Long id) {
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
	public Response updateUserST(@Parameter(description = "Label properties to modify", required = true) UserSupportTech userST) {
		try {
			UserSupportTech u = dao.findOne(userST.getIdUser());
			if(userST.getName() != null)
				u.setName(userST.getName());
			if(userST.getJob() != null)
				u.setJob(userST.getJob());
			dao.update(u);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur! Les données ne sont pas correctes : " + userST).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite : "+e.getMessage()).build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
}
