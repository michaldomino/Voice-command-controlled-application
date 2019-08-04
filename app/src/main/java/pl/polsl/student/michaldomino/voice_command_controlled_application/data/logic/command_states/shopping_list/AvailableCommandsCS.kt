package pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.shopping_list

import pl.polsl.student.michaldomino.voice_command_controlled_application.R
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.base.CSLeaf
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.shopping_list.model.CommandsModel
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.shopping_list.ShoppingListPresenter

class AvailableCommandsCS(override val presenter: ShoppingListPresenter) : CSLeaf(presenter) {

    private val ITEM_DELIMITER = ", "

    override val commandNameId: Int? = CommandsModel.AVAILABLE_COMMANDS_COMMAND

    override fun initialize() {
        val availableCommands: MutableList<Int> = CommandsModel.availableCommands
        val messageBuilder = StringBuilder().append(presenter.getString(R.string.available_commands_are))
        availableCommands.forEach { messageBuilder.append(presenter.getString(it)).append(ITEM_DELIMITER) }
        presenter.speak(messageBuilder.toString())
    }

    override fun processInput(userInput: String) {}
}