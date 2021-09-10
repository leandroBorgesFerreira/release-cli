package extensions

import model.Document
import output.Printer

fun Document.print(printer: Printer) {
    sections.flatMap { section -> section.lines }.forEach(printer::print)
}