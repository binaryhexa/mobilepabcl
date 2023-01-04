package com.example.aktorfavorit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.aktorfavorit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding : ActivityMainBinding by viewBinding()
    private val list : ArrayList<Actors> = arrayListOf()
    private lateinit var listActorAdapter: ListActorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvActors.setHasFixedSize(true)
        list.addAll(ActorsData.listData)

        showRecyclerViewList()
    }

    private fun showRecyclerViewList() {
        binding.apply {
            rvActors.layoutManager = LinearLayoutManager(this@MainActivity)
            listActorAdapter = ListActorAdapter(list)
            rvActors.adapter = listActorAdapter
        }
    }
}