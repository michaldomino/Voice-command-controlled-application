package pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.note_selection

import pl.polsl.student.michaldomino.voice_command_controlled_application.R
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.base.CSNode
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.note_selection.model.CommandsModel
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.note_selection.NoteSelectionPresenter

class OpenNoteCS(override val presenter: NoteSelectionPresenter) : CSNode(presenter) {

    override val commandNameId: Int? = CommandsModel.OPEN_NOTE

    override val messageToSpeakId: Int = R.string.tell_note_name

    override fun initialize() {
        presenter.askForInput(messageToSpeakId)
    }

    override fun processInput(userInput: String) {
        presenter.openNote(userInput)
    }
}