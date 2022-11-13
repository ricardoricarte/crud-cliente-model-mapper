package br.com.cliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cliente.models.Cliente;
import br.com.cliente.repositories.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

  private ClienteRepository clienteRepository;

  public Cliente salvar(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  public List<Cliente> listaClientes() {
    return clienteRepository.findAll();
  }

  public Optional<Cliente> buscarPorId(Long id) {
    return clienteRepository.findById(id);
  }

  public void removerPorId(Long id) {
    clienteRepository.deleteById(id);
  }

}
