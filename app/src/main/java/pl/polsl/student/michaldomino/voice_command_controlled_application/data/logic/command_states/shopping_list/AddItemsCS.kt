package pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.shopping_list

import pl.polsl.student.michaldomino.voice_command_controlled_application.R
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.base.CSDynamicNode
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.base.CSLeaf
import pl.polsl.student.michaldomino.voice_command_controlled_application.data.logic.command_states.shopping_list.model.CommandsModel
import pl.polsl.student.michaldomino.voice_command_controlled_application.ui.shopping_list.ShoppingListPresenter

class AddItemsCS(override val presenter: ShoppingListPresenter) : CSDynamicNode(presenter) {

    override val messageToSpeakId: Int = R.string.list_items

    override val commandNameId: Int? = CommandsModel.ADD_ITEMS_COMMAND

    override fun processInput(userInput: String) {
        presenter.addItems(userInput)
    }
}
