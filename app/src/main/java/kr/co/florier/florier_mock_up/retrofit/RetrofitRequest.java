package kr.co.florier.florier_mock_up.retrofit;

import java.util.ArrayList;


import kr.co.florier.florier_mock_up.Bean.flower_test;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018-03-21.
 */

public interface RetrofitRequest {
    //@GET("json_list")
   // Call<ArrayList<Board_Item>> getItemList();

    @GET("test")
    Call<ArrayList<flower_test>> test(@Query("id") int id , @Query("name") String name);

}
