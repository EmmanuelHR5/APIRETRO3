package com.example.apiretro.component
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.apiretro.utils.Constants.Companion.CUSTOM_BLACK

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun MainTopBar(title:String,showBackButton:Boolean = false,
               onClickBackButton:()-> Unit,
               onClickAction :()->Unit) {
    TopAppBar(
        title={
            Text(text=title,
                color=Color.White,
                fontWeight = FontWeight.Bold)
        },
        colors= TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(CUSTOM_BLACK)
        )

    )

}