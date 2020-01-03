package com.nightcoder.pubgtips.Supports;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Checks {
    public static boolean isDarkMode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("user_prefs", MODE_PRIVATE);
        return (preferences.getString("darkMode", "false").equals("true"));
    }
}
