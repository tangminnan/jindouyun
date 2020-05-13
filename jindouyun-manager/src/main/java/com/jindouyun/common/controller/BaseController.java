package com.jindouyun.common.controller;

import org.springframework.stereotype.Controller;

import com.jindouyun.common.utils.ShiroUtils;
import com.jindouyun.system.domain.UserDO;
import com.jindouyun.system.domain.UserToken;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}