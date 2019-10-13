package br.com.techsow.sherlock.model.interfaces.bo;

public interface IBaseBO<Entity> {
	public String add(Entity obj); 
	public Entity getById(int id);
	public int kill(int id);
	public String updateNome(Entity obj, String nomeNovo);
}