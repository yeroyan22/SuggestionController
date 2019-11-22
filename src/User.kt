class User(val id: String, val username: String, val name: String, val surname: String) {
    override fun toString(): String = ("id = $id, username = $username, name = $name, surname = $surname")
}