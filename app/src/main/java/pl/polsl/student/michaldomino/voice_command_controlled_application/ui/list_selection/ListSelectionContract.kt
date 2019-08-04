package pl.polsl.student.michaldomino.voice_command_controlled_application.ui.list_selection

import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.BasePresenter
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.BaseView

interface ListSelectionContract {

    interface View : BaseView

    abstract class Presenter(override val view: View) : BasePresenter(view)
}