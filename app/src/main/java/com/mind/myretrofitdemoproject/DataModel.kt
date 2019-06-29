package com.mind.myretrofitdemoproject

import com.google.gson.annotations.SerializedName

class DataModel {
    @SerializedName("data")
    var dataList = ArrayList<DataBean>()
data class DataBean(
    @SerializedName("id") val id: Int,
    @SerializedName("avatarUrl") var url: String,
    @SerializedName("name") var name: String
)

}
