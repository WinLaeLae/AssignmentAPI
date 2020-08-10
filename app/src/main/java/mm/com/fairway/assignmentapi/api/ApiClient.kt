package mm.com.fairway.assignmentapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {

    private val BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"
    private var retrofit: Retrofit? = null

    init {
        if (retrofit == null) {
            retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

    }

    val ApiService = retrofit!!.create(ApiInterface::class.java)

}