package com.example.diploma.presenter


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.diploma.presenter.todata.Priority
/*import com.ayse.todocompose.R
import com.ayse.todocompose.components.DisplayAlertDialog
import com.ayse.todocompose.data.ToDoTask
import com.ayse.todocompose.data.models.Priority
import com.ayse.todocompose.ui.theme.topAppBarBackgroundColor
import com.ayse.todocompose.ui.theme.topAppBarContentColor
import com.ayse.todocompose.util.Action*/
import com.example.diploma.R
import com.example.diploma.presenter.Actions.AddAction
import com.example.diploma.presenter.Actions.BackAction
import com.example.diploma.presenter.Actions.CloseAction
import com.example.diploma.presenter.Actions.DeleteAction
import com.example.diploma.presenter.Actions.MoreAction
import com.example.diploma.presenter.Actions.UpdateAction
import com.example.diploma.presenter.Main.ToDoTask
import com.example.diploma.toutils.Action
import com.example.diploma.ui.theme.*


@Composable
fun TaskAppBar(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    if (selectedTask == null) {
        NewTaskAppBar(modifier = Modifier)//navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    modifier: Modifier
    //navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            BackAction(/*onBackClicked = navigateToListScreen*/)
        },
        title = {
            Text(
                text = stringResource(id = R.string.add_task),
                color = MaterialTheme.colorScheme.primary
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer//backgroundLight
        ),
        // backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            NewTaskAppBarActions()
            // AddAction(/*onAddClicked = navigateToListScreen*/)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(/*onCloseClicked = navigateToListScreen*/)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.colorScheme.primary, //MaterialTheme.colors.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        actions = {
            ExistingAppBarActions(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        }
    )
}

@Composable
fun NewTaskAppBarActions(
) {
    MoreAction()
    AddAction(/*onAddClicked = navigateToListScreen*/)

}

@Composable
fun ExistingAppBarActions(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    var openDialog by remember { mutableStateOf(value = false) }


    /*    DisplayAlertDialog(
            title = stringResource(id = R.string.delete_task,selectedTask.title),
            message = stringResource(id = R.string.delete_task_confirmation,selectedTask.title),
            openDialog = openDialog,
            closeDialog = { openDialog = false },
            onYesClicked = { navigateToListScreen(Action.DELETE)}
        )*/
    MoreAction()
    DeleteAction(onDeleteClicked = { openDialog = true })
    UpdateAction(/*onUpdateClicked = navigateToListScreen*/)
}

@Composable
@Preview
fun previewNewTaskAppBar() {
    NewTaskAppBar(modifier = Modifier/*navigateToListScreen = {}*/)
}

@Composable
@Preview
fun previewExistingTaskAppBar() {
    ExistingTaskAppBar(
        selectedTask = ToDoTask(
            id = 0,
            title = "Test",
            description = "Some Random Text",
            priority = Priority.LOW
        ),
        navigateToListScreen = {})
}