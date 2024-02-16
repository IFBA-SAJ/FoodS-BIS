package org.acme.controller;

import java.util.List;

import org.acme.dto.ClienteDto;
import org.acme.dto.ComandaDto;
import org.acme.entidade.Cliente;
import org.acme.entidade.Comanda;
import org.acme.servico.ComandaServico;
import org.acme.dto.ComandaDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("comanda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComandaControler {

    @Inject
    ComandaServico comandaServico;

    @GET
    public Response listaComanda(){
        List<Comanda> comandas = comandaServico.listaComanda();
        return Response.ok(comandas).status(204).build();
    }


    @POST
    @Path("criar")
    public Response criarComanda(ComandaDto comandaDto){//criando a comanda e verificando se já existe o cliente
                             
        Comanda novaComanda = comandaServico.criarComanda(comandaDto);
        return Response.ok(novaComanda).status(204).build();
        
    }

    @PUT
    @Path("{id}")
    public Response atualizarComanda(@PathParam("id") Long id, ComandaDto dto){
        comandaServico.atualizarComanda(id, dto);

        return Response.status(204).build();
    }


    @DELETE
    @Path("{id}")
    public Response removerComanda(@PathParam("id") Long id){
        comandaServico.excluirComanda(id);
        return Response.ok().status(204).build();
    }


    
}
