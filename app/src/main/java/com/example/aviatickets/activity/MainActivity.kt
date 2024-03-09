package com.example.aviatickets.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aviatickets.R
import com.example.aviatickets.adapter.OfferListAdapter
import com.example.aviatickets.databinding.ActivityMainBinding
import com.example.aviatickets.fragment.OfferListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var offerListAdapter: OfferListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        offerListAdapter = OfferListAdapter()
//
//        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        recyclerView.adapter = offerListAdapter
//
//        offerViewModel.fetchOffers.observe(this) {
//            offerListAdapter.saveData(it.data)
//        }
        val recyclerView = findViewById<RecyclerView>(R.id.offer_list)
        val adapter = offerListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, OfferListFragment.newInstance())
            .commit()

    }
}