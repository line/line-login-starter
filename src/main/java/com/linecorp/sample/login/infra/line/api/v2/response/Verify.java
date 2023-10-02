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

public final class Verify {

    public final String scope;
    public final String client_id;
    public final Integer expires_in;

    public Verify(String scope, String client_id, Integer expires_in) {
        this.scope = scope;
        this.client_id = client_id;
        this.expires_in = expires_in;
    }

}
