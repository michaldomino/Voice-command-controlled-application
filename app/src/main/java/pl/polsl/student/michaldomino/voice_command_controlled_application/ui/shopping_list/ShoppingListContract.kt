package pl.polsl.student.michaldomino.voice_command_controlled_application.ui.shopping_list

import pl.polsl.student.michaldomino.voice_command_controlled_application.data.model.shopping_list.ShoppingListItem
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.BasePresenter
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.base.BaseView

interface ShoppingListContract {

    interface View : BaseView {
        fun addRow(text: CharSequence)
        fun getItems(): MutableList<ShoppingListItem>
        fun setNewItemName(item: ShoppingListItem, newName: String)
        fun onDoubleTap()
    }

    abstract class Presenter(override val view: View) : BasePresenter(view) {
        abstract fun addItems(userInput: String)
        abstract fun getItems(): MutableList<ShoppingListItem>
        abstract fun setNewItemName(item: ShoppingListItem, newName: String)
    }
}