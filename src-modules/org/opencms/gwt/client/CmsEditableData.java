/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/gwt/client/Attic/CmsEditableData.java,v $
 * Date   : $Date: 2011/06/06 12:10:26 $
 * Version: $Revision: 1.1 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2011 Alkacon Software (http://www.alkacon.com)
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

package org.opencms.gwt.client;

import org.opencms.util.CmsUUID;

/**
 * Bean holding data needed to open the xml content editor.<p>
 * 
 * @author Tobias Herrmann
 * 
 * @version $Revision: 1.1 $
 * 
 * @since 8.0.1
 */
public class CmsEditableData implements I_CmsEditableData {

    /** The edit id. */
    private String m_editId;

    /** The element language. */
    private String m_elementLanguage;

    /** The element name. */
    private String m_elementName;

    /** The new link. */
    private String m_newLink;

    /** The new title. */
    private String m_newTitle;

    /** The site path. */
    private String m_sitePath;

    /** The structure id. */
    private CmsUUID m_structureId;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getEditId()
     */
    public String getEditId() {

        return m_editId;
    }

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getElementLanguage()
     */
    public String getElementLanguage() {

        return m_elementLanguage;
    }

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getElementName()
     */
    public String getElementName() {

        return m_elementName;
    }

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getNewLink()
     */
    public String getNewLink() {

        return m_newLink;
    }

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getNewTitle()
     */
    public String getNewTitle() {

        return m_newTitle;
    }

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getSitePath()
     */
    public String getSitePath() {

        return m_sitePath;
    }

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getStructureId()
     */
    public CmsUUID getStructureId() {

        return m_structureId;
    }

    /**
     * Sets the edit id.<p>
     *
     * @param editId the edit id to set
     */
    public void setEditId(String editId) {

        m_editId = editId;
    }

    /**
     * Sets the element language.<p>
     *
     * @param elementLanguage the element language to set
     */
    public void setElementLanguage(String elementLanguage) {

        m_elementLanguage = elementLanguage;
    }

    /**
     * Sets the element name.<p>
     *
     * @param elementName the element name to set
     */
    public void setElementName(String elementName) {

        m_elementName = elementName;
    }

    /**
     * Sets the new link.<p>
     *
     * @param newLink the new link to set
     */
    public void setNewLink(String newLink) {

        m_newLink = newLink;
    }

    /**
     * Sets the new title.<p>
     *
     * @param newTitle the new title to set
     */
    public void setNewTitle(String newTitle) {

        m_newTitle = newTitle;
    }

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#setSitePath(java.lang.String)
     */
    public void setSitePath(String sitePath) {

        m_sitePath = sitePath;

    }

    /**
     * Sets the structure id.<p>
     *
     * @param structureId the structure id to set
     */
    public void setStructureId(CmsUUID structureId) {

        m_structureId = structureId;
    }
}
