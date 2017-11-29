package br.com.jhonatancolina.cadastromaquina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhonatancolina.cadastromaquina.model.Usuario;
import br.com.jhonatancolina.cadastromaquina.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController
{
	@Autowired
	public UsuarioService usuarioService;
	
	/** 
	 * Retorna a lista completa de usuarios.<br>
	 * Ver mais em {@link UsuarioService#buscarTodosUsuarios()}.
	 * @return Lista de Usuarios
	 */
  @GetMapping
  List<Usuario> buscarTodos()
  {
      return usuarioService.buscarTodosUsuarios();
  }
  
	/** 
	 * Retorna um usuario de acordo com o id.<br>
	 * Ver mais em {@link UsuarioService#buscarPorId(String)}.
	 * @param id id do usuario na base
	 * @return Classe Usuario
	 */
  @GetMapping("/id/{id}")
	public Usuario buscaUsuarioId(@PathVariable(value = "id") String id)
	{
		return usuarioService.buscarPorId(id);
	}
  
  /** 
	 * Verifica os dados de acesso ao aplicativo.<br>
	 * Ver mais em {@link UsuarioService#realizaLogin(String, String)}.
	 * @param usuario Usuario de acesso ao aplicativo
	 * @param senha Senha de acesso ao aplicativo
	 * @return Classe Usuario
	 */
  @PostMapping("/login")
	public Usuario realizaLogin(@RequestBody Usuario u)
	{
		return usuarioService.realizaLogin(u.getUsuario(), u.getSenha());
	}
  
  /** 
	 * Persiste um usuario na base de dados.<br>
	 * Ver mais em {@link UsuarioService#salvar(Usuario)}.
	 * @param u Classe Usuario
	 */
	@PostMapping
	public void salvarUsuario(@RequestBody Usuario u)
	{
		usuarioService.salvar(u);
	}
}
