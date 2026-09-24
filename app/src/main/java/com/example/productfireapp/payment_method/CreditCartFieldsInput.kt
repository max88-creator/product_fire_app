package com.example.productfireapp.payment_method

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.productfireapp.payment_method.data_text_fields.CardNumberTF
import com.example.productfireapp.payment_method.data_text_fields.CvvTF
import com.example.productfireapp.payment_method.data_text_fields.MonthYearTF
import com.example.productfireapp.payment_method.data_text_fields.NameOnCartTF
import com.example.productfireapp.ui.theme.DarkPrimary

@Composable
@Preview(showBackground = true)
fun CreditCartFieldsInput() {

    var isNameTyping by remember { mutableStateOf(false) }
    var isNumberTyping by remember { mutableStateOf(false) }
    var isMonthYearTyping by remember { mutableStateOf(false) }
    var isCvvTyping by remember { mutableStateOf(false) }
    var nameValue by remember { mutableStateOf("") }
    var cvvValue by remember { mutableStateOf("") }
    var cardNumberValue by remember { mutableStateOf("") }
    var monthValue by remember { mutableStateOf("") }
    var yearValue by remember { mutableStateOf("") }
    var numberOnCard by remember { mutableStateOf("XXXX XXXX XXXX XXXX") }
    var nameOnCard by remember { mutableStateOf("OWNERS NAME") }
    var monthOnCard by remember { mutableStateOf("00 / ") }
    var yearOnCard by remember { mutableStateOf("00") }

    var isChecked by remember { mutableStateOf(false) }

    Column(
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
                        nameOnCard = nameValue
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
                    onValueChange = { cardNumberValue = it },
                    onSaveClick = {}
                )
                Spacer(modifier = Modifier.height(51.dp))
                Button(
                    onClick = {
                        isNumberTyping = false
                        numberOnCard = cardNumberValue
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
            } else if (isMonthYearTyping) {
                Spacer(modifier = Modifier.height(31.dp))
                MonthYearTF(
                    month = monthValue,
                    onMonthValueChange = { monthValue = it },
                    year = yearValue,
                    onYearValueChange = { yearValue = it }
                )
                Spacer(modifier = Modifier.height(51.dp))
                Button(
                    onClick = {
                        isMonthYearTyping = false
                        monthOnCard = monthValue
                        yearOnCard = yearValue
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
            } else if (isCvvTyping) {
                Spacer(modifier = Modifier.height(31.dp))
                CvvTF(
                    cvvValue = cvvValue,
                    onMonthValueChange = { cvvValue = it }
                )
                Spacer(modifier = Modifier.height(51.dp))
                Button(
                    onClick = {
                        isCvvTyping = false
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
                Spacer(modifier = Modifier.height(14.dp))
                CreditCardImage(
                    numberOnCard = numberOnCard,
                    nameOnCard = nameOnCard,
                    monthValueOnCard = monthOnCard,
                    yearValueOnCard = yearOnCard
                )
                Spacer(modifier = Modifier.height(14.dp))
                Box(
                    modifier = Modifier
                        .clickable {
                            isNameTyping = true
                        }
                ) {
                    NameOnTheCartBox()
                }

                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .clickable {
                            isNumberTyping = true
                        }
                ) {
                    CardNumberBox()
                }
                Spacer(modifier = Modifier.height(3.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .clickable {
                                isMonthYearTyping = true
                            }
                    ) {
                        MonthYearRow()
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .clickable {
                                isCvvTyping = true
                            }
                    ) {
                        CvvRow()
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 34.dp)
        ) {
           CustomSwitch()
            val space = 12.sp * 0.03f
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = "Save this card",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = space
                )
            )
        }
        Spacer(modifier = Modifier.height(19.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        ) {
            MakePaymentButton()
        }
    }
}
