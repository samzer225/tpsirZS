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

import dao.TagDao;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;


@Path("/tag")
@Produces({"application/json"})
@Tag(name = "TAG RESOURCE")
public class TagResource {
	
	TagDao dao = new TagDao();
	
	@GET
	@Path("/{id}")
	public system.Tag getTagById(@PathParam("id") Long id)  {
		system.Tag tag;
		try {
			tag = dao.findOne(id);
		}catch (Exception e) {
			tag = null;
		}
		
		return tag;
	}
	
	@GET
	public Collection<system.Tag> getTag() {
		return dao.findAll();
	}
	
	@POST
	@Consumes("application/json")
	public Response addTag(
			@RequestBody(description = "Tag object to add", required = true) system.Tag tag) {
		try {
			dao.save(tag);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur! Les données ne sont pas correctes : " + tag.toString()).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteTagById(@PathParam("id") Long id) {
		try{
			dao.deleteById(id);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur lors de la suppression du Tag").build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@PATCH
	@Consumes("application/json")
	public Response updateTag(@Parameter(description = "Label properties to modify", required = true) system.Tag tag) {
		try {
			system.Tag t = dao.findOne(tag.getId());
			if(tag.getLibelle() != null)
				t.setLibelle(tag.getLibelle());
			if(tag.getDes () != null)
				t.setDes(tag.getDes());
			if(tag.getTickets() != null)
				t.setTickets(tag.getTickets());
			dao.update(t);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur! Les données ne sont pas correctes : " + tag).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite : "+e.getMessage()).build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
}
