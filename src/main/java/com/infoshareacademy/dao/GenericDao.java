package com.infoshareacademy.dao;

import com.infoshareacademy.model.ModelInterface;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class GenericDao<Entity extends ModelInterface<Id>, Id> {
    @PersistenceContext
    EntityManager entityManager;
    Class<Entity> entityClass;

    public GenericDao(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    public Id save(Entity o) {
        entityManager.persist(o);
        return o.getId();
    }

    public Entity update(Entity o) {
        return entityManager.merge(o);
    }

    public void delete(Id id) {
        final Entity t = findById(id);
        if (t != null) {
            entityManager.remove(t);
        }
    }

    public Entity findById(Id id) {
        return entityManager.find(entityClass, id);
    }

    public List<Entity> findAll() {
        final TypedQuery<Entity> typedQuery = entityManager
                .createQuery("SELECT s FROM " + entityClass.getSimpleName() + " s ", entityClass);

        return typedQuery.getResultList();
    }
}
