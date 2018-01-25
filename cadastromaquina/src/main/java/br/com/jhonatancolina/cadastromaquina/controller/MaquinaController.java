package br.com.jhonatancolina.cadastromaquina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.jhonatancolina.cadastromaquina.model.Maquina;
import br.com.jhonatancolina.cadastromaquina.service.MaquinaService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/maquina")
public class MaquinaController
{
	@Autowired
	public MaquinaService maquinaService;
	
	/** 
	 * Retorna a lista completa de maquinas.<br>
	 * Ver mais em {@link MaquinaService#buscarTodasMaquinas()}.
	 * @return Lista de maquinas
	 */
  @GetMapping
  List<Maquina> buscarTodos()
  {
      return maquinaService.buscarTodasMaquinas();
  }
  
	/** 
	 * Retorna uma maquina de acordo com o hostname.<br>
	 * Ver mais em {@link MaquinaService#buscarPorId(String)}.
	 * @param id id da maquina na base
	 * @return Classe maquina
	 */
  @GetMapping("/id/{id}")
	public Maquina buscaMaquinaId(@PathVariable(value = "id") String id)
	{
		return maquinaService.buscarPorId(id);
	}
	
	/** 
	 * Retorna uma maquina de acordo com o hostname.<br>
	 * Ver mais em {@link MaquinaService#buscarPorHostname(String)}.
	 * @param hostname hostname da maquina na base
	 * @return Classe maquina 
	 */
	@GetMapping("/hostname/{hostname}")
	public List<Maquina> buscaMaquinaHostname(@PathVariable(value = "hostname") String hostname)
	{
		return maquinaService.buscarPorHostname(hostname);
	}
	
	/** 
	 * Retorna uma maquina de acordo com o ip.<br>
	 * Ver mais em {@link MaquinaService#buscarPorIp(String)}.
	 * @param ip endereco de ip da maquina na base
	 * @return Classe maquina
	 */
	@GetMapping("/ip/{ip:.+}") /*A inserção de :.+ especifica que pontos serão aceitos na passagem de url*/
	public Maquina buscaMaquinaIp(@PathVariable(value = "ip") String ip)
	{
		return maquinaService.buscarPorIp(ip);
	}
	
	/** 
	 * Retorna uma maquina de acordo com o mac.<br>
	 * Ver mais em {@link MaquinaService#buscarPorMac(String)}.
	 * @param mac endereco de mac da maquina na base
	 * @return Classe maquina
	 */
	@GetMapping("/mac/{mac}")
	public Maquina buscaMaquinaMac(@PathVariable(value = "mac") String mac)
	{
		return maquinaService.buscarPorMac(mac);
	}
	
	/** 
	 * Retorna uma lista de maquinas de acordo com o local.<br>
	 * Ver mais em {@link MaquinaService#buscarPorLocal(String)}.
	 * @param local local fisico da maquina na base
	 * @return Lista de maquinas
	 */
	@GetMapping("/local/{local}")
	public List<Maquina> buscaMaquinaLocal(@PathVariable(value = "local") String local)
	{
		return maquinaService.buscarPorLocal(local);
	}
	
	/** 
	 * Persiste uma maquina na base de dados.<br>
	 * Ver mais em {@link MaquinaService#salvar(Maquina)}.
	 * @param m Classe Maquina
	 */
	@PostMapping
	public void salvarMaquina(@RequestBody Maquina m)
	{
		maquinaService.salvar(m);
	}
	
	/** 
	 * Apaga uma maquina na base de dados.<br>
	 * Ver mais em {@link MaquinaService#apagar(String)}.
	 * @param id ID da maquina na base
	 */
	@DeleteMapping("delete/{id}")
	public void apagarMaquina(@PathVariable(value = "id") String id)
	{
		maquinaService.apagar(id);
	}
	/** 
	 * retorna quatidade de maquinas cadastradas.<br>
	 * Ver mais em {@link MaquinaService#contagemMaquinas()}.
	 */
	@GetMapping("/count")
	public long contagemMaquinas()
	{
		return maquinaService.contagemMaquinas();
	}
}
