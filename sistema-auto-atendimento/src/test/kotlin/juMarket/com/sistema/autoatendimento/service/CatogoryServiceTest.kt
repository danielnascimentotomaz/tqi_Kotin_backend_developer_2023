package juMarket.com.sistema.autoatendimento.service

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import juMarket.com.sistema.autoatendimento.exception.BunissException
import juMarket.com.sistema.autoatendimento.model.Category
import juMarket.com.sistema.autoatendimento.repository.CategoryRepository
import juMarket.com.sistema.autoatendimento.services.category.CategoryService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*


@ExtendWith(MockKExtension::class)
class CatogoryServiceTest {
    @InjectMockKs  lateinit var categoryService: CategoryService
    @MockK lateinit var categoryRepository: CategoryRepository

    @Test
    fun `should create category`(){
        //given
        val fakecategory :Category = buildCategory()

        every {categoryRepository.save(any()) } returns fakecategory

        //when
        val actual: Category = categoryService.save(fakecategory)

        //then
        Assertions.assertThat(actual).isNotNull


    }


    @Test
    fun `should find category by id`(){

        //given
        val fakeId:Long = Random().nextLong()
        val fakeCategory = buildCategory(id = fakeId)

        every {categoryRepository.findById(fakeId) } returns Optional.of(fakeCategory)

        // when

        val actual : Category = categoryService.findById(fakeId)

        // then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCategory)
        Assertions.assertThat(actual).isExactlyInstanceOf(Category::class.java)

        verify(exactly = 1) { categoryRepository.findById(fakeId) }

    }

    @Test
    fun `should not find custormer by invalid id and throw BusinessException`(){
        //given
        val fakeId:Long = Random().nextLong()

        every { categoryRepository.findById(fakeId) } returns Optional.empty()

        //when

        //then
        Assertions.assertThatExceptionOfType(BunissException::class.java).isThrownBy {
            categoryService.findById(fakeId)
        }.withMessage("Id $fakeId not found")

       verify(exactly = 1) { categoryRepository.findById(fakeId) }

    }

    @Test
    fun `should delete custormer by id`(){
        //given
        val fakeid:Long= Random().nextLong()
        val fakeCategory = buildCategory(id = fakeid)

        every { categoryRepository.findById(fakeid) } returns Optional.of(fakeCategory)
        every { categoryRepository.delete(fakeCategory) } just runs


        //when

        categoryService.delete(fakeid)

        //then

        verify(exactly = 1) { categoryRepository.findById(fakeid) }
        verify(exactly = 1) { categoryRepository.delete(fakeCategory) }














    }

















    private fun buildCategory(
                     id:Long= 1L,
                     name:String= "Limpza")= Category(id= id,
        name=name)


}
