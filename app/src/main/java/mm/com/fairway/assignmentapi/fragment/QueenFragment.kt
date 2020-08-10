package mm.com.fairway.assignmentapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_queen.*
import mm.com.fairway.assignmentapi.R
import mm.com.fairway.assignmentapi.adapter.QueenAdapter
import mm.com.fairway.assignmentapi.api.ApiClient
import mm.com.fairway.assignmentapi.model.QueenItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class QueenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_queen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getQueenInfo()
    }

fun getQueenInfo(){
    val apiClient=ApiClient()
    val apiCall= apiClient.ApiService.getQueen()
    apiCall.enqueue(object : Callback<ArrayList<QueenItem>>{
        override fun onFailure(call: Call<ArrayList<QueenItem>>, t: Throwable) {
            Toast.makeText(context,t.toString(), Toast.LENGTH_LONG).show()
        }

        override fun onResponse(
            call: Call<ArrayList<QueenItem>>,
            response: Response<ArrayList<QueenItem>>
        ) {
            recyclerView_Queen.apply {
                layoutManager= LinearLayoutManager(context)
                adapter= QueenAdapter(response.body()!!)
            }
        }

    })
}
}