package com.example.aviatickets.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aviatickets.R
import com.example.aviatickets.adapter.OfferListAdapter
import com.example.aviatickets.databinding.FragmentOfferListBinding
import com.example.aviatickets.model.network.ApiClient
import com.example.aviatickets.model.service.FakeService
import com.example.aviatickets.model.service.OfferAPIresponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OfferListFragment : Fragment() {

    companion object {
        fun newInstance() = OfferListFragment()
    }

    private var _binding: FragmentOfferListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: OfferListAdapter by lazy {
        OfferListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOfferListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        adapter.setItems(FakeService.offerList)
    }
    val client = ApiClient.instance
    val response = client.fetchOfferList()
    response.enqueue(object : Callback<OfferAPIresponse> {
        override fun onResponse(
            call: Call<OfferAPIresponse>,
            response: Response<OfferAPIresponse>
        ) {
            println("HttpResponse: ${response.body()}")

            /**
             * example
             */
            val movieList = response.body()?.results

            if (movieList != null) {
                adapter.setData(
                )
            }
        }

        override fun onFailure(call: Call<OfferAPIresponse>, t: Throwable) {
            TODO("Not yet implemented")
        }


    })
    private fun setupUI() {
        with(binding) {
            offerList.adapter = adapter

            sortRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.sort_by_price -> {
                        /**
                         * implement sorting by price
                         */
                    }

                    R.id.sort_by_duration -> {
                        /**
                         * implement sorting by duration
                         */
                    }
                }
            }
        }
    }
}