package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.utilities.presence.PresenceUtils;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: ModelRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0005*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presence", "Lrx/Observable;", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/presence/Presence;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.presence.ModelRichPresence$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelRichPresence3<T, R> implements Func1<Presence, Observable<? extends ModelRichPresence>> {
    public static final ModelRichPresence3 INSTANCE = new ModelRichPresence3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ModelRichPresence> call(Presence presence) {
        return call2(presence);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModelRichPresence> call2(Presence presence) {
        Long applicationId;
        if (presence == null) {
            return new ScalarSynchronousObservable(null);
        }
        Activity primaryActivity = PresenceUtils.INSTANCE.getPrimaryActivity(presence);
        return (primaryActivity == null || (applicationId = primaryActivity.getApplicationId()) == null) ? new ScalarSynchronousObservable(new ModelRichPresence(presence, null, 2, null)) : StoreStream.INSTANCE.getApplication().observeApplication(Long.valueOf(applicationId.longValue())).G(new ModelRichPresence2(presence));
    }
}
