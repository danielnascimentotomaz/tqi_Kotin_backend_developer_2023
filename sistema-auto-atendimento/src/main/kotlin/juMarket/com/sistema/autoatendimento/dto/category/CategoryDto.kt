package juMarket.com.sistema.autoatendimento.dto.category

import jakarta.validation.constraints.NotNull
import juMarket.com.sistema.autoatendimento.model.Category
import lombok.Data

@Data
class CategoryDto(
    @NotNull(message = "Esse campo não pode ser nulo")
    var name:String = ""

) {
        fun toEntry(): Category {

            val category = Category(name = this.name)
            return category

        }


    }
