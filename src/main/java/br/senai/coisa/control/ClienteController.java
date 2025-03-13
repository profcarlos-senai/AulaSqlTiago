package br.senai.coisa.control;
import br.senai.coisa.model.Cliente;
import br.senai.coisa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Criar ou atualizar um cliente
    @PostMapping
    public ResponseEntity<Cliente> criarOuAtualizarCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.salvarCliente(cliente);
        return ResponseEntity.ok(savedCliente);
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos os clientes
    @GetMapping
    public Iterable<Cliente> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }

    // Deletar cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
