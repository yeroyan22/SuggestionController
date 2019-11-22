fun main(args: Array<String>) {

    println("Search username or hashtag using @ or #")

    val tagSuggestionController: SuggestionController<Tag> = TagSuggestionController()
    val userSuggestionController: SuggestionController<User> = UserSuggestionController()
    val inputKeyword = readLine().toString()

    if (inputKeyword == "#" || inputKeyword == "@") {
        println("Please insert any keyword after # or @")
        return
    }

    when {
        inputKeyword[0].toString() == "#" -> println("Result: ${tagSuggestionController.search(inputKeyword[1].toString())}")
        inputKeyword[0].toString() == "@" -> println("Result: ${userSuggestionController.search(inputKeyword[1].toString())}")
        else -> {
            println("Your search should start with either @ or #")
            return
        }
    }

    println("Choose one of the above")
    val chosenKeyword = readLine().toString()
    when {
        inputKeyword[0].toString() == "@" -> println(userSuggestionController.selectedUser(chosenKeyword).toString())
        else -> println(tagSuggestionController.selectedTag(chosenKeyword).toString())
    }

    val newKeyword = readLine().toString()
    when {
        newKeyword == "@" && inputKeyword[0].toString() == "@" -> println(
            "Result: ${userSuggestionController.recent(
                chosenKeyword
            )}"
        )
        newKeyword == "#" && inputKeyword[0].toString() == "#" -> println(
            "Result: ${tagSuggestionController.recent(
                chosenKeyword
            )}"
        )
        newKeyword == "@" && inputKeyword[0].toString() == "#" -> println("Please insert any keyword after # or @")
        newKeyword == "#" && inputKeyword[0].toString() == "@" -> println("Please insert any keyword after # or @")
        newKeyword[0].toString() == "#" && newKeyword.length != 1 -> println(
            "Result: ${tagSuggestionController.search(
                inputKeyword[1].toString()
            )}"
        )
        newKeyword[0].toString() == "@" && newKeyword.length != 1 -> println(
            "Result: ${userSuggestionController.search(
                inputKeyword[1].toString()
            )}"
        )
        else -> {
            println("Your search should start with either @ or #")
            return
        }
    }
}