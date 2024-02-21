package com.example.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_basics.ui.theme.Compose_BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         Column(horizontalAlignment = Alignment.CenterHorizontally,
             modifier = Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.SpaceBetween // use to create space between the items present in the column
         ) {
             Text(text = "Fenil")
             Text(text = "Ahir")
             Text(text = "Bardoli")
             // There is a concept about main axis and cross axis for rows and column so if we talk about an row the main axis would be the horizontal axis as we put the elements in that direction.
             // and for the column it would be vertical axis as the main axis.
             // In the above code we use the center horizontal property but it wont center the item horizontally because right now our items only acquire space that is been required by them so in general they are centered for the space acquired by them.
             // Lets use an modififer and make some changes. After using the modifier fill max size property we can see the changes in out items positions. Let us now use some vertical arrangements 
             
         }
            HaveRow()
        }
    }


    @Composable
    fun HaveRow(){
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
            Text(text = "Fenil")
            Text(text = "Bardoli")
        }
    }
}

