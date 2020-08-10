package mm.com.fairway.assignmentapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_king.*
import mm.com.fairway.assignmentapi.R
import mm.com.fairway.assignmentapi.adapter.KingAdapter
import mm.com.fairway.assignmentapi.api.ApiClient
import mm.com.fairway.assignmentapi.model.KingItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_king, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getKingInfo()
        btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_kingFragment_to_queenFragment)
        }
    }
    fun getKingInfo() {
        val apiClient = ApiClient()
        val apiCall = apiClient.ApiService.getKing()
        apiCall.enqueue(object : Callback<ArrayList<KingItem>> {
            override fun onFailure(call: Call<ArrayList<KingItem>>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<ArrayList<KingItem>>,
                response: Response<ArrayList<KingItem>>
            ) {
                recyclerView_King.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = KingAdapter(response.body()!!)
                }
            }

        })
    }
}