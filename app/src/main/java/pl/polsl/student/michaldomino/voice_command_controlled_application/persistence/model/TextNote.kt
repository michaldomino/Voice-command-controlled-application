package pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.model

import androidx.annotation.NonNull
import androidx.room.*

@Entity(
    tableName = "text_notes",
    indices = arrayOf(Index(value = arrayOf("note_id"), unique = true)),
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Note::class,
            parentColumns = arrayOf("note_id"),
            childColumns = arrayOf("note_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    )
)
data class TextNote(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "text_note_id")
    @NonNull
    val id: Long,

    @ColumnInfo(name = "text")
    @NonNull
    var text: String,

    @ColumnInfo(name = "note_id")
    @NonNull
    val noteId: Long
) {
    constructor(text: String, noteId: Long) : this(0, text, noteId)
}