package tda.ms_segurity.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.classic.Logger;

public class AuthController {
private Logger logger = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	private IAuthService authService;

	@Autowired
	private UtilsProperties prop;
	

}

