package com.example.chemistrify.interfaces;

import com.example.chemistrify.models.Element;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ElementsServices {
    @GET("/")
    void getElements(Callback<List<Element>> callback);
}
