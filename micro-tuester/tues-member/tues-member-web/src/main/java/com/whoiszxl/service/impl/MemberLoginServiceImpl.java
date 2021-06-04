package com.whoiszxl.service.impl;

import com.whoiszxl.constants.RedisPrefixConstants;
import com.whoiszxl.entity.params.LoginParam;
import com.whoiszxl.entity.vo.LoginMemberVO;
import com.whoiszxl.exception.ExceptionCatcher;
import com.whoiszxl.feign.JwtToken;
import com.whoiszxl.feign.OAuth2FeignClient;
import com.whoiszxl.service.MemberLoginService;
import com.whoiszxl.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MemberLoginServiceImpl implements MemberLoginService {

    @Autowired
    private OAuth2FeignClient oAuth2FeignClient;

    @Value("${basic.token:Basic dHVlc3Rlcjp0dWVzdGVy}")
    private String basicToken;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public LoginMemberVO login(LoginParam loginParam) {
        LoginMemberVO loginMemberVO = null;

        //调用远程auth服务获取token
        ResponseEntity<JwtToken> tokenResponseEntity = oAuth2FeignClient.getToken("password", loginParam.getUsername(), loginParam.getPassword(), "MEMBER_TYPE", basicToken);
        if (tokenResponseEntity.getStatusCode() == HttpStatus.OK) {
            JwtToken jwtToken = tokenResponseEntity.getBody();
            if(jwtToken == null) {
                ExceptionCatcher.catchAuthFailEx();
            }
            //构建返回结果
            loginMemberVO = new LoginMemberVO(loginParam.getUsername(), jwtToken.getExpiresIn(), jwtToken.getTokenType() + " " + jwtToken.getAccessToken(), jwtToken.getRefreshToken());

            //保存token到redis
            redisUtils.setEx(RedisPrefixConstants.JWT_MEMBER_PREFIX + jwtToken.getAccessToken(), "", jwtToken.getExpiresIn(), TimeUnit.SECONDS);
        }
        return loginMemberVO;
    }
}
