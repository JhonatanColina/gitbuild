package br.com.jhonatancolina.cadastromaquina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatancolina.cadastromaquina.model.Maquina;
import br.com.jhonatancolina.cadastromaquina.repository.MaquinaRepository;

@Service
public class MaquinaService
{
	@Autowired
	MaquinaRepository maquinaRepository;
	
	/** 
	 * Persiste uma maquina na base de dados.
	 * Caso exista um hostname com o mesmo nome, ele será atualizado com os novos dados<br>
	 * Ver mais em {@link #salvar(Maquina)}
	 * @param m Classe maquina
	 */
	public void salvar(Maquina m)
	{
		Maquina maquina = maquinaRepository.findByHostname(m.getHostname());
		if(maquina !=null) /*se existir um hostname ele atualiza no banco*/
			m.setId(maquina.getId());
		
		maquinaRepository.save(m);
	}
	
	/** 
	 * Busca todas as maquinas persistidas na base de dados<br>
	 * Ver mais em {@link #buscarTodasMaquinas()}.
	 * @return Lista de maquinas
	 */
	public List<Maquina> buscarTodasMaquinas()
	{
		return maquinaRepository.findAll();
	}
	
	/** 
	 * Busca maquinas pelo ID <br>
	 * Ver mais em {@link #buscarPorId(String)}.
	 * @return Maquina
	 * @param id ID da maquina
	 */
	public Maquina buscarPorId(String id)
  {
      return maquinaRepository.findById(id);
  }
	
	/** 
	 * Busca maquinas pelo Hostname<br>
	 * Ver mais em {@link #buscarPorHostname(String)}. 
	 * @return Maquina
	 * @param hostname hostname da maquina
	 */
	public Maquina buscarPorHostname(String hostname)
  {
      return maquinaRepository.findByHostname(hostname);
  } 
	
	/** 
	 * Busca maquinas pelo IP <br>
	 * Ver mais em {@link #buscarPorIp(String)}. 
	 * @return Maquina
	 * @param ip IP da maquina
	 */
	public Maquina buscarPorIp(String ip)
  {
      return maquinaRepository.findByIp(ip);
  } 
	
	/** 
	 * Busca maquinas pelo Mac<br>
	 * Ver mais em {@link #buscarPorMac(String)}. 
	 * @return Maquina
	 * @param mac Mac da maquina
	 */
	public Maquina buscarPorMac(String mac)
  {
      return maquinaRepository.findByMac(mac);
  }
	
	/** 
	 * Busca uma lista de maquinas pelo local<br>
	 * Ver mais em {@link #buscarPorLocal(String)}. 
	 * @return Lista de Maquinas
	 * @param local Local aonde a maquina esta alocada
	 */	
	public List<Maquina> buscarPorLocal(String local)
  {
      return maquinaRepository.findBylocal(local);
  } 
	
	/** 
	 * Apaga uma maquina pelo ID<br>
	 * Ver mais em {@link #apagar(String)}.
	 * @param id ID da maquina
	 */	
	public void apagar(String id)
	{
		Maquina m = maquinaRepository.findById(id);
		if(m != null)
			maquinaRepository.delete(m);
	}
	
	/** 
	 * Apaga todas as maquinas da base<br>
	 * Ver mais em {@link #apagarTodos()}.
	 */	
	public void apagarTodos()
	{
		maquinaRepository.deleteAll();
	}
}
