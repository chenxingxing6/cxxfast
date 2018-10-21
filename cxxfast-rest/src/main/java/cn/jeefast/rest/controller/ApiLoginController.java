package cn.jeefast.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jeefast.common.utils.R;
import cn.jeefast.common.validator.Assert;
import cn.jeefast.rest.annotation.AuthIgnore;
import cn.jeefast.rest.service.TbTokenService;
import cn.jeefast.rest.service.TbUserService;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

/**
 * API登录授权
 *
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017-10-23 15:31
 */
@RestController
@RequestMapping("/api")
public class ApiLoginController {
    @Autowired
    private TbUserService userService;
    @Autowired
    private TbTokenService tokenService;

    /**
     * 登录
     */
    @AuthIgnore
    @PostMapping("login")
    @ApiOperation(value="登录", notes="登录")
    public R login(String mobile, String password){
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        //用户登录
        long userId = userService.login(mobile, password);

        //生成token
        Map<String, Object> map = tokenService.createToken(userId);

        return R.ok(map);
    }

}
