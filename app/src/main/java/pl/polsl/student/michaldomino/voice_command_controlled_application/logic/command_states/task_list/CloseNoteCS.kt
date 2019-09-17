package pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.task_list

import pl.polsl.student.michaldomino.voice_command_controlled_application.R
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.base.CSLeaf
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.task_list.TaskListPresenter

class CloseNoteCS(override val presenter: TaskListPresenter) : CSLeaf(presenter) {

    override val commandNameId: Int? = R.string.close_note

    override fun initialize() {
        presenter.closeNote()
    }
}