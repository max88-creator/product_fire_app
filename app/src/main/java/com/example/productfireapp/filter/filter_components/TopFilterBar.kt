package com.example.productfireapp.filter.filter_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.R
import com.example.productfireapp.ui.theme.AppFontFamily

@Composable
fun TopFilterBar(
    backToHomeScreenClick: () -> Unit,
    filterOrRefresh: Boolean,
    refreshClick: () -> Unit,
    returnToSort: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        ) {
            Spacer(modifier = Modifier.height(63.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .width(23.dp)
                        .height(16.dp)
                        .clickable {
                            backToHomeScreenClick()
                        }
                )
                Spacer(modifier = Modifier.width(98.dp))
                Text(
                    text = "Apply Filters",
                    style = TextStyle(
                        fontFamily = AppFontFamily,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                Spacer(modifier = Modifier.width(113.dp))
                if (filterOrRefresh) {
                    Image(
                        painter = painterResource(R.drawable.ic_sort),
                        contentDescription = null,
                        modifier = Modifier
                            .width(19.dp)
                            .height(17.dp)
                            .clickable {
                                returnToSort()
                            }
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.ic_reload_button),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .clickable {
                                refreshClick()
                            }
                    )

                }
            }
            Spacer(modifier = Modifier.height(23.dp))
        }
    }
}