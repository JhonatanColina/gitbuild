package br.com.jhonatancolina.cadastromaquina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatancolina.cadastromaquina.model.Usuario;
import br.com.jhonatancolina.cadastromaquina.repository.UsuarioRepository;

@Service
public class UsuarioService
{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/** 
	 * Persiste um usuario na base de dados.
	 * Caso exista um usuario com o mesmo id, ele será atualizado com os novos dados<br>
	 * Ver mais em {@link #salvar(Usuario)}
	 * @param u Classe usuario
	 */
	public void salvar(Usuario u)
	{
		Usuario user = usuarioRepository.findById(u.getId());
		if(user!=null) /*se existir um usuario ele atualiza no banco*/
			u.setId(user.getId());
		
		usuarioRepository.save(u);
	}
	
	/** 
	 * Remove um usuario na base de dados.<br>
	 * Ver mais em {@link #apagar(Usuario)}
	 * @param id ID do usuario
	 */
	public void apagar(String id)
	{
		usuarioRepository.delete(id);
	}
	
	/** 
	 * Busca todas os usuarios persistidos na base de dados<br>
	 * Ver mais em {@link #buscarTodosUsuarios()}.
	 * @return Lista de Usuarios
	 */
	public List<Usuario> buscarTodosUsuarios()
	{
		return usuarioRepository.findAll();
	}
	
	/** 
	 * Busca todas os usuarios persistidos na base de dados pelo nome<br>
	 * Ver mais em {@link #buscarUsuariosPorNome()}.
	 * @return Lista de Usuarios
	 */
	public List<Usuario> buscarUsuariosPorNome(String usuario)
	{
		return usuarioRepository.findByUsuarioContaining(usuario);
	}
	
	/** 
	 * Busca o usuario persistido na base de dados pelo id<br>
	 * Ver mais em {@link #buscarPorId(String)}.
	 * @return Classe usuario
	 * @param id ID do usuario
	 */
	public Usuario buscarPorId(String id)
	{
		return usuarioRepository.findById(id);
	}
	
	/** 
	 * Verifica Dados de acesso ao usuario no aplicativo<br>
	 * Ver mais em {@link #buscarPorId(String)}.
	 * @return Classe usuario
	 * @param usuario nome de acesso do usuario
	 * @param senha senha de acesso do usuario
	 */
	public Usuario realizaLogin(String usuario, String senha)
	{
		return usuarioRepository.findByUsuarioAndSenha(usuario, senha);
	}
	/** 
	 * retorna quatidade de usuarios cadastrados<br>
	 * Ver mais em {@link #contagemMaquinas()}.
	 */
	public long contagemUsuario()
	{
		return usuarioRepository.count();
	}
}
