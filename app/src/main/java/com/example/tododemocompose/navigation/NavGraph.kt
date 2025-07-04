package com.example.tododemocompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.tododemocompose.navigation.destinations.listComposable
import com.example.tododemocompose.navigation.destinations.taskComposable
import com.example.tododemocompose.ui.viewmodels.SharedViewModel
import com.example.tododemocompose.util.logD

@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    NavHost(
        navController,
        startDestination = Screen.List()
    ) {

        listComposable(
            navigateToTaskScreen = { taskId ->
                navController.navigate(Screen.Task(taskId))
                logD("called task id $taskId")
            },
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = { action ->
                logD("successfully added, action name ${action.name}")

                navController.navigate(Screen.List(action)) {
                    popUpTo(Screen.List()) { inclusive = true }
                }
            },
            sharedViewModel = sharedViewModel
        )
    }
}