package pl.polsl.student.michaldomino.voice_command_controlled_application.view_model.note_selection

import android.view.LayoutInflater
import android.widget.LinearLayout
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.model.Note

class NoteSelectionItemsManager(
    private val inflater: LayoutInflater,
    private val parentLinearLayout: LinearLayout
) {

    private val container: LinkedHashSet<NoteSelectionItem> = linkedSetOf()

    val items: MutableList<NoteSelectionItem>
        get() {
            return container.toMutableList()
        }

    fun addRow(note: Note) {
        val rowItem = NoteSelectionItem(inflater, note)
        container.add(rowItem)
        parentLinearLayout.addView(rowItem.getView(), parentLinearLayout.childCount)
    }
}