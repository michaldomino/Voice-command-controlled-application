package pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.shared

import pl.polsl.student.michaldomino.voice_command_controlled_application.R
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.base.BaseCommandStateModel
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.base.CSLeaf
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.VoiceCommandsPresenterImpl

class AvailableCommandsCS(
    override val presenter: VoiceCommandsPresenterImpl,
    private val commandsModel: BaseCommandStateModel
) : CSLeaf(presenter) {

    private val ITEMS_DELIMITER = ", "

    override val commandNameId: Int? = R.string.available_commands

    override fun initialize() {
        val availableCommands: List<Int?> = commandsModel.availableCommandStates
            .map { it.commandNameId }
            .filter { it != commandNameId }
        val messageBuilder =
            StringBuilder().append(presenter.getString(R.string.available_commands_are))
        availableCommands.forEach {
            messageBuilder.append(it?.let { it1 -> presenter.getString(it1) })
                .append(ITEMS_DELIMITER)
        }
        presenter.speak(messageBuilder.toString())
    }
}