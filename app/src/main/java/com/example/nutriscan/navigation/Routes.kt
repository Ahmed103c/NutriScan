package com.example.nutriscan.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {

    @Serializable
    data object HomePage : Route

    @Serializable
    data object HistoryPage : Route

    @Serializable
    data object DataPage : Route
}