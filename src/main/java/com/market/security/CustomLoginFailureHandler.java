package com.market.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.domain.User;
import com.market.entity.ResponseObject;
import com.market.repo.UserRepository;
import com.market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Service
@Transactional
public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private UserService userService;



    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
       // exception.addSuppressed(new LoginException("Your account has been unlocked. Please try to login again."));
       // this.onAuthenticationFailure(request,response,exception);
//        String username = request.getParameter("username");
//        User user = userRepository.findByUsername(username);
//
//        log.info("user information {}",user.toString());

        Map<String,String> locks = new HashMap<>();
        locks.put("lock","Your account has been unlocked. Please try to login again.");
        log.info("Your account has been unlocked. Please try to login again.");
        response.setContentType(APPLICATION_JSON_VALUE);
      //  new ObjectMapper().writeValue(response.getOutputStream(),tokens);
       // ResponseEntity<T> body = ResponseEntity.ok().body(new ObjectMapper().writeValue(response.getOutputStream(), tokens));
        new ObjectMapper().writeValue(response.getOutputStream(),new ResponseObject("FALSE", "Your account has been unlocked. Please try to login again.", locks));
    }
}
