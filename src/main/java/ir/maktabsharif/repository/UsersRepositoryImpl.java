package ir.maktabsharif.repository;

import ir.maktabsharif.model.Users;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;

import java.util.Optional;

public class UsersRepositoryImpl extends BaseRepositoryImpl<Users, Long> implements UsersRepository {
    public UsersRepositoryImpl() {
        super(Users.class);
    }

    @Override
    protected Long getId(Users users) {
        return users.getId();
    }

    @Override
    protected void copyProperties(Users source, Users target) {
        if (Optional.ofNullable(source.getUsername()).isPresent()) {
            target.setUsername(source.getUsername());
        }
        if (Optional.ofNullable(source.getPassword()).isPresent()) {
            target.setPassword(source.getPassword());
        }
        if (Optional.ofNullable(source.getEmail()).isPresent()) {
            target.setEmail(source.getEmail());
        }
        if (Optional.ofNullable(source.getRole()).isPresent()) {
            target.setRole(source.getRole());
        }
    }
}
