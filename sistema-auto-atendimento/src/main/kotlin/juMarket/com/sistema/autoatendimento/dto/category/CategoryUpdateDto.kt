package juMarket.com.sistema.autoatendimento.dto.category

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import juMarket.com.sistema.autoatendimento.model.Category

class CategoryUpdateDto(
    @NotNull(message = "Esse campo não pode ser nulo")
    val name : String

) {

    fun update(category: Category):Category{
        category.name = this.name
        return category
    }




}