package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.logging.Logger;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: StoreV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\n\u0010\u0006J#\u0010\n\u001a\u00020\u00042\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000b\"\u00020\u0003H\u0004¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/Store;", "Lcom/discord/stores/DispatchHandler;", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "", "assertStoreThread", "()V", "", "getUpdateSources", "()Ljava/util/Set;", "markChanged", "", "updates", "([Lcom/discord/stores/updates/ObservationDeck$UpdateSource;)V", "updateSource", "markUnchanged", "(Lcom/discord/stores/updates/ObservationDeck$UpdateSource;)V", "snapshotData", "onDispatchEnded", "", "updateSources", "Ljava/util/Set;", "<init>", "MarkChangedDelegate", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class StoreV2 extends Store implements Store2, ObservationDeck.UpdateSource {
    private final Set<ObservationDeck.UpdateSource> updateSources = new HashSet();

    /* compiled from: StoreV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0007\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/stores/StoreV2$MarkChangedDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/discord/stores/StoreV2;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Lcom/discord/stores/StoreV2;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", "setValue", "(Lcom/discord/stores/StoreV2;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Ljava/lang/Object;", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "overrideUpdateSource", "Lcom/discord/stores/updates/ObservationDeck$UpdateSource;", "<init>", "(Ljava/lang/Object;Lcom/discord/stores/updates/ObservationDeck$UpdateSource;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MarkChangedDelegate<T> {
        private final ObservationDeck.UpdateSource overrideUpdateSource;
        private T value;

        public MarkChangedDelegate(T t, ObservationDeck.UpdateSource updateSource) {
            this.value = t;
            this.overrideUpdateSource = updateSource;
        }

        public final T getValue(StoreV2 thisRef, KProperty<?> property) {
            Intrinsics3.checkNotNullParameter(property, "property");
            return this.value;
        }

        public final void setValue(StoreV2 thisRef, KProperty<?> property, T value) {
            Intrinsics3.checkNotNullParameter(property, "property");
            if (!Intrinsics3.areEqual(this.value, value)) {
                this.value = value;
                ObservationDeck.UpdateSource updateSource = this.overrideUpdateSource;
                if (updateSource != null) {
                    if (thisRef != null) {
                        thisRef.markChanged(updateSource);
                    }
                } else if (thisRef != null) {
                    thisRef.markChanged();
                }
            }
        }

        public /* synthetic */ MarkChangedDelegate(Object obj, ObservationDeck.UpdateSource updateSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? null : updateSource);
        }
    }

    private final void assertStoreThread() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        if (threadCurrentThread.getId() != StoreStream.INSTANCE.getSTORE_THREAD_ID()) {
            Logger.e$default(AppLog.g, "markChanged() should be run from the Store Dispatcher", new IllegalStateException("Dispatch not run on store thread"), null, 4, null);
        }
    }

    public final Set<ObservationDeck.UpdateSource> getUpdateSources() {
        return this.updateSources;
    }

    public final void markChanged() {
        assertStoreThread();
        this.updateSources.add(this);
    }

    public final void markUnchanged(ObservationDeck.UpdateSource updateSource) {
        Intrinsics3.checkNotNullParameter(updateSource, "updateSource");
        assertStoreThread();
        this.updateSources.remove(updateSource);
    }

    @Override // com.discord.stores.Store2
    public void onDispatchEnded() {
        this.updateSources.clear();
    }

    public void snapshotData() {
    }

    public final void markChanged(ObservationDeck.UpdateSource... updates) {
        Intrinsics3.checkNotNullParameter(updates, "updates");
        assertStoreThread();
        markChanged();
        MutableCollections.addAll(this.updateSources, updates);
    }
}
