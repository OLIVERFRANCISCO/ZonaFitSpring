//Este no es tu proyecto, solo copiaste y pegaste lo de Udemy.
package ao.zona_fit;

import ao.zona_fit.Modelo.Cliente;
import ao.zona_fit.repositorio.ClienteServicio;
import ao.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {
    @Autowired
    private IClienteServicio clienteServicio;
    // inyectar un depencia de servicio a la capa de presentacion

    private static final Logger logger =
            LoggerFactory.getLogger(ZonaFitApplication.class);

    public static void main(String[] args) {
        logger.info("Iniciando la aplicacion");
        //Levantar la fabrica de spring
        Scanner sc = new Scanner(System.in);
        SpringApplication.run(ZonaFitApplication.class, args);

        logger.info("Aplicacion Finalizada");


    }


    @Override
    public void run(String... args) throws Exception {
         logger.info("*** ZONA FIT ***");
         Scanner scanner = new Scanner(System.in);
        int opcion = 0;
         while(opcion != 6){

             try{
                 getOpcion();
                 opcion = scanner.nextInt();
                 logger.info("\n");
                 switch (opcion) {
                     case 1:
                         List<Cliente> clientes = clienteServicio.listarClientes();
                         for(Cliente cliente : clientes){
                             logger.info(cliente.toString().concat("\n"));
                         }

                         break;
                     case 2:
                         logger.info("Ingrese el id del cliente: ");
                         Integer idCliente = scanner.nextInt();
                         Cliente clienteEncontrado = clienteServicio.buscarClientePorId(idCliente);
                         if(clienteEncontrado != null) {
                             logger.info("Cliente encontrado \n ");
                             logger.info(clienteEncontrado.toString());
                         } else {
                             logger.info("Cliente no encontrado \n");

                         }
                         break;
                     case 3:
                         logger.info("Ingrese el nombre del cliente: ");
                         String nombre = scanner.next();
                         logger.info("Ingrese el apellido del cliente: ");
                         String apellido = scanner.next();
                         logger.info("Ingrese la menbresia del cliente: ");
                         int menbresia = scanner.nextInt();
                         Cliente cliente = new Cliente();
                         cliente.setNombre(nombre);
                         cliente.setApellido(apellido);
                         cliente.setMenbresia(menbresia);
                         clienteServicio.guardarCliente(cliente);
                         logger.info("\nCliente guardado/registrado");
                         break;
                     case 4:
                         logger.info("Ingrese el id del cliente si desea modificarlo: ");
                         Integer idClienteModificar = scanner.nextInt();
                         if(idClienteModificar == 0 || idClienteModificar == null){
                             logger.info("Cliente no modificado \n ");
                             break;
                         }
                         logger.info("Ingrese el nombre del cliente si desea modificarlo: ");
                         String nombreModificar = scanner.next();
                         logger.info("Ingrese el apellido del cliente si desea modificarlo: ");
                         String apellidoModificar = scanner.next();
                         logger.info("Ingrese la menbresia del cliente si desea modificarlo:  ");
                         int menbresiaModificar = scanner.nextInt();
                         Cliente clienteModificar = new Cliente();

                         clienteModificar.setId(idClienteModificar);
                         clienteModificar.setNombre(nombreModificar);
                         clienteModificar.setApellido(apellidoModificar);
                         clienteModificar.setMenbresia(menbresiaModificar);
                         if (clienteModificar.equals(clienteServicio.buscarClientePorId(idClienteModificar))) {
                             clienteServicio.guardarCliente(clienteModificar);
                             logger.info("\nCliente modificado\n");

                             break;
                         } else {
                             logger.info("Cliente no existe en la base de datos \n ");
                             break;
                         }

                     case 5:
                         logger.info("Ingrese el id del cliente: \n");
                         Integer idEliminar = scanner.nextInt();
                         var clienteEliminar = clienteServicio.buscarClientePorId(idEliminar);
                         clienteServicio.eliminarCliente(clienteEliminar);
                        break;

                     default:

                 }
             } catch (NumberFormatException e){


             }
         };
    }

    private void getOpcion(
            //Scanner scanner
    ) {

            logger.info("""
                
                1) Listar clientes
                2) Buscar cliente
                3) Agregar cliente
                4) Actualizar cliente
                5) Eliminar cliente
                6) Salir
                
                """);
           // return Integer.parseInt(scanner.nextLine());

    }
}
