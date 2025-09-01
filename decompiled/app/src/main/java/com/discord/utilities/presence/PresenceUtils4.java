package com.discord.utilities.presence;

import com.discord.api.activity.Activity;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: PresenceUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/activity/Activity;", "it", "", "invoke", "(Lcom/discord/api/activity/Activity;)Ljava/lang/Comparable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.presence.PresenceUtils$ACTIVITY_COMPARATOR$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class PresenceUtils4 extends Lambda implements Function1<Activity, Comparable<?>> {
    public static final PresenceUtils4 INSTANCE = new PresenceUtils4();

    public PresenceUtils4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(Activity activity) {
        return invoke2(activity);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "it");
        return Long.valueOf(activity.getCreatedAt());
    }
}
