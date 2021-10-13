package at.htl.boundary;

import at.htl.control.DancerRepository;
import at.htl.entities.DanceClass;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/dancers")
public class DancerEndpoint {
    @Inject
    DancerRepository dancerRepository;

    @GET
    public Response findAll(){return Response.ok(dancerRepository.findAllDancers()).build();}
}
