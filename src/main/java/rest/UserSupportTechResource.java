package rest;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dao.UserSupportTechDao;
import io.swagger.v3.oas.annotations.tags.Tag;


@Path("/userST")
@Produces({"application/json"})
@Tag(name = "USER SUPPORT TECH RESOURCE", description = "test")
public class UserSupportTechResource extends UserResource {

	UserSupportTechDao dao = new UserSupportTechDao();
}
