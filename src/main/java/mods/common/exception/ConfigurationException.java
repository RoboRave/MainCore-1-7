/***
 *                                                                                 
 *     _|      _|            _|              _|_|_|                                
 *     _|_|  _|_|    _|_|_|      _|_|_|    _|          _|_|    _|  _|_|    _|_|    
 *     _|  _|  _|  _|    _|  _|  _|    _|  _|        _|    _|  _|_|      _|_|_|_|  
 *     _|      _|  _|    _|  _|  _|    _|  _|        _|    _|  _|        _|        
 *     _|      _|    _|_|_|  _|  _|    _|    _|_|_|    _|_|    _|          _|_|_|  
 *                                                                                 
 *                                                                                 
 */
package mods.common.exception;

import java.io.IOException;


/**
 * Author: ShadowChild. adopted by RoboRave
 */
public class ConfigurationException extends IOException {

    /**
	 * serial id
	 */
	private static final long serialVersionUID = 1L;


    /**
     * @param message the text
     */
    public ConfigurationException(String message) {

        super(message);
    }
}