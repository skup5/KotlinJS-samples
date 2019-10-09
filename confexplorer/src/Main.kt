import kotlinx.css.*
import react.dom.*
import styled.css
import styled.styledDiv
import kotlin.browser.document

/**
 *
 * @author Roman Zelenik
 */


fun main() {

    render(document.getElementById("root")) {
        child(App::class){}
    }
}