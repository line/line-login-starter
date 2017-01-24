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
package com.linecorp.sample.login.infra.line.api.v2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.linecorp.sample.login.infra.http.Client;
import com.linecorp.sample.login.infra.line.api.v2.response.AccessToken;
import com.linecorp.sample.login.infra.line.api.v2.response.Profile;
import com.linecorp.sample.login.infra.line.api.v2.response.Verify;

import retrofit2.Call;

/**
 * <p>LINE v2 API Access</p>
 */
@Component
public class LineAPIService {

    private static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    private static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    @Value("${linecorp.platform.channel.channelId}")
    private String channelId;
    @Value("${linecorp.platform.channel.channelSecret}")
    private String channelSecret;
    @Value("${linecorp.platform.channel.callbackUri}")
    private String callbackUri;

    public AccessToken accessToken(String code) {
        return getClient(t -> t.accessToken(
                GRANT_TYPE_AUTHORIZATION_CODE,
                channelId,
                channelSecret,
                callbackUri,
                code));
    }

    public AccessToken refreshToken(final AccessToken accessToken) {
        return getClient(t -> t.refreshToken(
                GRANT_TYPE_REFRESH_TOKEN,
                accessToken.refresh_token,
                channelId,
                channelSecret));
    }

    public Verify verify(final AccessToken accessToken) {
        return getClient(t -> t.verify(accessToken.access_token));
    }

    public void revoke(final AccessToken accessToken) {
        getClient(t -> t.revoke(accessToken.refresh_token));
    }

    public Profile profile(final AccessToken accessToken) {
        return getClient(t -> t.profile(addBearer(accessToken)));
    }


    public String getLineWebLoginUrl(String state) {
        final String encodedCallbackUri;
        try {
            encodedCallbackUri = URLEncoder.encode(callbackUri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return "https://access.line.me/dialog/oauth/weblogin?response_type=code"
                + "&client_id=" + channelId
                + "&redirect_uri=" + encodedCallbackUri
                + "&state=" + state;
    }


    private <R> R getClient(final Function<LineAPI, Call<R>> function) {
        return Client.getClient("https://api.line.me/", LineAPI.class, function);
    }

    private String addBearer(final AccessToken accessToken) {
        return "Bearer " + accessToken.access_token;
    }
}
