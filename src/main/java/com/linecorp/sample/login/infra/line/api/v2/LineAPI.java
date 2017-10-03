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

import com.linecorp.sample.login.infra.line.api.v2.response.AccessToken;
import com.linecorp.sample.login.infra.line.api.v2.response.Profile;
import com.linecorp.sample.login.infra.line.api.v2.response.Verify;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * <p>LINE v2 API interface</p>
 */
public interface LineAPI {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("oauth2/v2.1/token")
    Call<AccessToken> accessToken(
            @Field("grant_type") String grant_type,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret,
            @Field("redirect_uri") String callback_url,
            @Field("code") String code);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("oauth2/v2.1/token")
    Call<AccessToken> refreshToken(
            @Field("grant_type") String grant_type,
            @Field("refresh_token") String refresh_token,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET("oauth2/v2.1/verify")
    Call<Verify> verify(
            @Query("access_token") String access_token);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("oauth2/v2.1/revoke")
    Call<Void> revoke(
            @Field("access_token") String access_token,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret);
    
    @GET("v2/profile")
    Call<Profile> profile(@Header("Authorization") String accessToken);

}

