package com.discord.widgets.tos;

import com.discord.api.user.UserProfile;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetTosReportViolationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/user/UserProfile;", "userProfile", "", "invoke", "(Lcom/discord/api/user/UserProfile;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$sendReportAPICall$onFetchSuccess$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTosReportViolationViewModel2 extends Lambda implements Function1<UserProfile, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ int $reason;
    public final /* synthetic */ WidgetTosReportViolationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolationViewModel2(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel, int i, long j, long j2) {
        super(1);
        this.this$0 = widgetTosReportViolationViewModel;
        this.$reason = i;
        this.$channelId = j;
        this.$messageId = j2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfile userProfile) {
        invoke2(userProfile);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
        List<UserProfile.GuildReference> listD = userProfile.d();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listD, 10));
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((UserProfile.GuildReference) it.next()).getId()));
        }
        AnalyticsTracker.INSTANCE.reportTosViolation(this.$reason, this.$channelId, this.$messageId, arrayList);
    }
}
