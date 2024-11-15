package com.example.diploma.presenter.Actions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diploma.R
import com.example.diploma.ui.theme.primaryLight

@Composable
fun BackAction(
    //onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { /*onBackClicked(Action.NO_ACTION)*/ }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_arrow),
            tint = MaterialTheme.colorScheme.primary//primaryLight//MaterialTheme.colorScheme.surfaceTint //MaterialTheme.colors.topAppBarContentColor
        )
    }
}
@Composable
fun AddAction(
    //onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = { /*onAddClicked(Action.ADD)*/ }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.add_task),
            tint = MaterialTheme.colorScheme.primary//primaryLight
        )
    }
}
@Composable
fun CloseAction(
    //onCloseClicked: (Action) -> Unit
) {
    IconButton(onClick = { /*onCloseClicked(Action.NO_ACTION)*/ }) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "",//stringResource(id = R.string.close_icon),
            tint = MaterialTheme.colorScheme.primary//primaryLight
        )
    }
}
@Composable
fun DeleteAction(
    onDeleteClicked: () -> Unit
) {
    IconButton(onClick = { onDeleteClicked() }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "",//stringResource(R.string.delete_icon),
            tint = MaterialTheme.colorScheme.primary//primaryLight//MaterialTheme.colors.topAppBarContentColor
        )
    }
}
@Composable
fun UpdateAction(
    // onUpdateClicked: (Action) -> Unit
) {
    IconButton(onClick = { /*onUpdateClicked(Action.UPDATE)*/ }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "",//stringResource(R.string.update_icon),
            tint = MaterialTheme.colorScheme.primary//primaryLight//MaterialTheme.colors.topAppBarContentColor
        )
    }
}
@Composable
fun MoreAction(
    // onUpdateClicked: (Action) -> Unit
) {
    IconButton(onClick = { /*onUpdateClicked(Action.UPDATE)*/ }) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = "",//stringResource(R.string.update_icon),
            tint = MaterialTheme.colorScheme.primary//primaryLight//MaterialTheme.colors.topAppBarContentColor
        )
    }
}
@Composable
@Preview
fun Preview_BackAction(){
    BackAction()
}
@Composable
@Preview
fun Preview_AddAction(){
    AddAction()
}
@Composable
@Preview
fun Preview_CloseAction(){
    CloseAction()
}
@Composable
@Preview
fun Preview_DeleteAction(){
    DeleteAction({})
}
@Composable
@Preview
fun Preview_UpdateAction(){
    UpdateAction()
}
@Composable
@Preview
fun Preview_MoreAction(){
    MoreAction()
}