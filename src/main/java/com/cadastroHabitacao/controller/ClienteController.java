package com.cadastroHabitacao.controller;

import com.cadastroHabitacao.config.ModelMapperConfiguration;
import com.cadastroHabitacao.model.domain.Cliente;
import com.cadastroHabitacao.model.dto.ClienteDTO;
import com.cadastroHabitacao.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ClienteDTO criarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente cevSalvo = clienteService.salvar(cliente);
        return modelMapper.map(cevSalvo, ClienteDTO.class);
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteService.listar();
       return clientes.stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
               .collect(Collectors.toList());
    }

    @PutMapping
    public ClienteDTO atualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente clienteAtualizado = clienteService.editar(cliente);
        return modelMapper.map(clienteAtualizado, ClienteDTO.class);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluir(id);
    }

}
