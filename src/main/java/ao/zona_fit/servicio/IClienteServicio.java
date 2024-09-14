package ao.zona_fit.servicio;

import ao.zona_fit.Modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();

    public Cliente buscarClientePorId(Integer idCliente);

    //se utilizara el mismo metodo tanto para insetar como para actualizar un cliente
    // La diferencia que se hara es que si la llave primaria del objeto es igual a nulo es insercion
    // si el valor de llave primaria es diferente de nulo se hara una actualizacion
    public void guardarCliente(Cliente cliente);

    // segun el id ese cliente se eliminara
    public void eliminarCliente(Cliente cliente);

}
