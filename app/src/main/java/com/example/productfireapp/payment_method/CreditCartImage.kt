package com.example.productfireapp.payment_method

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import com.example.productfireapp.ui.theme.AppFontFamily
import com.example.productfireapp.ui.theme.DarkPrimary
import com.example.productfireapp.ui.theme.RedCircle
import com.example.productfireapp.ui.theme.YellowCircle

@Composable
@Preview(showBackground = true)
fun CreditCartImage() {

    var isNameTyping by remember { mutableStateOf(false) }
    var isNumberTyping by remember { mutableStateOf(false) }

    var nameValue by remember { mutableStateOf("") }
    var cardNumberValue by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isNameTyping) {
                Spacer(modifier = Modifier.height(31.dp))
                NameOnCartTF(
                    value = nameValue,
                    onValueChange = { nameValue = it }
                )
                Spacer(modifier = Modifier.height(51.dp))
                Button(
                    onClick = {
                        isNameTyping = false
                    }
                ) {
                    Text(
                        text = "Save",
                        style = TextStyle(
                            color = DarkPrimary,
                            fontSize = 19.sp,
                            fontWeight = FontWeight(700)
                        )
                    )
                }
            } else if (isNumberTyping) {
                Spacer(modifier = Modifier.height(31.dp))
                CardNumberTF(
                    value = cardNumberValue,
                    onValueChange = { cardNumberValue = it }
                )
                Spacer(modifier = Modifier.height(51.dp))
                Button(
                    onClick = {
                        isNumberTyping = false
                    }
                ) {
                    Text(
                        text = "Save",
                        style = TextStyle(
                            color = DarkPrimary,
                            fontSize = 19.sp,
                            fontWeight = FontWeight(700)
                        )
                    )
                }
            } else {
                Spacer(modifier = Modifier.height(18.dp))
                Box(
                    modifier = Modifier
                        .width(380.dp)
                        .height(189.dp)
                        .background(
                            color = DarkPrimary,
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 16.dp, start = 47.dp)
                            .size(34.dp)
                            .background(
                                YellowCircle,
                                shape = CircleShape
                            )
                    )
                    Box(
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                start = 21.dp
                            )
                            .size(34.dp)
                            .background(
                                color = RedCircle,
                                shape = CircleShape
                            )
                    )

                    Column(
                        modifier = Modifier
                            .padding(
                                top = 143.dp,
                                start = 21.dp
                            )
                    ) {
                        Text(
                            text = "CARD HOLDER",
                            style = TextStyle(
                                color = Color.White,
                                fontFamily = AppFontFamily,
                                fontSize = 10.sp,
                                fontWeight = FontWeight(500)
                            )
                        )
                        Text(
                            text = if (nameValue.isEmpty()) {
                                "OWNERS NAME"
                            } else{
                                nameValue.uppercase()
                            },
                            style = TextStyle(
                                color = Color.White,
                                fontFamily = AppFontFamily,
                                fontSize = 10.sp,
                                fontWeight = FontWeight(500)
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                Box(
                    modifier = Modifier
                        .clickable {
                            isNameTyping = true
                        }
                ) {
                    NameOnTheCartBox()
                }

                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .clickable {
                            isNumberTyping = true
                        }
                ) {
                    CardNumberBox()
                }
            }
        }
    }
}
