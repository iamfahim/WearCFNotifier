package com.mif.wearcfnotifierapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.items
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.mif.wearcfnotifierapp.presentation.theme.WearCFNotifierAppTheme

class WearCFNotifierBaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            WearCFNotifierApp()
        }
    }
}

@Composable
fun WearCFNotifierApp() {
    WearCFNotifierAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            LazyColumnCFContestItem()
        }
    }
}

@Composable
fun LazyColumnCFContestItem() {
    LazyColumnWithRoundedCorners()
}

@Composable
fun LazyColumnWithRoundedCorners() {
    val items = listOf(
        Item("Item 1", "CF Contest"),
        Item("Item 2", "CF Contest"),
        Item("Item 3", "CF Contest"),
        Item("Item 4", "CF Contest"),
        Item("Item 5", "CF Contest"),
        Item("Item 6", "CF Contest"),
        Item("Item 7", "CF Contest"),
        Item("Item 8", "CF Contest"),
        Item("Item 9", "CF Contest"),
        Item("Item 10", "CF Contest"),
        Item("Item 11", "CF Contest"),
        Item("Item 12", "CF Contest"),
        Item("Item 13", "CF Contest"),
        Item("Item 14", "CF Contest")
    )

    ScalingLazyColumn(
        contentPadding = PaddingValues(horizontal = 3.dp),
        autoCentering = AutoCenteringParams(itemOffset = 30)
    ) {
        item {
            Text(
                "Upcoming contests",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.title3
            )
        }
        items(items) { item ->
            ItemCard(item)
        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Card(
        onClick = { onClick() },
        shape = RoundedCornerShape(25.dp) // Adjust the corner radius as needed
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.caption2,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.caption3,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

fun onClick() {
    //TODO
}

data class Item(val title: String, val description: String)

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearCFNotifierApp()
}