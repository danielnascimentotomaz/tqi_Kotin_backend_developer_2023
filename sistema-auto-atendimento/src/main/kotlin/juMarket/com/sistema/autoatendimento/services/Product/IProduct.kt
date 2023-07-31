package juMarket.com.sistema.autoatendimento.services.Product

import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.model.Product

interface IProduct {

    fun save(product: Product):Product

    fun findAllbyCategoryId(catagory_id:Long): List<Product>
}