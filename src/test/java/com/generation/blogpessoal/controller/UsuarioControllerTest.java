package com.generation.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.UsuarioRepository;
import com.generation.blogpessoal.service.UsuarioService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() 
	{
		usuarioRepository.deleteAll();
		
		usuarioService.cadastrarUsuario(new Usuario(0L, "Root", "root@root.com", "rootroot", " "));
	}
	
@Test // Indica que este Método executará um teste.
@Order(1)
@DisplayName("Cadastrar Um Usuário") // @DisplayName configura uma mensagem que será exibida ao invés do nome do Método.
public void deveCriarUmUsuario()
	{
	
	//um objeto da Classe Usuario. 
	HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario> (new Usuario(0L,"Paulo Antunes", "paulo_antune@semail.com.br", "13465278", "-"));
	
	/*a Requisição HTTP será enviada através do Método exchange() da Classe TestRestTemplate e a Resposta da Requisição (Response) será recebida 
 pelo objeto corpoResposta do tipo ResponseEntity*/
	ResponseEntity<Usuario> corpoResposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, Usuario.class);
	
	/*checaremos se a resposta da requisição (Response), é a resposta esperada (CREATED 🡪 201). 
	 * Para obter o status da resposta vamos utilizar o Método getStatusCode() da Classe ResponseEntity.*/
	assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
	}

@Test
@DisplayName("Não deve permitir duplicação do Usuário")
public void naoDeveDuplicarUsuario() {
	
	usuarioService.cadastrarUsuario(new Usuario(0L,"Maria da Silva", "maria_silva@email.com.br", "13465278", "-"));
	
	HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario> (new Usuario(0L, "Maria da Silva", "maria_silva@email.com.br", "13465278", "-"));
	
	ResponseEntity<Usuario> corpoResposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST,corpoRequisicao, Usuario.class);
	
	assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
}

@Test
@DisplayName("Atualizar um usuário")
public void deveAtualizarUmUsuario() {
	
	Optional<Usuario> usuarioCadastrado = usuarioService.cadastrarUsuario(new Usuario(0L, "Juliana Andrews", "juliana_andrews@email.com.br", "juliana123", "-"));
	
	Usuario usuarioUpdate = new Usuario(usuarioCadastrado.get().getId(), "Juliana Andrews Ramos", "juliana_ramos@email.com.br", "juliana123", "-");
	
	HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(usuarioUpdate);
	
	ResponseEntity<Usuario> corpoResposta = testRestTemplate.withBasicAuth("root@root.com", "rootroot").exchange("/usuarios/atualizar", HttpMethod.PUT, corpoRequisicao, Usuario.class);
	
	assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
	
}

@Test
@DisplayName("Listar todos os Usuários")
public void deveMostrarTodosUsuarios() {
	
	usuarioService.cadastrarUsuario(new Usuario(0L, "Sabrina Sanches", "sabrina_sanches@email.com.br", "sabrina123", "-"));
	
	
	usuarioService.cadastrarUsuario(new Usuario(0L, "Ricardo Marques", "ricardo_marques@email.com.br", "ricardo123", "-"));
	
	ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("root@root.com", "rootroot")
			.exchange("/usuarios/all", HttpMethod.GET, null, String.class);
			
			assertEquals(HttpStatus.OK, resposta.getStatusCode());
}

}
