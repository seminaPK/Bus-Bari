package com.example.hackatonmhoo14;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;

public interface RoutingService {
	
		  @GET("/mhoo")
		  List<GeoJson> listRepos(@Query("lat") Double lat,@Query("lng") Double lng, @Query("idFermata") String idFermata );
}
