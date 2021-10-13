package at.htl.boundary;

import at.htl.control.DanceGroupRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/dancegroups")
public class DanceGroupEndpoint {
    @Inject
    DanceGroupRepository danceGroupRepository;

    @GET
    public Response findAll(){return Response.ok(danceGroupRepository.findAllDanceGroups()).build();}
}
