package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ChatTypingModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "names", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingUsers$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel7<T, R> implements Func1<List<? extends String>, List<? extends CharSequence>> {
    public static final ChatTypingModel7 INSTANCE = new ChatTypingModel7();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<? extends CharSequence> call(List<? extends String> list) {
        return call2((List<String>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<CharSequence> call2(List<String> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "names");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(FormatUtils.l(outline.y("!!", (String) it.next(), "!!"), new Object[0], null, 2));
        }
        return _Collections.take(arrayList, 4);
    }
}
