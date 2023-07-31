package juMarket.com.sistema.autoatendimento.dto.product

import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.model.Product

class ProductDto(
    var name:String,
    var unit:Int,
    var price :Long,
    var categoryId: Long

) {
    fun toEntry():Product{
        val product = Product(name = this.name, unit = this.unit,
            price = this.price, category = Category(id = this.categoryId))

        return  product


    }
}