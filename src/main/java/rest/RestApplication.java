package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

@ApplicationPath("/")
public class RestApplication extends Application {


	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> resources = new HashSet<>();


		// SWAGGER endpoints
		resources.add(OpenApiResource.class);
		resources.add(CommentaireResource.class);
		resources.add(TagResource.class);
		resources.add(TicketResource.class);
		resources.add(UserResource.class);
		resources.add(UserSupportTechResource.class);
        //NEW LINE TO ADD
		resources.add(SwaggerResource.class);

		return resources;
	}
}