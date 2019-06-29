package com.mind.myretrofitdemoproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_row.view.*
import java.util.*

class DataAdapter() : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    val userDataList = ArrayList<DataModel.DataBean>()

    fun addDataList(arrList: ArrayList<DataModel.DataBean>) {
        userDataList.addAll(arrList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_row, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bindItem(userDataList[i])
    }

    override fun getItemCount(): Int {
        return userDataList.size
    }

    inner class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        fun bindItem(dataBean: DataModel.DataBean) {
            itemView.tvUserID.text = dataBean.id.toString()
            itemView.tvUserName.setText(dataBean.name)

            Glide.with(itemView.context)
                    .load(dataBean.url)
                    .into(itemView.ivUserImage)
        }
    }
}