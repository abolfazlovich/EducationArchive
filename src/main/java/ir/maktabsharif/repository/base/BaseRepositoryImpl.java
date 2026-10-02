package ir.maktabsharif.repository.base;

import ir.maktabsharif.model.BaseEntity;
import ir.maktabsharif.util.JpaUtil;

import java.util.List;

public abstract class BaseRepositoryImpl<T extends BaseEntity, ID> implements BaseRepository<T, ID> {
    private final Class<T> entityType;

    public BaseRepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    protected abstract ID getId(T t);

    protected abstract void copyProperties(T source, T target);

    @Override
    public T persist(T t) {
        return JpaUtil.inTXResult(
                em -> {
                    em.persist(t);
                    System.out.println(t + " create successfully");
                    return t;
                }
        );
    }

    @Override
    public T findById(ID id) {
        return JpaUtil.inTXResult(
                em -> {
                    return em.find(entityType, id);
                }
        );
    }

    @Override
    public T update(T t, ID id) {
        return JpaUtil.inTXResult(
                em -> {
                    try{
                        ID id1 = getId(t);
                        T managed = em.find(entityType, id1);
                        copyProperties(t, managed);
                        System.out.println(t + " update successfully");
                        return t;
                    } catch (RuntimeException e) {
                        throw new RuntimeException("ID Is Wrong");
                    }

                }
        );
    }

    @Override
    public List<T> findAll() {
        return JpaUtil.inTXResult(
                em ->{
                   return em.createQuery("select e from "+ entityType.getSimpleName() + " e" ,entityType).getResultList();
                }
        );
    }

    @Override
    public ID delete(ID id) {
        return JpaUtil.inTXResult(
                em ->{
                    try {
                        T entity = em.find(entityType,id);
                        em.remove(entity);
                        System.out.println("Entity Removed Successfully");
                        return id;
                    }
                    catch (RuntimeException e){
                        throw new RuntimeException("ID is wrong");
                    }
                }
        );
    }
}
