package markdown

fun sectionLevel(line: String) : Int {
    val trimmedLine = line.trim()
    var i = 0

    while (trimmedLine[i] == '#') i++

    return i
}