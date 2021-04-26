package com.linecorp.sample.login.infra.pkce;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Proof Key for Code Exchange. <br></br>
 * for more details, please refer to: <a href="https://oauth.net/2/pkce/">RFC 7636: Proof Key for Code Exchange</a>
 */
public class PKCECode {
    private static final int LENGTH_VERIFIER = 64;

    private final String verifier;
    private final String challenge;

    private PKCECode(final String verifier) {
        this.verifier = verifier;
        challenge = generateChallenge(verifier);
    }

    public static PKCECode newCode() {
        final String verifier = generateVerifier();
        return new PKCECode(verifier);
    }

    private static String generateVerifier() {
        byte[] bytes = new byte[LENGTH_VERIFIER];
        (new SecureRandom()).nextBytes(bytes);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        return token;
    }

    private static String generateChallenge(final String verifier) {
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(verifier.getBytes());
            final byte[] hashBytes = md.digest();
            final String toBe = Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes);
            return toBe;
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String getVerifier() {
        return verifier;
    }

    public String getChallenge() {
        return challenge;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (!(o instanceof PKCECode)) { return false; }

        final PKCECode pkceCode = (PKCECode) o;

        if (!verifier.equals(pkceCode.verifier)) { return false; }
        return challenge.equals(pkceCode.challenge);
    }

    @Override
    public int hashCode() {
        int result = verifier.hashCode();
        result = 31 * result + challenge.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PKCECode{" +
               "verifier='" + verifier + '\'' +
               ", challenge='" + challenge + '\'' +
               '}';
    }
}
