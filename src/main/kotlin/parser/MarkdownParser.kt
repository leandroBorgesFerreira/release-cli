package parser

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
        currentSectionLines.add(line)

        when {
            isStartOfProject(line) && isCurrentProjectValid || i == lines.lastIndex -> {
                isCurrentProjectValid = false
                isCurrentSectionValid = false
                document.add(Project(currentProjectSections))
                currentSectionLines = mutableListOf()
                currentProjectSections = mutableListOf()
            }

            isStartOfSection(line) && isCurrentSectionValid -> {
                isCurrentSectionValid = false
                currentProjectSections.add(Section(currentSectionLines))
                currentSectionLines = mutableListOf()
            }

            line.startsWith("-") -> {
                isCurrentProjectValid = true
                isCurrentSectionValid = true
            }
        }
    }

    return document
}

private fun isStartOfProject(line: String) = line.startsWith("##") && !line.startsWith("###")

private fun isStartOfSection(line: String) = line.startsWith("###")
