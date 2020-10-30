package io.takima.demo.security;

import com.google.firebase.auth.FirebaseToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FirebaseAuthentication implements Authentication {
  private static final Logger LOGGER = LoggerFactory.getLogger(FirebaseAuthentication.class);
  private final String userId;
  private final List<GrantedAuthority> authorities;
  private final FirebaseToken token;
  private final String credentials;
  private boolean authenticated;

  private FirebaseAuthentication(String idToken, FirebaseToken token) {
    if (token == null) {
      LOGGER.warn("FirebaseAuthentication token should not be null");
      throw new IllegalStateException();
    }
    this.userId = token.getUid();
    this.authorities = new LinkedList<>();
    this.token = token;
    this.credentials = idToken;
    // Si vous avez envie de développer des rôles
    token.getClaims().forEach((k, v) -> {
      if (k.startsWith("role_") && ((boolean) v)) {
        authorities.add((GrantedAuthority) () -> k);
      }
    });
    authenticated = true;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getCredentials() {
    return credentials;
  }

  @Override
  public Map<String, Object> getDetails() {
    return token.getClaims();
  }

  @Override
  public FirebaseToken getPrincipal() {
    return token;
  }

  public String getUserId() {
    return userId;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    this.authenticated = isAuthenticated;
  }

  @Override
  public String getName() {
    return token.getName();
  }

  public static FirebaseAuthentication of(String idToken, FirebaseToken token) {
    return new FirebaseAuthentication(idToken, token);
  }
}
