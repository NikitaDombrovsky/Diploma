package com.example.diploma.presenter.Task.Details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diploma.R
import com.example.diploma.ui.theme.CustomTheme
import com.example.diploma.ui.theme.DinamicTheme
import com.example.diploma.ui.theme.backgroundLight


val LARGE_PADDING = 6.dp
val MEDIUM_PADDING = 4.dp

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LARGE_PADDING)
            .background(color = MaterialTheme.colorScheme.background)//.background(backgroundLight)
            .padding(all = LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = if (title.isEmpty()) {
                stringResource(R.string.titleIsEmpty)
            } else
                title,
            colors = OutlinedTextFieldDefaults.colors(
                //unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer
            ),
            onValueChange = { onTitleChange(it) },
            //label = { Text(text = stringResource(R.string.title)) },

            textStyle = MaterialTheme.typography.bodyMedium,
            singleLine = true,

            )
        HorizontalDivider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color = backgroundLight
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = if (description.isEmpty()) {
                stringResource(R.string.descriptionIsEmpty)
            } else
                description,
            colors = OutlinedTextFieldDefaults.colors(
                //unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainer
            ),
            onValueChange = { onDescriptionChange(it) },
            //label = { if (description.isEmpty()) Text(text = stringResource(R.string.descriptionIsEmpty)) },
            textStyle = MaterialTheme.typography.bodySmall,
        )
    }

}


@Composable
@Preview
private fun TaskContentPreview_CustomTheme() {
    CustomTheme {
        TaskContent(
            title = "",
            onTitleChange = {},
            description = "",
            onDescriptionChange = {},

        )
    }
}
@Composable
@Preview
private fun TaskContentPreview_DinamicTheme() {
    DinamicTheme {
        TaskContent(
            title = "",
            onTitleChange = {},
            description = "",
            onDescriptionChange = {},

        )
    }
}

/*@Composable
@Preview
private fun TaskContentPreview(){
    TaskContent(
        title = "",
        onTitleChange = {},
        description = "",
        onDescriptionChange = {},
        Modifier
    )
}*/

/*@Composable
fun TaskContent (
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    modifier: Modifier
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LARGE_PADDING)
            .background(MaterialTheme.colorScheme.background)
            .padding(all = LARGE_PADDING)
    ){
        OutlinedTextField(
            modifier= Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            //  label = { Text(text = stringResource(R.string.title)) },

            //textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        HorizontalDivider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color= MaterialTheme.colorScheme.background
        )
        OutlinedTextField(
            modifier= Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            // label = { Text(text = stringResource(R.string.description)) },
            //textStyle = MaterialTheme.typography.body1,
        )
    }
}*/


/*

@Composable
fun TaskContent (
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LARGE_PADDING)
            .background(MaterialTheme.colors.background)
            .padding(all = LARGE_PADDING)
    ){
        OutlinedTextField(
            modifier= Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(R.string.title)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color= MaterialTheme.colors.background

        )
        PriorityDropDown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        OutlinedTextField(
            modifier= Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = stringResource(R.string.description)) },
            textStyle = MaterialTheme.typography.body1,
        )
    }
}
@Composable
@Preview
private fun TaskContentPreview(){
    TaskContent(
        title = "",
        onTitleChange = {},
        description = "",
        onDescriptionChange = {},
        priority = Priority.HIGH,
        onPrioritySelected = {}
    )
}*/
