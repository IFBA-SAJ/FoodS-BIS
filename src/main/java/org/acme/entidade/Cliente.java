package org.acme.entidade;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import org.acme.servico.ClienteServico;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import org.acme.controller.ClienteController;

@Entity
@Table(name ="cliente")
public class Cliente extends PanacheEntity {
    public String nome;
    public String email;
    public double saldo;
    
    public Cliente() {
        this.saldo = 0.0;
    }

    public Cliente(String nome, String email) {
        this();
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
