package pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.task_list

import pl.polsl.student.michaldomino.voice_command_controlled_application.R
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.base.CSNode
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.task_list.TaskListPresenter
import pl.polsl.student.michaldomino.voice_command_controlled_application.view_model.task_list.TaskListItem

class EditItemChangeCS(override val presenter: TaskListPresenter, private val selectedItem: TaskListItem) :
    CSNode(presenter) {

    override val messageToSpeakId: Int = R.string.tell_new_name

    override val commandNameId: Int? = null

    override fun processInput(userInput: String) {
        presenter.setNewItemName(selectedItem, userInput)
    }
}