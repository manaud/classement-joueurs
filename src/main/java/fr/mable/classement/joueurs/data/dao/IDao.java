package fr.mable.classement.joueurs.data.dao;

import java.util.List;

/**
 *
 * @author mable
 * @param <T>
 */
public interface IDao<T> {

    /**
     *
     * @param entity
     */
    void create(T entity);

    /**
     *
     * @param entity
     */
    void edit(T entity);

    /**
     *
     * @param entity
     */
    void remove(T entity);
  
    /**
     *
     */
    void removeAll();

    /**
     *
     * @param id
     * @return
     */
    T find(Object id);

    /**
     *
     * @return
     */
    List<T> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<T> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
}

