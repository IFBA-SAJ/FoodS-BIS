package org.acme.dto;
import org.acme.controller.ClienteController;
import org.acme.servico.ClienteServico;

public class ClienteDto {
    public String nome;
    public String email;
    public double saldo;

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
