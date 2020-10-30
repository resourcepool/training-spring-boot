package io.takima.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;

import javax.servlet.http.HttpServletRequest;

public class FirebaseAuthenticationConverter implements AuthenticationConverter {

  private static final Logger LOGGER = LoggerFactory.getLogger(FirebaseAuthenticationConverter.class);
  
  public static String FIREBASE_AUTH_HEADER_NAME = "Authorization";
  public static String FIREBASE_AUTH_HEADER_PREFIX = "Bearer ";
  
  private static String decodeHeader(String value) {
    return value.substring(FIREBASE_AUTH_HEADER_PREFIX.length());
  }
  
  public static String encodeToken(String token) {
    return FIREBASE_AUTH_HEADER_PREFIX + token;
  }

  @Override
  public Authentication convert(HttpServletRequest request) {
    String authHeader = request.getHeader(FIREBASE_AUTH_HEADER_NAME);
    if (authHeader == null || authHeader.isEmpty()) {
      LOGGER.debug("There is no token here...");
      return DummyAuthentication.invalid();
    }
    LOGGER.debug("There was a token here...");
    return DummyAuthentication.of(decodeHeader(authHeader));
  }
}
