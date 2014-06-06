package mods.common.addon.plugin.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Zach
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Info
{
    /**
     * @author Zach
     *
     */
    public @interface Init
    {
    }
    
    /**
     * @author Zach
     *
     */
    public @interface PostInit
    {
    }
    
    /**
     * @author Zach
     *
     */
    public @interface PreInit
    {
    	
    }
    
    @SuppressWarnings("javadoc")
	String name();
    
    @SuppressWarnings("javadoc")
	String version();
    
    @SuppressWarnings("javadoc")
	boolean wantsPostInit() default false;
    @SuppressWarnings("javadoc")
	boolean wantsPreInit() default false;
}
