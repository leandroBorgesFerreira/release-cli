package output

import model.Document

interface Printer {

    fun print(text: String)
}

fun Document.print(printer: Printer) {
    flatten().flatten().forEach(printer::print)
}

fun List<String>.print(printer: Printer) {
    forEach(printer::print)
}
