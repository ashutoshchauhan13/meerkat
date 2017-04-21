package android.com.sixthsense.meerkat;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by GrapeHut on 03/04/2015.
 */
public class RobotoSlabButton extends Button {

    private final Context context;

    public RobotoSlabButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
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