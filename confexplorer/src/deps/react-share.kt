@file:JsModule("react-share")
@file:JsNonModule

package deps

import react.RClass
import react.RProps

@JsName("EmailIcon")
external val EmailIcon: RClass<IconProps>

@JsName("EmailShareButton")
external val EmailShareButton: RClass<ShareButtonProps>

@JsName("FacebookIcon")
external val FacebookIcon: RClass<IconProps>

@JsName("FacebookShareButton")
external val FacebookShareButton: RClass<ShareButtonProps>

external interface ShareButtonProps : RProps {
    var url: String
}

external interface IconProps : RProps {
    var size: Int
    var round: Boolean
}