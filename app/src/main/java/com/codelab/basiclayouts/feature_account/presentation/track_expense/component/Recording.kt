package com.codelab.basiclayouts.feature_account.presentation.track_expense.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codelab.basiclayouts.R
import com.codelab.basiclayouts.navigation.Screen
import com.codelab.basiclayouts.feature_account.presentation.track_expense.RecordingViewModel
import com.codelab.basiclayouts.ui.theme.MySootheTheme


@Composable
fun RecordingPageScreen(
    navController: NavController,
    recordingViewModel: RecordingViewModel,
    modifier: Modifier = Modifier,
){
    MySootheTheme{
        Scaffold(
            topBar = { MyTopAppBar(navController) },
            modifier = modifier.fillMaxSize()
        ) {
            Box(
                modifier = modifier.fillMaxSize(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_background),
                    contentDescription = null,
                    modifier = modifier.fillMaxSize()
                )
                RecordingPage(navController, recordingViewModel, modifier)
            }
        }
    }
}

@Composable
fun RecordingPage(
    navController: NavController,
    recordingViewModel: RecordingViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Function()
        Column {
            Surface(
                border = BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(10.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(350.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Date()
                    Spacer(modifier = Modifier.height(10.dp))
                    Item()
                    Spacer(modifier = Modifier.height(10.dp))
                    Price()
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Category",
                        fontWeight = FontWeight.W400,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 25.dp)
                    )
                    Category(
                        recordingViewModel.typeData,
                        recordingViewModel.typeChoose,
                        onSelectionChange = { type ->
                            recordingViewModel.typeChange(type)
                        })
                    Spacer(modifier = Modifier.height(60.dp))
                    Button(
                        onClick = { navController.navigate(Screen.RecordScreen.route) },
                        modifier = Modifier.width(200.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Magenta,
                            contentColor = Color.White
                        )
                    ) {
                        Text("Save")
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                }
            }
        }
    }
}

@Composable
fun Function() {
    val options = listOf(
        "Expense",
        "Income",
    )
    var selectedOption by remember {
        mutableStateOf("Expense")
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        options.forEach { text ->
            Row(
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Surface(
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(
                        text = text,
                        style = typography.body1.merge(),
                        color = Color.White,
                        fontWeight = FontWeight.W600,
                        fontSize = when (text == selectedOption) {
                            true -> 22.sp
                            else -> 13.sp
                        },
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(
                                    size = 12.dp,
                                ),
                            )
                            .clickable {
                                onSelectionChange(text)
                            }
                            .background(
                                if (text == selectedOption) {
                                    Magenta
                                } else {
                                    Color.LightGray
                                }
                            )
                            .padding(
                                vertical = 12.dp,
                                horizontal = 20.dp,
                            ),
                    )
                }
            }
        }
    }
}

@Composable
fun Date(){
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Date") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null
            )
        },
        placeholder = {
            Text(
                text = "Ex. 2022 / 6 / 6",
                color = Color.Gray,
                fontWeight = FontWeight.W600
            )
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
fun Item(){
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Item") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null
            )
        },
        placeholder = {
            Text(
                text = "Ex. Pizza",
                color = Color.Gray,
                fontWeight = FontWeight.W600
            )
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
fun Price(){
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Price") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        },
        placeholder = {
            Text(
                text = "Ex. 20$",
                color = Color.Gray,
                fontWeight = FontWeight.W600
            )
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
fun Category(
    typelist: List<String>,
    selectedtype: String,
    onSelectionChange: (String) -> Unit
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(vertical = 15.dp, horizontal = 25.dp)
    ) {
        items(typelist) { item ->
            Type(item, selectedtype, os = { onSelectionChange(item) })
        }
    }
}

@Composable
fun Type(text: String, st: String, os:() -> Unit){
    Row{
        Surface(
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(50.dp)
                .height(40.dp)
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                modifier = Modifier
                    .clickable { os() }
                    .background(
                        if (text == st) {
                            Magenta
                        } else {
                            Color.White
                        }
                    )
                    .padding(start = 5.dp, top = 5.dp)

            )
        }
    }
}

@Composable
fun MyTopAppBar(navController: NavController){
    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        IconButton(onClick = { navController.navigateUp() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
                    .clickable(
                        enabled = true,
                        onClick = { navController.navigateUp() }
                    )
            )
        }

        Spacer(modifier = Modifier.width(80.dp))

        Text(
            text = "Track Spending",
            style = typography.h5,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun DatePreview() {
    Date()
}

@Preview(showBackground = true)
@Composable
fun FunctionPreview() {
    Function()
}

@Preview(showBackground = true, device = Devices.PIXEL_3_XL)
@Composable
fun RecordingPageScreenPreview() {
    val navController = rememberNavController()
    val recordingViewModel: RecordingViewModel = viewModel()
    RecordingPageScreen(navController, recordingViewModel)
}
