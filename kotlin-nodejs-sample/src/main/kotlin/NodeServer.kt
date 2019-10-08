/**
 *
 * @author Roman Zelenik
 */

fun simpleNodeServer() {
    println("Hello JavaScript!".plus(" by Kotlin"))

    val http = require("http")
    val hostname = "127.0.0.1"
    val port = 3000

    println("Server will try to run at http://${hostname}:${port}/")

    val server = http.createServer { req, res ->
        res.statusCode = 200
        res.setHeader("Content-Type", "text/plain")
        res.end("Hello from Kotlin NodeJS application\n")
    }

    server.listen(port, hostname) {
        println("Server running at http://${hostname}:${port}/")
    }
}