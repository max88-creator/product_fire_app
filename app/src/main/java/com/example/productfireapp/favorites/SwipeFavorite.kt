package com.example.productfireapp.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.productfireapp.R
import com.example.productfireapp.domain.models.Favorite
import com.example.productfireapp.ui.theme.SwipeBoxColor

@Composable
fun SwipeFavorite(
    favorite: Favorite,
    onDeleteClick: () -> Unit
) {
val dismissState = rememberSwipeToDismissBoxState(
    confirmValueChange = { value ->
        if (value == SwipeToDismissBoxValue.EndToStart) {
            onDeleteClick()
            true
        } else {
            false
        }
    }
)
    SwipeToDismissBox(
        state = dismissState,
        modifier = Modifier
            .fillMaxWidth(),
        backgroundContent = {
           Box(
               modifier = Modifier
                .fillMaxSize()
                .background(SwipeBoxColor)
                .padding(12.dp),
            contentAlignment = Alignment.CenterEnd
            ) {
               Image(
                   painter = painterResource(R.drawable.swipe_bascket),
                   contentDescription = null,
                   modifier = Modifier
                       .width(23.dp)
                       .height(28.dp)
               )
           }
        },
        content = {
            FavoriteItem(favorite)
        },
        enableDismissFromStartToEnd = false
    )
}