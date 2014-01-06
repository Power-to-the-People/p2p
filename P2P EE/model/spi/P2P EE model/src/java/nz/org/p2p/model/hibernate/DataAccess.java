package nz.org.p2p.model.hibernate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>The data access annotation  provides runtime identification of supported
 * entities for a DAO.</p>
 * 
 * <p>This software is offered under the terms of the GNU AFERO GENERAL PUBLIC
 * LICENCE of 2007,
 * <b>See</b> {@link nz.org.p2p.model.hibernate package documentation} for more
 * information.</p>
 *
 * @author John Hutcheson &lt;witerat.test@gmail.com&gt;
 * @author Richard Thomas &lt;richard@kanecta.com&gt;
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataAccess{

	/**
	 * Entity.
	 *
	 * @return A string
	 */
	String entity() default "";
}


