package com.training.appssquaretaskone.viewmodel

import android.content.Context
import com.training.appssquaretaskone.R
import com.training.appssquaretaskone.model.City

class CitiesViewModel(var context:Context) {
    fun getCities():List<City>{
        return listOf(
            City(
                R.drawable.kanada,
                context.getString(R.string.cities_name),
                context.getString(R.string.cities_reviews)
            ),
            City(
                R.drawable.germany,
                context.getString(R.string.cities_name),
                context.getString(R.string.cities_reviews)
            ),
            City(
                R.drawable.italian,
                context.getString(R.string.cities_name),
                context.getString(R.string.cities_reviews)
            )
        )
    }
}