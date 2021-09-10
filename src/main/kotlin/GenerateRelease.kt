import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file
import extensions.print
import output.StdoutPrinter
import parser.parseReleaseDocument

class GenerateRelease : CliktCommand() {
    private val file by argument(help="Path of file").file(mustBeReadable = true, mustExist = true)

    override fun run() {
        echo("File path: ${file.absolutePath}\n")

        parseReleaseDocument(file.readLines()).print(StdoutPrinter())
    }
}

fun main(args: Array<String>) = GenerateRelease().main(args)