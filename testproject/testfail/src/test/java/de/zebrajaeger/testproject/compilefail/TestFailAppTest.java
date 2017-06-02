package de.zebrajaeger.testproject.compilefail;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lars Brandt, Silpion IT Solutions GmbH
 */
public class TestFailAppTest {

    @Test
    public void foo() {
        Assert.assertTrue(false);
    }
}
