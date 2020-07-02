package com.opah.android.testepan.model

data class VersionInfoModel(
    val patch: String,
    val classes: List<String>,
    val standard: List<String>,
    val types: List<String>,
    val factions: List<String>,
    val races: List<String>,

    val locales: List<String>
)