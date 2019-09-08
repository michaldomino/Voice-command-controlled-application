package pl.polsl.student.michaldomino.voice_command_controlled_application.ui.text_note

import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.base.BaseCommandState
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.base.CSRoot
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.text_note.model.TextNoteCommandStatesModel
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.VoiceCommandsPresenter

class TextNotePresenter(override val view: TextNoteContract.View) : VoiceCommandsPresenter(view),
    TextNoteContract.Presenter {

    override val initialState: CSRoot = CSRoot(this, TextNoteCommandStatesModel(this))

    override var currentState: BaseCommandState = initialState

    override fun create() {

    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun speak(message: String) {
        view.speakInForeground(message)
    }

    override fun addText(text: String) {
        view.addText(text)
    }

}