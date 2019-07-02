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
public class ClienteCrear {
	
	@Autowired
	TestEntityManager manager;
	
	@Autowired
	IClienteDAO dao;

	@Before
	public void setUp() throws Exception {
		Cliente cliente = new Cliente("18350689-4", "Pedro", "Pedreros", "pedro@email.com", "(+569)0303456");
		this.manager.persist(cliente);
	}

	@Test
	public void cuandoInserta1Entonces2Clientes() {
		this.dao.save(new Cliente("17673589-K", "Eulalio", "Cartagena", "superlalio@machotes.com", "(+562)8754129"));
		int largo = this.dao.findAll().size();
		assertTrue("Ahora son " + largo + " Pero deberían ser 2", largo == 2);
	}

}
