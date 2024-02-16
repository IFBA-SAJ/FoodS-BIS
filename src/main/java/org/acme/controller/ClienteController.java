package org.acme.controller;
import java.util.List;

import org.acme.dto.ClienteDto;
import org.acme.entidade.Cliente;
import org.acme.servico.ClienteServico;
import jakarta.inject.Inject;
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



@Path("clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ClienteController{

    @Inject
    ClienteServico clienteServico;

    @GET
    public Response listaCliente(){
      List<Cliente> clientes =  clienteServico.listaCliente();

      return Response.ok(clientes).build();
    }

    @POST
    public Response salvarCliente(ClienteDto dto){

        Cliente novoCliente = clienteServico.salvarCliente(dto);

        return Response.ok(novoCliente).status(201).build();
    }

    @PUT
    @Path("{id}")
    public Response atualizarCliente(@PathParam("id") Long id, ClienteDto dto){
        clienteServico.atualizarCliente(id, dto);

        return Response.status(204).build();
    }

    @DELETE
    @Path("{id}")
    public Response removerCliente(@PathParam("id") Long id){

        clienteServico.removerCliente(id);

        return Response.status(204).build();
    }


}
