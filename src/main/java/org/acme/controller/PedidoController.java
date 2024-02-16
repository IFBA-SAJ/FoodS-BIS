package org.acme.controller;
import java.math.BigDecimal;
import org.acme.entidade.Comanda;
import org.acme.entidade.Pedido;
import org.acme.servico.PedidoServico;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("pedidos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoController {
    
    @Inject
    PedidoServico pedidoServico;

    @POST
    public Response criarPedido(@QueryParam("comandaId") Long comandaID,
                                @QueryParam("descricao") String descricao,
                                @QueryParam("valor") BigDecimal valor
 ){
    Comanda comandaBusca = Comanda.findById(comandaID);
    if(comandaBusca == null){
        return Response.status(Response.Status.NOT_FOUND).entity("Comanda não encontrada!").build();

    }
      Pedido pedidoOk = pedidoServico.criarPedido(comandaBusca, descricao, valor) ;                            
        
      return Response.ok(pedidoOk).status(204).build();
 }
}
