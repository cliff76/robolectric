package org.robolectric.shadows;

import android.app.Activity;
import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import org.robolectric.R;
import org.robolectric.Robolectric;
import org.robolectric.TestRunners;
import org.robolectric.res.PackageResourceLoader;
import org.robolectric.res.Attribute;
import org.robolectric.res.RoboAttributeSet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

@RunWith(TestRunners.WithDefaults.class)
public class DialogPreferenceTest {

    private static final String TEST_DIALOG_MESSAGE = "This is only a test";

    private DialogPreference preference;
    private ShadowDialogPreference shadow;

    private Context context;
    private RoboAttributeSet attrs;

    @Before
    public void setup() {
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(new Attribute("android:attr/dialogMessage", TEST_DIALOG_MESSAGE, R.class.getPackage().getName()));
        context = new Activity();
        attrs = new RoboAttributeSet(attributes, new PackageResourceLoader(), null);
        preference = new TestDialogPreference(context, attrs);
        shadow = Robolectric.shadowOf(preference);
    }

    @Test
    public void testConstructors() {
        int defStyle = 7;

        preference = new TestDialogPreference(context, attrs, defStyle);
        shadow = Robolectric.shadowOf(preference);
        assertThat(shadow.getContext(), sameInstance(context));
        assertThat(shadow.getAttrs(), sameInstance((AttributeSet) attrs));
        assertThat(shadow.getDefStyle(), equalTo(defStyle));

        preference = new TestDialogPreference(context, attrs);
        shadow = Robolectric.shadowOf(preference);
        assertThat(shadow.getContext(), sameInstance(context));
        assertThat(shadow.getAttrs(), sameInstance((AttributeSet) attrs));
        assertThat(shadow.getDefStyle(), equalTo(0));
    }

    @Test
    public void testGetDialogMessage() {
        assertThat((String) preference.getDialogMessage(), equalTo(TEST_DIALOG_MESSAGE));
    }

    protected static class TestDialogPreference extends DialogPreference {

        public TestDialogPreference(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        public TestDialogPreference(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
    }
}
