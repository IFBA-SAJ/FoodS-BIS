package org.acme.servico;

import java.util.List;
import java.util.Optional;
import org.acme.dto.ClienteDto;
import org.acme.dto.ComandaDto;
import org.acme.entidade.Cliente;
import org.acme.entidade.Comanda;
import org.acme.controller.ComandaControler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class ComandaServico {
   

    public List<Comanda> listaComanda(){
        return Comanda.listAll();
    }   


    @Transactional
    public Comanda criarComanda(ComandaDto comandaRecebida){
        Comanda novaComanda = new Comanda();
        novaComanda.setCliente(comandaRecebida.getCliente());
        novaComanda.setPagamento(comandaRecebida.getPagamento());
        novaComanda.setPedidos(comandaRecebida.getPedidos());
        novaComanda.setSituacaoPagamento(novaComanda.getSituacaoPagamento());
        novaComanda.persist();
        return novaComanda;
    }

    @Transactional
    public void atualizarComanda(Long id, ComandaDto dto){
        Comanda comandaAtualiza = new Comanda();
        Optional<Comanda> comandaOp =  Comanda.findByIdOptional(id);
        if(comandaOp.isEmpty()){
            throw new NullPointerException("Comanda não encontrada!");
        }
        comandaAtualiza.cliente = dto.cliente;
        comandaAtualiza.pagamento = dto.pagamento;
        comandaAtualiza.situacaoPagamento = dto.situacaoPagamento;
    } 

    public void excluirComanda(Long id){
        Optional<Comanda> comandaOp = Comanda.findByIdOptional(id);
        if(comandaOp.isEmpty()){
            throw new NullPointerException("Comanda não encontrada!");
        }
        Comanda comandaExclui = comandaOp.get();

        comandaExclui.delete();
    }

    
}
