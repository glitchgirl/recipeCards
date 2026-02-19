package com.example.recipecards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipecards.ui.theme.RecipeCardsTheme
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Timer
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {

        // Your original header card
        MyCard()

        // Recipe Card with outlined difficulty
        RecipeCard(
            title = "Spaghetti Carbonara",
            time = "30 min",
            servings = 4,
            difficulty = "Easy",
            imageRes = android.R.drawable.ic_menu_gallery
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("second")
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text("Go to add recipe")
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
            Text("Add recipe")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Back to list of recipes")
            }
        }
    }
}
@Composable
fun RecipeCard(
    title: String,
    time: String,
    servings: Int,
    difficulty: String,
    imageRes: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {

        Column {

            // IMAGE
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {

                // TITLE
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                // INFO ROW
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // TIME
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = "Time",
                        tint = Color.Blue
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(text = time)

                    Spacer(modifier = Modifier.width(16.dp))

                    // SERVINGS
                    Icon(
                        imageVector = Icons.Default.People,
                        contentDescription = "Servings",
                        tint = Color.Green
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(text = servings.toString())

                    Spacer(modifier = Modifier.width(16.dp))

                    // DIFFICULTY
                    Text(
                        text = difficulty,
                        color = Color(0xFFE0218A),
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFE0218A),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )

                }
            }
        }
    }
}


