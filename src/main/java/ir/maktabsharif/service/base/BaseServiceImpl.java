package ir.maktabsharif.service.base;

import ir.maktabsharif.model.BaseEntity;
import ir.maktabsharif.repository.base.BaseRepository;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;

import java.util.List;

public class BaseServiceImpl<T extends BaseEntity, ID , R extends BaseRepositoryImpl<T,ID>>  implements BaseService<T , ID> {
   private final  R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T persist(T t) {
        return repository.persist(t);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T update(T t, ID id) {
        return repository.update(t,id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public ID delete(ID id) {
        return repository.delete(id);
    }
}
