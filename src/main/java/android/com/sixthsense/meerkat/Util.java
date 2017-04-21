package android.com.sixthsense.meerkat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pc on 19/2/15.
 */
public class Util {

    private final static int INVALID_SCREEN_WIDTH = -1;
    private static int screenWidth = INVALID_SCREEN_WIDTH;
    private static int density = INVALID_SCREEN_WIDTH;


    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        return size.x;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static String getTimeDifferenceInMinutes(long prevTime) {
        if (prevTime != 0) {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            long currentTime = dateTime.getMillis();
            long diff = currentTime - prevTime;
            if (diff > 0) {
                long diffInHours = 0;
                long diffInMinutes = 0;
                long diffInSeconds = 0;
                long diffInDays = diff / (60 * 60 * 1000 * 24);
                if (diffInDays == 0) {
                    diffInHours = diff / (60 * 60 * 1000);
                    if (diffInHours == 0) {
                        diffInMinutes = diff / (60 * 1000);
                        if (diffInMinutes == 0) {
                            diffInSeconds = diff / 1000;
                            if (diffInSeconds == 1) {
                                return diffInSeconds + " second";
                            } else {
                                return diffInSeconds + " seconds";
                            }
                        } else {
                            if (diffInMinutes == 1) {
                                return diffInMinutes + " minute";
                            } else {
                                return diffInMinutes + " minutes";
                            }
                        }
                    } else {
                        if (diffInHours == 1) {
                            return diffInHours + " hour";
                        } else {
                            return diffInHours + " hours";
                        }
                    }
                } else {
                    if (diffInDays == 1) {
                        return diffInDays + " day";
                    } else {
                        return diffInDays + " days";
                    }
                }
            }
        }
        return "-";
    }

    public static long convertDateToLong(String dateInStringFormat, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, java.util.Locale.getDefault());
        try {
            Date date = simpleDateFormat.parse(dateInStringFormat);
            if (date != null) {
                return date.getTime();
            }
        } catch (Exception e) {
            //parsing error
        }
        return 0;
    }

    public static String getTimeAgo(String updatedDate, String format) {
        return getTimeDifferenceInMinutes(convertDateToLong(updatedDate, format));
    }


    private static void intializeScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        screenWidth = size.x;
    }


    public static int pixelFromDp(Context context, float dp) {
        if (density == INVALID_SCREEN_WIDTH) {
            density = (int) context.getResources().getDisplayMetrics().density;
        }
        return (int) dp * density;
    }

    private static String versionName = "";

    public static String getVersionName(Context context) {
        if (!TextUtils.isEmpty(versionName)) {
            return versionName;
        }
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            return "";
        }
    }

    public static boolean isOdd(int position) {
        if(position%2==0) {
            return false;
        }
        return true;
    }
}
