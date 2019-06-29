package com.mind.myretrofitdemoproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getData()

        call.enqueue(object : Callback<DataModel> {
            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.i(TAG, "Repsonce Fail")
            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                val statusCode = response.code()
                Log.i(TAG, "Status Code" + statusCode)

                Toast.makeText(this@MainActivity, "Success Code" + statusCode, Toast.LENGTH_LONG).show()

                if (response.body() != null) {

                    val dataModel = response.body()!!
                    dataModel.dataList

                    getDataList(response.body()!!.dataList)
                    Log.d(TAG, "Succees " + response.body()!!.dataList.size.toString())
                }
            }
        })
    }

    private fun getDataList(dataList: ArrayList<DataModel.DataBean>) {
        val dataAdapter = DataAdapter()
        dataAdapter.addDataList(dataList)
        rvDataDisplay.adapter = dataAdapter
    }
}