import java.lang.IllegalArgumentException

open class TagSuggestionController : SuggestionController<Tag>() {
    override fun search(keyword: String): List<String> {
        val hashtagslist = mutableListOf<String>()
        for (tag in tagList) {
            if (tag.hashtag.toLowerCase().contains(keyword.toLowerCase())) {
                hashtagslist.add(tag.hashtag)
            }
        }
        return hashtagslist
    }

    override fun selectedTag(chosenKeyword: String): Tag? {
        for (tag in tagList) {
            if (tag.hashtag.toLowerCase() == chosenKeyword.toLowerCase()) {
                return tag
            }
        }
        return null ?: throw IllegalArgumentException("No such hashtag")
    }

    override fun recent(recentKeyword: String): List<String> {
        val recentUsers = mutableListOf<String>()
        recentUsers.add(recentKeyword)
        return recentUsers
    }
}
