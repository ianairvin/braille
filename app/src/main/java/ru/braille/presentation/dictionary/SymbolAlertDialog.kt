package ru.braille.presentation.dictionary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.braille.R
import ru.braille.domain.entities.Symbol

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SymbolAlertDialog (
    openAlertDialog: MutableState<Boolean>,
    symbol: Symbol
){

    AlertDialog(onDismissRequest = {
        openAlertDialog.value = false
    }) {
        Surface(
            modifier = Modifier
                .width(120.dp)
                .height(360.dp)
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.large,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(3f))
                Text(
                    text = symbol.symbol,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (symbol.dot1)
                                R.drawable.fill_circle
                            else R.drawable.outline_circle
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .height(54.dp)
                            .width(54.dp)
                            .padding(6.dp, 0.dp, 6.dp, 0.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        painter = painterResource(
                            id = if (symbol.dot2)
                                R.drawable.fill_circle
                            else R.drawable.outline_circle
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .height(54.dp)
                            .width(54.dp)
                            .padding(6.dp, 0.dp, 6.dp, 0.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (symbol.dot3)
                                R.drawable.fill_circle
                            else R.drawable.outline_circle
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .height(54.dp)
                            .width(54.dp)
                            .padding(6.dp, 0.dp, 6.dp, 0.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        painter = painterResource(
                            id = if (symbol.dot4)
                                R.drawable.fill_circle
                            else R.drawable.outline_circle
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .height(54.dp)
                            .width(54.dp)
                            .padding(6.dp, 0.dp, 6.dp, 0.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (symbol.dot5)
                                R.drawable.fill_circle
                            else R.drawable.outline_circle
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .height(54.dp)
                            .width(54.dp)
                            .padding(6.dp, 0.dp, 6.dp, 0.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Icon(
                        painter = painterResource(
                            id = if (symbol.dot6)
                                R.drawable.fill_circle
                            else R.drawable.outline_circle
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .height(54.dp)
                            .width(54.dp)
                            .padding(6.dp, 0.dp, 6.dp, 0.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.weight(3f))
            }
        }
    }
}