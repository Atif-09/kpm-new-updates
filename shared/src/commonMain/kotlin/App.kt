import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }

        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            CommonDialog { showImage = true }
            if (showImage) {
                ShowImage("pic1.jpg")
            }
        }
    }
}

@Composable
fun CommonDialog(onOKClick: () -> Unit) {
    var isDialogOpen by remember { mutableStateOf(false) }
    Button(onClick = { isDialogOpen = true }, modifier = Modifier.wrapContentSize()) {
        Text("Open")
    }
    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                Button(onClick = {
                    isDialogOpen = false
                    onOKClick() // Call the callback function to show the image
                }) {
                    Text("OK")
                }
            },
            title = { Text("Alert Dialog") },
            text = { Text("Show cat from shared resources using new compose version for kmp") },
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ShowImage(res: String) {
    Image(
        painterResource(res),
        null
    )
}


expect fun getPlatformName(): String