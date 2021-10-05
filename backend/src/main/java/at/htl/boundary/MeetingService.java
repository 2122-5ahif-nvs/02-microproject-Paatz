package at.htl.boundary;

import at.htl.repository.RepositoryMeeting;
import at.htl.entity.Meeting;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resteasy/hello")
public class MeetingService {

    @GET
    public String hello() {
        return "hello";
    }

    @Inject
    RepositoryMeeting repositoryMeeting;

    @GET
    @Path("MeetingList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGroup(){
        return Response.accepted(repositoryMeeting.getMeetings()).build();
    }

    @POST
    @Path("NewMeeting")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Meeting createMeeting(JsonObject group){
        Meeting newMeeting = repositoryMeeting.addMeeting(group.getString("day"));
        return newMeeting;
    }

    @Transactional
    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMeeting(@PathParam("name") String name){
        Meeting deleteMeeting = repositoryMeeting.removeMeeting(name);
        return Response.ok(deleteMeeting.getDay()).build();
    }

    @Transactional
    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMeeting(@PathParam("name") String day,JsonObject meeting){
        Meeting findMeetingToUpdate =  repositoryMeeting.getMeetings().stream()
                .filter(currentMeeting -> currentMeeting.getDay().equals(day))
                .findAny().get();

        Meeting updateMeeting = repositoryMeeting
                .UpdateMeeting(findMeetingToUpdate ,meeting.getString("name"));
        return Response.ok(updateMeeting).build();
    }


}