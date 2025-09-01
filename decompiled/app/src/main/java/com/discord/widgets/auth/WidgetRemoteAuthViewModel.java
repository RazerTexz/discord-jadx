package com.discord.widgets.auth;

import android.content.Context;
import androidx.view.ViewModel3;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Result3;
import d0.g0.StringsJVM;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetRemoteAuthViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0019\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u0005R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR:\u0010\u0010\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00060\u0006 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;", "", "remoteLogin", "()V", "", "isTemporary", "toggleTemporary", "(Z)V", "cancelLogin", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "temporaryBehaviorSubject", "Lrx/subjects/BehaviorSubject;", "", "fingerprint", "<init>", "(Ljava/lang/String;Lcom/discord/utilities/rest/RestAPI;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetRemoteAuthViewModel extends AppViewModel<ViewState> {
    private final RestAPI restAPI;
    private final BehaviorSubject<Boolean> temporaryBehaviorSubject;

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelRemoteAuthHandshake;", "handshakeData", "", "invoke", "(Lcom/discord/models/domain/ModelRemoteAuthHandshake;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelRemoteAuthHandshake, Unit> {

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        @DebugMetadata(c = "com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1", f = "WidgetRemoteAuthViewModel.kt", l = {54}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02371 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ ModelRemoteAuthHandshake $handshakeData;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02371(ModelRemoteAuthHandshake modelRemoteAuthHandshake, Continuation continuation) {
                super(2, continuation);
                this.$handshakeData = modelRemoteAuthHandshake;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass1.this.new C02371(this.$handshakeData, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02371) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (f.P(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = WidgetRemoteAuthViewModel.this;
                String handshakeToken = this.$handshakeData.getHandshakeToken();
                BehaviorSubject behaviorSubjectAccess$getTemporaryBehaviorSubject$p = WidgetRemoteAuthViewModel.access$getTemporaryBehaviorSubject$p(WidgetRemoteAuthViewModel.this);
                Intrinsics3.checkNotNullExpressionValue(behaviorSubjectAccess$getTemporaryBehaviorSubject$p, "temporaryBehaviorSubject");
                Object objN0 = behaviorSubjectAccess$getTemporaryBehaviorSubject$p.n0();
                Intrinsics3.checkNotNullExpressionValue(objN0, "temporaryBehaviorSubject.value");
                WidgetRemoteAuthViewModel.access$updateViewState(widgetRemoteAuthViewModel, new ViewState.Loaded(handshakeToken, ((Boolean) objN0).booleanValue(), true));
                return Unit.a;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
            invoke2(modelRemoteAuthHandshake);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
            Intrinsics3.checkNotNullParameter(modelRemoteAuthHandshake, "handshakeData");
            WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = WidgetRemoteAuthViewModel.this;
            String handshakeToken = modelRemoteAuthHandshake.getHandshakeToken();
            BehaviorSubject behaviorSubjectAccess$getTemporaryBehaviorSubject$p = WidgetRemoteAuthViewModel.access$getTemporaryBehaviorSubject$p(WidgetRemoteAuthViewModel.this);
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectAccess$getTemporaryBehaviorSubject$p, "temporaryBehaviorSubject");
            Object objN0 = behaviorSubjectAccess$getTemporaryBehaviorSubject$p.n0();
            Intrinsics3.checkNotNullExpressionValue(objN0, "temporaryBehaviorSubject.value");
            WidgetRemoteAuthViewModel.access$updateViewState(widgetRemoteAuthViewModel, new ViewState.Loaded(handshakeToken, ((Boolean) objN0).booleanValue(), false));
            f.H0(ViewModel3.getViewModelScope(WidgetRemoteAuthViewModel.this), null, null, new C02371(modelRemoteAuthHandshake, null), 3, null);
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(error, "it");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            if (response.getCode() != 10056) {
                return;
            }
            WidgetRemoteAuthViewModel.access$updateViewState(WidgetRemoteAuthViewModel.this, ViewState.Failed.INSTANCE);
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;", "", "<init>", "()V", "Failed", "Loaded", "Loading", "Succeeded", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Loading;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Loaded;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Succeeded;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Failed;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Loaded;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "handshakeToken", "isTemporary", "loginAllowed", "copy", "(Ljava/lang/String;ZZ)Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getHandshakeToken", "Z", "getLoginAllowed", "<init>", "(Ljava/lang/String;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final String handshakeToken;
            private final boolean isTemporary;
            private final boolean loginAllowed;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(String str, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "handshakeToken");
                this.handshakeToken = str;
                this.isTemporary = z2;
                this.loginAllowed = z3;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.handshakeToken;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isTemporary;
                }
                if ((i & 4) != 0) {
                    z3 = loaded.loginAllowed;
                }
                return loaded.copy(str, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final String getHandshakeToken() {
                return this.handshakeToken;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsTemporary() {
                return this.isTemporary;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getLoginAllowed() {
                return this.loginAllowed;
            }

            public final Loaded copy(String handshakeToken, boolean isTemporary, boolean loginAllowed) {
                Intrinsics3.checkNotNullParameter(handshakeToken, "handshakeToken");
                return new Loaded(handshakeToken, isTemporary, loginAllowed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.handshakeToken, loaded.handshakeToken) && this.isTemporary == loaded.isTemporary && this.loginAllowed == loaded.loginAllowed;
            }

            public final String getHandshakeToken() {
                return this.handshakeToken;
            }

            public final boolean getLoginAllowed() {
                return this.loginAllowed;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String str = this.handshakeToken;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.isTemporary;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.loginAllowed;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isTemporary() {
                return this.isTemporary;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(handshakeToken=");
                sbU.append(this.handshakeToken);
                sbU.append(", isTemporary=");
                sbU.append(this.isTemporary);
                sbU.append(", loginAllowed=");
                return outline.O(sbU, this.loginAllowed, ")");
            }
        }

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Loading;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: WidgetRemoteAuthViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState$Succeeded;", "Lcom/discord/widgets/auth/WidgetRemoteAuthViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Succeeded extends ViewState {
            public static final Succeeded INSTANCE = new Succeeded();

            private Succeeded() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$cancelLogin$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$remoteLogin$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetRemoteAuthViewModel.access$updateViewState(WidgetRemoteAuthViewModel.this, ViewState.Succeeded.INSTANCE);
        }
    }

    /* compiled from: WidgetRemoteAuthViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$remoteLogin$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetRemoteAuthViewModel.access$updateViewState(WidgetRemoteAuthViewModel.this, ViewState.Failed.INSTANCE);
        }
    }

    public /* synthetic */ WidgetRemoteAuthViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ BehaviorSubject access$getTemporaryBehaviorSubject$p(WidgetRemoteAuthViewModel widgetRemoteAuthViewModel) {
        return widgetRemoteAuthViewModel.temporaryBehaviorSubject;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetRemoteAuthViewModel widgetRemoteAuthViewModel, ViewState viewState) {
        widgetRemoteAuthViewModel.updateViewState(viewState);
    }

    public final void cancelLogin() {
        if (getViewState() instanceof ViewState.Loaded) {
            RestAPI restAPI = this.restAPI;
            ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.postRemoteAuthCancel(new RestAPIParams.RemoteAuthCancel(((ViewState.Loaded) viewState).getHandshakeToken())), false, 1, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
        }
    }

    public final void remoteLogin() {
        if (getViewState() instanceof ViewState.Loaded) {
            RestAPI restAPI = this.restAPI;
            ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthFinish(new RestAPIParams.RemoteAuthFinish(false, ((ViewState.Loaded) viewState).getHandshakeToken())), false), this, null, 2, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }

    public final void toggleTemporary(boolean isTemporary) {
        this.temporaryBehaviorSubject.onNext(Boolean.valueOf(isTemporary));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel(String str, RestAPI restAPI) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "fingerprint");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.temporaryBehaviorSubject = BehaviorSubject.l0(Boolean.TRUE);
        if (StringsJVM.isBlank(str)) {
            updateViewState(ViewState.Failed.INSTANCE);
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthInitialize(new RestAPIParams.RemoteAuthInitialize(str)), false), this, null, 2, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }
}
