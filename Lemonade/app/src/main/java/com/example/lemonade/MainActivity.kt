package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeTextAndImage(modifier: Modifier = Modifier) {

    var etapaAtual by remember { mutableStateOf(1) }
    var espremidas by remember { mutableStateOf(0) }
    val imagemResource = when (etapaAtual) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textoResource = when (etapaAtual) {
        1 -> R.string.lemon_select
        2 -> R.string.lemon_squeeze
        3 -> R.string.lemon_drink
        else -> R.string.lemon_empty_glass
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(imagemResource),
            contentDescription = stringResource(textoResource),
            modifier = Modifier.clickable {
                when (etapaAtual) {
                    1 -> {
                        etapaAtual = 2
                        espremidas = (2..4).random()
                    }
                    2 -> {
                        espremidas--
                        if (espremidas == 0) {
                            etapaAtual = 3
                        }
                    }
                    3 -> {
                        etapaAtual = 4
                    }
                    4 -> {
                        etapaAtual = 1
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(textoResource),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LemonadeTextAndImage()
    }
}