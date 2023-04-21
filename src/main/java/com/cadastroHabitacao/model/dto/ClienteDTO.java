package com.cadastroHabitacao.model.dto;

import com.cadastroHabitacao.model.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;

    public ClienteDTO(Cliente cliente) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Cliente toEntity() {
        Cliente cliente = new Cliente();

        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setEmail(email);
        return cliente;
    }
}
