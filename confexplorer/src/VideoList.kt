import kotlinx.html.js.onClickFunction
import react.*
import react.dom.p
import kotlin.browser.window

/**
 *
 * @author Roman Zelenik
 */
class VideoList(props: VideoListProps) : RComponent<VideoListProps, VideoListState>(props) {
    override fun RBuilder.render() {
        props.videos.forEach { video ->
            p {
                key = video.id.toString()
                attrs {
                    onClickFunction = {
                        setState { selectedVideo = video }
                    }
                }
                if (video == state.selectedVideo) {
                    +"▶ "
                }
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}

interface VideoListProps : RProps {
    var videos: List<Video>
}

interface VideoListState : RState {
    var selectedVideo: Video?
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoList::class) {
        this.attrs(handler)
    }
}