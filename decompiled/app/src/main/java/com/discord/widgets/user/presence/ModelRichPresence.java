package com.discord.widgets.user.presence;

import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.presence.PresenceUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ModelRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u00168F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006!"}, d2 = {"Lcom/discord/widgets/user/presence/ModelRichPresence;", "", "Lcom/discord/models/presence/Presence;", "component1", "()Lcom/discord/models/presence/Presence;", "Lcom/discord/api/application/Application;", "component2", "()Lcom/discord/api/application/Application;", "presence", "primaryApplication", "copy", "(Lcom/discord/models/presence/Presence;Lcom/discord/api/application/Application;)Lcom/discord/widgets/user/presence/ModelRichPresence;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/activity/Activity;", "getPrimaryActivity", "()Lcom/discord/api/activity/Activity;", "primaryActivity", "Lcom/discord/models/presence/Presence;", "getPresence", "Lcom/discord/api/application/Application;", "getPrimaryApplication", "<init>", "(Lcom/discord/models/presence/Presence;Lcom/discord/api/application/Application;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelRichPresence {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Presence presence;
    private final Application primaryApplication;

    /* compiled from: ModelRichPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/user/presence/ModelRichPresence$Companion;", "", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/stores/StoreUserPresence;", "storeUserPresence", "Lrx/Observable;", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "get", "(JLcom/discord/stores/StoreUserPresence;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Observable get$default(Companion companion, long j, StoreUserPresence storeUserPresence, int i, Object obj) {
            if ((i & 2) != 0) {
                storeUserPresence = StoreStream.INSTANCE.getPresences();
            }
            return companion.get(j, storeUserPresence);
        }

        public final Observable<ModelRichPresence> get(long userId, StoreUserPresence storeUserPresence) {
            Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Observable observableY = storeUserPresence.observePresenceForUser(userId).Y(ModelRichPresence3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeUserPresence\n      …          }\n            }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelRichPresence(Presence presence, Application application) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        this.presence = presence;
        this.primaryApplication = application;
    }

    public static /* synthetic */ ModelRichPresence copy$default(ModelRichPresence modelRichPresence, Presence presence, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            presence = modelRichPresence.presence;
        }
        if ((i & 2) != 0) {
            application = modelRichPresence.primaryApplication;
        }
        return modelRichPresence.copy(presence, application);
    }

    public static final Observable<ModelRichPresence> get(long j, StoreUserPresence storeUserPresence) {
        return INSTANCE.get(j, storeUserPresence);
    }

    /* renamed from: component1, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* renamed from: component2, reason: from getter */
    public final Application getPrimaryApplication() {
        return this.primaryApplication;
    }

    public final ModelRichPresence copy(Presence presence, Application primaryApplication) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        return new ModelRichPresence(presence, primaryApplication);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelRichPresence)) {
            return false;
        }
        ModelRichPresence modelRichPresence = (ModelRichPresence) other;
        return Intrinsics3.areEqual(this.presence, modelRichPresence.presence) && Intrinsics3.areEqual(this.primaryApplication, modelRichPresence.primaryApplication);
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final Activity getPrimaryActivity() {
        return PresenceUtils.INSTANCE.getPrimaryActivity(this.presence);
    }

    public final Application getPrimaryApplication() {
        return this.primaryApplication;
    }

    public int hashCode() {
        Presence presence = this.presence;
        int iHashCode = (presence != null ? presence.hashCode() : 0) * 31;
        Application application = this.primaryApplication;
        return iHashCode + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelRichPresence(presence=");
        sbU.append(this.presence);
        sbU.append(", primaryApplication=");
        sbU.append(this.primaryApplication);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ ModelRichPresence(Presence presence, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(presence, (i & 2) != 0 ? null : application);
    }
}
