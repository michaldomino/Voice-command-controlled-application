package pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.model.shopping_list

import pl.polsl.student.michaldomino.voice_command_controlled_application.R
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.Command
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.model.base.CSStaticNode
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.shopping_list.ShoppingListPresenter

class ShoppingListInitialCS(override val presenter: ShoppingListPresenter) : CSStaticNode(presenter) {

    val ADD_ITEMS = AddShoppingListElementCS(presenter)
    val EDIT_ITEM_SELECT = EditShoppingListElementCS(presenter)

    override fun processInput(userInput: String) {
        val command = Command(userInput)
        when {
            isAddElement(command) -> {
                presenter.currentState =
                    AddShoppingListElementCS(
                        presenter
                    )
            }
            isEditElement(command) -> {
                presenter.currentState =
                    EditShoppingListElementCS(
                        presenter
                    )
            }
            else -> {

            }
        }
    }

    private fun isAddElement(command: Command): Boolean {
//        possibleMatches.firstOrNull {  }
        return isSimilar(command, R.string.add_items)
    }

    private fun isEditElement(command: Command): Boolean {
        return isSimilar(command, R.string.edit_item)
    }

    private fun isSimilar(command: Command, resId: Int): Boolean {
        val stringCommand = presenter.getString(resId)
        return command.similarTo(stringCommand)
    }
}