package at.htl.boundary;

import at.htl.control.DanceClassRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/api/danceclasses")
@Tag(name = "DanceClass REST endpoint")
public class DanceClassEndpoint {
    @Inject
    DanceClassRepository danceClassRepository;

    @GET
    @Operation(
            summary = "Get dancers",
            description = "Gets all dancers from repository"
    )
    public Response findAll(){ return Response.ok(danceClassRepository.findAllDanceClasses()).build();}
}
