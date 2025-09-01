package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: StoreGuilds.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "token", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuilds3<T, R> implements Func1<String, Boolean> {
    public static final StoreGuilds3 INSTANCE = new StoreGuilds3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(String str) {
        boolean z2 = false;
        if (str != null) {
            int length = str.length() - 1;
            int i = 0;
            boolean z3 = false;
            while (i <= length) {
                boolean z4 = Intrinsics3.compare(str.charAt(!z3 ? i : length), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length--;
                } else if (z4) {
                    i++;
                } else {
                    z3 = true;
                }
            }
            if (str.subSequence(i, length + 1).toString().length() > 0) {
                z2 = true;
            }
        }
        return Boolean.valueOf(z2);
    }
}
