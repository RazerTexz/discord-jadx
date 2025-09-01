package com.discord.utilities.font;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.provider.Settings;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.core.content.res.ResourcesCompat;
import com.discord.stores.StoreStream;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: FontUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/font/FontUtils;", "", "Landroid/content/ContentResolver;", "contentResolver", "", "getSystemFontScaleInt", "(Landroid/content/ContentResolver;)I", "Landroid/content/Context;", "context", "", "getTargetFontScaleFloat", "(Landroid/content/Context;)F", "attrResourceId", "getThemedFontResId", "(Landroid/content/Context;I)I", "Landroid/graphics/Typeface;", "getThemedFont", "(Landroid/content/Context;I)Landroid/graphics/Typeface;", "USE_SYSTEM_FONT_SCALE", "I", "MAX_FONT_SCALING", "MIN_FONT_SCALING", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FontUtils {
    public static final FontUtils INSTANCE = new FontUtils();
    public static final int MAX_FONT_SCALING = 150;
    public static final int MIN_FONT_SCALING = 80;
    public static final int USE_SYSTEM_FONT_SCALE = -1;

    private FontUtils() {
    }

    public final int getSystemFontScaleInt(ContentResolver contentResolver) {
        Intrinsics3.checkNotNullParameter(contentResolver, "contentResolver");
        return MathJVM.roundToInt(Settings.System.getFloat(contentResolver, "font_scale", 1.0f) * 100);
    }

    public final float getTargetFontScaleFloat(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return StoreStream.INSTANCE.getUserSettingsSystem().getFontScale() == -1 ? Settings.System.getFloat(context.getContentResolver(), "font_scale", 1.0f) : r0.getUserSettingsSystem().getFontScale() / 100.0f;
    }

    public final Typeface getThemedFont(Context context, @AttrRes int attrResourceId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return ResourcesCompat.getFont(context, getThemedFontResId(context, attrResourceId));
    }

    public final int getThemedFontResId(Context context, @AttrRes int attrResourceId) {
        Resources.Theme theme;
        TypedValue typedValue = new TypedValue();
        if (context != null && (theme = context.getTheme()) != null) {
            theme.resolveAttribute(attrResourceId, typedValue, true);
        }
        return typedValue.resourceId;
    }
}
