import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.capitani.cliente.domain.model.Cliente;
import com.capitani.cliente.domain.repository.ClienteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import util.DatabaseCleaner;
import util.ResourceUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroClienteIT {

	private static final String CLIENTE_EMAIL_INEXISTENTE = "s.gomes234@gmail.com";

	@LocalServerPort
	private int port;
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Cliente cliente;
	private String jsonCorretoCliente;
	
	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/clientes";

		jsonCorretoCliente = ResourceUtils.getContentFromResource(
				"/json/correto/cliente.json");
		
		databaseCleaner.clearTables();
		prepararDados();
	}
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarClientes() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveRetornarStatus201_QuandoCadastrarClientes() {
		given()
			.body(jsonCorretoCliente)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}

	@Test
	public void deveRetornarRespostaEStatusCorretos_QuandoConsultarClienteExistente() {
		given()
			.pathParam("email", cliente.getEmail())
			.accept(ContentType.JSON)
		.when()
			.get("/{email}")
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("nome", equalTo(cliente.getEmail()));
	}
	
	@Test
	public void deveRetornarStatus404_QuandoConsultarCLienteInexistente() {
		given()
			.pathParam("email", CLIENTE_EMAIL_INEXISTENTE)
			.accept(ContentType.JSON)
		.when()
			.get("/{email}")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	private void prepararDados() {
		Cliente cliente = new Cliente();
		cliente.setNome("Cliente teste");
		cliente.setCep("71939-000");
		cliente.setCpf("999-000-000-11");
		clienteRepository.save(cliente);
	}
	
}
