package actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.ui.Messages

class HelloAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val dir = Messages.showInputDialog("Input the dir your want to exclude", "Exclude dir", null);
        ContentEntry
    }

}