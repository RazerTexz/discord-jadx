package com.discord.stores;

import com.discord.stores.StoreRtcConnection;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreVoiceSpeaking.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/discord/stores/StoreVoiceSpeaking;", "Lcom/discord/stores/StoreV2;", "", "", "getSpeakingUsers", "()Ljava/util/Set;", "Lrx/Observable;", "observeSpeakingUsers", "()Lrx/Observable;", "", "Lcom/discord/stores/StoreRtcConnection$SpeakingUserUpdate;", "speakingList", "", "handleSpeakingUpdates", "(Ljava/util/List;)V", "voiceChannelId", "handleVoiceChannelSelected", "(J)V", "snapshotData", "()V", "Ljava/util/HashSet;", "speakingUsers", "Ljava/util/HashSet;", "speakingUsersSnapshot", "Ljava/util/Set;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreVoiceSpeaking extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashSet<Long> speakingUsers;
    private Set<Long> speakingUsersSnapshot;

    /* compiled from: StoreVoiceSpeaking.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreVoiceSpeaking$observeSpeakingUsers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreVoiceSpeaking.this.getSpeakingUsers();
        }
    }

    public StoreVoiceSpeaking(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.speakingUsers = new HashSet<>();
        this.speakingUsersSnapshot = new HashSet();
    }

    public final Set<Long> getSpeakingUsers() {
        return this.speakingUsersSnapshot;
    }

    @Store3
    public final void handleSpeakingUpdates(List<StoreRtcConnection.SpeakingUserUpdate> speakingList) {
        Intrinsics3.checkNotNullParameter(speakingList, "speakingList");
        boolean z2 = false;
        for (StoreRtcConnection.SpeakingUserUpdate speakingUserUpdate : speakingList) {
            long userId = speakingUserUpdate.getUserId();
            boolean zAdd = speakingUserUpdate.getIsSpeaking() ? this.speakingUsers.add(Long.valueOf(userId)) : this.speakingUsers.remove(Long.valueOf(userId));
            if (!z2 && zAdd) {
                z2 = true;
            }
        }
        if (z2) {
            markChanged();
        }
    }

    @Store3
    public final void handleVoiceChannelSelected(long voiceChannelId) {
        if (voiceChannelId > 0) {
            return;
        }
        this.speakingUsers.clear();
        markChanged();
    }

    public final Observable<Set<Long>> observeSpeakingUsers() {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.speakingUsersSnapshot = new HashSet(this.speakingUsers);
    }
}
