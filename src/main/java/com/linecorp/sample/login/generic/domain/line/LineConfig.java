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
package com.linecorp.sample.login.generic.domain.line;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <p>LINE Configuration</p>
 */
@Configuration
public class LineConfig {

    @Value("${linecorp.platform.channel.channelId}")
    private String channelId;
    @Value("${linecorp.platform.channel.channelSecret}")
    private String channelSecret;
    @Value("${linecorp.platform.channel.redirectUrl}")
    private String redirectUrl;

    public String getChannelId(){
        return channelId;
    }

    public String getChannelSecret(){
        return channelSecret;
    }

    public String getRedirectUrl(){
        return redirectUrl;
    }

    public String getLineWebLoginUrl(String state) {
    	final String encodedRedirectUrl;
        try {
            encodedRedirectUrl = URLEncoder.encode(getRedirectUrl(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    			
        return "https://access.line.me/dialog/oauth/weblogin?response_type=code"
                + "&client_id=" + channelId
                + "&redirect_uri=" + encodedRedirectUrl
                + "&state=" + state;
    }
}
