package at.htl.boundary;

import at.htl.control.DancerRepository;
import at.htl.entities.DanceClass;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/dancers")
@Tag(name = "Dancer REST endpoint")
public class DancerEndpoint {
    @Inject
    DancerRepository dancerRepository;

    @GET
    @Operation(
            summary = "Get Dancers",
            description = "Gets all Dancers from Repository"
    )
    public Response findAll(){return Response.ok(dancerRepository.findAllDancers()).build();}
}
