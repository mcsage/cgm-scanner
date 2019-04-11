package de.welthungerhilfe.cgm.scanner;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import java.util.List;

import de.welthungerhilfe.cgm.scanner.datasource.models.Person;
import de.welthungerhilfe.cgm.scanner.datasource.repository.PersonRepository;
import de.welthungerhilfe.cgm.scanner.utils.Utils;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("de.welthungerhilfe.cgm.scanner", appContext.getPackageName());
    }

    @Test
    public void testPersonIds() {
        String validId = AppController.getInstance().getPersonId();
        String invalidId = "2e4358e040b59f2e_consent_1550288920148_eKtxZ4ZRBdXXIbQL";

        String[] array = invalidId.split("_");

        Assert.assertEquals("Person ID schema is not correct, expect 3 underscores", 4, array.length);
        Assert.assertEquals("wrong UUID", Utils.getAndroidID(InstrumentationRegistry.getTargetContext().getContentResolver()), array[0]);
        Assert.assertEquals("Wrong object name, expected : person", "person", array[1]);
    }
}
