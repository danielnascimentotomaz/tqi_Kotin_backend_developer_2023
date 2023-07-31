package juMarket.com.sistema.autoatendimento.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Swagger3Config {

    @Bean
    fun publicApi():GroupedOpenApi?{
                                              // Nome do projeto
        return GroupedOpenApi.builder().group("Sistema-Auto-Atendimento").
            // uri
        pathsToMatch("/api/category/**","/api/Product/**").build()



    }
}