package br.com.jhonatancolina.cadastromaquina.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.jhonatancolina.cadastromaquina.model.Maquina;

@Repository
public interface MaquinaRepository extends MongoRepository<Maquina, String>
{
	Maquina findById(String id);
	Maquina findByIp(String ip);
	Maquina findByHostname(String hostname);
	List<Maquina> findByHostnameContainingIgnoreCase(String hostname);
	Maquina findByMac(String mac);
	List<Maquina> findBylocal(String local);
}
