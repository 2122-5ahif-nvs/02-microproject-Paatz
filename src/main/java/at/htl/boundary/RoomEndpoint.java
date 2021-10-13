package at.htl.boundary;

import at.htl.control.RoomRepository;
import at.htl.entities.Room;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/rooms")
@Tag(name = "Room REST endpoint")
public class RoomEndpoint {
    @Inject
    RoomRepository roomRepository;

    @GET
    @Operation(
            summary = "Get Rooms",
            description = "Gets all Rooms from Repository"
    )
    public Response findAll(){return Response.ok(roomRepository.findAllRooms()).build();}
}
