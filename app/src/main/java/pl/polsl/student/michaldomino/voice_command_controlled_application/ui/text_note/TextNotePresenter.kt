package pl.polsl.student.michaldomino.voice_command_controlled_application.ui.text_note

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.polsl.student.michaldomino.voice_command_controlled_application.R
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.base.BaseCommandState
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.base.CSRoot
import pl.polsl.student.michaldomino.voice_command_controlled_application.logic.command_states.text_note.model.TextNoteCommandStatesModel
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.dao.TextNoteDao
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.database.AppDatabase
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.model.TextNote
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.NotePresenterImpl

class TextNotePresenter(override val view: TextNoteContract.View, val noteId: Long) :
    NotePresenterImpl(view),
    TextNoteContract.Presenter {

    override val initialState: CSRoot = CSRoot(this, TextNoteCommandStatesModel(this))

    override var currentState: BaseCommandState = initialState

    private lateinit var dao: TextNoteDao

    private val disposable = CompositeDisposable()

    private lateinit var textInDatabase: String

    override fun create() {
        dao = AppDatabase.getInstance(view.getApplicationContext()).textNoteDao()
        loadTextNote()
    }

    override fun stop() {
        disposable.clear()
    }

    private fun handleError(error: Throwable?) {
        view.showToast(error?.localizedMessage)
    }

    private fun loadTextNote() {
        disposable.add(
            dao.findByNoteId(noteId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { textNote -> passToView(textNote).also { textInDatabase = textNote.text } },
                    { createTextNote(noteId) })
        )
    }

    private fun createTextNote(noteId: Long) {
        val newTextNote = TextNote(noteId)
        disposable.add(
            dao.insert(newTextNote)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { passToView(newTextNote).also { textInDatabase = newTextNote.text } },
                    { error -> handleError(error) })
        )
    }

    private fun passToView(textNote: TextNote) {
        view.setTextNote(textNote)
    }

    override fun addText(text: String) {
        view.addText(text)
    }

    fun readText() {
        speak(view.textNoteItem().text)
    }

    override fun saveChanges() {
        val textNote = view.textNoteItem().textNote
        if (textNote.text != textInDatabase) {
            disposable.add(
                dao.update(textNote)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { textInDatabase = textNote.text },
                        { error -> handleError(error) })
            )
        } else {
            speak(getString(R.string.no_changes))
        }
    }

    override fun discardChanges() {
        val textNote = view.textNoteItem()
        if (textNote.text != textInDatabase) {
            view.setText(textInDatabase)
        } else {
            speak(getString(R.string.no_changes))
        }
    }

    fun clearText() {
        view.setText("")
    }
}
