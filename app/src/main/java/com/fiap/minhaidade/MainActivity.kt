package com.fiap.minhaidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.minhaidade.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MinhaIdade()
                }
            }
        }
    }
}

@Composable
fun MinhaIdade(modifier: Modifier = Modifier) {
    val idade = remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            color = Color.Red,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            text = "Qual a sua idade?",
            modifier = modifier
        )
        Text (
            text = "Aperte os botões para inserir sua idade",
            modifier = modifier
        )
        Spacer(modifier.height(20.dp))
        Text (
            text = "${idade.value}",
            modifier = modifier
        )
        Spacer(modifier.height(20.dp))
        Row {
            Button(
                onClick = { idade.value-- },
                shape = RoundedCornerShape(8.dp),
                modifier = modifier.size(84.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
            ) {
                Text(text = "-", fontSize = 24.sp)
            }
            Spacer(modifier.width(20.dp))
            Button(
                onClick = { idade.value++ },
                shape = RoundedCornerShape(8.dp),
                modifier = modifier.size(84.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))) {
                Text(text = "+", fontSize = 24.sp)
            }
        }
        Spacer(modifier.height(40.dp))

        VerificaEhMaiorDeIdade(idade.value)
    }
}

@Composable
fun VerificaEhMaiorDeIdade(idade:Int) {
    Row (horizontalArrangement = Center) {
        if (idade <= 0) Text("Por enquanto ainda é menor de idade!", fontSize = (16.sp))
        else if (idade >= 18)
            Text("É maior de idade!", fontSize = (24.sp))
        else Text("Você já é maior de idade...", fontSize = 24.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MinhaIdadePreview() {
    MyApplicationTheme {
        MinhaIdade()
    }
}