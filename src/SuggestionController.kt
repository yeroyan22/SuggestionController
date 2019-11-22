abstract class SuggestionController<T> {
    abstract fun search(keyword: String): List<String>
    abstract fun recent(recentKeyword: String): List<String>
    open fun selectedUser(chosenKeyword: String): User? {
        return null
    }

    open fun selectedTag(chosenKeyword: String): Tag? {
        return null
    }
}