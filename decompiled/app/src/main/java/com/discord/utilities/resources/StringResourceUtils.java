package com.discord.utilities.resources;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.string.StringUtils2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: StringResourceUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aA\u0010\t\u001a\u00020\b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\t\u0010\u000e\u001a7\u0010\u000f\u001a\u00020\b*\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/content/res/Resources;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "zeroCountStringId", "quantity", "", "", "formatArgs", "", "getQuantityString", "(Landroid/content/res/Resources;III[Ljava/lang/Object;)Ljava/lang/CharSequence;", "Landroid/content/Context;", "context", "resId", "(Landroid/content/res/Resources;Landroid/content/Context;II[Ljava/lang/Object;)Ljava/lang/CharSequence;", "getI18nPluralString", "(Landroid/content/Context;II[Ljava/lang/Object;)Ljava/lang/CharSequence;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.resources.StringResourceUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class StringResourceUtils {
    public static final CharSequence getI18nPluralString(Context context, @PluralsRes int i, int i2, Object... objArr) {
        Intrinsics3.checkNotNullParameter(context, "$this$getI18nPluralString");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        String quantityString = context.getResources().getQuantityString(i, i2);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(resId, quantity)");
        return objArr.length == 0 ? FormatUtils.l(quantityString, new Object[0], null, 2) : FormatUtils.l(quantityString, Arrays.copyOf(objArr, objArr.length), null, 2);
    }

    public static final CharSequence getQuantityString(Resources resources, @PluralsRes int i, @StringRes int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(resources, "$this$getQuantityString");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        if (i3 == 0) {
            return FormatUtils.i(resources, i2, new Object[0], null, 4);
        }
        String quantityString = resources.getQuantityString(i, i3);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "getQuantityString(id, quantity)");
        return objArr.length == 0 ? FormatUtils.l(quantityString, new Object[0], null, 2) : FormatUtils.l(quantityString, Arrays.copyOf(objArr, objArr.length), null, 2);
    }

    public static final CharSequence getQuantityString(Resources resources, Context context, @PluralsRes int i, int i2, Object... objArr) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(resources, "$this$getQuantityString");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj instanceof Integer) {
                obj = StringUtils2.format(i2, context);
            }
            arrayList.add(obj);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String quantityString = resources.getQuantityString(i, i2);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "getQuantityString(resId, quantity)");
        if (array.length == 0) {
            return FormatUtils.l(quantityString, new Object[0], null, 2);
        }
        return FormatUtils.l(quantityString, Arrays.copyOf(array, array.length), null, 2);
    }
}
