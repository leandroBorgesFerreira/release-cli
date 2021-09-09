import com.github.ajalt.clikt.core.CliktCommand
import output.Printer
import output.StdoutPrinter

class GenerateRelease : CliktCommand() {

    private val printer: Printer = StdoutPrinter()

    override fun run() {
        printer.print("Command will come here")
    }
}

fun main(args: Array<String>) = GenerateRelease().main(args)