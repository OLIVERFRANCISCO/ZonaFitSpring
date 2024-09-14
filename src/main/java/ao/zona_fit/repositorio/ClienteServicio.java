package ao.zona_fit.repositorio;

import ao.zona_fit.Modelo.Cliente;
import ao.zona_fit.servicio.IClienteServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

// se realizara un inyeccion de depencia

public class ClienteServicio implements IClienteServicio {
    // autoinyectar un referencia de la capa de datos
    // de la clase repositorio
    @Autowired
    // va a crear una instancia a partir del tipo de dato
    // que he proporciona y la llave primaria

    private ClienteRepositorio clienteRepositorio;


    @Override
    public List<Cliente> listarClientes() {
        // se encuentra dentro de la clase padre JpaRepositorio
        // regresara todos los clientes de la clase que tengamos en la tabla de clientes

        List<Cliente> clientes = clienteRepositorio.findAll();
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        // regresa un tipo de valor OPCIONAL
        // or Else para indicar si el cliente no esta en la base de datos regresa nulo
        Cliente cliente = clienteRepositorio.findById(idCliente).orElse(null);

        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        //todo lo hara de maneera interna y auto-matica
        clienteRepositorio.save(cliente);

    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.deleteById(cliente.getId());
    }

    public long contarCliente() {
        return clienteRepositorio.count();
    }

}
