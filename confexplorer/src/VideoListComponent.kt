import kotlinx.html.js.onClickFunction
import react.*
import react.dom.p

/**
 *
 * @author Roman Zelenik
 */
class VideoListComponent(props: VideoListProps) : RComponent<VideoListProps, RState>(props) {
    override fun RBuilder.render() {
        props.videos.forEach { video ->
            p {
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
    var onSelectVideo: (Video)->Unit

}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoListComponent::class) {
        this.attrs(handler)
    }
}