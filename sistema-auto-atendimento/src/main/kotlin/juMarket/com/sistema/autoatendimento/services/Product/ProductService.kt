package juMarket.com.sistema.autoatendimento.services.Product

import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.model.Product
import juMarket.com.sistema.autoatendimento.repository.CategoryRepository
import juMarket.com.sistema.autoatendimento.repository.ProductRepository
import juMarket.com.sistema.autoatendimento.services.category.CategoryService
import org.springframework.stereotype.Service


@Service
class ProductService(

    private val productRepository: ProductRepository,
    private  val categoryService: CategoryService


):IProduct{
    override fun save(product: Product): Product {
        product.apply {

            category = categoryService.findById(product.category?.id!!)
        }
        return this.productRepository.save(product)



    }

    override fun findAllbyCategoryId(catagory_id: Long): List<Product> {

        return this.productRepository.findAllCategoryId(catagory_id)
    }
}