/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
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

package org.opencms.ui.login;

import elemental.events.KeyboardEvent.KeyCode;

import org.opencms.i18n.CmsMessages;
import org.opencms.main.OpenCms;
import org.opencms.security.CmsOrganizationalUnit;
import org.opencms.ui.CmsVaadinUtils;
import org.opencms.workplace.CmsLogin;
import org.opencms.workplace.CmsWorkplace;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.google.common.collect.Maps;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;

/**
 * Login form.<p>
 */
@DesignRoot
public class CmsLoginForm extends VerticalLayout {

    /** Version id. */
    private static final long serialVersionUID = 1L;

    /** The label showing the copyright information. */
    private Label m_copyright;

    /** The security field, which allows the user to choose between a private or public PC. */
    private OptionGroup m_securityField;

    /** Widget for entering the user name.  */
    private CmsLoginUserField m_userField;

    /** Widget for entering the password. */
    private CmsLoginPasswordField m_passwordField;

    /** Widget for OU selection. */
    private CmsLoginOuSelector m_ouSelect;

    /** Login button. */
    private Button m_loginButton;

    /** OpenCms logo. */
    private Image m_logo;

    /** The login controller. */
    private CmsLoginController m_controller;

    /**
     * Creates a new instance.<p>
     * 
     * @param controller the login controller 
     * @param locale the locale to use 
     */
    @SuppressWarnings("serial")
    public CmsLoginForm(CmsLoginController controller, Locale locale) {

        m_controller = controller;
        final CmsMessages messages = org.opencms.workplace.Messages.get().getBundle(locale);
        Map<String, String> macros = Maps.newHashMap();
        macros.put("showSecure", "" + controller.isShowSecure());
        String pctype = controller.getPcType();
        CmsVaadinUtils.readAndLocalizeDesign(this, messages, macros);
        m_securityField.addItem("public");
        m_securityField.addItem("private");
        m_securityField.setValue(pctype);
        m_copyright.setContentMode(ContentMode.HTML);
        m_copyright.setValue(CmsLogin.getCopyrightHtml(locale));

        m_securityField.setItemCaption(
            "private",
            messages.key(org.opencms.workplace.Messages.GUI_LOGIN_PCTYPE_PRIVATE_0));
        m_securityField.setItemCaption("public", messages.key(org.opencms.workplace.Messages.GUI_LOGIN_PCTYPE_PUBLIC_0));
        setWidth("700px");

        m_logo.setSource(new ExternalResource(OpenCms.getSystemInfo().getContextPath()
            + CmsWorkplace.RFS_PATH_RESOURCES
            + "commons/login_logo.png"));
        setComponentAlignment(m_logo, Alignment.MIDDLE_CENTER);
        m_loginButton.setClickShortcut(KeyCode.ENTER);
        m_loginButton.addClickListener(new ClickListener() {

            @SuppressWarnings("synthetic-access")
            public void buttonClick(ClickEvent event) {

                m_controller.onClickLogin();
            }

        });

    }

    /**
     * Gets the OU.<p>
     * 
     * @return the OU 
     */
    public String getOrgUnit() {

        return m_ouSelect.getValue();
    }

    /** 
     * Gets the password.<p>
     * 
     * @return the password 
     */
    public String getPassword() {

        return m_passwordField.getValue();
    }

    /**
     * Gets the PC type.<p>
     * 
     * @return the PC type 
     */
    public String getPcType() {

        return "" + m_securityField.getValue();
    }

    /**
     * Gets the user.<p>
     * 
     * @return the user 
     */
    public String getUser() {

        return m_userField.getValue();
    }

    /**
     * Selects a specific org unit.<p>
     * 
     * @param preselectedOu the OU to select 
     */
    public void selectOrgUnit(String preselectedOu) {

        m_ouSelect.setValue(preselectedOu);

    }

    /**
     * Sets the org units available for selection.<p>
     * 
     * @param ous the ous 
     */
    public void setSelectableOrgUnits(List<CmsOrganizationalUnit> ous) {

        m_ouSelect.initOrgUnits(ous);
    }

}
