package com.pietvandongen.anagrapp.resource;

import com.pietvandongen.anagrapp.service.AnagramService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("anagram")
public class AnagramResource {

    @Inject
    private AnagramService anagramService;

    @GET
    public Response isHealthy() {
        return Response.ok().build();
    }

    @GET
    @Path("/{word}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnagrams(@PathParam("word") String word) {
        // @todo

        return Response.serverError().build();
    }
}
