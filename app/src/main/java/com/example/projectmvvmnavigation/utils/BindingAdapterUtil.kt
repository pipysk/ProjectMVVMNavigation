package com.example.projectmvvmnavigation.utils

import androidx.lifecycle.MutableLiveData
import com.example.projectmvvmnavigation.data.entities.Data
import io.paperdb.Paper
import java.util.ArrayList

object BindingAdapterUtil {
    var listDatas = MutableLiveData(getData())

    private fun getData(): ArrayList<Data> {
        return Paper.book(STICKY_NOTES).read(LIST_NOTES, ArrayList())!!
    }

    fun deleteHome(data: Data) {
        val result = listDatas.value?.filter { it.id != data.id }
        listDatas.postValue(result as ArrayList<Data>)
        Paper.book(STICKY_NOTES).write(LIST_NOTES,result)
    }
}