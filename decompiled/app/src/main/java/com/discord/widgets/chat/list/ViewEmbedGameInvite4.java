package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: ViewEmbedGameInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005 \u0002*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "authorId", "Lrx/Observable;", "Lcom/discord/api/activity/Activity;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewEmbedGameInvite4<T, R> implements Func1<Long, Observable<? extends Activity>> {
    public final /* synthetic */ Long $applicationId;
    public final /* synthetic */ String $partyId;

    /* compiled from: ViewEmbedGameInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/activity/Activity;", "it", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/activity/Activity;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Activity, Boolean> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Activity activity) {
            return call2(activity);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean call2(Activity activity) {
            boolean z2;
            if (activity == null) {
                z2 = false;
            } else {
                ActivityParty party = activity.getParty();
                if (Intrinsics3.areEqual(party != null ? party.getId() : null, ViewEmbedGameInvite4.this.$partyId)) {
                    z2 = true;
                }
            }
            return Boolean.valueOf(z2);
        }
    }

    public ViewEmbedGameInvite4(Long l, String str) {
        this.$applicationId = l;
        this.$partyId = str;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Activity> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Activity> call2(Long l) {
        StoreUserPresence presences = StoreStream.INSTANCE.getPresences();
        Intrinsics3.checkNotNullExpressionValue(l, "authorId");
        return presences.observeApplicationActivity(l.longValue(), this.$applicationId.longValue()).y(new AnonymousClass1());
    }
}
