package juMarket.com.sistema.autoatendimento.services.category

import juMarket.com.sistema.autoatendimento.model.Category

interface ICategory {
    fun save(category: Category):Category
    fun findById(id:Long):Category
    fun delete(id:Long)




}