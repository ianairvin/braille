package ru.braille.presentation.repeat_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.braille.ui.theme.InterFamily

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HelpSurface (
    openAlertDialog: MutableState<Boolean>
){
    BasicAlertDialog(onDismissRequest = {
        openAlertDialog.value = false
    }) {
        Surface(
            modifier = Modifier
                .width(140.dp)
                .height(360.dp)
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.large,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Повторение №1: сразу после изучения",
                    fontFamily = InterFamily,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Повторение №2: через 1 час",
                    fontFamily = InterFamily,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Повторение №3: через 3 часа",
                    fontFamily = InterFamily,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Повторение №4: через 8 часов",
                    fontFamily = InterFamily,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Повторение №5: через 24 часа",
                    fontFamily = InterFamily,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Повторение №6: через 2 дня",
                    fontFamily = InterFamily,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Повторение №7: через 1 неделю",
                    fontFamily = InterFamily,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Повторение №8: через 2 недели",
                    fontFamily = InterFamily,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}