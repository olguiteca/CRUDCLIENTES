package duoc.banco.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import duoc.banco.modelo.Cliente;
import duoc.banco.modelo.dao.IClienteDAO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteEliminar {
	
	@Autowired
	TestEntityManager manager;
	
	@Autowired
	IClienteDAO dao;

	@Before
	public void setUp() throws Exception {
		Cliente cliente = new Cliente("18350689-4", "Pedro", "Pedreros", "pedro@email.com", "(+569)0303456");
		this.manager.persist(cliente);
		cliente = new Cliente("17673589-K", "Eulalio", "Cartagena", "superlalio@machotes.com", "(+562)8754129");
		this.manager.persist(cliente);
		cliente = new Cliente("12004896-7", "Petronila", "Ramos", "nila@regias.cl", "(+569)89562456");
		this.manager.persist(cliente);
		cliente = new Cliente("13589741-8", "Luzmira", "Villarroel", "luz.vi@ejecutiva.com", "(+569)96581254");
		this.manager.persist(cliente);
	}

	
	@Test
	public void cuandoElimina1Entonces3Clientes() {
		this.dao.deleteById("18350689-4");
		int largo = this.dao.findAll().size();
		assertTrue("Ahora son " + largo + " Pero deberían ser 3", largo == 3);
	}
	
}