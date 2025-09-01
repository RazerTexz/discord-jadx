package com.discord.widgets.notice;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import d0.Tuples;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetNoticeNuxSamsungLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001aB\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00030\u0003 \u0001* \u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "kotlin.jvm.PlatformType", "isAuthed", "Lcom/discord/models/user/MeUser;", "meUser", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Lcom/discord/models/user/MeUser;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$Companion$enqueue$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink2<T1, T2, R> implements Func2<Boolean, MeUser, Tuples2<? extends Boolean, ? extends MeUser>> {
    public static final WidgetNoticeNuxSamsungLink2 INSTANCE = new WidgetNoticeNuxSamsungLink2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Boolean, ? extends MeUser> call(Boolean bool, MeUser meUser) {
        return call2(bool, meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Boolean, MeUser> call2(Boolean bool, MeUser meUser) {
        return Tuples.to(bool, meUser);
    }
}
