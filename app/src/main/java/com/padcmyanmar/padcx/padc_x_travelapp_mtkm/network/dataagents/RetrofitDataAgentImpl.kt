//package com.padcmyanmar.padcx.padc_x_travelapp_mtkm.network.dataagents
//
//
//import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.data.vos.TourVO
//import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.network.TourApi
//import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.network.responses.GetAllTourResponses
//import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.utils.BASE_URL
//import com.padcmyanmar.padcx.padc_x_travelapp_mtkm.utils.EM_NO_INTERNET_CONNECTION
//import okhttp3.OkHttpClient
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//object RetrofitDataAgentImpl : TourDataAgent {
//    private var mTourApi: TourApi? = null
//
//    init {
//        val mOkHttpClient = OkHttpClient.Builder()
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .readTimeout(15, TimeUnit.SECONDS)
//            .writeTimeout(15, TimeUnit.SECONDS)
//            .build()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(mOkHttpClient)
//            .build()
//
//        mTourApi = retrofit.create(TourApi::class.java)
//    }
//
//    override fun getAllTours(
//
//        onSuccess: (List<TourVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//
//
//        val getAllToursCall =
//            mTourApi?.getAllTours()
//
//        getAllToursCall?.enqueue(object : Callback<GetAllTourResponses> {
//            override fun onFailure(call: Call<GetAllTourResponses>, t: Throwable) {
//                onFailure(t.message ?: EM_NO_INTERNET_CONNECTION)
//            }
//
//            override fun onResponse(
//                call: Call<GetAllTourResponses>,
//                response: Response<GetAllTourResponses>
//            ) {
//                val getAllToursResponse = response.body()
//                if (getAllToursResponse != null) {
//                    if (getAllToursResponse.isResponseOk()) {
//                        getAllToursResponse.data?.let {
//                            onSuccess(it.toList())
//                        }
//                    } else {
//                        onFailure(getAllToursResponse.message)
//                    }
//                } else {
//                    onFailure(EM_NO_INTERNET_CONNECTION)
//                }
//            }
//
//        })
//    }
//
//
//}
