package br.com.jhonatancolina.cadastromaquina.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Maquina
{
	@Id
	private String id;
	private String hostname;
	private String mac;
	private String ip;
	private String local;
	private String observacoes;
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getHostname()
	{
		return hostname;
	}
	public void setHostname(String hostname)
	{
		this.hostname = hostname;
	}
	public String getMac()
	{
		return mac;
	}
	public void setMac(String mac)
	{
		this.mac = mac;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	public String getLocal()
	{
		return local;
	}
	public void setLocal(String local)
	{
		this.local = local;
	}
	public String getObservacoes()
	{
		return observacoes;
	}
	public void setObservacoes(String observacoes)
	{
		this.observacoes = observacoes;
	}
	
}
