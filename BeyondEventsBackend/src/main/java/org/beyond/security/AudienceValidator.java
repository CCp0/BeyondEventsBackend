package org.beyond.security;


import java.util.List;
import org.springframework.security.oauth2.core.*;
import org.springframework.security.oauth2.jwt.*;

public class AudienceValidator implements OAuth2TokenValidator<Jwt> {

    private final String expectedAudience;

    public AudienceValidator(String expectedAudience) {
        this.expectedAudience = expectedAudience;
    }

    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {
        List<String> aud = token.getAudience();
        if (aud != null && aud.contains(expectedAudience)) {
            return OAuth2TokenValidatorResult.success();
        }
        OAuth2Error err = new OAuth2Error(
                OAuth2ErrorCodes.INVALID_TOKEN,
                "Invalid audience",
                null
        );
        return OAuth2TokenValidatorResult.failure(err);
    }
}
