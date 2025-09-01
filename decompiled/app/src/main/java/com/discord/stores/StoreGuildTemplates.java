package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildTemplates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00010B\u001f\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0016R\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010 ¨\u00061"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates;", "Lcom/discord/stores/StoreV2;", "", "guildTemplateCode", "", "requestGuildTemplate", "(Ljava/lang/String;)V", "Lcom/discord/models/domain/ModelGuildTemplate;", "guildTemplate", "handleRequestGuildTemplateSuccess", "(Lcom/discord/models/domain/ModelGuildTemplate;)V", "Lcom/discord/utilities/error/Error$Type;", "errorType", "handleRequestGuildTemplateError", "(Ljava/lang/String;Lcom/discord/utilities/error/Error$Type;)V", "Lrx/Observable;", "observeDynamicLinkGuildTemplateCode", "()Lrx/Observable;", "getDynamicLinkGuildTemplateCode", "()Ljava/lang/String;", "setDynamicLinkGuildTemplateCode", "clearDynamicLinkGuildTemplateCode", "()V", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "getGuildTemplate", "(Ljava/lang/String;)Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "observeGuildTemplate", "(Ljava/lang/String;)Lrx/Observable;", "maybeInitTemplateState", "snapshotData", "", "guildTemplatesByCode", "Ljava/util/Map;", "dynamicLinkGuildTemplateCode", "Ljava/lang/String;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "guildTemplatesByCodeSnapshot", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;)V", "GuildTemplateState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildTemplates extends StoreV2 {
    private final Dispatcher dispatcher;
    private String dynamicLinkGuildTemplateCode;
    private final Map<String, GuildTemplateState> guildTemplatesByCode;
    private Map<String, ? extends GuildTemplateState> guildTemplatesByCodeSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "", "<init>", "()V", "Invalid", "LoadFailed", "Loading", "None", "Resolved", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$None;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$Loading;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$LoadFailed;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$Invalid;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$Resolved;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class GuildTemplateState {

        /* compiled from: StoreGuildTemplates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$Invalid;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends GuildTemplateState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: StoreGuildTemplates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$LoadFailed;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class LoadFailed extends GuildTemplateState {
            public static final LoadFailed INSTANCE = new LoadFailed();

            private LoadFailed() {
                super(null);
            }
        }

        /* compiled from: StoreGuildTemplates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$Loading;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends GuildTemplateState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreGuildTemplates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$None;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class None extends GuildTemplateState {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        /* compiled from: StoreGuildTemplates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$Resolved;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "Lcom/discord/models/domain/ModelGuildTemplate;", "component1", "()Lcom/discord/models/domain/ModelGuildTemplate;", "guildTemplate", "copy", "(Lcom/discord/models/domain/ModelGuildTemplate;)Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState$Resolved;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelGuildTemplate;", "getGuildTemplate", "<init>", "(Lcom/discord/models/domain/ModelGuildTemplate;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Resolved extends GuildTemplateState {
            private final ModelGuildTemplate guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGuildTemplate modelGuildTemplate) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
                this.guildTemplate = modelGuildTemplate;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGuildTemplate modelGuildTemplate, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildTemplate = resolved.guildTemplate;
                }
                return resolved.copy(modelGuildTemplate);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public final Resolved copy(ModelGuildTemplate guildTemplate) {
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new Resolved(guildTemplate);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.guildTemplate, ((Resolved) other).guildTemplate);
                }
                return true;
            }

            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public int hashCode() {
                ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
                if (modelGuildTemplate != null) {
                    return modelGuildTemplate.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private GuildTemplateState() {
        }

        public /* synthetic */ GuildTemplateState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Error.Type.values();
            int[] iArr = new int[18];
            $EnumSwitchMapping$0 = iArr;
            iArr[Error.Type.DISCORD_REQUEST_ERROR.ordinal()] = 1;
            iArr[Error.Type.NETWORK.ordinal()] = 2;
        }
    }

    /* compiled from: StoreGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildTemplates$maybeInitTemplateState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGuildTemplates.access$getGuildTemplatesByCode$p(StoreGuildTemplates.this).containsKey(this.$guildTemplateCode) || (StoreGuildTemplates.access$getGuildTemplatesByCode$p(StoreGuildTemplates.this).get(this.$guildTemplateCode) instanceof GuildTemplateState.LoadFailed)) {
                StoreGuildTemplates.access$getGuildTemplatesByCode$p(StoreGuildTemplates.this).put(this.$guildTemplateCode, GuildTemplateState.Loading.INSTANCE);
                StoreGuildTemplates.this.markChanged();
                StoreGuildTemplates.access$requestGuildTemplate(StoreGuildTemplates.this, this.$guildTemplateCode);
            }
        }
    }

    /* compiled from: StoreGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildTemplates$observeDynamicLinkGuildTemplateCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<String> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            return StoreGuildTemplates.access$getDynamicLinkGuildTemplateCode$p(StoreGuildTemplates.this);
        }
    }

    /* compiled from: StoreGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "invoke", "()Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildTemplates$observeGuildTemplate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<GuildTemplateState> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ GuildTemplateState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildTemplateState invoke() {
            GuildTemplateState guildTemplate = StoreGuildTemplates.this.getGuildTemplate(this.$guildTemplateCode);
            return guildTemplate != null ? guildTemplate : GuildTemplateState.Loading.INSTANCE;
        }
    }

    /* compiled from: StoreGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelGuildTemplate;", "guildTemplate", "", "invoke", "(Lcom/discord/models/domain/ModelGuildTemplate;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelGuildTemplate, Unit> {

        /* compiled from: StoreGuildTemplates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01331 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelGuildTemplate $guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01331(ModelGuildTemplate modelGuildTemplate) {
                super(0);
                this.$guildTemplate = modelGuildTemplate;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildTemplates.access$handleRequestGuildTemplateSuccess(StoreGuildTemplates.this, this.$guildTemplate);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildTemplate modelGuildTemplate) {
            invoke2(modelGuildTemplate);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGuildTemplate modelGuildTemplate) {
            Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
            StoreGuildTemplates.access$getDispatcher$p(StoreGuildTemplates.this).schedule(new C01331(modelGuildTemplate));
        }
    }

    /* compiled from: StoreGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* compiled from: StoreGuildTemplates.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGuildTemplates storeGuildTemplates = StoreGuildTemplates.this;
                String str = anonymousClass2.$guildTemplateCode;
                Error.Type type = this.$error.getType();
                Intrinsics3.checkNotNullExpressionValue(type, "error.type");
                StoreGuildTemplates.access$handleRequestGuildTemplateError(storeGuildTemplates, str, type);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGuildTemplates.access$getDispatcher$p(StoreGuildTemplates.this).schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGuildTemplates.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildTemplates$setDynamicLinkGuildTemplateCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildTemplates.access$setDynamicLinkGuildTemplateCode$p(StoreGuildTemplates.this, this.$guildTemplateCode);
            StoreGuildTemplates.this.markChanged();
        }
    }

    public StoreGuildTemplates(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildTemplatesByCode = new LinkedHashMap();
        this.guildTemplatesByCodeSnapshot = Maps6.emptyMap();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildTemplates storeGuildTemplates) {
        return storeGuildTemplates.dispatcher;
    }

    public static final /* synthetic */ String access$getDynamicLinkGuildTemplateCode$p(StoreGuildTemplates storeGuildTemplates) {
        return storeGuildTemplates.dynamicLinkGuildTemplateCode;
    }

    public static final /* synthetic */ Map access$getGuildTemplatesByCode$p(StoreGuildTemplates storeGuildTemplates) {
        return storeGuildTemplates.guildTemplatesByCode;
    }

    public static final /* synthetic */ void access$handleRequestGuildTemplateError(StoreGuildTemplates storeGuildTemplates, String str, Error.Type type) {
        storeGuildTemplates.handleRequestGuildTemplateError(str, type);
    }

    public static final /* synthetic */ void access$handleRequestGuildTemplateSuccess(StoreGuildTemplates storeGuildTemplates, ModelGuildTemplate modelGuildTemplate) {
        storeGuildTemplates.handleRequestGuildTemplateSuccess(modelGuildTemplate);
    }

    public static final /* synthetic */ void access$requestGuildTemplate(StoreGuildTemplates storeGuildTemplates, String str) {
        storeGuildTemplates.requestGuildTemplate(str);
    }

    public static final /* synthetic */ void access$setDynamicLinkGuildTemplateCode$p(StoreGuildTemplates storeGuildTemplates, String str) {
        storeGuildTemplates.dynamicLinkGuildTemplateCode = str;
    }

    @Store3
    private final void handleRequestGuildTemplateError(String guildTemplateCode, Error.Type errorType) {
        int iOrdinal = errorType.ordinal();
        if (iOrdinal == 3) {
            this.guildTemplatesByCode.put(guildTemplateCode, GuildTemplateState.Invalid.INSTANCE);
            markChanged();
            AnalyticsTracker.guildTemplateResolveFailed(guildTemplateCode);
        } else {
            if (iOrdinal != 11) {
                return;
            }
            this.guildTemplatesByCode.put(guildTemplateCode, GuildTemplateState.LoadFailed.INSTANCE);
            markChanged();
        }
    }

    @Store3
    private final void handleRequestGuildTemplateSuccess(ModelGuildTemplate guildTemplate) {
        this.guildTemplatesByCode.put(guildTemplate.getCode(), new GuildTemplateState.Resolved(guildTemplate));
        markChanged();
        AnalyticsTracker.INSTANCE.guildTemplateResolved(guildTemplate);
    }

    private final void requestGuildTemplate(String guildTemplateCode) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildTemplateCode(guildTemplateCode), false, 1, null), StoreGuildTemplates.class, (Context) null, (Function1) null, new AnonymousClass2(guildTemplateCode), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    public final void clearDynamicLinkGuildTemplateCode() {
        setDynamicLinkGuildTemplateCode(null);
    }

    public final String getDynamicLinkGuildTemplateCode() {
        return this.dynamicLinkGuildTemplateCode;
    }

    public final GuildTemplateState getGuildTemplate(String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return this.guildTemplatesByCodeSnapshot.get(guildTemplateCode);
    }

    public final void maybeInitTemplateState(String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        this.dispatcher.schedule(new AnonymousClass1(guildTemplateCode));
    }

    public final Observable<String> observeDynamicLinkGuildTemplateCode() {
        Observable<String> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<GuildTemplateState> observeGuildTemplate(String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        Observable<GuildTemplateState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildTemplateCode), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setDynamicLinkGuildTemplateCode(String guildTemplateCode) {
        this.dispatcher.schedule(new AnonymousClass1(guildTemplateCode));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildTemplatesByCodeSnapshot = new HashMap(this.guildTemplatesByCode);
    }
}
