package markdown

import model.Document

fun Document.cleanLines(): List<String> =
    filter { project ->
        project.flatten().any { line ->
            line.startsWith("-")
        }
    }.flatten().flatten()
