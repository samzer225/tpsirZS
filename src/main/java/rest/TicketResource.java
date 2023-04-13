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

import dao.TicketDao;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import system.Ticket;

@Path("/ticket")
@Produces({"application/json"})
@Tag(name = "TICKET RESOURCE", description = "test")
public class TicketResource {

	TicketDao dao = new TicketDao();
	
	@GET
	@Path("/{id}")
	public Ticket getTicketById(@PathParam("id") Long id)  {
		Ticket ticket;
		try {
			ticket = dao.findOne(id);
		}catch (Exception e) {
			ticket = null;
		}
		
		return ticket;
	}
	
	@GET
	public Collection<Ticket> getTicket() {
		return dao.findAll();
	}
	
	@POST
	@Consumes("application/json")
	public Response addTicket(
			@RequestBody(description = "Ticket object to add", required = true) Ticket ticket) {
		try {
			dao.save(ticket);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur ! Les données ne sont pas correctes : " + ticket.toString()).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteTicketById(@PathParam("id") Long id) {
		try{
			dao.deleteById(id);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur lors de la suppression du ticket").build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite lors de la suppression du ticket").build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
	
	@PATCH
	@Consumes("application/json")
	public Response updateTicket(@Parameter(description = "Ticket properties to modify", required = true) Ticket ticket) {
		try {
			Ticket t = dao.findOne(ticket.getIdTicket());
			if(ticket.getSujet() != null)
				t.setSujet(ticket.getSujet());
			if(ticket.getDescription() != null)
				t.setDescription(ticket.getDescription());
			if(ticket.getStatut() != null)
				t.setStatut(ticket.getStatut());
			if(ticket.getTag() != null)
				t.setTag(ticket.getTag());
			if(ticket.getUser() != null)
				t.setUser(ticket.getUser());
			if(ticket.getUserST() != null)
				t.setUserST(ticket.getUserST());
			if(ticket.getCommentaire() != null)
				t.setCommentaire(ticket.getCommentaire());
			dao.update(t);
		} catch (PersistenceException e) {
			return Response.serverError().entity("Erreur ! Les données ne sont pas correctes : " + ticket).build();
		} catch (Exception e) {
			return Response.serverError().entity("Une erreur inconnue s'est produite : "+e.getMessage()).build();
		}
		return Response.ok().entity("SUCCESS").build();
	}
}
