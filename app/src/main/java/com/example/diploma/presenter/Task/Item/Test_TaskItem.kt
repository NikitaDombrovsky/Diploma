package com.example.diploma.presenter.Task.Item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Task(val title: String, val description: String, val isCompleted: Boolean)

@Composable
fun TaskItem(task: Task, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (task.isCompleted) Color(0xFFE0F7FA) else Color.White,
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        border = BorderStroke(1.dp, if (task.isCompleted) Color(0xFF00796B) else Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = task.title,
                fontSize = 20.sp,
                color = if (task.isCompleted) Color.Gray else Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = task.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (task.isCompleted) {
                Text(
                    text = "Completed",
                    color = Color.Green,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun TaskList(tasks: List<Task>, onTaskClick: (Task) -> Unit) {
    LazyColumn {
        items(tasks) { task ->
            TaskItem(task = task) {
                onTaskClick(task)
            }
        }
    }
}

@Composable
fun TaskItem_Material(task: Task, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (task.isCompleted) Color(0xFFE0F7FA) else MaterialTheme.colorScheme.background,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
       // border = BorderStroke(1.dp, if (task.isCompleted) Color(0xFF00796B) else Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = task.title,
                fontSize = 20.sp,
                color = if (task.isCompleted) Color.Gray else Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = task.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (task.isCompleted) {
                Text(
                    text = "Completed",
                    color = Color.Green,
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun Task(){
    TaskItem(task = Task(title = "SUPER", description = "MEGA", isCompleted = true)) {

    }
}
@Preview
@Composable
fun Material_Task(){
    TaskItem_Material(task = Task(title = "SUPER", description = "MEGA", isCompleted = true)) {

    }
}
@Preview
@Composable
fun Tasks(){

    val tasks: List<Task> = listOf(Task("0", "0", false), Task("0", "0", false))
    LazyColumn {
        items(tasks) { task ->
            TaskItem(task = task) {
                //onTaskClick(task)
            }
        }
    }
}
@Preview
@Composable
fun Material_Tasks(){

    val tasks: List<Task> = listOf(Task("0", "0", false), Task("0", "0", false))
    LazyColumn {
        items(tasks) { task ->
            TaskItem_Material(task = task) {
                //onTaskClick(task)
            }
        }
    }
}