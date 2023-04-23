package com.cadastroHabitacao.model.dto;

import com.cadastroHabitacao.model.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private Long id;
    private String nome;
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

}
