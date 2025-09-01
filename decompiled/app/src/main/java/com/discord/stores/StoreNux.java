package com.discord.stores;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreNux.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\rJ\u001d\u0010\u0013\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\u00042\n\u0010\u001b\u001a\u00060\u0011j\u0002`\u0012H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00042\n\u0010\u001b\u001a\u00060\u0011j\u0002`\u0012H\u0007¢\u0006\u0004\b\u001e\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001fR:\u0010\"\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u00020\u0002 !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u00020\u0002\u0018\u00010 0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/discord/stores/StoreNux;", "Lcom/discord/stores/Store;", "Lcom/discord/stores/StoreNux$NuxState;", "nuxState", "", "publishNuxUpdated", "(Lcom/discord/stores/StoreNux$NuxState;)V", "Lrx/Observable;", "getNuxState", "()Lrx/Observable;", "", "value", "setFirstOpen", "(Z)V", "setPostRegister", "setPostRegisterWithInvite", "setContactSyncCompleted", "", "Lcom/discord/primitives/GuildId;", "setPremiumGuildHintGuildId", "(Ljava/lang/Long;)V", "Lkotlin/Function1;", "updateFunction", "updateNux", "(Lkotlin/jvm/functions/Function1;)V", "clearNux", "()V", "guildId", "handleGuildSelected", "(J)V", "handleSamplePremiumGuildSelected", "Lcom/discord/stores/StoreNux$NuxState;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "nuxStateSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;)V", "NuxState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNux extends Store {
    private final Dispatcher dispatcher;
    private NuxState nuxState;
    private final BehaviorSubject<NuxState> nuxStateSubject;

    /* compiled from: StoreNux.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJT\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b#\u0010\u0004R!\u0010\u0012\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\f¨\u0006("}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "", "", "component1", "()Z", "component2", "component3", "component4", "component5", "", "Lcom/discord/primitives/GuildId;", "component6", "()Ljava/lang/Long;", "postRegister", "postRegisterWithInvite", "contactSyncCompleted", "firstOpen", "addGuildHint", "guildBoostHintGuildId", "copy", "(ZZZZZLjava/lang/Long;)Lcom/discord/stores/StoreNux$NuxState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPostRegisterWithInvite", "getContactSyncCompleted", "getPostRegister", "getFirstOpen", "getAddGuildHint", "Ljava/lang/Long;", "getGuildBoostHintGuildId", "<init>", "(ZZZZZLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class NuxState {
        private final boolean addGuildHint;
        private final boolean contactSyncCompleted;
        private final boolean firstOpen;
        private final Long guildBoostHintGuildId;
        private final boolean postRegister;
        private final boolean postRegisterWithInvite;

        public NuxState() {
            this(false, false, false, false, false, null, 63, null);
        }

        public NuxState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l) {
            this.postRegister = z2;
            this.postRegisterWithInvite = z3;
            this.contactSyncCompleted = z4;
            this.firstOpen = z5;
            this.addGuildHint = z6;
            this.guildBoostHintGuildId = l;
        }

        public static /* synthetic */ NuxState copy$default(NuxState nuxState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = nuxState.postRegister;
            }
            if ((i & 2) != 0) {
                z3 = nuxState.postRegisterWithInvite;
            }
            boolean z7 = z3;
            if ((i & 4) != 0) {
                z4 = nuxState.contactSyncCompleted;
            }
            boolean z8 = z4;
            if ((i & 8) != 0) {
                z5 = nuxState.firstOpen;
            }
            boolean z9 = z5;
            if ((i & 16) != 0) {
                z6 = nuxState.addGuildHint;
            }
            boolean z10 = z6;
            if ((i & 32) != 0) {
                l = nuxState.guildBoostHintGuildId;
            }
            return nuxState.copy(z2, z7, z8, z9, z10, l);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getPostRegister() {
            return this.postRegister;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getPostRegisterWithInvite() {
            return this.postRegisterWithInvite;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getContactSyncCompleted() {
            return this.contactSyncCompleted;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getFirstOpen() {
            return this.firstOpen;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getAddGuildHint() {
            return this.addGuildHint;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getGuildBoostHintGuildId() {
            return this.guildBoostHintGuildId;
        }

        public final NuxState copy(boolean postRegister, boolean postRegisterWithInvite, boolean contactSyncCompleted, boolean firstOpen, boolean addGuildHint, Long guildBoostHintGuildId) {
            return new NuxState(postRegister, postRegisterWithInvite, contactSyncCompleted, firstOpen, addGuildHint, guildBoostHintGuildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NuxState)) {
                return false;
            }
            NuxState nuxState = (NuxState) other;
            return this.postRegister == nuxState.postRegister && this.postRegisterWithInvite == nuxState.postRegisterWithInvite && this.contactSyncCompleted == nuxState.contactSyncCompleted && this.firstOpen == nuxState.firstOpen && this.addGuildHint == nuxState.addGuildHint && Intrinsics3.areEqual(this.guildBoostHintGuildId, nuxState.guildBoostHintGuildId);
        }

        public final boolean getAddGuildHint() {
            return this.addGuildHint;
        }

        public final boolean getContactSyncCompleted() {
            return this.contactSyncCompleted;
        }

        public final boolean getFirstOpen() {
            return this.firstOpen;
        }

        public final Long getGuildBoostHintGuildId() {
            return this.guildBoostHintGuildId;
        }

        public final boolean getPostRegister() {
            return this.postRegister;
        }

        public final boolean getPostRegisterWithInvite() {
            return this.postRegisterWithInvite;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.postRegister;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.postRegisterWithInvite;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.contactSyncCompleted;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.firstOpen;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            boolean z3 = this.addGuildHint;
            int i8 = (i7 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            Long l = this.guildBoostHintGuildId;
            return i8 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("NuxState(postRegister=");
            sbU.append(this.postRegister);
            sbU.append(", postRegisterWithInvite=");
            sbU.append(this.postRegisterWithInvite);
            sbU.append(", contactSyncCompleted=");
            sbU.append(this.contactSyncCompleted);
            sbU.append(", firstOpen=");
            sbU.append(this.firstOpen);
            sbU.append(", addGuildHint=");
            sbU.append(this.addGuildHint);
            sbU.append(", guildBoostHintGuildId=");
            return outline.G(sbU, this.guildBoostHintGuildId, ")");
        }

        public /* synthetic */ NuxState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) == 0 ? z6 : false, (i & 32) != 0 ? null : l);
        }
    }

    /* compiled from: StoreNux.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNux$clearNux$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreNux.access$setNuxState$p(StoreNux.this, new NuxState(false, false, false, false, false, null, 63, null));
            StoreNux storeNux = StoreNux.this;
            StoreNux.access$publishNuxUpdated(storeNux, StoreNux.access$getNuxState$p(storeNux));
        }
    }

    /* compiled from: StoreNux.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "it", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNux$setContactSyncCompleted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, this.$value, false, false, null, 59, null);
        }
    }

    /* compiled from: StoreNux.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "it", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNux$setFirstOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, false, this.$value, false, null, 55, null);
        }
    }

    /* compiled from: StoreNux.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "it", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNux$setPostRegister$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, this.$value, false, false, false, false, null, 62, null);
        }
    }

    /* compiled from: StoreNux.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "it", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNux$setPostRegisterWithInvite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, this.$value, false, false, false, null, 61, null);
        }
    }

    /* compiled from: StoreNux.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreNux$NuxState;", "it", "invoke", "(Lcom/discord/stores/StoreNux$NuxState;)Lcom/discord/stores/StoreNux$NuxState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNux$setPremiumGuildHintGuildId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ Long $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(1);
            this.$value = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NuxState invoke(NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NuxState invoke2(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, false, false, false, this.$value, 31, null);
        }
    }

    /* compiled from: StoreNux.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNux$updateNux$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function1 $updateFunction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(0);
            this.$updateFunction = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreNux storeNux = StoreNux.this;
            StoreNux.access$setNuxState$p(storeNux, (NuxState) this.$updateFunction.invoke(StoreNux.access$getNuxState$p(storeNux)));
            StoreNux storeNux2 = StoreNux.this;
            StoreNux.access$publishNuxUpdated(storeNux2, StoreNux.access$getNuxState$p(storeNux2));
        }
    }

    public StoreNux(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        NuxState nuxState = new NuxState(false, false, false, false, false, null, 63, null);
        this.nuxState = nuxState;
        this.nuxStateSubject = BehaviorSubject.l0(nuxState);
    }

    public static final /* synthetic */ NuxState access$getNuxState$p(StoreNux storeNux) {
        return storeNux.nuxState;
    }

    public static final /* synthetic */ void access$publishNuxUpdated(StoreNux storeNux, NuxState nuxState) {
        storeNux.publishNuxUpdated(nuxState);
    }

    public static final /* synthetic */ void access$setNuxState$p(StoreNux storeNux, NuxState nuxState) {
        storeNux.nuxState = nuxState;
    }

    private final void publishNuxUpdated(NuxState nuxState) {
        this.nuxStateSubject.onNext(nuxState);
    }

    public final void clearNux() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final Observable<NuxState> getNuxState() {
        Observable<NuxState> observableR = this.nuxStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "nuxStateSubject.distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleGuildSelected(long guildId) {
        Long guildBoostHintGuildId = this.nuxState.getGuildBoostHintGuildId();
        if (guildBoostHintGuildId != null && guildBoostHintGuildId.longValue() == guildId) {
            return;
        }
        NuxState nuxStateCopy$default = NuxState.copy$default(this.nuxState, false, false, false, false, false, null, 31, null);
        this.nuxState = nuxStateCopy$default;
        publishNuxUpdated(nuxStateCopy$default);
    }

    @Store3
    public final void handleSamplePremiumGuildSelected(long guildId) {
        NuxState nuxStateCopy$default = NuxState.copy$default(this.nuxState, false, false, false, false, false, Long.valueOf(guildId), 31, null);
        this.nuxState = nuxStateCopy$default;
        publishNuxUpdated(nuxStateCopy$default);
    }

    public final void setContactSyncCompleted(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setFirstOpen(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPostRegister(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPostRegisterWithInvite(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPremiumGuildHintGuildId(Long value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void updateNux(Function1<? super NuxState, NuxState> updateFunction) {
        Intrinsics3.checkNotNullParameter(updateFunction, "updateFunction");
        this.dispatcher.schedule(new AnonymousClass1(updateFunction));
    }
}
