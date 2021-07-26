package com.vaadin.testbenchexample;

import com.github.mvysny.kaributesting.v10.MockVaadin;
import com.github.mvysny.kaributesting.v10.Routes;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.github.mvysny.kaributesting.v10.LocatorJ._click;
import static com.github.mvysny.kaributesting.v10.LocatorJ._get;
import static org.junit.Assert.assertEquals;

/**
 * This test is run by the maven-surefire-plugin as a regular unit test; the app is running
 * in the same JVM as the tests; the tests are not using an actual browser but rather
 * talking to the Vaadin UI directly.
 * <p></p>
 * See https://github.com/mvysny/karibu-testing for more details.
 */
public class MyFirstUnitTest {
    @Before
    public void setup() {
        MockVaadin.setup(new Routes().autoDiscoverViews("com.vaadin.testbenchexample"));
    }
    @After
    public void teardown() {
        MockVaadin.tearDown();
    }

    @Test
    public void clickButtonShouldChangeTheLabel() throws Exception {
        _click(_get(Button.class, spec -> spec.withCaption("Click Me")));
        assertEquals("Clicked!", _get(Span.class, spec -> spec.withId("status")).getText());
    }
}
