package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: StoreGuilds.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "token", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuilds2<T, R> implements Func1<String, String> {
    public final /* synthetic */ boolean $autocomplete;

    public StoreGuilds2(boolean z2) {
        this.$autocomplete = z2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ String call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(String str) {
        if (this.$autocomplete) {
            if (!(str == null || str.length() == 0) && str.charAt(0) == '@') {
                String strSubstring = str.substring(1);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        if (!this.$autocomplete) {
            if (!(str == null || str.length() == 0)) {
                return str;
            }
        }
        return null;
    }
}
