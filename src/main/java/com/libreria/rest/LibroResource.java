package com.libreria.rest;

import com.libreria.dao.LibroBeanDAO;
import com.libreria.data.LibroBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("libro")
@Produces("application/json;charset=utf-8")
@Api(value = "libro", description = "Servicio libro")
public class LibroResource {

    private LibroBeanDAO libroBeanDAO;

    public LibroResource() {
        this.libroBeanDAO = new LibroBeanDAO();
    }

    @GET
    @Path("/find/all")
    @ApiOperation("list objetos libro")
    public Response list() {
        return Response.ok(this.libroBeanDAO.listPorAutor()).build();
    }

    @GET
    @Path("/find/{id}")
    @ApiOperation("get objeto libro por id")
    public Response get(@PathParam("id") Long id) {
        LibroBean bean = this.libroBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bean).build();
    }

    @POST
    @Path("/save")
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("save objeto libro")
    public Response save(LibroBean bean) {
        this.libroBeanDAO.save(bean);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    @ApiOperation("delete objeto libro")
    public Response delete(@PathParam("id") Long id) {
        LibroBean bean = this.libroBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.libroBeanDAO.delete(bean);
        return Response.ok().build();
    }
}
