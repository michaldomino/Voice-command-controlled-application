package pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.model.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note): Single<Long>

    @Update
    fun update(note: Note): Completable

    @Delete
    fun delete(note: Note): Completable

    @Query("SELECT * FROM notes")
    fun findAll(): Single<List<Note>>

    @Query("SELECT * FROM notes WHERE note_name = :name LIMIT 1")
    fun findByName(name: String): Single<Note>
}