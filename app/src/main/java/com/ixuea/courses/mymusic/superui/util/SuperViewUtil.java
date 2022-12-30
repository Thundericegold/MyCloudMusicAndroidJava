package com.ixuea.courses.mymusic.superui.util;

import android.view.View;

public class SuperViewUtil {
    public static void show(View data) {
        data.setVisibility(View.VISIBLE);
    }

    public static void gone(View data) {
        data.setVisibility(View.GONE);
    }
}
