package shankar.lohar20bai10040.task7.ui.views.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shankar.lohar20bai10040.task7.R

@Composable
fun SimpleOffsetStateAnimation() {
    SubtitleText(subtitle = "Animate Offset x,y value")
    Spacer(modifier = Modifier.height(20.dp))
    var enabled by remember { mutableStateOf(true) }
    val animatedOffset by animateOffsetAsState(
        targetValue = if (enabled) Offset(0f, 0f) else Offset(50f, 40f)
    )
    Row(horizontalArrangement = Arrangement.SpaceAround) {
        Image(
            painterResource(id = R.drawable.p1),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
                .offset(x = Dp(animatedOffset.x), y = Dp(animatedOffset.y))
                .clickable { enabled = !enabled }
        )
        Image(
            painterResource(id = R.drawable.p2),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
                .offset(x = -Dp(animatedOffset.x), y = -Dp(animatedOffset.y))
                .clickable { enabled = !enabled }
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun SubtitleText(subtitle: String, modifier: Modifier = Modifier) {
    androidx.compose.material3.Text(text = subtitle, modifier = modifier.padding(8.dp))
}


@Composable
fun DrawLayerWithAnimateAsStateAnimations() {
    TitleText(title = "Float state Animations on graphicsLayer")
    var draw by remember { mutableStateOf(false) }

    Spacer(modifier = Modifier.padding(30.dp))
    var draw2 by remember { mutableStateOf(false) }

    Box {
        Image(
            painter = painterResource(id = R.drawable.adele21),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer(
                    shadowElevation = animateFloatAsState(if (draw2) 30f else 5f).value,
                    translationX = animateFloatAsState(if (draw2) 320f else 0f).value,
                    translationY = 0f,
                )
                .clickable(onClick = { draw2 = !draw2 })
        )
        Image(
            painter = painterResource(id = R.drawable.dualipa),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer(
                    shadowElevation = animateFloatAsState(if (draw2) 30f else 10f).value,
                    translationX = animateFloatAsState(if (draw2) -320f else 0f).value,
                    translationY = animateFloatAsState(if (draw2) 0f else 30f).value
                )
                .clickable(onClick = { draw2 = !draw2 })
        )
        Image(
            painter = painterResource(id = R.drawable.edsheeran),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer(
                    shadowElevation = animateFloatAsState(if (draw2) 30f else 5f).value,
                    translationY = animateFloatAsState(if (draw2) 0f else 50f).value
                )
                .clickable(onClick = { draw2 = !draw2 })
        )
    }
}
@Composable
fun TitleText(modifier: Modifier = Modifier, title: String) {
    androidx.compose.material3.Text(
        text = title,
        modifier = modifier.padding(8.dp)
    )
}