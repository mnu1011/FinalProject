package com.codelab.basiclayouts

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codelab.basiclayouts.feature_account.domain.model.PetCard
import com.codelab.basiclayouts.feature_account.domain.model.PetCardType
import com.codelab.basiclayouts.feature_account.presentation.graph.GraphViewModel
import com.codelab.basiclayouts.feature_account.presentation.graph.components.ExpenseGraphScreen
import com.codelab.basiclayouts.feature_account.presentation.graph.components.IncomeGraphScreen
import com.codelab.basiclayouts.feature_account.presentation.homepage.HomepageViewModel
import com.codelab.basiclayouts.feature_account.presentation.homepage.component.HomepageScreen
import com.codelab.basiclayouts.feature_account.presentation.record_list.RecordViewModel
import com.codelab.basiclayouts.feature_account.presentation.record_list.components.RecordScreen
import com.codelab.basiclayouts.feature_account.presentation.search_filter.FilterViewModel
import com.codelab.basiclayouts.feature_account.presentation.search_filter.components.FilterScreen
import com.codelab.basiclayouts.feature_account.presentation.search_filter.components.SearchScreen
import com.codelab.basiclayouts.feature_account.presentation.track_expense.RecordingViewModel
import com.codelab.basiclayouts.feature_account.presentation.track_expense.component.RecordingPage
import com.codelab.basiclayouts.feature_account.presentation.track_expense.component.RecordingPageScreen
import com.codelab.basiclayouts.feature_cards.presentation.CardViewModel
import com.codelab.basiclayouts.feature_cards.presentation.card.components.CardScreen
import com.google.gson.Gson

@Composable
fun Navigation() {

    val homepageViewModel: HomepageViewModel = viewModel()
    val cardViewModel: CardViewModel = viewModel()
    val graphViewModel: GraphViewModel = viewModel()
    val recordViewModel: RecordViewModel = viewModel()
    val filterViewModel: FilterViewModel = viewModel()
    val recordingViewModel: RecordingViewModel = viewModel()

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomMenu(
                navController,
                onButtonClicked = { screen ->
                    navController.navigate(screen) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
    ){ innerPadding ->
        NavHost(navController = navController, startDestination = Screen.HomePage.route, Modifier.padding(innerPadding)){
            composable(route = Screen.HomePage.route){
                HomepageScreen(
                    onClickCollectionBook = { navController.navigate(Screen.CardCollectionScreen.route) },
                    homepageViewModel
                )
            }
            composable(route = Screen.CardCollectionScreen.route){
                CardCollectionScreen(
                    navController,
                    cardViewModel
                )
            }
            composable(route = Screen.ExpenseGraphScreen.route){
                ExpenseGraphScreen(
                    navController,
                    graphViewModel
                )
            }
            composable(route = Screen.IncomeGraphScreen.route){
                IncomeGraphScreen(
                    navController,
                    graphViewModel
                )
            }
            composable(route = Screen.RecordScreen.route){
                RecordScreen(
                    navController,
                    recordViewModel
                )
            }
            composable(route = Screen.SearchScreen.route){
                SearchScreen(
                    navController,
                    filterViewModel
                )
            }
            composable(route = Screen.SortFilterScreen.route){
                FilterScreen(
                    navController,
                    filterViewModel
                )
            }
            composable(route = Screen.TrackingScreen.route){
                RecordingPageScreen(
                    navController,
                    recordingViewModel
                )
            }
            composable(
                route = "petcard" + "/{petCard}",
                arguments = listOf(
                    navArgument("petCard") {
                        type = PetCardType()
                        //defaultValue = ""
                        //nullable = false
                    }
                )
            ){ entry ->
                val petCard = entry.arguments?.getParcelable<PetCard>("petCard")
                if (petCard != null) {
                    CardScreen(
                        navController,
                        cardViewModel,
                        petCard
                    )
                }
            }
        }
    }
}



