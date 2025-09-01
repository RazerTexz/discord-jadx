package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildMemberVerificationForm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002()B#\u0012\u0006\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b&\u0010'J#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u0014\u0010\u0015R:\u0010\u0018\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\r0\u0016j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\r`\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\r0\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/discord/stores/StoreGuildMemberVerificationForm;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/models/domain/ModelMemberVerificationForm;", "memberVerificationForm", "", "handleMemberVerificationFormFetchSuccess", "(JLcom/discord/models/domain/ModelMemberVerificationForm;)V", "handleMemberVerificationFormFetchStart", "(J)V", "handleMemberVerificationFormFetchFailed", "Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "getMemberVerificationFormData", "(J)Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "Lrx/Observable;", "observeMemberVerificationFormData", "(J)Lrx/Observable;", "fetchMemberVerificationForm", "snapshotData", "()V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "memberVerificationFormState", "Ljava/util/HashMap;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "memberVerificationFormSnapshot", "Ljava/util/Map;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/updates/ObservationDeck;)V", "FetchStates", "MemberVerificationFormData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildMemberVerificationForm extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, MemberVerificationFormData> memberVerificationFormSnapshot;
    private final HashMap<Long, MemberVerificationFormData> memberVerificationFormState;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreGuildMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreGuildMemberVerificationForm$FetchStates;", "", "<init>", "(Ljava/lang/String;I)V", "FETCHING", "FAILED", "SUCCEEDED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum FetchStates {
        FETCHING,
        FAILED,
        SUCCEEDED
    }

    /* compiled from: StoreGuildMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "", "Lcom/discord/stores/StoreGuildMemberVerificationForm$FetchStates;", "component1", "()Lcom/discord/stores/StoreGuildMemberVerificationForm$FetchStates;", "Lcom/discord/models/domain/ModelMemberVerificationForm;", "component2", "()Lcom/discord/models/domain/ModelMemberVerificationForm;", "fetchState", "form", "copy", "(Lcom/discord/stores/StoreGuildMemberVerificationForm$FetchStates;Lcom/discord/models/domain/ModelMemberVerificationForm;)Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelMemberVerificationForm;", "getForm", "Lcom/discord/stores/StoreGuildMemberVerificationForm$FetchStates;", "getFetchState", "<init>", "(Lcom/discord/stores/StoreGuildMemberVerificationForm$FetchStates;Lcom/discord/models/domain/ModelMemberVerificationForm;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MemberVerificationFormData {
        private final FetchStates fetchState;
        private final ModelMemberVerificationForm form;

        public MemberVerificationFormData(FetchStates fetchStates, ModelMemberVerificationForm modelMemberVerificationForm) {
            Intrinsics3.checkNotNullParameter(fetchStates, "fetchState");
            this.fetchState = fetchStates;
            this.form = modelMemberVerificationForm;
        }

        public static /* synthetic */ MemberVerificationFormData copy$default(MemberVerificationFormData memberVerificationFormData, FetchStates fetchStates, ModelMemberVerificationForm modelMemberVerificationForm, int i, Object obj) {
            if ((i & 1) != 0) {
                fetchStates = memberVerificationFormData.fetchState;
            }
            if ((i & 2) != 0) {
                modelMemberVerificationForm = memberVerificationFormData.form;
            }
            return memberVerificationFormData.copy(fetchStates, modelMemberVerificationForm);
        }

        /* renamed from: component1, reason: from getter */
        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelMemberVerificationForm getForm() {
            return this.form;
        }

        public final MemberVerificationFormData copy(FetchStates fetchState, ModelMemberVerificationForm form) {
            Intrinsics3.checkNotNullParameter(fetchState, "fetchState");
            return new MemberVerificationFormData(fetchState, form);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberVerificationFormData)) {
                return false;
            }
            MemberVerificationFormData memberVerificationFormData = (MemberVerificationFormData) other;
            return Intrinsics3.areEqual(this.fetchState, memberVerificationFormData.fetchState) && Intrinsics3.areEqual(this.form, memberVerificationFormData.form);
        }

        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        public final ModelMemberVerificationForm getForm() {
            return this.form;
        }

        public int hashCode() {
            FetchStates fetchStates = this.fetchState;
            int iHashCode = (fetchStates != null ? fetchStates.hashCode() : 0) * 31;
            ModelMemberVerificationForm modelMemberVerificationForm = this.form;
            return iHashCode + (modelMemberVerificationForm != null ? modelMemberVerificationForm.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MemberVerificationFormData(fetchState=");
            sbU.append(this.fetchState);
            sbU.append(", form=");
            sbU.append(this.form);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreGuildMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildMemberVerificationForm.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationForm;", "memberVerificationForm", "", "invoke", "(Lcom/discord/models/domain/ModelMemberVerificationForm;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01211 extends Lambda implements Function1<ModelMemberVerificationForm, Unit> {

            /* compiled from: StoreGuildMemberVerificationForm.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01221 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelMemberVerificationForm $memberVerificationForm;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01221(ModelMemberVerificationForm modelMemberVerificationForm) {
                    super(0);
                    this.$memberVerificationForm = modelMemberVerificationForm;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildMemberVerificationForm.access$handleMemberVerificationFormFetchSuccess(StoreGuildMemberVerificationForm.this, anonymousClass1.$guildId, this.$memberVerificationForm);
                }
            }

            public C01211() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationForm modelMemberVerificationForm) {
                invoke2(modelMemberVerificationForm);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelMemberVerificationForm modelMemberVerificationForm) {
                Intrinsics3.checkNotNullParameter(modelMemberVerificationForm, "memberVerificationForm");
                StoreGuildMemberVerificationForm.access$getDispatcher$p(StoreGuildMemberVerificationForm.this).schedule(new C01221(modelMemberVerificationForm));
            }
        }

        /* compiled from: StoreGuildMemberVerificationForm.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreGuildMemberVerificationForm.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01231 extends Lambda implements Function0<Unit> {
                public C01231() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildMemberVerificationForm.access$handleMemberVerificationFormFetchFailed(StoreGuildMemberVerificationForm.this, anonymousClass1.$guildId);
                }
            }

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
                StoreGuildMemberVerificationForm.access$getDispatcher$p(StoreGuildMemberVerificationForm.this).schedule(new C01231());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MemberVerificationFormData memberVerificationFormData = (MemberVerificationFormData) StoreGuildMemberVerificationForm.access$getMemberVerificationFormState$p(StoreGuildMemberVerificationForm.this).get(Long.valueOf(this.$guildId));
            if ((memberVerificationFormData != null ? memberVerificationFormData.getFetchState() : null) == FetchStates.FETCHING) {
                return;
            }
            StoreGuildMemberVerificationForm.access$handleMemberVerificationFormFetchStart(StoreGuildMemberVerificationForm.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreGuildMemberVerificationForm.access$getRestAPI$p(StoreGuildMemberVerificationForm.this).getGuildMemberVerificationForm(this.$guildId), false, 1, null), StoreGuildMemberVerificationForm.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01211(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildMemberVerificationForm.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "invoke", "()Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$observeMemberVerificationFormData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<MemberVerificationFormData> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MemberVerificationFormData invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberVerificationFormData invoke() {
            return StoreGuildMemberVerificationForm.this.getMemberVerificationFormData(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildMemberVerificationForm(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getMemberVerificationFormState$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.memberVerificationFormState;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.restAPI;
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchFailed(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchStart(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchStart(j);
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchSuccess(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j, ModelMemberVerificationForm modelMemberVerificationForm) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchSuccess(j, modelMemberVerificationForm);
    }

    @Store3
    private final void handleMemberVerificationFormFetchFailed(long guildId) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.FAILED, null));
        markChanged();
    }

    @Store3
    private final void handleMemberVerificationFormFetchStart(long guildId) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.FETCHING, null));
        markChanged();
    }

    @Store3
    private final void handleMemberVerificationFormFetchSuccess(long guildId, ModelMemberVerificationForm memberVerificationForm) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.SUCCEEDED, memberVerificationForm));
        markChanged();
    }

    public final void fetchMemberVerificationForm(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final MemberVerificationFormData getMemberVerificationFormData(long guildId) {
        return this.memberVerificationFormSnapshot.get(Long.valueOf(guildId));
    }

    public final Observable<MemberVerificationFormData> observeMemberVerificationFormData(long guildId) {
        Observable<MemberVerificationFormData> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.memberVerificationFormSnapshot = new HashMap(this.memberVerificationFormState);
    }

    public StoreGuildMemberVerificationForm(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.memberVerificationFormSnapshot = Maps6.emptyMap();
        this.memberVerificationFormState = new HashMap<>();
    }
}
