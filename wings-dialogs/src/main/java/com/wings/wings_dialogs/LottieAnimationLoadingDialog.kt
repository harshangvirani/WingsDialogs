package com.wings.wings_dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimatedLDDialog(
    onDismiss: () -> Unit,
    horizontalDialog: Boolean
) {
    var isSpeed by remember {
        mutableStateOf(1f)
    }

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.loading_animation)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        speed = isSpeed,
        isPlaying = true,
        restartOnPlay = false
    )

    Dialog(
        onDismissRequest = { onDismiss },
    ) {
        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
        ) {
            if (horizontalDialog) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    LottieAnimation(
                        modifier = Modifier.size(30.dp),
                        composition = composition,
                        progress = { progress },
                        alignment = Alignment.TopStart
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Please wait...")
                }
            } else {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LottieAnimation(
                        modifier = Modifier.size(30.dp),
                        composition = composition,
                        progress = { progress },
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Please Wait...")
                }
            }
        }
    }
}