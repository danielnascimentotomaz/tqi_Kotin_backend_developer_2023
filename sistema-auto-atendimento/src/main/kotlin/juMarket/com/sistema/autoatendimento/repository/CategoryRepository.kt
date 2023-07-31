package juMarket.com.sistema.autoatendimento.repository

import juMarket.com.sistema.autoatendimento.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository:JpaRepository<Category,Long> {

}