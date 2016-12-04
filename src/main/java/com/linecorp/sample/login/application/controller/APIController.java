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
package com.linecorp.sample.login.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linecorp.sample.login.infra.line.api.v2.LineAPIService;
import com.linecorp.sample.login.infra.line.api.v2.response.AccessToken;
import com.linecorp.sample.login.infra.line.api.v2.response.Verify;

@RestController
public class APIController {

    @Autowired
    private LineAPIService lineAPIService;

    @RequestMapping("api/refreshToken")
    public AccessToken refreshToken(HttpSession httpSession) {
        final AccessToken token = getAccessToken(httpSession);
        final AccessToken newAccessToken = lineAPIService.refreshToken(token);
        if (newAccessToken != null) {
            setAccessToken(httpSession, newAccessToken);
        }
        return newAccessToken;
    }

    @RequestMapping("api/verify")
    public Verify verify(HttpSession httpSession) {
        final AccessToken token = getAccessToken(httpSession);
        return lineAPIService.verify(token);
    }

    @RequestMapping("api/revoke")
    public void revoke(HttpSession httpSession) {
        final AccessToken token = getAccessToken(httpSession);
        lineAPIService.revoke(token);
    }

    private AccessToken getAccessToken(HttpSession httpSession) {
        return (AccessToken) httpSession.getAttribute(WebController.ACCESS_TOKEN);
    }

    private void setAccessToken(HttpSession httpSession, AccessToken accessToken) {
        httpSession.setAttribute(WebController.ACCESS_TOKEN, accessToken);
    }


}
