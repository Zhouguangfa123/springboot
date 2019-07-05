package com.springboot;

import com.springboot.User;
import com.springboot.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.springboot.UserService
 *
 * @author zhougf
 * @date 2019/7/3
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDAO;

    public List<User> queryUserList() {
        // 调用userDAO中的方法进行查询
        return this.userDAO.queryUserList();
    }

}
