/*
 * Copyright 2016 LY Corporation
 *
 * LY Corporation licenses this file to you under the Apache License,
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
package com.linecorp.sample.login.infra.line.api.v2.response;

public final class IdToken {
    public final String iss;
    public final String sub;
    public final String aud;
    public final Long exp;
    public final Long iat;
    public final String nonce;
    public final String name;
    public final String picture;

    public IdToken(String iss, String sub, String aud, Long exp, Long iat, String nonce, String name, String picture) {
        this.iss = iss;
        this.sub = sub;
        this.aud = aud;
        this.exp = exp;
        this.iat = iat;
        this.nonce = nonce;
        this.name = name;
        this.picture = picture;
    };

}

