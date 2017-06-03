package de.zebrajaeger.buildsign.display;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Lars Brandt
 */
public class VersionTest {

    @Test
    public void version1(){
        Version version = new Version("1");
        assertThat(version.getMajor(), is(1));
        assertThat(version.getMinor(), is(0));
        assertThat(version.getBugfix(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void version1_fail(){
        Version version = new Version("1.");
    }

    @Test
    public void version2(){
        Version version = new Version("1.2");
        assertThat(version.getMajor(), is(1));
        assertThat(version.getMinor(), is(2));
        assertThat(version.getBugfix(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void version2_fail(){
        Version version = new Version("1.2.");
    }

    @Test
    public void version3(){
        Version version = new Version("1.2.3");
        assertThat(version.getMajor(), is(1));
        assertThat(version.getMinor(), is(2));
        assertThat(version.getBugfix(), is(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void version3_fail(){
        Version version = new Version("1.2.3.");
    }

}