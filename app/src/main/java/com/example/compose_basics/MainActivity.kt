package com.example.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         val messilist= listOf<ImageItems>(
             ImageItems(
                 painter = painterResource(id = R.drawable.i1),
                 contentdecsciption = "Messi",
                 title="Messi Magic"
                 
             ),
             ImageItems(
                 painter = painterResource(id = R.drawable.i2),
                 contentdecsciption = "Messi",
                 title="Messi at its best"
             ),
             ImageItems(
                 painter = painterResource(id = R.drawable.i3),
                 contentdecsciption = "Messi",
                 title="Vamos Messi"
             ),
             ImageItems(
                 painter = painterResource(id = R.drawable.i4),
                 contentdecsciption = "Messi",
                 title="Ancara Messi"
             ),
             
         )
            VerticalImageView(imagelist = messilist)
             
        }

    }
}


@Composable
fun ImageCard(
    holdingitems:ImageItems,
    modifier: Modifier=Modifier
){

    Card(
        modifier= modifier
            .width(200.dp)
            .padding(top = 20.dp, start = 20.dp),
        //we want to apply rounded corners to the card so we would use the following property
       shape = RoundedCornerShape(15.dp)
    ){
     // Now our main goal is to place the items that in our case are an image,an text and a gradient in a stack manner like on top of each other so we would use Box composable to achieve it.

        Box(modifier = modifier.height(250.dp)){
            Image(painter = holdingitems.painter, contentDescription =holdingitems.contentdecsciption,
                modifier= modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop //-> center cropping
            )
            // One of our goal is to place the text in the left bottom as in the alignment so that we cannot acheive by keeping the text in the current box composable
            // so we just use another box and give it an alignment which would be apply to our text.

            Box(modifier=modifier.fillMaxSize().background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    )
                )
            ))

            Box(modifier = modifier
                .fillMaxSize()
                .padding(12.dp),
               contentAlignment = Alignment.BottomStart
                ){
                Text(text =holdingitems.title, style= TextStyle(color= Color.White), fontSize = 15.sp, fontWeight = FontWeight.Bold)

            }



        }

    }

}


@Composable
fun VerticalImageView(imagelist:List<ImageItems>){
    LazyRow{
        items(imagelist.size){
            Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                ImageCard(
                    imagelist[it]
                )
            }
        }
    }
}




