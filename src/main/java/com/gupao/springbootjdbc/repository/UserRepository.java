package com.gupao.springbootjdbc.repository;

import com.gupao.springbootjdbc.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;


/**
 *
 * 用户的仓储 (SQL、或 nosql、内存型)
 *
 * 用户的仓储
 */
@Repository
public class UserRepository {

    //把数据源注入进来
    private final DataSource datasource;

    @Autowired
    public UserRepository(DataSource datasource){
        this.datasource = datasource;
    }


    public boolean save(MyUser user){

        System.out.println("MyUser save" + user);
        return true;

    }


    public Collection<SecurityProperties.User> findAll(){
        return Collections.emptyList();
    }

}
