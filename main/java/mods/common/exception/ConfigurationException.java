package mods.common.exception;

import java.io.IOException;


/**
 * Author: ShadowChild. adopted by RoboRave
 */
public class ConfigurationException extends IOException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConfigurationException() {

        super();
    }

    public ConfigurationException(String message) {

        super(message);
    }
}