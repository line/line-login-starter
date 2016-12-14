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
package com.linecorp.sample.login.generic.domain.line.api.v1.response;

/**
 * <p>AccessToken object</p>
 * https://developers.line.me/web-api/integrating-web-login#obtain_access_token<br/>
 */
public final class AccessToken {

    public final String mid;
    public final String access_token;
    public final Integer expires_in;
    public final String refresh_token;

    public AccessToken(String mid, String access_token, Integer expires_in, String refresh_token) {
        this.mid = mid;
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
    }

}
