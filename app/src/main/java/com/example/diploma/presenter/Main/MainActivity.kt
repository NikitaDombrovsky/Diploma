package com.example.diploma.presenter.Main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diploma.R
import com.example.diploma.presenter.Task.Details.TaskContent
import com.example.diploma.presenter.TaskAppBar
import com.example.diploma.presenter.todata.Priority
import com.example.diploma.ui.theme.CustomTheme
import com.example.diploma.ui.theme.DinamicTheme
import com.example.diploma.ui.theme.primaryContainerDark


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

data class ToDoTask(
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
@Composable
fun Main(){
    CustomTheme {
        // Main(modifier = Modifier)
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                TaskAppBar(
                    // TODO Замокать
                    selectedTask = ToDoTask(0, "TITLE", "DESCRUPTION", Priority.LOW),
                    {}
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*presses++*/ }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        )
        { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    //TODO Column?
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
/*        // TODO Нахуя ты два раза таск передаешь?
        TaskAppBar(
            selectedTask = ToDoTask(0, "TITLE", "DESCRUPTION", Priority.LOW),
            {}
        )*/

        TaskContent(
            title = stringResource(R.string.title),
            onTitleChange = {},
            onDescriptionChange = {},
            description = stringResource(R.string.description),
        )
    }


}


@Preview(showBackground = true)
@Composable
fun PreviewMain_CustomTheme() {
    CustomTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain_DinamicTheme() {
    DinamicTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain_MaterialTheme() {
    MaterialTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    }
}

///////////////////////////////////////////////////////////////////////////////////////////
@Composable
fun TestButtons() {
    Column(modifier = Modifier.fillMaxSize()) {
        ThemeTest(true)
        ThemeTest(false)
        DinamicTheme {
            ThemeTest(true)
            ThemeTest(false)
        }
        CustomTheme {
            ThemeTest(true)
            ThemeTest(false)
        }
    }
}

/*@Composable
fun TaskAppBar(modifier: Modifier = Modifier) {
    NewTaskAppBar(modifier*//*navigateToListScreen = {}*//*)
}*/


@Composable
fun TestThemeCard(modifier: Modifier = Modifier, email: Boolean) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .semantics { }
            .clickable { },
        colors = CardDefaults.cardColors(
            containerColor = if (email) //isImportant
                MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        /*..*/
    }

}

@Composable
fun TestThemeButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier.fillMaxWidth(),

        colors = ButtonDefaults.buttonColors(containerColor = primaryContainerDark),
        onClick = { /*TODO*/ }) {

    }

}

/*@Composable
fun TestThemeButton2(modifier: Modifier = Modifier){
    Button(
        modifier = modifier.fillMaxWidth(),

        colors = ButtonDefaults.buttonColors(containerColor = Diplo ),
        onClick = { *//*TODO*//* }) {

    }

}*/
@Composable
fun TestTheme() {
    DinamicTheme {
        Surface(tonalElevation = 5.dp) {
            ReplySearchBar()
        }
    }
}

@Composable
fun ReplySearchBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Search bar content
    }
}


/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiplomaTheme {
        Greeting("Android")
    }
}*/

/*@Preview(showBackground = true)
@Composable
fun Preview() {
    TestTheme()
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    TestThemeCard(email = true)
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    TestThemeButton()
}*/



@Composable
fun ThemeTest(isSelected: Boolean) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor =
            if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Text(
            text = "Dinner club",
            style = MaterialTheme.typography.bodyLarge,
            color =
            if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
            else MaterialTheme.colorScheme.onSurface,
        )
    }

}

