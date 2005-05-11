/*
 * File   : $Source: /alkacon/cvs/opencms/src/org/opencms/main/CmsResourceInitException.java,v $
 * Date   : $Date: 2005/05/11 08:32:42 $
 * Version: $Revision: 1.5 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Mananagement System
 *
 * Copyright (C) 2002 - 2005 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.main;

import org.opencms.i18n.CmsMessageContainer;

/**
 * This exeption is thrown by a class which implements com.opencms.core.I_CmsResourceInit.
 * When this exeption is thrown, 
 * all other implementations of I_CmsResourceInit will not be executed.<p>
 * 
 * @author  Andreas Zahner (a.zahner@alkacon.com)
 * @version $Revision: 1.5 $
 */
public class CmsResourceInitException extends CmsException {

    /**
     * Default empty constructor.
     */
    public CmsResourceInitException() {

        super();
    }

    /**
     * Constructor with message String.<p>
     * 
     * @param message the detailed exception message
     */
    public CmsResourceInitException(String message) {

        super(message);
    }
    
    /**
     * Creates a new localized Exception.<p>
     * 
     * @param container the localized message container to use
     */
    public CmsResourceInitException(CmsMessageContainer container) {

        super(container);
    }

    /**
     * Creates a new localized Exception that also containes a root cause.<p>
     * 
     * @param container the localized message container to use
     * @param cause the Exception root cause
     */
    public CmsResourceInitException(CmsMessageContainer container, Throwable cause) {

        super(container, cause);
    }
       
    /**
     * @see org.opencms.main.CmsException#createException(org.opencms.i18n.CmsMessageContainer, java.lang.Throwable)
     */
    public CmsException createException(CmsMessageContainer container, Throwable cause) {
        
        return new CmsResourceInitException(container, cause);
    } 
    
    
}
