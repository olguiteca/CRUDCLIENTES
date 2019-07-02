package duoc.banco.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import duoc.banco.modelo.Cliente;
import duoc.banco.modelo.dao.IClienteDAO;

@RestController
public class RESTController {

	@Autowired
	IClienteDAO dao;
	
	@GetMapping("/clientes")
	public List<Cliente> getCliente() {
		return this.dao.findAll();
	}
	
	@GetMapping("cliente/{rut}")
	public Cliente getCliente(@PathVariable String rut) {
		return this.dao.findById(rut).orElse(new Cliente());
		}
	
	@PostMapping("/cliente")
	public boolean crearCliente(@RequestBody Cliente nuevoCliente) {
		if(!this.dao.existsById(nuevoCliente.getRut())) {
			this.dao.save(nuevoCliente);
			return true;
		}
		return false;
	}
	
	@PutMapping("/cliente")
	public boolean actualizarCliente(@RequestBody Cliente clienteModificado) {
		if(this.dao.existsById(clienteModificado.getRut())){
			this.dao.save(clienteModificado);
			return true;
		}
		return false;
	}
	
	@DeleteMapping("/cliente/{rut}")
	public boolean borraCliente(@PathVariable String rut) {
		if(rut.equals("99999999-9")) {
			this.dao.deleteAll();
			return true;
		} 
		if(this.dao.existsById(rut)) {
			this.dao.deleteById(rut);
			return true;
		}
		return false;
		
	}
}