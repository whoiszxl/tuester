package com.whoiszxl.feign;

import com.whoiszxl.config.feign.OAuth2FeignConfig;
import com.whoiszxl.dto.MemberFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "tues-member-web", contextId = "memberFeign", configuration = OAuth2FeignConfig.class, path = "/member")
public interface MemberFeign {

    @PostMapping("/info")
    MemberFeignDTO memberInfo();

}