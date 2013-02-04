package org.robolectric.shadows;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.robolectric.TestRunners;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Activity;
import android.content.Context;
import android.preference.EditTextPreference;

import org.robolectric.res.RoboAttributeSet;

@RunWith(TestRunners.WithDefaults.class)
public class EditTextPreferenceTest {

	private static final String SOME_TEXT = "some text";
	private EditTextPreference preference;

	private Context context;
	private RoboAttributeSet attrs;

	@Before
	public void setup() {
		context = new Activity();
		preference = new EditTextPreference(context, attrs);
	}

	@Test
	public void testConstructor() {
		preference = new EditTextPreference(context, attrs, 7);
		assertNotNull(preference.getEditText());
	}

	@Test
	public void testSetText() {
		preference.setText(SOME_TEXT);
		assertThat((String) preference.getEditText().getText().toString(), equalTo(SOME_TEXT));
	}

}
