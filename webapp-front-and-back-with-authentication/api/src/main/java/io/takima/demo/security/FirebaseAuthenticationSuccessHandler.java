package io.takima.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static io.takima.demo.security.FirebaseAuthenticationConverter.FIREBASE_AUTH_HEADER_NAME;

public class FirebaseAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
  
  /**
   * A successful authentication object us used to create a JWT object and
   * added in the authorization header of the current WebExchange.
   * This is only done when authentication is not anonymous!
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
    if (authentication instanceof FirebaseAuthentication) {
      httpServletResponse.setHeader(FIREBASE_AUTH_HEADER_NAME, FirebaseAuthenticationConverter.encodeToken(authentication.getCredentials().toString()));
    }
  }
}
