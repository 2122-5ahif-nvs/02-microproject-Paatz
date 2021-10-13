package at.htl.boundary;

import at.htl.control.DanceClassRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/daceclasses")
public class DanceClassEndpoint {
    @Inject
    DanceClassRepository danceClassRepository;

    @GET
    public Response findAll(){ return Response.ok(danceClassRepository.findAllDanceClasses()).build();}
}
