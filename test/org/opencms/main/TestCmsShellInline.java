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
 * For further information about Alkacon Software GmbH, please see the
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

import org.opencms.file.CmsObject;
import org.opencms.test.OpenCmsTestCase;
import org.opencms.test.OpenCmsTestProperties;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

/** 
 * Test cases for the OpenCms shell when used "inline".<p>
 * 
 * @since 9.5.0
 */
public class TestCmsShellInline extends OpenCmsTestCase {

    /**
     * Default JUnit constructor.
     * 
     * @param arg0 JUnit parameters
     */
    public TestCmsShellInline(String arg0) {

        super(arg0);
    }

    /**
     * Test suite for this test class.
     * 
     * @return the test suite
     */
    public static Test suite() {

        OpenCmsTestProperties.initialize(org.opencms.test.AllTests.TEST_PROPERTIES_PATH);

        TestSuite suite = new TestSuite();
        suite.setName(TestCmsShellInline.class.getName());

        suite.addTest(new TestCmsShellInline("testShellInline"));
        suite.addTest(new TestCmsShellInline("testShellSetProperties"));

        TestSetup wrapper = new TestSetup(suite) {

            @Override
            protected void setUp() {

                setupOpenCms(null, "/sites/default/");
            }

            @Override
            protected void tearDown() {

                removeOpenCms();
            }
        };

        return wrapper;
    }

    /**
     * Tests basic inline shell invocation.<p>
     * 
     * @throws Exception in case something goes wrong
     */
    public void testShellInline() throws Exception {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);

        CmsObject cms = getCmsObject();
        CmsShell shell = new CmsShell(cms, "${user}@${project}:${siteroot}|${uri}>", null, out, out);
        shell.execute("echo on\n pwd \n userName \n exit");

        // some variables in the String so that we don't have to change the test case every version / year
        String expected = "\nWelcome to the OpenCms shell!\n" + "\n" + "\n" + "This is OpenCms "
            + OpenCms.getSystemInfo().getVersionNumber()
            + ".\n"
            + "\n"
            + Messages.COPYRIGHT_BY_ALKACON[1]
            + "\n"
            + "OpenCms comes with ABSOLUTELY NO WARRANTY\n"
            + "This is free software, and you are welcome to\n"
            + "redistribute it under certain conditions.\n"
            + "Please see the GNU Lesser General Public Licence for\n"
            + "further details.\n"
            + "\n"
            + "\n"
            + "help              Shows this text.\n"
            + "help *            Shows the signatures of all available methods.\n"
            + "help {string}     Shows the signatures of all methods containing this string.\n"
            + "exit or quit      Leaves this OpenCms Shell.\n"
            + "\n"
            + "Admin@Offline:/sites/default|/>Echo is now on.\n"
            + "Admin@Offline:/sites/default|/>pwd\n"
            + "/\n"
            + "Admin@Offline:/sites/default|/>userName\n"
            + "Admin\n"
            + "Admin@Offline:/sites/default|/>exit\n"
            + "\n"
            + "Goodbye!\n";

        String result = bytes.toString();
        assertEquals("Shell did not produce expected output", expected, result);
    }

    /**
     * Tests setting some properties using the shell.<p>
     * 
     * @throws Exception in case something goes wrong
     */
    public void testShellSetProperties() throws Exception {

        CmsObject cms = getCmsObject();
        CmsShell shell = new CmsShell(cms, "${user}@${project}:${siteroot}|${uri}>", null, System.out, System.err);
        String read, value;

        value = "This is a test";
        shell.execute("echo on\n help * \n writeProperty '/' 'Title' '" + value + "'");
        read = cms.readPropertyObject("/", "Title", false).getValue();
        assertEquals("Title property not set as expected", value, read);

        value = "This is on the sites folder";
        shell.execute("setSiteRoot '/' \n writeProperty '/sites/' 'Title' '" + value + "'");
        read = cms.readPropertyObject("/sites/", "Title", false).getValue();
        assertEquals("Title property not set as expected", value, read);
    }
}
