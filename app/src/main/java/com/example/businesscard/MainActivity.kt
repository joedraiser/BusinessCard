package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF1b3042)
                ) {
                    BusinessCardDraw("Korchagov Evgenii", "Developer", "+7 (921) 305 59 69", "korchagov@mail.ru", "joedraiser")
                }
            }
        }
    }
}

@Composable
fun BusinessCardDraw(name: String, title: String, phoneNumber: String, email: String, socialMediaLink: String) {
    Column() {
        Spacer(Modifier.height(100.dp))
        DrawNameTitleLogo(name, title)
        Spacer(Modifier.height(100.dp))
        DrawNameContact(
            mail = "korchagov@mail.ru",
            phone = "+7 (921) 305-59-69",
            socialMedia = "no media"
        )
    }
}

@Composable
fun DrawNameTitleLogo(name: String, title: String)
{
    val androidLogoImage = painterResource(R.drawable.android_logo)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth())
    {
        Image(painter = androidLogoImage, contentDescription = null, modifier = Modifier.requiredSize(100 .dp))
        Text(text = name, color = Color.LightGray, fontSize = 36.sp)
        Text(text = title, color = Color.LightGray, fontSize = 20.sp)
    }
}

@Composable
fun DrawNameContact(mail: String, phone: String, socialMedia: String)
{
    val phoneLogo = painterResource(R.drawable.baseline_phone_white_24dp)
    val mailLogo = painterResource(id = R.drawable.baseline_mail_white_24dp)
    val shareLogo = painterResource(id = R.drawable.baseline_share_white_24dp)
    Column(modifier = Modifier.padding(start = 20.dp))
    {
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = phoneLogo, contentDescription = null, modifier = Modifier
                .requiredSize(24.dp)
                .padding(end = 8.dp),
                colorFilter = ColorFilter.tint(color = Color.Green)
            )
            Text(text = phone, color = Color.LightGray, fontSize = 12.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = mailLogo, contentDescription = null, modifier = Modifier
                .requiredSize(24.dp)
                .padding(end = 8.dp),
                colorFilter = ColorFilter.tint(color = Color.Green)
            )
            Text(text = mail, color = Color.LightGray, fontSize = 12.sp)
        }
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = shareLogo, contentDescription = null,
                modifier = Modifier
                    .requiredSize(24.dp)
                    .padding(end = 8.dp),
                colorFilter = ColorFilter.tint(color = Color.Green)
            )
            Text(text = socialMedia, color = Color.LightGray, fontSize = 12.sp)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardDraw("Korchagov Evgenii", "Developer", "+7 (921) 305 59 69", "korchagov@mail.ru", "joedraiser")
    }
}