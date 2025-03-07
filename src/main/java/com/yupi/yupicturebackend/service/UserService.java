package com.yupi.yupicturebackend.service;

import com.yupi.yupicturebackend.common.BaseResponse;
import com.yupi.yupicturebackend.model.dto.UserRegisterRequest;
import com.yupi.yupicturebackend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupicturebackend.model.vo.LoginUserVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 24826
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-03-07 00:27:46
*/
public interface UserService extends IService<User> {

    long userRegister(String userAccount, String userPassword, String checkPassword);

    String getEncryptPassword(String userPassword);

    User getLoginUser(HttpServletRequest request);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户注销
     */
    boolean userLogout(HttpServletRequest request);

}
