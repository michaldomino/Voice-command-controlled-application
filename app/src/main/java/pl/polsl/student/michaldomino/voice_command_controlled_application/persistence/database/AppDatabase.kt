package pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.dao.NoteDao
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.dao.TaskDao
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.dao.TextNoteDato
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.model.Converters
import pl.polsl.student.michaldomino.voice_command_controlled_application.persistence.model.Note


@Database(entities = arrayOf(Note::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    abstract fun taskDao(): TaskDao

    abstract fun textNoteDao(): TextNoteDato

    companion object {

        private const val DATABASE_NAME = "voice_commands.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            )
                .build()
    }
}