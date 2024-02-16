package org.acme.dto;
import java.util.List;
import org.acme.entidade.Cliente;
import org.acme.entidade.Pagamento;
import org.acme.entidade.Pedido;
import org.acme.entidade.SituacaoPagamento;
import org.acme.controller.ComandaControler;

public class ComandaDto {
    public ClienteDto cliente;
    public List<Pedido> pedidos;
    public Pagamento pagamento;
    public SituacaoPagamento situacaoPagamento;
    

    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    public SituacaoPagamento getSituacaoPagamento() {
        return situacaoPagamento;
    }
    public void setSituacaoPagamento(SituacaoPagamento situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }
    public ClienteDto getCliente() {
        return cliente;
    }
    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }
   
    
}
