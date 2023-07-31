package juMarket.com.sistema.autoatendimento.services.category

import juMarket.com.sistema.autoatendimento.exception.BunissException
import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService (
    private val categoryRepository: CategoryRepository



): ICategory {
    override fun save(category: Category): Category {
        this.categoryRepository.save(category)
        return category
    }

    override fun findById(id: Long): Category {
        val categoryBD = categoryRepository.findById(id).orElseThrow(){
            throw BunissException("Id $id not found")
        }
        return categoryBD

    }

    override fun delete(id: Long) {
        var categoryBD = categoryRepository.findById(id).orElseThrow() {
            throw BunissException("Id $id not found")
        }

        this.categoryRepository.delete(categoryBD)
    }


}