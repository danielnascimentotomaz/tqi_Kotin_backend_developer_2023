package juMarket.com.sistema.autoatendimento.dto.product

import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.model.Product

data class ProductViewList(

    val name:String,
    val unit :Int,
    var price: Long,



) {

    constructor():this("",0,0)

    fun listProduct(product: Product):ProductViewList{

        val productList = ProductViewList(name= product.name,unit=product.unit,price=product.price)

        return productList
    }


}