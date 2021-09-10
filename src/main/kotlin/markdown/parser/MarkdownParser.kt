package markdown.parser

import model.Document
import model.Project
import model.Section

fun parseReleaseDocument(lines: List<String>): Document {
    val document = Document(mutableListOf())
    var isCurrentProjectValid = false
    var isCurrentSectionValid = false

    var currentProjectSections = mutableListOf<Section>()
    var currentSectionLines = mutableListOf<String>()

    lines.forEachIndexed { i, line ->
        when {
            isStartOfProject(line) || i == lines.lastIndex -> {
                if (i == lines.lastIndex) {
                    currentSectionLines.add(line)
                }

                currentProjectSections.add(Section(currentSectionLines))
                val project = Project(currentProjectSections)
                document.add(project)

//                println("Project -----")
//                printProject(project)
//                println("Project end -----")

                currentSectionLines = mutableListOf(line)
                currentProjectSections = mutableListOf()
            }

            isStartOfSection(line) -> {
                currentProjectSections.add(Section(currentSectionLines))
                currentSectionLines = mutableListOf(line)
            }

            line.startsWith("-") -> {
                currentSectionLines.add(line)
            }
        }
    }

    return document
}

fun isStartOfProject(line: String) = line.startsWith("##") && !line.startsWith("###")

fun isStartOfSection(line: String) = line.startsWith("###")

private fun printProject(project: Project) {
    project.flatten().forEach(::println)
}