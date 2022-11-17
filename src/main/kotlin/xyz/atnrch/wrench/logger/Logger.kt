package xyz.atnrch.wrench.logger

import xyz.atnrch.wrench.WrenchApp

class Logger {
    companion object {
        private fun log(level: Level, log: String) {
            println("${WrenchApp.PREFIX} ${level.getName()} - $log")
        }

        fun debug(log: String) {
            log(Level.DEBUG, log)
        }

        fun info(log: String) {
            log(Level.INFO, log)
        }

        fun warn(log: String) {
            log(Level.WARN, log)
        }
    }

    enum class Level {
        INFO,
        DEBUG,
        WARN;

        fun getName(): String {
            return name.lowercase().replaceFirstChar(Char::titlecase)
        }
    }
}