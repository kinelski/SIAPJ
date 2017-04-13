import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControladorSIAPJTest {
	ControladorSIAPJ control;
	Processo proc;
	@Before
	public void setUp(){
		control = new ControladorSIAPJ();
		proc = new Processo();
		proc.setId(1244);
		proc.setEmail("fulano@provedor.com");
		proc.setTelefone("(12)12345-6789");
		proc.setNomeReclamante("Marcella");
		proc.setContent("A conta de luz ta um absurrrdo!");
	}
	@Test
	public void testValidId() {
		assertTrue(control.initProcesso(proc));
	}
	
	@Test
	public void testInvalidId() {
		proc.setId(-345);
		assertFalse(control.initProcesso(proc));
	}

}
