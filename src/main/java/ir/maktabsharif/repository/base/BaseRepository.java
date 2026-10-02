package ir.maktabsharif.repository.base;

import ir.maktabsharif.model.BaseEntity;

import java.util.List;

public interface BaseRepository <T extends BaseEntity,ID> {
    T persist(T t);
    T findById(ID id);
    T update(T t ,ID id);
    List<T> findAll();
    ID delete (ID id);

}
