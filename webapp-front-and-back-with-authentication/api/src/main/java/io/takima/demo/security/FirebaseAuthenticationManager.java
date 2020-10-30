package io.takima.demo.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

public class FirebaseAuthenticationManager implements AuthenticationManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirebaseAuthenticationManager.class);

    @Override
    public Authentication authenticate(Authentication authentication) {
        LOGGER.debug("Will attempt to authenticate token " + authentication.getCredentials());
        String idToken = (String) authentication.getCredentials();
        if (idToken == null) {
            LOGGER.debug("No Credentials provided: Anonymous");
            return DummyAuthentication.anonymous();
        }

        FirebaseToken firebaseToken = null;
        try {
            firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            LOGGER.debug("Credentials were checked and are valid!");
            return FirebaseAuthentication.of(idToken, firebaseToken);
        } catch (FirebaseAuthException e) {
            throw new FirebaseAuthenticationException(e);
        }
    }
}
