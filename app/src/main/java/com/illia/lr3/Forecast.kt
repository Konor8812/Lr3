package com.illia.lr3

import java.io.Serializable

class Forecast(
    val forecastAsString: String,
    val humidity: Int,
    val imageUrl: String?
) : Serializable {

}