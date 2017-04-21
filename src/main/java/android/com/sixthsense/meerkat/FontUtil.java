package android.com.sixthsense.meerkat;


import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by GrapeHut on 14/05/2015.
 */
public class FontUtil {

    private static Typeface robotoSlabThin;
    private static Typeface robotoSlabRegular;

    public static void initialise(Context context) {
        if (robotoSlabThin == null) {
            robotoSlabThin = Typeface.createFromAsset(context.getResources().getAssets(), "fonts/RobotoSlab-Thin.ttf");
        }
        if (robotoSlabRegular == null) {
            robotoSlabRegular = Typeface.createFromAsset(context.getResources().getAssets(), "fonts/RobotoSlab-Regular.ttf");
        }
    }

    public static Typeface getRobotoSlabThin() {
        return robotoSlabThin;

    }

    public static Typeface getRobotoSlabRegular() {
        return robotoSlabRegular;
    }
}
