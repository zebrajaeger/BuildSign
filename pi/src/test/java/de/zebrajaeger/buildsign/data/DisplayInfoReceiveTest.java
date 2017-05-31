package de.zebrajaeger.buildsign.data;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Lars Brandt
 */
public class DisplayInfoReceiveTest {
    @Test
    public void setValues() throws Exception {
        DisplayInfoReceive displayInfoReceive = new DisplayInfoReceive();
        displayInfoReceive.setValues("BuildDisplay: v1.2.3 msg(20)");

        assertThat(displayInfoReceive.getDisplayInfo().getDisplayType(), is(DisplayType.BUILD_DISPLAY));
        assertThat(displayInfoReceive.getDisplayInfo().getVersion().toString(), is("1.2.3"));
        assertThat(displayInfoReceive.getDisplayInfo().getMessageLength(), is(20));
    }

    @Test
    public void setValues_unknown() throws Exception {
        DisplayInfoReceive displayInfoReceive = new DisplayInfoReceive();
        displayInfoReceive.setValues("XXX: v1.2.3 msg(20)");

        assertThat(displayInfoReceive.getDisplayInfo().getDisplayType(), is(DisplayType.UNKNOWN));
        assertThat(displayInfoReceive.getDisplayInfo().getVersion().toString(), is("1.2.3"));
        assertThat(displayInfoReceive.getDisplayInfo().getMessageLength(), is(20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setValues_fail() throws Exception {
        DisplayInfoReceive displayInfoReceive = new DisplayInfoReceive();
        displayInfoReceive.setValues("XXX: v1.2.3 msg(X)");
    }
}