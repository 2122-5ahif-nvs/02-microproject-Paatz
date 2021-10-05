package at.htl.boundary;

import at.htl.repository.RepositoryGroup;
import at.htl.entity.Group;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resteasy/hello")
public class GroupService {

    @GET
    public String hello() {
        return "hello";
    }

    @Inject
    RepositoryGroup repositoryGroup;

    @GET
    @Path("GroupList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGroup(){
        return Response.accepted(repositoryGroup.getGroups()).build();
    }

    @POST
    @Path("NewGroup")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Group createGroup(JsonObject group){
        Group newGroup = repositoryGroup.addGroup(group.getString("groupName"));
        return newGroup;
    }

    @Transactional
    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDancer(@PathParam("name") String name){
        Group deleteGroup = repositoryGroup.removeGroup(name);
        return Response.ok(deleteGroup.getGroupName()).build();
    }

    @Transactional
    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGroup(@PathParam("name") String name, JsonObject group){
        Group findGroupToUpdate =  repositoryGroup.getGroups().stream()
                .filter(currentGroup -> currentGroup.getGroupName().equals(name))
                .findAny().get();

        Group updateGroup = repositoryGroup
                .UpdateGroup(findGroupToUpdate ,group.getString("name"));
        return Response.ok(updateGroup).build();
    }


}