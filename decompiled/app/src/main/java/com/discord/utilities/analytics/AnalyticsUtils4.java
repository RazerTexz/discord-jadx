package com.discord.utilities.analytics;

import com.discord.api.science.Science;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.error.Error;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AnalyticsUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.analytics.AnalyticsUtils$Tracker$drainEventsQueue$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnalyticsUtils4 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ ArrayList $copy;
    public final /* synthetic */ AnalyticsUtils.Tracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsUtils4(AnalyticsUtils.Tracker tracker, ArrayList arrayList) {
        super(1);
        this.this$0 = tracker;
        this.$copy = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        ArrayList arrayList = this.$copy;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Science.Event) it.next()).getType());
        }
        AppLog.g.w("failed to log events: " + arrayList2, error.getThrowable());
        AnalyticsUtils.Tracker.access$getEventsQueue$p(this.this$0).addAll(this.$copy);
    }
}
