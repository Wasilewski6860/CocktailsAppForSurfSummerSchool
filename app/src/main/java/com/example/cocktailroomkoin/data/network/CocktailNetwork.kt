package com.example.cocktailroomkoin.data.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CocktailNetwork(
    val idDrink: String,
    val strAlcoholic: String,
    val strDrink: String,
    val strDrinkThumb: String,// image
    val strIngredient1: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strInstructions: String?

): Parcelable



public fun CocktailNetwork.ingridientsToString() : String {
    var ingredient01Str = if(strIngredient1 != null ) strIngredient1 +"\n" else ""
    var ingredient02Str = if(strIngredient2 != null ) strIngredient2 +"\n" else ""
    var ingredient03Str = if(strIngredient3 != null ) strIngredient3 +"\n" else ""
    var ingredient04Str = if(strIngredient4 != null ) strIngredient4 +"\n" else ""
    var ingredient05Str = if(strIngredient5 != null ) strIngredient5 +"\n" else ""
    var ingredient06Str = if(strIngredient6 != null ) strIngredient6 +"\n" else ""
    var ingredient07Str = if(strIngredient7 != null ) strIngredient7 +"\n" else ""
    var ingredient08Str = if(strIngredient8 != null ) strIngredient8 +"\n" else ""
    var ingredient09Str = if(strIngredient9 != null ) strIngredient9 +"\n" else ""
    var ingredient10Str = if(strIngredient10 != null ) strIngredient10 +"\n" else ""
    var ingredient11Str = if(strIngredient11 != null ) strIngredient11 +"\n" else ""
    var ingredient12Str = if(strIngredient12 != null ) strIngredient12 +"\n" else ""
    var ingredient13Str = if(strIngredient13 != null ) strIngredient13 +"\n" else ""
    var ingredient14Str = if(strIngredient14 != null ) strIngredient14 +"\n" else ""
    var ingredient15Str = if(strIngredient15 != null ) strIngredient15 +"\n" else ""

    return ingredient01Str + ingredient02Str + ingredient03Str + ingredient04Str + ingredient05Str + ingredient06Str +
            ingredient07Str + ingredient08Str + ingredient09Str + ingredient10Str + ingredient11Str + ingredient12Str +
            ingredient13Str + ingredient14Str + ingredient15Str

}