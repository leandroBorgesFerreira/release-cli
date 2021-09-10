package extensions

import model.Document
import output.Printer

fun Document.print(printer: Printer) {
    flatten().flatten().forEach(printer::print)
}