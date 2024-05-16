package org.jp.resource;

import org.jp.application.Result;
import org.jp.dto.EstadoDTO;
import org.jp.dto.EstadoResponseDTO;
import org.jp.service.EstadoService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    EstadoService estadoService;

    //private static final Logger LOGER = Logger.getLogger(modeloResource.class);

    @POST
    @Transactional
    public Response insert(EstadoDTO dto) throws Exception {
        try {
            return Response.status(Status.CREATED).entity(estadoService.insert(dto)).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(EstadoDTO dto, @PathParam ("id") Long id){

        try {
        estadoService.update(dto, id);
        return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        try {
            estadoService.delete(id);
            return Response.noContent().build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam ("id") Long id) {
        
        try {
            EstadoResponseDTO estadoResponseDTO = estadoService.findByID(id);
            return Response.ok(estadoResponseDTO).build();

        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response findAll(){
        return Response.ok(estadoService.findByAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam ("nome") String nome) {
        try {
            return Response.ok(estadoService.findByNome(nome)).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

}
