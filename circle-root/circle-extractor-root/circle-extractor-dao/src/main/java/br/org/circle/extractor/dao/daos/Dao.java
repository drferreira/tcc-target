package br.org.circle.extractor.dao.daos;

public interface Dao {
	
	public void save(Object entity);
	
	public <T> T findbyKey(Class<T> clazz, Object pk);
	
	public void remove(Object entity);
	
	public void update(Object entity);

}
