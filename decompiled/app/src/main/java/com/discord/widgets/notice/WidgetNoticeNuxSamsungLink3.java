package com.discord.widgets.notice;

import com.discord.models.user.MeUser;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.notice.WidgetNoticeNuxSamsungLink;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNoticeNuxSamsungLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052F\u0010\u0004\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "Lcom/discord/models/user/MeUser;", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$Companion$enqueue$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink3 extends Lambda implements Function1<Tuples2<? extends Boolean, ? extends MeUser>, Unit> {
    public final /* synthetic */ Clock $clock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeNuxSamsungLink3(Clock clock) {
        super(1);
        this.$clock = clock;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Boolean, ? extends MeUser> tuples2) {
        invoke2((Tuples2<Boolean, MeUser>) tuples2);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples2<Boolean, MeUser> tuples2) {
        Boolean boolComponent1 = tuples2.component1();
        MeUser meUserComponent2 = tuples2.component2();
        if (!boolComponent1.booleanValue()) {
            Intrinsics3.checkNotNullParameter("google", "flavorVendor");
            if (!Intrinsics3.areEqual("google", "samsung")) {
                StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), "NUX/SamsungLink", 0L, 2, null);
            }
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUserComponent2, "meUser");
        if (userUtils.getAgeMs(meUserComponent2, this.$clock) > 2419200000L) {
            WidgetNoticeNuxSamsungLink.Companion.access$internalEnqueue(WidgetNoticeNuxSamsungLink.INSTANCE);
        }
    }
}
