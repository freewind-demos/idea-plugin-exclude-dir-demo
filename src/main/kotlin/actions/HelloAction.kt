package actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.module.impl.ModuleImpl
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ModuleRootModel
import com.intellij.openapi.roots.impl.ContentEntryImpl
import com.intellij.openapi.ui.Messages

class HelloAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val dir = Messages.showInputDialog("Input the dir your want to exclude", "Exclude dir", null)
        println("dir: $dir")

        val currentProject = event.project!!

        val module = ModuleManager.getInstance(currentProject).modules[0]
        val rootModel = ModuleRootManager.getInstance(module).modifiableModel

        val contentEntry = rootModel.contentEntries[0]

        val targetDir = currentProject.baseDir.findFileByRelativePath(dir!!)
        println("targetDir: $targetDir")
        if (targetDir != null) {
            println("Added as exclude folder: $targetDir")
            contentEntry.addExcludeFolder(targetDir)

            ApplicationManager.getApplication().runWriteAction {
                println("commit changes")
                rootModel.commit()
            }
        } else {
            println("target dir is not found")
        }
    }

}