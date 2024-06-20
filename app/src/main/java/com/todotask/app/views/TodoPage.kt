package com.todotask.app.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.todotask.app.R
import com.todotask.app.models.TodoData
import com.todotask.app.viewmodels.TodoViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ToDoPage(viewModel: TodoViewModel) {
    var inputText by remember {
        mutableStateOf("")
    }
    val todoList by viewModel.todoList.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.75f),
                value = inputText,
                maxLines = 2,
                onValueChange = {
                    inputText = it
                },
            )
            Button(onClick = {
                viewModel.addTodo(inputText)
                inputText = ""
            }) {
                Text(text = "Add")
            }
        }
        todoList?.let {
            LazyColumn(content = {
                itemsIndexed(it) { index: Int, todoItem: TodoData ->
                    ToDoItem(item = todoItem, onDelete = { viewModel.deleteTodo(todoItem.id) })
                }
            })
        } ?: Text(
            modifier = Modifier.fillMaxWidth(),
            text = "No items yet.",
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ToDoItem(item: TodoData, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colors.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = SimpleDateFormat("hh:mm:aa, dd/MM", Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.LightGray
            )
            Text(
                text = item.title,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete button",
                tint = Color.White,
            )
        }
    }
}