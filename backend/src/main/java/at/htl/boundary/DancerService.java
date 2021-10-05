package at.htl.boundary;

import at.htl.repository.RepositoryDancer;
import at.htl.entity.Dancer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/resteasy/hello")
public class DancerService {

    @GET
    public String hello() {
        return "hello";
    }

    @Inject
    RepositoryDancer repositoryDancer;

    @GET
    @Path("DancerList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDancer(){
        return Response.accepted(repositoryDancer.getDancers()).build();
    }

    @POST
    @Path("NewDancer")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Dancer createDancer(JsonObject dancer){
        Dancer newDancer = repositoryDancer.addDancer(dancer.getString("name"), dancer.getString("address"), dancer.getInt("age") );
        return newDancer;
    }

    @Transactional
    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDancer(@PathParam("name") String name){
        Dancer deletedDancer = repositoryDancer.removeDancer(name);
        return Response.ok(deletedDancer.getName()).build();
    }

    @Transactional
    @PUT
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDancer(@PathParam("name") String name, JsonObject dancer){
        Dancer findDancerToUpdate =  repositoryDancer.getDancers().stream()
                .filter(currentDancer -> currentDancer.getName().equals(name))
                .findAny().get();

        Dancer updateDancer = repositoryDancer
                .UpdateDancer(findDancerToUpdate ,dancer.getString("name"),dancer.getString("address"), dancer.getInt("age"));
        return Response.ok(updateDancer).build();
    }


}