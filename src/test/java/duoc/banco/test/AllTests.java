package duoc.banco.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClienteCrear.class, ClienteEliminar.class, ClienteModificar.class, ClientesListar.class,
		ClienteVer.class })
public class AllTests {

}
