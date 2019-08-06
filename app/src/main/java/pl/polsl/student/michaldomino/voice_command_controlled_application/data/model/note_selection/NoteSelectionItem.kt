package pl.polsl.student.michaldomino.voice_command_controlled_application.data.model.note_selection

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import pl.polsl.student.michaldomino.voice_command_controlled_application.R

class NoteSelectionItem(inflater: LayoutInflater) {

    private val rowView: View = inflater.inflate(R.layout.note_selection_row, null)

    private val noteNameTextView: TextView = rowView.findViewById(R.id.note_name)

    private val noteTypeImageView: ImageView = rowView.findViewById(R.id.note_type)

    val name: String
        get() {
            return noteNameTextView.text.toString()
        }

    val type: Drawable?
        get() {
            return noteTypeImageView.drawable
//            return noteTypeImageView.text.toString()
        }

    fun getView(): View {
        return rowView
    }

    fun setText(value: CharSequence): NoteSelectionItem {
        this.noteNameTextView.text = value
        return this
    }

    fun setType(value: NoteType): NoteSelectionItem {
        this.noteTypeImageView.setImageResource(android.R.drawable.checkbox_on_background)
        return this
    }
}