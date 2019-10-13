import kotlinx.css.Cursor
import kotlinx.css.cursor
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.a
import react.dom.p
import styled.css
import styled.styledP

/**
 *
 * @author Roman Zelenik
 */
class VideoListComponent(props: VideoListProps) : RComponent<VideoListProps, RState>(props) {
    override fun RBuilder.render() {
        props.videos.forEach { video ->
            styledP {
                css {
                    cursor = Cursor.pointer
                }

                key = video.id.toString()

                attrs {
                    onClickFunction = {
                        props.onSelectVideo(video)
                    }
                }

                if (video == props.selectedVideo) {
                    +"▶ "
                }
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}

interface VideoListProps : RProps {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit

}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoListComponent::class) {
        this.attrs(handler)
    }
}