package pl.polsl.student.michaldomino.voice_command_controlled_application.ui.text_note

import pl.polsl.student.michaldomino.voice_command_controlled_application.layout_managers.text_note.TextNoteItem
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.model.TextNote
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.VoiceCommandsPresenter
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.VoiceCommandsView

interface TextNoteContract {

    interface View : VoiceCommandsView {
        fun addText(text: String)
        fun textNoteItem(): TextNoteItem
        fun setTextNote(textNote: TextNote)
        fun setText(text: String)
    }

    interface Presenter : VoiceCommandsPresenter {
        fun addText(text: String)
    }
}