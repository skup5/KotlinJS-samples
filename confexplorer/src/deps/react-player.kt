@file:JsModule("react-player")

package deps

import react.*

// This line is equivalent to a JavaScript import like require("react-player").default;
@JsName("default")
external val ReactPlayer: RClass<ReactPlayerProps>

external interface ReactPlayerProps : RProps {
    var url: String
}