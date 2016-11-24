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
package com.linecorp.sample.login.generic.domain.line.api.v1;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.linecorp.sample.login.generic.domain.line.LineConfig;
import com.linecorp.sample.login.generic.domain.line.api.v1.response.AccessToken;
import com.linecorp.sample.login.infra.http.Client;

import retrofit2.Call;

/**
 * <p>LINE v1 API Access</p>
 */
@Component
public class LineAPIService {

    private static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";

    @Autowired
    LineConfig lineConfig;

    /**
     * <p>Get AccessToken</p>
     */
    public AccessToken accessToken(String code) {
        return getClient(t -> t.accessToken(
                GRANT_TYPE_AUTHORIZATION_CODE,
                lineConfig.getChannelId(),
                lineConfig.getChannelSecret(),
                lineConfig.getRedirectUrl(),
                code));
    }

    private <R> R getClient(final Function<LineAPI, Call<R>> function) {
        return Client.getClient("https://api.line.me/", LineAPI.class, function);
    }
}
