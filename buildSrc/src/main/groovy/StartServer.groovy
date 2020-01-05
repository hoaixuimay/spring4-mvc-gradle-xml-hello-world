import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

class StartServer extends DefaultTask {
    @Input
    def ignoreExitValue = false

    @TaskAction
    protected void exec() {
        project.exec {
            ignoreExitValue = this.ignoreExitValue
            commandLine "${project.wildflyHome}/bin/standalone.sh"

        }
    }
}