package org.acme.entidade;
import java.math.BigDecimal;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.acme.servico.PedidoServico;

@Entity
@Table(name = "pedido" )
public class Pedido extends PanacheEntity{
    public Comanda comanda;
    public String descricao;
    public BigDecimal valor;

    public Comanda getComanda() {
        return comanda;
    }
    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    
}
