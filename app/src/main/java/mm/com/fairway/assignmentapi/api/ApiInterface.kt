package mm.com.fairway.assignmentapi.api

import mm.com.fairway.assignmentapi.model.KingItem
import mm.com.fairway.assignmentapi.model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("king")
    fun getKing():Call<ArrayList<KingItem>>
    @GET("queen")
    fun getQueen():Call<ArrayList<QueenItem>>
}