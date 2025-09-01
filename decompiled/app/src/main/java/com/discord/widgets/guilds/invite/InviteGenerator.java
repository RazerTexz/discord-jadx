package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/* compiled from: InviteGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u001f\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\r\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\bR:\u0010\u0018\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00150\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteGenerator;", "Ljava/io/Closeable;", "Lcom/discord/models/domain/ModelInvite;", "invite", "", "handleGeneratedInvite", "(Lcom/discord/models/domain/ModelInvite;)V", "handleRestCallFailed", "()V", "Lcom/discord/app/AppFragment;", "fragment", "", "Lcom/discord/primitives/ChannelId;", "channelId", "generate", "(Lcom/discord/app/AppFragment;J)V", "Lcom/discord/app/AppComponent;", "appComponent", "generateForAppComponent", "(Lcom/discord/app/AppComponent;J)V", "close", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;", "kotlin.jvm.PlatformType", "generationStateSubject", "Lrx/subjects/BehaviorSubject;", "Lrx/Observable;", "generationState", "Lrx/Observable;", "getGenerationState", "()Lrx/Observable;", "<init>", "GenerationState", "InviteGenerationState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class InviteGenerator implements Closeable {
    private final Observable<InviteGenerationState> generationState;
    private final BehaviorSubject<InviteGenerationState> generationStateSubject;

    /* compiled from: InviteGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteGenerator$GenerationState;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "GENERATING", "SUCCESS", "FAILURE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum GenerationState {
        INIT,
        GENERATING,
        SUCCESS,
        FAILURE
    }

    /* compiled from: InviteGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;", "", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "Lcom/discord/widgets/guilds/invite/InviteGenerator$GenerationState;", "component2", "()Lcom/discord/widgets/guilds/invite/InviteGenerator$GenerationState;", "lastGeneratedInvite", "state", "copy", "(Lcom/discord/models/domain/ModelInvite;Lcom/discord/widgets/guilds/invite/InviteGenerator$GenerationState;)Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guilds/invite/InviteGenerator$GenerationState;", "getState", "Lcom/discord/models/domain/ModelInvite;", "getLastGeneratedInvite", "<init>", "(Lcom/discord/models/domain/ModelInvite;Lcom/discord/widgets/guilds/invite/InviteGenerator$GenerationState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class InviteGenerationState {
        private final ModelInvite lastGeneratedInvite;
        private final GenerationState state;

        public InviteGenerationState() {
            this(null, null, 3, null);
        }

        public InviteGenerationState(ModelInvite modelInvite, GenerationState generationState) {
            Intrinsics3.checkNotNullParameter(generationState, "state");
            this.lastGeneratedInvite = modelInvite;
            this.state = generationState;
        }

        public static /* synthetic */ InviteGenerationState copy$default(InviteGenerationState inviteGenerationState, ModelInvite modelInvite, GenerationState generationState, int i, Object obj) {
            if ((i & 1) != 0) {
                modelInvite = inviteGenerationState.lastGeneratedInvite;
            }
            if ((i & 2) != 0) {
                generationState = inviteGenerationState.state;
            }
            return inviteGenerationState.copy(modelInvite, generationState);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelInvite getLastGeneratedInvite() {
            return this.lastGeneratedInvite;
        }

        /* renamed from: component2, reason: from getter */
        public final GenerationState getState() {
            return this.state;
        }

        public final InviteGenerationState copy(ModelInvite lastGeneratedInvite, GenerationState state) {
            Intrinsics3.checkNotNullParameter(state, "state");
            return new InviteGenerationState(lastGeneratedInvite, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InviteGenerationState)) {
                return false;
            }
            InviteGenerationState inviteGenerationState = (InviteGenerationState) other;
            return Intrinsics3.areEqual(this.lastGeneratedInvite, inviteGenerationState.lastGeneratedInvite) && Intrinsics3.areEqual(this.state, inviteGenerationState.state);
        }

        public final ModelInvite getLastGeneratedInvite() {
            return this.lastGeneratedInvite;
        }

        public final GenerationState getState() {
            return this.state;
        }

        public int hashCode() {
            ModelInvite modelInvite = this.lastGeneratedInvite;
            int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
            GenerationState generationState = this.state;
            return iHashCode + (generationState != null ? generationState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("InviteGenerationState(lastGeneratedInvite=");
            sbU.append(this.lastGeneratedInvite);
            sbU.append(", state=");
            sbU.append(this.state);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ InviteGenerationState(ModelInvite modelInvite, GenerationState generationState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : modelInvite, (i & 2) != 0 ? GenerationState.INIT : generationState);
        }
    }

    /* compiled from: InviteGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "p1", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generate$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ModelInvite, Unit> {
        public AnonymousClass1(InviteGenerator inviteGenerator) {
            super(1, inviteGenerator, InviteGenerator.class, "handleGeneratedInvite", "handleGeneratedInvite(Lcom/discord/models/domain/ModelInvite;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "p1");
            InviteGenerator.access$handleGeneratedInvite((InviteGenerator) this.receiver, modelInvite);
        }
    }

    /* compiled from: InviteGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generate$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            InviteGenerator.access$handleRestCallFailed(InviteGenerator.this);
        }
    }

    /* compiled from: InviteGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "invite", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generateForAppComponent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            InviteGenerator.access$handleGeneratedInvite(InviteGenerator.this, modelInvite);
        }
    }

    /* compiled from: InviteGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "<anonymous parameter 0>", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generateForAppComponent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "<anonymous parameter 0>");
            InviteGenerator.access$handleRestCallFailed(InviteGenerator.this);
        }
    }

    public InviteGenerator() {
        BehaviorSubject<InviteGenerationState> behaviorSubjectL0 = BehaviorSubject.l0(new InviteGenerationState(null, null, 3, null));
        this.generationStateSubject = behaviorSubjectL0;
        Observable<InviteGenerationState> observableR = behaviorSubjectL0.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "generationStateSubject.distinctUntilChanged()");
        this.generationState = observableR;
    }

    public static final /* synthetic */ void access$handleGeneratedInvite(InviteGenerator inviteGenerator, ModelInvite modelInvite) {
        inviteGenerator.handleGeneratedInvite(modelInvite);
    }

    public static final /* synthetic */ void access$handleRestCallFailed(InviteGenerator inviteGenerator) {
        inviteGenerator.handleRestCallFailed();
    }

    private final void handleGeneratedInvite(ModelInvite invite) {
        this.generationStateSubject.onNext(new InviteGenerationState(invite, GenerationState.SUCCESS));
    }

    private final void handleRestCallFailed() {
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.n0(), null, GenerationState.FAILURE, 1, null));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.generationStateSubject.onCompleted();
    }

    public final void generate(AppFragment fragment, long channelId) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.n0(), null, GenerationState.GENERATING, 1, null));
        ObservableExtensionsKt.ui$default(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), channelId, null, 2, null), fragment, null, 2, null).k(o.a.g(fragment.getContext(), new AnonymousClass1(this), new AnonymousClass2()));
    }

    public final void generateForAppComponent(AppComponent appComponent, long channelId) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.n0(), null, GenerationState.GENERATING, 1, null));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), channelId, null, 2, null)), appComponent, null, 2, null), InviteGenerator.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    public final Observable<InviteGenerationState> getGenerationState() {
        return this.generationState;
    }
}
