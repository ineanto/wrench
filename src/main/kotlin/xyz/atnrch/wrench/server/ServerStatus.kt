package xyz.atnrch.wrench.server

enum class ServerStatus {
    /**
     * Servers in this state are waiting to be cleaned up.
     */
    DEAD,

    /**
     * Servers in this state are offline and can be started at any moment.
     */
    OFFLINE,

    /**
     * Servers in this state are running and can be stopped at any moment.
     */
    RUNNING,

    /**
     * Servers in this state are actively restarting.
     */
    RESTARTING
}