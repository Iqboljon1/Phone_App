package com.example.phonesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonesapp.MyAdapter.MyAdapter
import kotlinx.android.synthetic.main.activity_main2.*
import androidx.recyclerview.widget.GridLayoutManager
import com.example.phonesapp.MyOnClickListiner.MyOnClickListiner
import com.example.phonesapp.MyShare.MyShare
import com.example.phonesapp.Object.Object


class MainActivity2 : AppCompatActivity() {
    var arrayListModel = ArrayList<String>()
    lateinit var arraylistModelTest:ArrayList<Dataa>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        MyShare.init(this)
        arraylistModelTest = ArrayList()
        arraylistModelTest.addAll(MyShare.dataList!!)
        arrayListModel = ArrayList()
        arrayListModel = BuildArrayModel(arraylistModelTest)
        AddDataRecycleView(arrayListModel)
    }

    private fun BuildArrayModel(arrayList: ArrayList<Dataa>):ArrayList<String> {
        var arrayListString = ArrayList<String>()
        val hashSet = HashSet<String>()
        for (i in 0 until arrayList.size) {
            val boolean = hashSet.add(arrayList[i].stringModel)
            if (boolean){
                arrayListString.add(arrayList[i].stringModel)
            }
        }

        return arrayListString
    }


    fun AddDataRecycleView(arrayList: ArrayList<String>) {
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        container.layoutManager = linearLayoutManager
        container.layoutManager = GridLayoutManager(this, 2)
        val adapter = MyAdapter(arrayList, object : MyOnClickListiner {
            override fun OnClick(tag: String) {
                Intent(tag)
                super.OnClick(tag)
            }
        })
        container.adapter = adapter
    }

    fun Intent(string: String) {
        val intent = Intent(this, MainActivity4::class.java)
        startActivity(intent)
        Object.string = string
    }
}