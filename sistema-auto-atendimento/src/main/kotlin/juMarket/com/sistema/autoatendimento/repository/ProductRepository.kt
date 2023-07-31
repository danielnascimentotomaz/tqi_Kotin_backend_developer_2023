package juMarket.com.sistema.autoatendimento.repository

import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductRepository:JpaRepository<Product,Long> {

    @Query(value = "select * from Product where CATEGORY_ID = :category_id", nativeQuery = true)
    fun findAllCategoryId(category_id:Long):List<Product>
}