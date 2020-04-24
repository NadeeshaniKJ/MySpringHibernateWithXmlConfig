package com.kanchi.service;

import com.kanchi.dao.UserDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDaoImpl userDao;

    @Autowired
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public int getUserCount() {
        logger.info("getUserCount="+ userDao.getUserCount());
        return  userDao.getUserCount();
//        return userDao.getUserCount(); // must use hibernate.query.Query package
    }
}
