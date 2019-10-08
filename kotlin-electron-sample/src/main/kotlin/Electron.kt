/**
 *
 */
class ElectronApp {

    val windowWidth: Int = 800
    val windowHeight: Int = 600

    private val electron = require("electron")
    private val app = electron.app
    val BrowserWindow = electron.BrowserWindow

    /**
     * Bez globální reference na okno by ho mohl garbage collector
     * smazat a okno by se zavřelo
     */
    var window: dynamic = null;

    init {
        app.on("ready") {
            if (window === null) {
                createWindow()
            }
        }

        app.on("window-all-closed") {
            /**
             * Na macOS je běžné, že aplikace běží na pozadí, dokud nejsou
             * explicitně zavřené pomocí zkratky Cmd + Q
             */
            if (process.platform !== "darwin") {
                app.quit()
            }
        }
    }

    private fun createWindow() {
        val windowOptions = """{
            width:$windowWidth,
            height:$windowHeight,
            webPreferences: {
                nodeIntegration: true
            }
        }"""

        // Vytvoří novou instanci okna
        window = js("new this.BrowserWindow($windowOptions)")

        // Načte HTML šablonu pro okno
        window.loadFile("index.html")

        // Otevře v okně vývojářské nástroje
        //window.webContents.openDevTools()

        // Pokud bylo okno zavřeno, vymaže referenci
        window.on("closed", fun() {
            window = null
        })
    }
}
