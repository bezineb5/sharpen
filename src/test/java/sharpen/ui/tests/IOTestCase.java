/* Copyright (C) 2010 Versant Inc. http://www.db4o.com */

package sharpen.ui.tests;

import org.junit.Test;
import sharpen.core.io.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IOTestCase {

    private static final String Expected = "comment1=42";
    private static final String CommentedOut = "#comment1=10";

    private static final String ConfigContents = "foo=start\r\n" + CommentedOut + "\r\n" + Expected + "\r\n#comment1\r\nbar=end";

    @Test
    public void testCommentsAreIgnored() throws IOException {
        ArrayList<String> lines = new ArrayList<String>();

        IO.collectLines(lines, new BufferedReader(new StringReader(ConfigContents)));

        assertFalse(lines.contains(CommentedOut));
        assertTrue(lines.contains(Expected));
    }

}
