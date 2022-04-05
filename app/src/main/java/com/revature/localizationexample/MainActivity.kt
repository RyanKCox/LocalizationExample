package com.revature.localizationexample

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.localizationexample.ui.theme.LocalizationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalizationExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Screen()
                }
            }
        }
    }
}
@Composable
fun Screen(){

    Scaffold(
        topBar = {
            TopAppBar(title = {Text(stringResource(id = R.string.app_name))})
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                
                Spacer(modifier = Modifier.size(20.dp))
                
                MultiLineText(
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .border(
                            width = 2.dp,
                            Color.Black,
                            shape = RoundedCornerShape(2.dp)
                        )
                        .padding(5.dp),
                    sLine1 = stringResource(id = R.string.TC),
                    sLine3 = stringResource(id = R.string.AboutUs),
                    sLine4 = "Line not using String Resource, no language change"
                )
            }

        }
    )
}
@Composable
fun MultiLineText(modifier:Modifier = Modifier,sLine1:String="",sLine2:String = "",sLine3:String = "",sLine4:String =""){

        Text(
            text = "$sLine1 \n$sLine2 \n$sLine3\n$sLine4",
            modifier = modifier,
            style = MaterialTheme.typography.h5
        )
}

@Preview
@Composable
fun Preview(){
    LocalizationExampleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Screen()
        }
    }
}