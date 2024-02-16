package org.acme.entidade;
import java.util.List;
import org.acme.dto.ClienteDto;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "comanda")
public class Comanda extends PanacheEntity{
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
    public Pagamento setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
        return pagamento;
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
