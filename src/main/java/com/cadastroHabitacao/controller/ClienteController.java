package com.cadastroHabitacao.controller;

import com.cadastroHabitacao.model.domain.Cliente;
import com.cadastroHabitacao.model.dto.ClienteDTO;
import com.cadastroHabitacao.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    private ClienteService clienteService = new ClienteService();
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ClienteDTO criarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente cevSalvo = clienteService.salvar(cliente);
        return modelMapper.map(cevSalvo, ClienteDTO.class);
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteService.listar();
       return clientes.stream().map(cliente -> modelMapper.map(clientes, ClienteDTO.class))
               .collect(Collectors.toList());
    }

    @PutMapping
    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente clienteAtualizado = clienteService.editar(cliente);
        return modelMapper.map(clienteAtualizado, ClienteDTO.class);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(Long id) {
        clienteService.excluir(id);
    }

}
