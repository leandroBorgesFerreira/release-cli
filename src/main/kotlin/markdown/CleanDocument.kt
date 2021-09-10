package markdown

import extensions.toDocument
import markdown.parser.isStartOfProject
import model.Document
import model.Project
import model.Section

fun Document.clean(): Document =
    removeEmptyProjects()
        .map { project -> project.removeEmptySections() }
        .toDocument()

fun Document.removeEmptyProjects(): List<Project> =
    filter { project ->
        project.flatten().any { line ->
            line.startsWith("-")
        }
    }

fun List<Section>.removeEmptySections(): List<Section> =
    filter { section ->
        section.any { line ->
            line.startsWith("-") || isStartOfProject(line)
        }
    }