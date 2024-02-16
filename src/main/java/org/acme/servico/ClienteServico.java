package org.acme.servico;
import java.util.List;
import java.util.Optional;

import org.acme.entidade.Cliente;
import org.acme.controller.ClienteController;
import org.acme.dto.ClienteDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ClienteServico {

    public List<Cliente> listaCliente(){
        return Cliente.listAll();
    }

    @Transactional
    public Cliente salvarCliente(ClienteDto dto){
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        novoCliente.setSaldo(dto.getSaldo());
        novoCliente.persist();

        return novoCliente;

    }

    @Transactional
    public void atualizarCliente(Long id, ClienteDto dto){
        
        Cliente cliAtualizado = new Cliente();
        Optional<Cliente> clienteOp = Cliente.findByIdOptional(id);
        if(clienteOp.isEmpty()){
            throw new NullPointerException("Cliente não encontrado!");
        }
        cliAtualizado = clienteOp.get();
        cliAtualizado.setNome(dto.getNome());
        cliAtualizado.setEmail(dto.getEmail());
        cliAtualizado.setSaldo(dto.getSaldo());

        cliAtualizado.persist();
    }

    @Transactional
    public void removerCliente(Long id){
       Optional<Cliente> ClienteOp = Cliente.findByIdOptional(id);
       
       if(ClienteOp.isEmpty()){
        throw new NullPointerException("Cliente não encontrado!");
       }

       Cliente clienteRemove = ClienteOp.get();

       clienteRemove.delete();
    }
}
