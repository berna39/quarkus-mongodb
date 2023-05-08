package com.terminator.event;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventController {

    @Inject
    EventRepository repository;

    @GET
    public Response get(){
        return Response.ok(repository.findAll().list()).build();
    }

    @GET
    @Path("/ordered")
    public Response ordered(){
        return Response.ok(repository.findOrderByTitle()).build();
    }

    @POST
    public Response save(Event event){
        repository.persist(event);
        return Response.ok("saved successfully").build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id){
        Event event = repository.findById(new ObjectId(id));
        return Response.ok(event).build();
    }

    @GET
    @Path("/{title}")
    public Response getByTitle(@PathParam("title") String title){
        Event event = repository.findByTitle(title);
        return Response.ok(event).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Event event){
        event.id = new ObjectId(id);
        repository.update(event);
        return Response.ok(event).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id){
        repository.deleteById(new ObjectId(id));
        return Response.ok("deleted successfully").build();
    }
}
