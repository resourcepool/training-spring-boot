package io.takima.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.LinkedList;

public class DummyAuthentication implements Authentication {

  private static final Logger LOGGER = LoggerFactory.getLogger(DummyAuthentication.class);
  private final String credentials;
  private final boolean authenticated;
  private final LinkedList<GrantedAuthority> authorities;

  private DummyAuthentication(String token, boolean authenticated) {
    this.credentials = token;
    this.authenticated = authenticated;
    this.authorities = new LinkedList<>();
    if (authenticated) {
      this.authorities.add((GrantedAuthority) () -> "role_anonymous");
    }
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getCredentials() {
    return credentials;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    LOGGER.warn("setAuthenticated should not be called");
    throw new UnsupportedOperationException();
  }

  @Override
  public String getName() {
    return null;
  }

  static DummyAuthentication invalid() {
    return new DummyAuthentication(null, false);
  }

  static DummyAuthentication anonymous() {
    return new DummyAuthentication(null, true);
  }

  static DummyAuthentication of(String idToken) {
    return new DummyAuthentication(idToken, true);
  }
}
