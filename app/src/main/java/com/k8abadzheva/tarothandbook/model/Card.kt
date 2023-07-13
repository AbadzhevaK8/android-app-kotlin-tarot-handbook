package com.k8abadzheva.tarothandbook.model

import com.k8abadzheva.tarothandbook.R

data class Card(
    val id: Int,
    val titleResourceId: Int,
    val interpretationResourceId: Int,
    val arcanaResourceId: Int,
    val imageResourceId: Int
)
