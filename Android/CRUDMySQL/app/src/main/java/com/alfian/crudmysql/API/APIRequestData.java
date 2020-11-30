package com.alfian.crudmysql.API;

import com.alfian.crudmysql.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("read")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("create")
    Call<ResponseModel> ardCreateData(
            @Field("inputNim") String nim,
            @Field("inputNama") String nama,
            @Field("inputProdi") String prodi
    );

    @FormUrlEncoded
    @POST("delete")
    Call<ResponseModel> ardDeleteData(
            @Field("inputId") int id
    );

    @FormUrlEncoded
    @POST("update")
    Call<ResponseModel> ardUpdateData(
            @Field("inputId") int id,
            @Field("inputNim") String nim,
            @Field("inputNama") String nama,
            @Field("inputProdi") String prodi
    );
}
