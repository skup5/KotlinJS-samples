import kotlinx.css.*
import react.*
import react.dom.*
import styled.css
import styled.styledDiv

/**
 *
 * @author Roman Zelenik
 */
class App : RComponent<RProps, AppState>() {

    val unwatchedVideos = listOf(
            Video(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
            Video(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
            Video(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
    )

    val watchedVideos = listOf(
            Video(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
    )

    override fun RBuilder.render() {
        h1 { +"KotlinConf Explorer" }

        div {

            h3 { +"Videos to watch" }

            videoList {
                videos = unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }

            h3 { +"""Videos watched""" }

            videoList {
                videos = watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }

        }

        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }

            h3 { +"John Doe : Building and breaking things" }

            img(src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder") {}
        }
    }
}

interface AppState : RState {
    var currentVideo: Video?
}