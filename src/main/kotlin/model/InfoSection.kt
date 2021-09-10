package model

class InfoSection(
    val infoList: MutableList<Info>,
    var parent: InfoSection? = null
) : Info, MutableList<Info> by infoList