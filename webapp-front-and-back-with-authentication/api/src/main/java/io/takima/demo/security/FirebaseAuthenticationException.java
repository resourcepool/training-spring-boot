package io.takima.demo.security;

import org.springframework.security.core.AuthenticationException;

public class FirebaseAuthenticationException extends AuthenticationException {
  public FirebaseAuthenticationException(Throwable t) {
    super("An error occurend during authentication", t);
  }
}
