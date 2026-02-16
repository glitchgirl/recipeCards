package com.example.recipecards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipecards.ui.theme.RecipeCardsTheme
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.recipecards.ui.theme.Pink40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeCardsTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "first"
                ) {
                    composable("first") {
                        FirstScreen(navController)
                    }

                    composable("second") {
                        SecondScreen(navController)
                    }
                }
            }
        }

    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Recipe Collection",
                style = MaterialTheme.typography.titleLarge,
                color = Pink40
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Discover delicious recipes for every meal\n"

            )
        }
    }
}

@Composable
fun FirstScreen(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("This is Page 1")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                navController.navigate("second")
            }) {
                Text("Go to Page 2")
            }
        }
    }
}

@Composable
fun SecondScreen(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("This is Page 2")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Back to Page 1")
            }
        }
    }
}

