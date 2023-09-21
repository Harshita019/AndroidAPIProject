package com.example.myapplication;

public class ApiUtils {
    private ApiUtils() {}
    public static final String BASE_URL = "http://127.0.0.1:80/api/v1/employee/";
    public static ApiService getAPIService() {
        return retrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
