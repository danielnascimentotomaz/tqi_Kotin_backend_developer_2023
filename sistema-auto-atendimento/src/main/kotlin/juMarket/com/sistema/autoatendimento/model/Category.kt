package juMarket.com.sistema.autoatendimento.model

import jakarta.persistence.*
import lombok.Data

@Data
@Entity
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id :Long? = null,

    @Column(name = "name",unique = true,nullable = false)
    var name:String = "",

    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE,CascadeType.PERSIST), mappedBy = "category")
    var product: List<Product> = mutableListOf()


)


/*

1- @OneToMany: esta anotação estabelece uma relação um-para-muitos entre duas entidades.
Nesse caso, indica que a entidade atual possui um relacionamento um-para-muitos com
outra entidade.

2- fetch = FetchType.LAZY: Este atributo especifica o tipo de busca para a associação.
LAZY significa que a entidade associada (o lado "muitos") será carregada do banco de
dados somente quando for acessada pela primeira vez. Isso pode ajudar a melhorar o
desempenho, evitando consultas desnecessárias ao banco de dados.

3- cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST): Este atributo define as
operações em cascata a serem aplicadas às entidades associadas. Nesse caso, especifica
que quando a entidade pai é removida ( CascadeType.REMOVE) ou persistida ( CascadeType.PERSIST),
as entidades associadas também devem ser removidas ou persistidas de acordo. Isso garante que as
entidades relacionadas sejam gerenciadas automaticamente quando a entidade pai é modificada.

4-> mappedBy = "category": Este atributo especifica o nome do campo na entidade associada (o lado
"muitos") que possui o relacionamento. Nesse caso, indica que a entidade do lado "muitos" tem um
campo chamado "categoria" que mapeia de volta para a entidade atual (o lado "um"). O atributo
"mappedBy" é normalmente usado ao lidar com relacionamentos bidirecionais e ajuda a manter a
consistência do relacionamento em ambas as direções.

5-> No geral, essa anotação indica que a entidade atual tem um relacionamento um-para-muitos com
outra entidade, a associação deve ser buscada lentamente e as entidades relacionadas devem ser
removidas ou mantidas automaticamente quando a entidade pai é removida ou persistida, respectivamente.
A associação é bidirecional, com a entidade do lado "muitos" contendo uma referência à entidade do lado
"um" por meio do campo "categoria".



 */

