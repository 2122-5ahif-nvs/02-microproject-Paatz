package at.htl.boundary;

import at.htl.control.DanceGroupRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/api/dancegroups")
@Tag(name = "DanceGroup REST endpoint")
public class DanceGroupEndpoint {
    @Inject
    DanceGroupRepository danceGroupRepository;

    @GET
    @Operation(
            summary = "Get DanceGroups",
            description = "Gets all DanceGroups from Repository"
    )
    public Response findAll(){return Response.ok(danceGroupRepository.findAllDanceGroups()).build();}
}
