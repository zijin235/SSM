package ioc_annotation.dao.impl;

import ioc_annotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser(){
        System.out.println("success!");
    }
}
