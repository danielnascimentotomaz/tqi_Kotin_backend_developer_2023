package juMarket.com.sistema.autoatendimento.dto.category

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import juMarket.com.sistema.autoatendimento.model.Category

data class CategoryViewDto(
    @NotNull(message = "Esse campo não pode ser nulo")
    val name:String
) {
    constructor(category: Category): this(
        category.name
    )


}