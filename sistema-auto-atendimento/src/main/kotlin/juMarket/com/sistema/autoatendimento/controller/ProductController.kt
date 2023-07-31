package juMarket.com.sistema.autoatendimento.controller

import juMarket.com.sistema.autoatendimento.dto.product.ProductDto
import juMarket.com.sistema.autoatendimento.dto.product.ProductViewList
import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.model.Product
import juMarket.com.sistema.autoatendimento.services.Product.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Collections
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/Product")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun save (@RequestBody productDto: ProductDto):ResponseEntity<String>{

        val productSave = productService.save(productDto.toEntry())
        return ResponseEntity.status(HttpStatus.CREATED).body("product ${productSave.name}")

    }

    @GetMapping("/{categoryId}")
    fun findAllByProductId(@PathVariable categoryId:Long):ResponseEntity<List<ProductViewList>?>{

        var productViewList = this.productService.findAllbyCategoryId(categoryId).
        stream().map {product:Product -> ProductViewList().listProduct(product)  }.
        collect(Collectors.toList())


        return ResponseEntity.status(HttpStatus.OK).body(productViewList)



    }
}