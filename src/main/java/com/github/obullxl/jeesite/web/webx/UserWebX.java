/**
 * Author: obullxl@gmail.com
 * Copyright (c) 2004-2013 All Rights Reserved.
 */
package com.github.obullxl.jeesite.web.webx;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.obullxl.jeesite.utils.UserConverter;
import com.github.obullxl.lang.user.UserContextHolder;
import com.github.obullxl.lang.webx.WebX;
import com.github.obullxl.model.cfg.CfgModel;
import com.github.obullxl.model.cfg.CfgModelEnum;
import com.github.obullxl.model.cfg.CfgUtils;
import com.github.obullxl.model.user.UserModel;
import com.github.obullxl.model.user.service.UserService;
import com.google.common.collect.Sets;

/**
 * 用户X工具
 * 
 * @author obullxl@gmail.com
 * @version $Id: UserWebX.java, V1.0.1 2013年12月9日 下午7:14:17 $
 */
@Component("userWebX")
public class UserWebX implements WebX {

    /** 用户模型服务 */
    @Autowired
    private UserService userService;

    /**
     * 根据编号获取用户信息
     */
    public UserModel findByNo(String no) {
        return this.userService.findByNo(no);
    }

    /**
     * 判断用户是否为管理员
     */
    public boolean isAdmin(String no) {
        return isAdmin(this.findByNo(no));
    }

    /**
     * 判断用户是否为管理员
     */
    public static boolean isAdmin(UserModel user) {
        return user.getMngtEnum().is();
    }

    /**
     * 获取登录用户
     */
    public UserModel findSessionUser() {
        UserModel user = new UserModel();
        UserConverter.convert(user, UserContextHolder.get());

        return user;
    }

    /**
     * 获取密保问题列表
     */
    public Set<String> findPwdQuestions() {
        // 系统参数
        CfgModel cfg = CfgUtils.find(CfgModelEnum.PARAM.code(), "passwd_question_params");
        if (cfg == null || StringUtils.isBlank(cfg.getValue())) {
            return this.findPwdDefaultQuestions();
        }

        // 问题参数
        Set<String> questions = Sets.newConcurrentHashSet();
        String value = StringUtils.trim(cfg.getValue());
        for (String param : StringUtils.split(value, ",")) {
            CfgModel tmp = CfgUtils.find(CfgModelEnum.PARAM.code(), param);
            if (tmp != null && StringUtils.isNotBlank(tmp.getValue())) {
                String[] names = StringUtils.split(tmp.getValue(), ",");
                for (String name : names) {
                    questions.add(name);
                }
            }
        }

        return questions;
    }

    /**
     * 获取默认密保问题列表
     */
    private Set<String> findPwdDefaultQuestions() {
        Set<String> set = Sets.newConcurrentHashSet();

        set.add("您父亲的出生地是哪里？");
        set.add("您出生的医院是哪间？");
        set.add("您成长的街道叫什么路？");
        set.add("您就读的第一所学校名称是？");
        set.add("您的初恋情人叫什么名字？");
        set.add("您就职的第一间公司叫什么名称？");
        set.add("您的双亲姓名叫什么？");
        set.add("您母亲的生日是哪一天？");
        set.add("您父亲的生日是哪一天？");
        set.add("您的父亲的姓名是？");
        set.add("您的母亲的姓名是？");
        set.add("您的配偶的姓名是？");
        set.add("您最后就读的学校名是？");

        return set;
    }

}
