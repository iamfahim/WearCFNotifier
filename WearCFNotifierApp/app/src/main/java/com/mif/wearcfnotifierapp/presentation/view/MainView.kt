package com.mif.wearcfnotifierapp.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.items
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.mif.wearcfnotifierapp.presentation.model.ItemData
import com.mif.wearcfnotifierapp.presentation.theme.WearCFNotifierAppTheme
import com.mif.wearcfnotifierapp.presentation.viewmodel.ContestItemViewModel

@Composable
fun WearCFNotifierApp(viewModel: ContestItemViewModel) {
    WearCFNotifierAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            LazyColumnCFContestItem(viewModel)
        }
    }
}

@Composable
fun LazyColumnCFContestItem(viewModel: ContestItemViewModel) {
    LazyColumnWithRoundedCorners(viewModel)
}

@Composable
fun LazyColumnWithRoundedCorners(viewModel: ContestItemViewModel) {
    val itemsData = viewModel.contestItemData.observeAsState()
    val isLoadingData = viewModel.isLoading.observeAsState()

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

        item {
            Button(onClick = {
                viewModel.getContestItemData()
            }) {
                Text(text = "Get")
            }
        }

        if (isLoadingData.value == true) {
            item {
                CircularProgressIndicator()
            }
        } else {
            itemsData.value?.let {
                items(it) { data ->
                    ItemCard(data)
                }
            }
        }
    }
}

@Composable
fun ItemCard(item: ItemData) {
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