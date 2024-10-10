package com.mif.wearcfnotifierapp.presentation.model

import kotlinx.coroutines.delay

class ItemDataRepository {
    suspend fun fetchContestItemData() : List<ItemData> {
        delay(3000)
        return listOf(ItemData("Item 1", "CF Contest"),
            ItemData("Item 2", "CF Contest"),
            ItemData("Item 3", "CF Contest"),
            ItemData("Item 4", "CF Contest"),
            ItemData("Item 5", "CF Contest"),
            ItemData("Item 6", "CF Contest"),
            ItemData("Item 7", "CF Contest"),
            ItemData("Item 8", "CF Contest"),
            ItemData("Item 9", "CF Contest"),
            ItemData("Item 10", "CF Contest"),
            ItemData("Item 11", "CF Contest"),
            ItemData("Item 12", "CF Contest"),
            ItemData("Item 13", "CF Contest"),
            ItemData("Item 14", "CF Contest"))
    }
}