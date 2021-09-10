//package parser
//
//import com.github.ajalt.clikt.output.TermUi.echo
//import model.Document
//import model.Section
//import java.io.File
//
//fun parseRelease(file: File): Document {
//    val document = Document(mutableListOf())
//    var isSectionValid = false
//
//    var currentSectionLines = mutableListOf<String>()
//
//    file.forEachLine { line ->
//        when {
//            isStartOfSection(line) && isSectionValid -> {
//                document.sections.add(Section(currentSectionLines))
//                isSectionValid = false
//                currentSectionLines = mutableListOf()
//            }
//
//            line.startsWith("-") -> {
//                isSectionValid = true
//                currentSectionLines.add(line)
//            }
//        }
//    }
//
//    return document
//}
//
//private fun isStartOfSection(line: String) = line.startsWith("##") && !line.startsWith("###")
