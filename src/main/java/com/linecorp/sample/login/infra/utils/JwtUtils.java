/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.sample.login.infra.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.UnsupportedEncodingException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.linecorp.sample.login.infra.line.api.v2.response.Profile;

/**
 * <p>ID TOKEN utilities</p>
 */
@Component
public class JwtUtils {

	@Value("${linecorp.platform.channel.channelSecret}")
    private String channelSecret;

	public boolean verify(String id_token, String nonce){
		try{
            Algorithm algorithm = Algorithm.HMAC256(channelSecret);
            JWT.require(algorithm)
            .withIssuer("https://access.line.me")
            .withClaim("nonce", nonce)
            .build()
            .verify(id_token);
            return true;
        } catch(UnsupportedEncodingException e){
            //UTF-8 encoding not supported
        	return false;
    	} catch (JWTVerificationException e){
            //Invalid signature/claims
            return false;
        }  
	}

	public Profile getProfile(String id_token){
		try{
            DecodedJWT jwt = JWT.decode(id_token);
            return new Profile(jwt.getClaim("name").asString(),jwt.getClaim("sub").asString(),jwt.getClaim("picture").asString());
        }catch(JWTDecodeException e){
        	throw new RuntimeException(e);
        }
	}
}