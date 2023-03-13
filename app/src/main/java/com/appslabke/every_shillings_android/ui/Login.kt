import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.togitech.ccp.component.*

@Composable
fun Login() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val phoneNumber = rememberSaveable { mutableStateOf("") }
        val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
        val onlyPhoneNumber = rememberSaveable { mutableStateOf("") }

            Text(
            text = "Login",
            color = Color(0xFF2B5EC0),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Enter your phone number",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "We will send you the four digit verification code",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(70.dp))
        TogiCountryCodePicker(
            text = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            unfocusedBorderColor = MaterialTheme.colors.primary,
            bottomStyle = false, //  if true the text-field is below the country code selector at the top.
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                if (!isPhoneNumber()) {
                    fullPhoneNumber.value = getFullPhoneNumber()
                    onlyPhoneNumber.value = getOnlyPhoneNumber()
                } else {
                    fullPhoneNumber.value = "Error"
                    onlyPhoneNumber.value = "Error"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF2B5EC0),
                contentColor = Color.White
            )
        ) {
            Text(text = "Generate OTP", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "Sign up",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color(0xFF2B5EC0),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {
                    /*TODO()*/
                }
            )
        }
    }
}

