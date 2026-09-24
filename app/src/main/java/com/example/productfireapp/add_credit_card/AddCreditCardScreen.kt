package com.example.productfireapp.add_credit_card

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
import androidx.compose.material3.Scaffold
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
import com.example.productfireapp.payment_method.CardNumberBox
import com.example.productfireapp.payment_method.CustomSwitch
import com.example.productfireapp.payment_method.CvvRow
import com.example.productfireapp.payment_method.data_text_fields.CvvTF
import com.example.productfireapp.payment_method.MonthYearRow
import com.example.productfireapp.payment_method.NameOnTheCartBox

@Composable
@Preview(showBackground = true)
fun AddCreditCardScreen() {
    var numberOnCard by remember { mutableStateOf("XXXX XXXX XXXX XXXX") }
    var nameOnCard by remember { mutableStateOf("CARDS OWNER") }
    var monthValueOnCard by remember { mutableStateOf("00") }
    var yearOnCard by remember { mutableStateOf("00") }
    var isNameTyping by remember { mutableStateOf(false) }
    var isNumberTyping by remember { mutableStateOf(false) }
    var isMonthYearTyping by remember { mutableStateOf(false) }
    var isCvvTyping by remember { mutableStateOf(false) }
    var nameValue by remember { mutableStateOf("") }
    var cvvValue by remember { mutableStateOf("") }
    var cardNumberValue by remember { mutableStateOf("") }
    var monthValue by remember { mutableStateOf("") }
    var yearValue by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            AddCardTopBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 17.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(33.dp))
            AddCardImage(
                numberOnCard = numberOnCard,
                nameOnCard = nameOnCard,
                monthValueOnCard = monthValueOnCard,
                yearValueOnCard = yearOnCard
            )
            Spacer(modifier = Modifier.height(18.dp))
            if (isNameTyping) {
                AddNameOnCardTf(
                    value = nameValue,
                    onValueChange = {
                        nameValue = it
                    },
                    onSaveClick = {}
                )
            } else {
                Box(
                    modifier = Modifier
                        .clickable {
                            isNameTyping = true
                        }
                ) {
                    NameOnTheCartBox()
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            if (isNumberTyping) {
                CardNumberTF(
                    value = cardNumberValue,
                    onValueChange = {
                        cardNumberValue = it
                    }
                )
            } else {
                Box(
                    modifier = Modifier
                        .clickable {
                            isNumberTyping = true
                        }
                ) {
                    CardNumberBox()
                }
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                if (isMonthYearTyping) {
                    MonthYearTF(
                        month = monthValue,
                        onMonthValueChange = {
                            monthValue = it
                        },
                        year = yearValue,
                        onYearValueChange = {
                            yearValue = it
                        }
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .clickable {
                                isMonthYearTyping = true
                            }
                    ) {
                        MonthYearRow()
                    }
                }
                Spacer(modifier = Modifier.width(6.dp))
                if (isCvvTyping) {
                    CvvTF(
                        cvvValue = cvvValue,
                        onMonthValueChange = {
                            cvvValue = it
                        }
                    )
                } else {
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

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 34.dp)
            ) {
               CustomSwitch()
                val space = 17.sp * 0.03f
                Spacer(modifier = Modifier.width(25.dp))
                Text(
                    text = "Save this card",
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight(500),
                        letterSpacing = space
                    )
                )
            }
            Spacer(modifier = Modifier.height(170.dp))
            AddCreditCardButton()
        }
    }
}

