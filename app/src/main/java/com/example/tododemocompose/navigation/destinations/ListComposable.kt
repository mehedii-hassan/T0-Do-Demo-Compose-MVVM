package com.example.tododemocompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.tododemocompose.navigation.Screen
import com.example.tododemocompose.ui.viewmodels.SharedViewModel
import com.example.tododemocompose.util.Action

@ExperimentalAnimationApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable<Screen.List> { navBackStackEntry ->
        val action = navBackStackEntry.toRoute<Screen.List>().action
        var myAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }

        /*LaunchedEffect(key1 = myAction) {
            if(action != myAction){
                myAction = action
                sharedViewModel.updateAction(newAction = action)
            }
        }*/

        val databaseAction = sharedViewModel.action

       /* ListScreen(
            action = databaseAction,
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )*/
    }

}