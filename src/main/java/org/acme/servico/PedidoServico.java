package org.acme.servico;
import java.math.BigDecimal;
import org.acme.entidade.Comanda;
import org.acme.entidade.Pedido;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.controller.PedidoController;


@ApplicationScoped
public class PedidoServico {
    
    @Transactional
    public Pedido criarPedido(Comanda comanda, String descricao, BigDecimal valor){
        Pedido pedidoNovo = new Pedido();
        pedidoNovo.comanda = comanda;
        pedidoNovo.descricao = descricao;
        pedidoNovo.valor = valor;
        
        return pedidoNovo;
    }
}
