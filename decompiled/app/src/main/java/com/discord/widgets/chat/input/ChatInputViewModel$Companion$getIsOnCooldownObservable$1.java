package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: ChatInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "cooldownSecs", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(I)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$getIsOnCooldownObservable$1<T, R> implements Func1<Integer, Boolean> {
    public static final ChatInputViewModel$Companion$getIsOnCooldownObservable$1 INSTANCE = new ChatInputViewModel$Companion$getIsOnCooldownObservable$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Integer num) {
        return call(num.intValue());
    }

    public final Boolean call(int i) {
        return Boolean.valueOf(i > 0);
    }
}
