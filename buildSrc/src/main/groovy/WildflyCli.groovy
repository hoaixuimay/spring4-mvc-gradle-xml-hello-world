import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

class WildflyCli extends DefaultTask {
	@Input
	def cli
	@Input
	def ignoreExitValue = false
	@Input
	def executable = "${project.wildflyCli}"
	@Input
	def controller = "${project.wildflyController}"

	@TaskAction
	protected void exec() {
		project.exec {
			ignoreExitValue = this.ignoreExitValue
			commandLine this.executable, "--user=admin123", "--password=123admin", "--connect", "--controller=${controller}", "--command=${cli}", "--timeout=20000"
			environment "JAVA_OPTS", ""
		}
	}
}