package pl.polsl.student.michaldomino.voice_command_controlled_application.ui.text_note

import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.base.BaseCommandState
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.base.CSRoot
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.text_note.TextNoteInitialCS

class TextNotePresenter(override val view: TextNoteContract.View) : TextNoteContract.Presenter(view) {

    override val initialState: CSRoot = TextNoteInitialCS(this)

    override var currentState: BaseCommandState = initialState

    override fun start() {

    }

    override fun speak(message: String) {
        view.speakInForeground(message)
    }

    override fun addText(text: String) {
        view.addText(text)
    }

}