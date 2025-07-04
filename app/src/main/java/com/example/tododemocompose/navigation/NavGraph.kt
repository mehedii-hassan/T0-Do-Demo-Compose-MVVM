package com.example.tododemocompose.navigation

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.tododemocompose.navigation.destinations.listComposable
import com.example.tododemocompose.ui.viewmodels.SharedViewModel

@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.List()
    ) {

        listComposable(
            navigateToTaskScreen = { taskId ->
                navController.navigate(Screen.Task(id = taskId))
                Log.d("TAG","called task id $taskId")
            },
            sharedViewModel = sharedViewModel
        )
    }
}