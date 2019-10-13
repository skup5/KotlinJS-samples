import deps.*
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.h3
import styled.css
import styled.styledButton
import styled.styledDiv

/**
 * Allows play videos inside a web page.
 * @author Roman Zelenik
 */
class VideoPlayerComponent(props: VideoPlayerProps) : RComponent<VideoPlayerProps, RState>(props) {
    override fun RBuilder.render() {
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }

            h3 { +"${props.video.speaker}: ${props.video.title}" }

            styledButton {
                css {
                    display = Display.block
                    borderRadius = 0.3.rem
                    borderColor = Color("#888")
                    borderWidth = 0.1.rem
                    marginBottom = 0.5.rem
                    padding = "0.3rem 0.6rem"
                    backgroundColor = if (props.unwatchedVideo) Color.lightGreen else Color.red
                }
                attrs {
                    onClickFunction = {
                        props.onWatchedButtonPressed(props.video)
                    }
                }
                if (props.unwatchedVideo) {
                    +"Mark as watched"
                } else {
                    +"Mark as unwatched"
                }
            }

            styledDiv {
                css {
                    display = Display.flex
                    marginBottom = 0.5.rem
                }

                EmailShareButton {
                    attrs.url = props.video.videoUrl
                    EmailIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }

                FacebookShareButton {
                    attrs.url = props.video.videoUrl
                    FacebookIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }
            }

            ReactPlayer {
                attrs.url = props.video.videoUrl
            }
        }
    }

}

interface VideoPlayerProps : RProps {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement {
    return child(VideoPlayerComponent::class) {
        this.attrs(handler)
    }
}