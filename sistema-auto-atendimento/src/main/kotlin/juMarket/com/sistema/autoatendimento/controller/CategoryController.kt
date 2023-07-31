package juMarket.com.sistema.autoatendimento.controller


import juMarket.com.sistema.autoatendimento.dto.category.CategoryDto
import juMarket.com.sistema.autoatendimento.dto.category.CategoryUpdateDto
import juMarket.com.sistema.autoatendimento.dto.category.CategoryViewDto
import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.services.category.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryController(
    private val categoryService: CategoryService

) {
    @PostMapping
    fun save(@RequestBody categoryDto: CategoryDto):ResponseEntity<String>{
        val savecategory = categoryService.save(categoryDto.toEntry())

        return ResponseEntity.status(HttpStatus.CREATED).body("Category ${savecategory.name} saved")

    }

    @GetMapping("/{id}")
    fun finById(@PathVariable id:Long):ResponseEntity<CategoryViewDto> {

        val categoryBD = categoryService.findById(id)

        val categoryViewDto = CategoryViewDto(categoryBD)

        return ResponseEntity.status(HttpStatus.OK).body(categoryViewDto)

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//NO_CONTENTindicar que o recurso foi excluído
    fun delete(@PathVariable id :Long){
        categoryService.delete(id)

    }

    @PutMapping("/{id}")

    fun  update(@PathVariable id:Long,@RequestBody categoryUpdateDto: CategoryUpdateDto):ResponseEntity<CategoryViewDto>{
        val categoryBD = categoryService.findById(id)

        val update = categoryUpdateDto.update(categoryBD)

        categoryService.save(update)

        return ResponseEntity.status(HttpStatus.OK).body(CategoryViewDto(update))

    }



}