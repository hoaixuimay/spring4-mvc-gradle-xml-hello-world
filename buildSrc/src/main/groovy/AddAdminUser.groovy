import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

class AddAdminUser extends DefaultTask {
    @Input
    def ignoreExitValue = true

    @TaskAction
    protected void exec() {
        project.exec {
            ignoreExitValue = this.ignoreExitValue
            commandLine "${project.wildflyHome}/bin/add-user.sh", "-u", "admin123", "-p", "123admin"

        }
    }
}