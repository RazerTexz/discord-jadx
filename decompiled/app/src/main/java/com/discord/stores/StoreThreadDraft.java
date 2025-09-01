package com.discord.stores;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreThreadDraft.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bR:\u0010\u000f\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u0003 \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\r0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreThreadDraft;", "Lcom/discord/stores/StoreV2;", "Lrx/Observable;", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "observeDraftState", "()Lrx/Observable;", "draftState", "", "setDraftState", "(Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;)V", "setDraftSending", "()V", "clearDraftState", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "draftStateSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;)V", "ThreadDraftState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreThreadDraft extends StoreV2 {
    private final Dispatcher dispatcher;
    private final BehaviorSubject<ThreadDraftState> draftStateSubject;

    /* compiled from: StoreThreadDraft.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u0010\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\r\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/String;", "component4", "component5", "isPrivate", "autoArchiveDuration", "threadName", "isSending", "shouldDisplayNameError", "copy", "(ZLjava/lang/Integer;Ljava/lang/String;ZZ)Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getThreadName", "Ljava/lang/Integer;", "getAutoArchiveDuration", "getShouldDisplayNameError", "<init>", "(ZLjava/lang/Integer;Ljava/lang/String;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ThreadDraftState {
        private final Integer autoArchiveDuration;
        private final boolean isPrivate;
        private final boolean isSending;
        private final boolean shouldDisplayNameError;
        private final String threadName;

        public ThreadDraftState() {
            this(false, null, null, false, false, 31, null);
        }

        public ThreadDraftState(boolean z2, Integer num, String str, boolean z3, boolean z4) {
            this.isPrivate = z2;
            this.autoArchiveDuration = num;
            this.threadName = str;
            this.isSending = z3;
            this.shouldDisplayNameError = z4;
        }

        public static /* synthetic */ ThreadDraftState copy$default(ThreadDraftState threadDraftState, boolean z2, Integer num, String str, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = threadDraftState.isPrivate;
            }
            if ((i & 2) != 0) {
                num = threadDraftState.autoArchiveDuration;
            }
            Integer num2 = num;
            if ((i & 4) != 0) {
                str = threadDraftState.threadName;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                z3 = threadDraftState.isSending;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                z4 = threadDraftState.shouldDisplayNameError;
            }
            return threadDraftState.copy(z2, num2, str2, z5, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsPrivate() {
            return this.isPrivate;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        /* renamed from: component3, reason: from getter */
        public final String getThreadName() {
            return this.threadName;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsSending() {
            return this.isSending;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getShouldDisplayNameError() {
            return this.shouldDisplayNameError;
        }

        public final ThreadDraftState copy(boolean isPrivate, Integer autoArchiveDuration, String threadName, boolean isSending, boolean shouldDisplayNameError) {
            return new ThreadDraftState(isPrivate, autoArchiveDuration, threadName, isSending, shouldDisplayNameError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadDraftState)) {
                return false;
            }
            ThreadDraftState threadDraftState = (ThreadDraftState) other;
            return this.isPrivate == threadDraftState.isPrivate && Intrinsics3.areEqual(this.autoArchiveDuration, threadDraftState.autoArchiveDuration) && Intrinsics3.areEqual(this.threadName, threadDraftState.threadName) && this.isSending == threadDraftState.isSending && this.shouldDisplayNameError == threadDraftState.shouldDisplayNameError;
        }

        public final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        public final boolean getShouldDisplayNameError() {
            return this.shouldDisplayNameError;
        }

        public final String getThreadName() {
            return this.threadName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isPrivate;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.autoArchiveDuration;
            int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.threadName;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            ?? r2 = this.isSending;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (iHashCode2 + i2) * 31;
            boolean z3 = this.shouldDisplayNameError;
            return i3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isPrivate() {
            return this.isPrivate;
        }

        public final boolean isSending() {
            return this.isSending;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ThreadDraftState(isPrivate=");
            sbU.append(this.isPrivate);
            sbU.append(", autoArchiveDuration=");
            sbU.append(this.autoArchiveDuration);
            sbU.append(", threadName=");
            sbU.append(this.threadName);
            sbU.append(", isSending=");
            sbU.append(this.isSending);
            sbU.append(", shouldDisplayNameError=");
            return outline.O(sbU, this.shouldDisplayNameError, ")");
        }

        public /* synthetic */ ThreadDraftState(boolean z2, Integer num, String str, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : num, (i & 4) == 0 ? str : null, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }
    }

    /* compiled from: StoreThreadDraft.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadDraft$clearDraftState$1, reason: invalid class name */
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
            StoreThreadDraft.access$getDraftStateSubject$p(StoreThreadDraft.this).onNext(new ThreadDraftState(false, null, null, false, false, 31, null));
        }
    }

    /* compiled from: StoreThreadDraft.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadDraft$setDraftSending$1, reason: invalid class name */
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
            BehaviorSubject behaviorSubjectAccess$getDraftStateSubject$p = StoreThreadDraft.access$getDraftStateSubject$p(StoreThreadDraft.this);
            BehaviorSubject behaviorSubjectAccess$getDraftStateSubject$p2 = StoreThreadDraft.access$getDraftStateSubject$p(StoreThreadDraft.this);
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectAccess$getDraftStateSubject$p2, "draftStateSubject");
            behaviorSubjectAccess$getDraftStateSubject$p.onNext(ThreadDraftState.copy$default((ThreadDraftState) behaviorSubjectAccess$getDraftStateSubject$p2.n0(), false, null, null, true, false, 23, null));
        }
    }

    /* compiled from: StoreThreadDraft.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreThreadDraft$setDraftState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ThreadDraftState $draftState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ThreadDraftState threadDraftState) {
            super(0);
            this.$draftState = threadDraftState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreThreadDraft.access$getDraftStateSubject$p(StoreThreadDraft.this).onNext(this.$draftState);
        }
    }

    public StoreThreadDraft(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.draftStateSubject = BehaviorSubject.l0(new ThreadDraftState(false, null, null, false, false, 31, null));
    }

    public static final /* synthetic */ BehaviorSubject access$getDraftStateSubject$p(StoreThreadDraft storeThreadDraft) {
        return storeThreadDraft.draftStateSubject;
    }

    public final void clearDraftState() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final Observable<ThreadDraftState> observeDraftState() {
        BehaviorSubject<ThreadDraftState> behaviorSubject = this.draftStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "draftStateSubject");
        return behaviorSubject;
    }

    public final void setDraftSending() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void setDraftState(ThreadDraftState draftState) {
        Intrinsics3.checkNotNullParameter(draftState, "draftState");
        this.dispatcher.schedule(new AnonymousClass1(draftState));
    }
}
