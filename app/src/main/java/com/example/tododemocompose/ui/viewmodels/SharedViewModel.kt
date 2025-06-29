package com.example.tododemocompose.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tododemocompose.data.models.Priority
import com.example.tododemocompose.data.models.ToDoTask
import com.example.tododemocompose.data.repositories.ToDoRepository
import com.example.tododemocompose.util.Action
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository,
) : ViewModel() {

    var action by mutableStateOf(Action.NO_ACTION)
        private set
    var id by mutableIntStateOf(0)
        private set
    var title by mutableStateOf("")
        private set
    var description by mutableStateOf("")
        private set
    var priority by mutableStateOf(Priority.LOW)
        private set

    private fun addTask() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(
                ToDoTask(
                    title = title,
                    description = description,
                    priority = priority
                )
            )
        }
        //searchAppBarState = SearchAppBarState.CLOSED
    }


    fun handleDatabaseActions(action: Action) {
        when (action) {
            Action.ADD -> {
                addTask()
                updateAction(Action.NO_ACTION)
            }

            /*    Action.UPDATE -> {
                    updateTask()
                }

                Action.DELETE -> {
                    deleteTask()
                }

                Action.DELETE_ALL -> {
                    deleteAllTasks()
                }

                Action.UNDO -> {
                    addTask()
                    updateAction(Action.NO_ACTION)
                }*/

            else -> {

            }
        }
    }

    fun updateAction(newAction: Action) {
        action = newAction
    }
}