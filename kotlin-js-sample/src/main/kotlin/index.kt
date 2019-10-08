import kotlinx.html.button
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import org.w3c.dom.get
import org.w3c.notifications.*
import kotlin.browser.document
import kotlin.browser.window

/**
 *
 * @author Roman Zelenik
 */

fun main(args: Array<String>) {
    println("Kotlin log")
    document.getElementsByClassName("content")[0]!!.append {
        button {
            onClickFunction = { e -> onButtonClicked(e) }
            +"Kotlin alert button"
        }

        button {
            onClickFunction = { e -> newNotification(e) }
            +"Notification button"
        }
    }
}

fun newNotification(event: Event) {
    // Let's check if the browser supports notifications
//    if (!("Notification" in window)) {
//        alert("This browser does not support desktop notification");
//    }

    // Let's check whether notification permissions have already been granted
    if (Notification.permission == NotificationPermission.GRANTED) {
        // If it's okay let's create a notification
        createNotification()
    }

    // Otherwise, we need to ask the user for permission
    else if (Notification.permission != NotificationPermission.DENIED) {
        Notification.requestPermission { permission ->
            // If the user accepts, let's create a notification
            if (permission == NotificationPermission.GRANTED) {
                createNotification()
            }
        }
    }

}

private fun createNotification() {
    val notification = Notification("Kotlin JS Sample", NotificationOptions(body = "Kotlin notification test"))
    notification.onclick = { e -> println("Notification click") }
}

fun onButtonClicked(event: Event) {
    event.currentTarget?.let {
        val button = it as HTMLElement
        window.alert(button.innerText)
    }
}