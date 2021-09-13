import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file
import markdown.clean
import output.StdoutPrinter
import markdown.parser.parseReleaseDocument
import output.print

class GenerateRelease : CliktCommand() {
    override fun run() = Unit
}

class ParseUnreleadChangelog: CliktCommand(help="Parses the unreleased changeg .md file")  {
    private val file by argument(help="Path of file").file(mustBeReadable = true, mustExist = true)

    override fun run() {
        parseReleaseDocument(file)
            .clean()
            .print(StdoutPrinter())
    }
}

class KtlintSelected: CliktCommand(help="Applies ktlint only in the selected modules ")  {

    override fun run() {
        echo("To implement")
    }
}

fun main(args: Array<String>) = GenerateRelease()
    .subcommands(ParseUnreleadChangelog(), KtlintSelected())
    .main(args)