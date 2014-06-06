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
    public @interface Init{}
    
    /**
     * @author Zach
     *
     */
    public @interface PostInit{}
    
    /**
     * @author Zach
     *
     */
    public @interface PreInit{}
    
    
	String name();
	
	String version();
}
