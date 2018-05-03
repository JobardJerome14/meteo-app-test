package com.example.jjobard.newmeteo;

import com.example.jjobard.newmeteo.api.API;
import com.example.jjobard.newmeteo.api.helpers.ResultatCallback;
import com.example.jjobard.newmeteo.model.Meteo;

import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class APITests {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_get_meteo() {

        APITest apitest = new APITest();
        Call<Meteo> cm = apitest.get_meteo_by_city("Dijon");
        try {
            Response<Meteo> rm = cm.execute();
            assertEquals("Dijon", rm.body().getVille());
        } catch (IOException e) {
            assertTrue(false);
            e.printStackTrace();
        }
    }
}