package fr.mable.classement.joueurs.data.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
/**
 * Classe DAO générique
 * @author mable
 * @param <T>
 */
public abstract class AbstractDao<T>  implements IDao<T>{

    /**
     * Entité
     */
    protected Class<T> entityClass;

    /**
     *
     * @param entityClass
     */
    public AbstractDao(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

    /**
     *
     * @return
     */
    protected abstract EntityManager getEntityManager();

    /**
     *
     * @param entity
     */
    @Override
  public void create(T entity) {
    getEntityManager().persist(entity);
  }

    /**
     *
     * @param entity
     */
    @Override
  public void edit(T entity) {
    getEntityManager().merge(entity);
  }

    /**
     *
     * @param entity
     */
    @Override
  public void remove(T entity) {
    getEntityManager().remove(getEntityManager().merge(entity));
  }
  
    /**
     *
     * @param id
     * @return
     */
    @Override
  public T find(Object id) {
    return getEntityManager().find(entityClass, id);
  }

    /**
     *
     * @return
     */
    @Override
  public List<T> findAll() {
    CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

    /**
     *
     * @param range
     * @return
     */
    @Override
  public List<T> findRange(int[] range) {
    CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    q.setMaxResults(range[1] - range[0]);
    q.setFirstResult(range[0]);
    return q.getResultList();
  }

    /**
     *
     * @return
     */
    @Override
  public int count() {
    CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    Root<T> rt = cq.from(entityClass);
    cq.select(getEntityManager().getCriteriaBuilder().count(rt));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    return ((Long) q.getSingleResult()).intValue();
  }
}