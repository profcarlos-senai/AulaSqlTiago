package br.senai.coisa.service;
import br.senai.coisa.model.Cliente;
import br.senai.coisa.repo.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Criar ou atualizar cliente
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Buscar cliente por ID
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Listar todos os clientes
    public Iterable<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    // Deletar cliente por ID
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
