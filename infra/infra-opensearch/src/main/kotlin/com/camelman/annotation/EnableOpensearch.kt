import com.camelman.config.OpensearchConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(OpensearchConfig::class)
annotation class EnableOpensearch()