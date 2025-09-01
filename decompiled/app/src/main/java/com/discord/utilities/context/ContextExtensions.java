package com.discord.utilities.context;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.LocaleList;
import android.util.AttributeSet;
import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AppCompatActivity;
import d0.z.d.Intrinsics3;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ContextExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\t\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"Landroid/content/Context;", "Landroid/util/AttributeSet;", "attrs", "", "styleable", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "", "block", "useAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;[ILkotlin/jvm/functions/Function1;)V", "Landroidx/appcompat/app/AppCompatActivity;", "findActivity", "(Landroid/content/Context;)Landroidx/appcompat/app/AppCompatActivity;", "Ljava/util/Locale;", "getLocaleOrNull", "(Landroid/content/Context;)Ljava/util/Locale;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.context.ContextExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ContextExtensions {
    public static final AppCompatActivity findActivity(Context context) {
        Intrinsics3.checkNotNullParameter(context, "$this$findActivity");
        while (context != null) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                context = null;
            }
            ContextWrapper contextWrapper = (ContextWrapper) context;
            context = contextWrapper != null ? contextWrapper.getBaseContext() : null;
        }
        return null;
    }

    public static final Locale getLocaleOrNull(Context context) {
        Configuration configuration;
        Configuration configuration2;
        LocaleList locales;
        Intrinsics3.checkNotNullParameter(context, "$this$getLocaleOrNull");
        if (Build.VERSION.SDK_INT < 24) {
            Resources resources = context.getResources();
            if (resources == null || (configuration = resources.getConfiguration()) == null) {
                return null;
            }
            return configuration.locale;
        }
        Resources resources2 = context.getResources();
        if (resources2 == null || (configuration2 = resources2.getConfiguration()) == null || (locales = configuration2.getLocales()) == null) {
            return null;
        }
        return locales.get(0);
    }

    public static final void useAttrs(Context context, AttributeSet attributeSet, @StyleableRes int[] iArr, Function1<? super TypedArray, Unit> function1) {
        Intrinsics3.checkNotNullParameter(context, "$this$useAttrs");
        Intrinsics3.checkNotNullParameter(iArr, "styleable");
        Intrinsics3.checkNotNullParameter(function1, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        function1.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
