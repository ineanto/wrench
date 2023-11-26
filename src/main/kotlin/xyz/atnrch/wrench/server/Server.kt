package xyz.atnrch.wrench.server

import xyz.atnrch.wrench.Wrench
import xyz.atnrch.wrench.logger.Logger
import java.io.File
import java.util.*
import kotlin.random.Random

class Server internal constructor(var name: String, var type: ServerType) {
    var id = UUID.randomUUID().toString().take(5) // Much ❤ to Dave Brubeck!
    var folder = File(Wrench.SERVER_FOLDER, "${File.separator}${id}")

    internal constructor(type: ServerType) : this("Server ${Random.nextInt(99)}", type)

    init {
        Logger.info("(Server) Registering new server \"${name}\" (${type.name}/${id})")
        Logger.info("(Server/$id) Creating folders...")
        folder.mkdir()
    }
}