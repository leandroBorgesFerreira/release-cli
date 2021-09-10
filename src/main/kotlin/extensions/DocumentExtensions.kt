package extensions

import model.Document
import model.Project
import model.Section

fun List<List<Section>>.toDocument(): Document =
    this.map { sections ->
        Project(sections.toMutableList())
    }.let { projects ->
        Document(projects.toMutableList())
    }
