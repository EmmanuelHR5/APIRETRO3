package com.example.apiretro.component
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.apiretro.model.GameList
import com.example.apiretro.utils.Constants.Companion.CUSTOM_BLACK

@OptIn(ExperimentalStdlibApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title:String,showBackButton:Boolean = false,
               onClickBackButton:()-> Unit,
               onClickAction :()->Unit) {
    TopAppBar(
        title={Text(text=title,
            color=Color.White,
            fontWeight = FontWeight.Bold)},
        colors= TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(CUSTOM_BLACK)
        ), navigationIcon =  {
            if (showBackButton) {
                IconButton(onClick = { onClickBackButton() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        tint = Color.White
                    )
                }
            }
        },
        actions= {
            if(!showBackButton){
                IconButton(onClick = { onClickAction() }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
            }
        }
    )
}

@Composable
fun CardGame(game: GameList, onClick:()->Unit){

}