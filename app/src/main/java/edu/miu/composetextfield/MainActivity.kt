package edu.miu.composetextfield

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.miu.composetextfield.ui.theme.ComposeTextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTextFieldTheme {
                Scaffold { innerPadding ->
                    Registration(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Registration(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        //remember is a function to remember the state across recomposition(UI rendering)
//                        var text: MutableState<String> = remember {
//                            mutableStateOf("sample") //create a mutable state object
//                        }
//                        TextField(
//                            value = text.value,
//                            onValueChange = {data -> text.value = data},
//                            modifier = Modifier.fillMaxWidth()
//                        )
        //property delegation (by)
        var universityName by remember { mutableStateOf("") }
        TextField(
            value = universityName,
            onValueChange = { universityName = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("University Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        var firstName by remember { mutableStateOf("") }
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("First Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        var lastName by remember { mutableStateOf("") }
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Last Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        val context = LocalContext.current
        Button(
            onClick = {
                //do something
                Toast.makeText(context, "$universityName: $firstName $lastName @ $email", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationPreview() {
    ComposeTextFieldTheme {
        Registration()
    }
}