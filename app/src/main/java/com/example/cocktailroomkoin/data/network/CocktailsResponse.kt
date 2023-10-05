package com.example.cocktailroomkoin.data.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CocktailsResponse(
    val drinks: List<CocktailNetwork>
): Parcelable