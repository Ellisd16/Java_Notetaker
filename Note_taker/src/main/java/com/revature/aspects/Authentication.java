package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebSession;

import com.revature.beans.User;
import com.revature.util.WebSessionAttributes;

import reactor.core.publisher.Mono;

@Aspect
@Component

public class Authentication {

		private static final Logger log = LogManager.getLogger(Authentication.class);
		private User loggedUser;
		private WebSession session;
		
		@Autowired
		public Authentication(User loggedUser, WebSession session) {
			this.loggedUser = loggedUser;
			this.session = session;
		}
		
		@Around("loggedInHook()")
		public Object checkLoggedIn(ProceedingJoinPoint pjp) throws Throwable{
			setSession(pjp);
			if(session == null) {
				return Mono.just(ResponseEntity.status(404).build());
			}
			loggedUser = session.getAttribute(WebSessionAttributes.LOGGED_USER);
			
			if(loggedUser == null) {
				return pjp.proceed();
			}
			return Mono.just(ResponseEntity.status(401).build());
			
		}
		
		private void setSession(ProceedingJoinPoint pjp) {
			for(Object obj : pjp.getArgs()) {
				if(obj instanceof WebSession) {
					session = (WebSession)obj;
					log.debug(session);
				}
			}
		}
		
}
