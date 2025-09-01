package com.discord.stores.updates;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ObservationDeck.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/discord/stores/updates/ObservationDeck$connect$observer$1", "Lcom/discord/stores/updates/ObservationDeck$Observer;", "", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "observingUpdates", "Ljava/util/Set;", "getObservingUpdates", "()Ljava/util/Set;", "Lkotlin/Function0;", "", "onUpdate", "Lkotlin/jvm/functions/Function0;", "getOnUpdate", "()Lkotlin/jvm/functions/Function0;", "setOnUpdate", "(Lkotlin/jvm/functions/Function0;)V", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.updates.ObservationDeck$connect$observer$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ObservationDeck3 extends ObservationDeck.Observer {
    public final /* synthetic */ String $observerName;
    public final /* synthetic */ Function0 $onUpdate;
    public final /* synthetic */ ObservationDeck.UpdateSource[] $updateSources;
    private final String name;
    private final Set<ObservationDeck.UpdateSource> observingUpdates;
    private Function0<Unit> onUpdate;

    public ObservationDeck3(ObservationDeck.UpdateSource[] updateSourceArr, Function0 function0, String str) {
        this.$updateSources = updateSourceArr;
        this.$onUpdate = function0;
        this.$observerName = str;
        this.observingUpdates = _Arrays.toSet(updateSourceArr);
        this.onUpdate = function0;
        this.name = str == null ? String.valueOf(hashCode()) : str;
    }

    @Override // com.discord.stores.updates.ObservationDeck.Observer
    public String getName() {
        return this.name;
    }

    @Override // com.discord.stores.updates.ObservationDeck.Observer
    public Set<ObservationDeck.UpdateSource> getObservingUpdates() {
        return this.observingUpdates;
    }

    @Override // com.discord.stores.updates.ObservationDeck.Observer
    public Function0<Unit> getOnUpdate() {
        return this.onUpdate;
    }

    @Override // com.discord.stores.updates.ObservationDeck.Observer
    public void setOnUpdate(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onUpdate = function0;
    }
}
