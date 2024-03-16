package uniandes.edu.co.proyecto;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.Direccion;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.repositorio.DireccionRepository;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private DireccionRepository direccionRepository;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Direccion direccion  = direccionRepository.darDireccionPorId(1);
		System.out.println(direccion);

	}

}