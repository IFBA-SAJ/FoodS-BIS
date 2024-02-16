package org.acme.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.acme.entidade.Comanda;
import org.acme.entidade.Pagamento;
import org.acme.servico.PagamentoServico;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("pagamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PagamentoCrontroller {
    @Inject
    PagamentoServico pagamentoServico;

    @POST
    @Path("{id}")
    public Response realizarPagamento(@QueryParam("comandaId") Long comandaId,
                                        @QueryParam("valor") BigDecimal valor,
                                        @QueryParam("dataPagamento") String dataPagamento){
        
         Comanda comanda = Comanda.findById(comandaId);
         if(comanda == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Comanda não encontrada!").build();
         }    
         
         Pagamento pagamentoFeito = pagamentoServico.realizarPagamento(comanda, valor, LocalDateTime.parse(dataPagamento));
         
         return Response.ok(pagamentoFeito).status(204).build();
    }
}
