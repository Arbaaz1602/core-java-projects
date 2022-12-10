package example.jdbc.dao;

import java.util.Collection;

//This is a generic interface meant for handling CRUD operations
public interface IDao<T, K> {
	
	void create(T t);//Adds a new entity
	Collection<T> getAll();//Retrieves all entities
	T getOne(K key);//Retrieves one entity against id
	void update(T t);//update the entity
	void deleteOne(K key); //Deletes the entity against id
	

}
