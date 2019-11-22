import java.lang.IllegalArgumentException

open class UserSuggestionController : SuggestionController<User>() {
    override fun search(keyword: String): List<String> {
        val userNameList = mutableListOf<String>()
        for (user in userList) {
            if (user.name.toLowerCase().contains(keyword.toLowerCase()) ||
                user.surname.toLowerCase().contains(keyword.toLowerCase())
            ) {
                userNameList.add(user.username)
            }
        }
        return userNameList
    }

    override fun selectedUser(chosenKeyword: String): User? {
        for (user in userList) {
            if (user.username.toLowerCase() == chosenKeyword.toLowerCase()) {
                return user
            }
        }
        return null ?: throw IllegalArgumentException("No such username")

    }

    override fun recent(recentKeyword: String): List<String> {
        val recentHashtags = mutableListOf<String>()
        recentHashtags.add(recentKeyword)
        return recentHashtags
    }
}
