package com.b12game.exammodul6.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.b12game.exammodul6.R
import com.b12game.exammodul6.Room.DataBase
import com.b12game.exammodul6.Room.entity.Card
import com.b12game.exammodul6.adapter.CardAdapter
import com.b12game.exammodul6.model.CardAppModel
import com.b12game.exammodul6.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var add_card : ImageView
    lateinit var adapter: CardAdapter
    lateinit var database: DataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = DataBase.getInstance(this)
        initViews()
    }

    private fun initViews() {
        adapter = CardAdapter(this)
        add_card = findViewById(R.id.addCard)
        recyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = adapter
        add_card.setOnClickListener {
            callDetailActivity()
        }
        apiCardList()
    }

    private fun callDetailActivity() {
        var intent = Intent(this,DetaiilActivity::class.java)
        startActivity(intent)
    }

    private fun apiCardList(){
        RetrofitHttp.cardService.getcards().enqueue(object : Callback<ArrayList<CardAppModel>>{
            override fun onResponse(call: Call<ArrayList<CardAppModel>>, response: Response<ArrayList<CardAppModel>>) {
                adapter.addcard(response.body()!!)
                database.postDao().createPost(response.body()!! as Card)
                Log.d("@@@",response.body()!!.toString())
            }

            override fun onFailure(call: Call<ArrayList<CardAppModel>>, t: Throwable) {
                Log.e("@@@", t.message.toString())
                Log.e("@@@", t.toString())
            }


        })
    }
}