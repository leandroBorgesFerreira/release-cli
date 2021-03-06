package output

import model.Document
import model.Section

interface Printer {
    fun print(text: String)
}

fun Document.print(printer: Printer) {
    flatten().print(printer)
}

fun List<Section>.print(printer: Printer) {
    forEach { section ->
        section.forEach(printer::print)
        printer.print("")
    }
}
