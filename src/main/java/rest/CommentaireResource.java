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

import dao.CommentaireDao;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import system.Commentaire;

@Path("/commentaire")
@Produces({"application/json"})
@Tag(name = "COMMENTAIRE RESOURCE")
public class CommentaireResource {
	
	CommentaireDao dao = new CommentaireDao();
	
	@GET
	@Path("/{id}")
	public Commentaire getCommentaireById(@PathParam("id") Long id)  {
		Commentaire commentaire;
		try {
			commentaire = dao.findOne(id);
		}catch (Exception e) {
			commentaire = null;
		}
		
		return commentaire;
	}
	
	@GET
	public Collection<Commentaire> getCommentaire() {
		return dao.findAll();
	}
	
	@POST
	@Consumes("application/json")
	public Response addCommentaire(
			@RequestBody(description = "Commentaire object to add", required = true) Commentaire commentaire) {
		try {
			dao.save(commentaire);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur! Les données ne sont pas correctes : " + commentaire.toString()).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteCommentaireById(@PathParam("id") Long id) {
		try{
			dao.deleteById(id);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur lors de la suppression du commentaire").build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@PATCH
	@Consumes("application/json")
	public Response updateCommentaire(@Parameter(description = "Commentaire properties to modify", required = true) Commentaire commentaire) {
		try {
			Commentaire com = dao.findOne(commentaire.getIdCommentaire());
			if(commentaire.getCom() != null)
				com.setCom(commentaire.getCom());
			if(commentaire.getTicket() != null)
				com.setTicket(commentaire.getTicket());
			if(commentaire.getUser() != null)
				com.setUser(commentaire.getUser());
			dao.update(com);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur! Les données ne sont pas correctes : " + commentaire).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite : "+e.getMessage()).build();
		}
		return Response.ok().entity("SUCCESS").build();
	}

}
