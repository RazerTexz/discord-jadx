package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: Comparisons.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreEmoji$buildUsableEmojiSet$5$processGuildEmojis$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        String name = ((ModelEmojiCustom) t2).getName();
        Intrinsics3.checkNotNullExpressionValue(name, "it.name");
        Locale locale = Locale.ROOT;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String name2 = ((ModelEmojiCustom) t).getName();
        Intrinsics3.checkNotNullExpressionValue(name2, "it.name");
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = name2.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        return a.compareValues(lowerCase, lowerCase2);
    }
}
