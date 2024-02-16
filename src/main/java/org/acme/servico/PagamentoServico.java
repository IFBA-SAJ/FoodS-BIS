package org.acme.servico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.acme.entidade.Comanda;
import org.acme.entidade.Pagamento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PagamentoServico {
    
    @Transactional
    public Pagamento realizarPagamento(Comanda comanda, BigDecimal valor, LocalDateTime data ){
        Pagamento pagamento = new Pagamento();
        pagamento.comanda = comanda;
        pagamento.valor = valor;
        pagamento.data = data;

        return pagamento;
    }
}
