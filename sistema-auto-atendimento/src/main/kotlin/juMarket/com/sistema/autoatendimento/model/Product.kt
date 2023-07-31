package juMarket.com.sistema.autoatendimento.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val  id :Long? = null,

    var name:String="",
    var unit :Int = 0,
    var price: Long = 0,
    @ManyToOne
    var category: Category? = null

)

/*

  A anotação @ManyToOne é outra anotação utilizada no mapeamento objeto-relacional (ORM) com o
Java Persistence API (JPA). Ela é usada para definir um relacionamento muitos-para-um entre d-
uas entidades.

Vamos entender o significado da anotação @ManyToOne:

  Suponhamos que você tenha duas entidades: Produto e Categoria. Um produto pode pertencer a uma única
categoria, mas uma categoria pode ter muitos produtos. Neste cenário, você usaria a anotação @ManyToOne
para estabelecer esse relacionamento.


 */
