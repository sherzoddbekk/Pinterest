package com.example.pinterest.fragement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pinterest.R
import com.example.pinterest.Utils.Logger
import com.example.pinterest.adapter.FragmentOneAdapter
import com.example.pinterest.model.Photo
import com.example.pinterest.retrofit.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Fragment_one : Fragment(){

    lateinit var recyclerView: RecyclerView
    var a = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_one,container,false)
        initView(view)
        return view

    }

    fun  initView(view: View){
        recyclerView = view?.findViewById(R.id.recyclerView_home)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        getPhotos(a)

    }
    fun refreshAdapter(photo:ArrayList<Photo>){
        val adapter = FragmentOneAdapter(requireContext(),photo)
        recyclerView.adapter = adapter
    }
    private fun getPhotos(a:Int){
        RetrofitHttp.photoService.listPost(page = a).enqueue(object : Callback<ArrayList<Photo>> {
            override fun onResponse(
                call: Call<ArrayList<Photo>>,
                response: Response<ArrayList<Photo>>,
            ){
                refreshAdapter(response.body()!!)
                Logger.d("@@@","PhotosList -> ${response.body()}")

            }
            override fun onFailure(call: Call<ArrayList<Photo>>, t:Throwable) {
                Logger.d("@@@","PhotoList -> ${t.localizedMessage}")
            }
        })
    }

}