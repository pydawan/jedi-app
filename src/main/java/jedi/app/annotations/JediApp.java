package jedi.app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author thiago
 * @version v1.0.0
 * @since v1.0.0
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface JediApp {
   String name() default "";
   String verbose_name() default "";
   String verbose_name_plural() default "";
   String label() default "";
   String db_table() default "";
   String[]authors() default { "" };
   String version() default "";
   String description() default "";
   String date() default "";
}
