package ir.maktabsharif.service;

import ir.maktabsharif.model.Users;
import ir.maktabsharif.repository.UsersRepositoryImpl;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;
import ir.maktabsharif.service.base.BaseServiceImpl;

public class UserServiceImpl extends BaseServiceImpl<Users,Long, UsersRepositoryImpl> implements UserService {

    public UserServiceImpl(UsersRepositoryImpl repository) {
        super(repository);
    }
}
