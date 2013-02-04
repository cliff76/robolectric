package org.robolectric.shadows;

import android.widget.ImageButton;
import org.robolectric.Robolectric;
import org.robolectric.TestRunners;
import org.robolectric.res.PackageResourceLoader;
import org.robolectric.res.Attribute;
import org.robolectric.res.RoboAttributeSet;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(TestRunners.WithDefaults.class)
public class ImageButtonTest {
    @Test
    public void testBackground() throws Exception {
        RoboAttributeSet attrs = new RoboAttributeSet(new ArrayList<Attribute>(), new PackageResourceLoader(), null);
        ImageButton button = new ImageButton(Robolectric.application, attrs);
        assertThat(button.getBackground(), notNullValue());
    }
}
