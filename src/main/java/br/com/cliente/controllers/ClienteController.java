package br.com.cliente.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.cliente.models.Cliente;
import br.com.cliente.services.ClienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

  private ClienteService clienteService;

  private ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente salvar(@RequestBody Cliente cliente) {
    return clienteService.salvar(cliente);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Cliente> listaClientes() {
    return clienteService.listaClientes();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Cliente buscarPorId(@PathVariable("id") Long id) {
    return clienteService.buscarPorId(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void removerClientes(@PathVariable("id") Long id) {
    clienteService.buscarPorId(id)
        .map(cliente -> {
          clienteService.removerPorId(cliente.getId());
          return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void atualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
    clienteService.buscarPorId(id)
        .map(clienteBase -> {
          modelMapper.map(cliente, clienteBase);
          clienteService.salvar(clienteBase);
          return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
  }

}
