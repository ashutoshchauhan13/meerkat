package android.com.sixthsense.meerkat;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by GrapeHut on 03/04/2015.
 */
public class RobotoSlabTextView extends TextView {


    public RobotoSlabTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void setTypeface(Typeface tf, int style) {
        if (style == Typeface.ITALIC) {
            super.setTypeface(FontUtil.getRobotoSlabThin(), 0);
        } else {
            super.setTypeface(FontUtil.getRobotoSlabRegular(), 0);
        }
    }

}