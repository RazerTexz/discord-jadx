package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStreamPreview;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.Clock;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import retrofit2.HttpException;
import rx.Observable;
import rx.Subscription;

/* compiled from: StoreApplicationStreamPreviews.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u0001:\u0002;<B+\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010.\u001a\u00020-\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b9\u0010:J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u001d\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0012\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0007J#\u0010\u0017\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0016\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u0006\u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R&\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\b0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R:\u00103\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020100j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u000201`28\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R&\u00106\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\b058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010&R:\u00108\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020700j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u000207`28\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00104¨\u0006="}, d2 = {"Lcom/discord/stores/StoreApplicationStreamPreviews;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/StreamKey;", "streamKey", "", "fetchStreamPreviewIfNotFetching", "(Ljava/lang/String;)V", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "preview", "(Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;Ljava/lang/String;)V", "fetchStreamPreview", "", "getStreamKeyToPreviewMap", "()Ljava/util/Map;", "Lcom/discord/models/domain/ModelApplicationStream;", "applicationStream", "Lrx/Observable;", "observeStreamPreview", "(Lcom/discord/models/domain/ModelApplicationStream;)Lrx/Observable;", "(Ljava/lang/String;)Lrx/Observable;", "handleFetchStart", "url", "handleFetchSuccess", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/utilities/error/Error;", "error", "handleFetchFailed", "(Ljava/lang/String;Lcom/discord/utilities/error/Error;)V", "snapshotData", "()V", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "(Lcom/discord/utilities/streams/StreamContext;)V", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "streamKeyToPreviewMapSnapshot", "Ljava/util/Map;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "fetchAttempts", "Ljava/util/HashMap;", "", "streamKeyToPreviewMap", "Lrx/Subscription;", "fetchStreamPreviewSubscriptions", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "StreamPreview", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews extends StoreV2 {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long READ_PREVIEW_DEFAULT_RETRY_DELAY_MS = 10000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final HashMap<String, Integer> fetchAttempts;
    private final HashMap<String, Subscription> fetchStreamPreviewSubscriptions;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final Map<String, StreamPreview> streamKeyToPreviewMap;
    private Map<String, ? extends StreamPreview> streamKeyToPreviewMapSnapshot;

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreApplicationStreamPreviews$Companion;", "", "", "READ_PREVIEW_DEFAULT_RETRY_DELAY_MS", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "", "<init>", "()V", "Fetching", "Resolved", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview$Resolved;", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview$Fetching;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StreamPreview {

        /* compiled from: StoreApplicationStreamPreviews.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview$Fetching;", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Fetching extends StreamPreview {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* compiled from: StoreApplicationStreamPreviews.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview$Resolved;", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "", "component1", "()Ljava/lang/String;", "url", "copy", "(Ljava/lang/String;)Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview$Resolved;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUrl", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Resolved extends StreamPreview {
            private final String url;

            public Resolved(String str) {
                super(null);
                this.url = str;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = resolved.url;
                }
                return resolved.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final Resolved copy(String url) {
                return new Resolved(url);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.url, ((Resolved) other).url);
                }
                return true;
            }

            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                String str = this.url;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("Resolved(url="), this.url, ")");
            }
        }

        private StreamPreview() {
        }

        public /* synthetic */ StreamPreview(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.this.handleFetchStart(this.$streamKey);
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews.this).put(this.$streamKey, subscription);
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelApplicationStreamPreview;", "res", "", "invoke", "(Lcom/discord/models/domain/ModelApplicationStreamPreview;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ModelApplicationStreamPreview, Unit> {
        public final /* synthetic */ String $streamKey;

        /* compiled from: StoreApplicationStreamPreviews.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelApplicationStreamPreview $res;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelApplicationStreamPreview modelApplicationStreamPreview) {
                super(0);
                this.$res = modelApplicationStreamPreview;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreApplicationStreamPreviews.this.handleFetchSuccess(anonymousClass3.$streamKey, this.$res.getUrl());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelApplicationStreamPreview modelApplicationStreamPreview) {
            invoke2(modelApplicationStreamPreview);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelApplicationStreamPreview modelApplicationStreamPreview) {
            Intrinsics3.checkNotNullParameter(modelApplicationStreamPreview, "res");
            StoreApplicationStreamPreviews.access$getDispatcher$p(StoreApplicationStreamPreviews.this).schedule(new AnonymousClass1(modelApplicationStreamPreview));
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $streamKey;

        /* compiled from: StoreApplicationStreamPreviews.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$4$1, reason: invalid class name */
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
                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                StoreApplicationStreamPreviews.this.handleFetchFailed(anonymousClass4.$streamKey, this.$error);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreApplicationStreamPreviews.access$getDispatcher$p(StoreApplicationStreamPreviews.this).schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews.this).remove(this.$streamKey);
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews.this).put(this.$streamKey, subscription);
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews.this).remove(this.$streamKey);
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ String $streamKey;

        /* compiled from: StoreApplicationStreamPreviews.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$3$1, reason: invalid class name */
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
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreApplicationStreamPreviews.access$fetchStreamPreviewIfNotFetching(StoreApplicationStreamPreviews.this, anonymousClass3.$streamKey);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreApplicationStreamPreviews.access$getDispatcher$p(StoreApplicationStreamPreviews.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreApplicationStreamPreviews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "invoke", "()Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationStreamPreviews$observeStreamPreview$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StreamPreview> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StreamPreview invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StreamPreview invoke() {
            return StoreApplicationStreamPreviews.this.getStreamKeyToPreviewMap().get(this.$streamKey);
        }
    }

    public /* synthetic */ StoreApplicationStreamPreviews(Dispatcher dispatcher, Clock clock, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchStreamPreviewIfNotFetching(StoreApplicationStreamPreviews storeApplicationStreamPreviews, String str) {
        storeApplicationStreamPreviews.fetchStreamPreviewIfNotFetching(str);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return storeApplicationStreamPreviews.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return storeApplicationStreamPreviews.fetchStreamPreviewSubscriptions;
    }

    private final void fetchStreamPreview(String streamKey) {
        this.dispatcher.schedule(new AnonymousClass1(streamKey));
        Subscription subscription = this.fetchStreamPreviewSubscriptions.get(streamKey);
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(this.restAPI.getStreamPreview(streamKey, this.clock.currentTimeMillis()), false), StoreApplicationStreamPreviews.class, (Context) null, new AnonymousClass2(streamKey), new AnonymousClass4(streamKey), new AnonymousClass5(streamKey), (Function0) null, new AnonymousClass3(streamKey), 34, (Object) null);
    }

    public final void fetchStreamPreviewIfNotFetching(StreamContext streamContext) {
        Intrinsics3.checkNotNullParameter(streamContext, "streamContext");
        fetchStreamPreviewIfNotFetching(streamContext.getPreview(), streamContext.getStream().getEncodedStreamKey());
    }

    public final Map<String, StreamPreview> getStreamKeyToPreviewMap() {
        return this.streamKeyToPreviewMapSnapshot;
    }

    @Store3
    public final void handleFetchFailed(String streamKey, Error error) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(error, "error");
        Long lValueOf = null;
        this.streamKeyToPreviewMap.put(streamKey, new StreamPreview.Resolved(null));
        Throwable throwable = error.getThrowable();
        if (!(throwable instanceof HttpException)) {
            throwable = null;
        }
        HttpException httpException = (HttpException) throwable;
        Integer numValueOf = httpException != null ? Integer.valueOf(httpException.a()) : null;
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Long retryAfterMs = response.getRetryAfterMs();
        Integer num = this.fetchAttempts.get(streamKey);
        if (num == null) {
            num = 0;
        }
        Intrinsics3.checkNotNullExpressionValue(num, "fetchAttempts[streamKey] ?: 0");
        int iIntValue = num.intValue() + 1;
        long jLongValue = iIntValue * 10000;
        if (numValueOf == null) {
            lValueOf = Long.valueOf(jLongValue);
        } else if (numValueOf.intValue() == 429) {
            if (retryAfterMs != null) {
                jLongValue = retryAfterMs.longValue();
            }
            lValueOf = Long.valueOf(jLongValue);
        } else if (numValueOf.intValue() != 401 && numValueOf.intValue() != 403) {
            lValueOf = Long.valueOf(jLongValue);
        }
        if (lValueOf != null) {
            Subscription subscription = this.fetchStreamPreviewSubscriptions.get(streamKey);
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Long> observableD0 = Observable.d0(lValueOf.longValue(), TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(retryAf…s, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(observableD0, StoreApplicationStreamPreviews.class, (Context) null, new AnonymousClass1(streamKey), (Function1) null, new AnonymousClass2(streamKey), (Function0) null, new AnonymousClass3(streamKey), 42, (Object) null);
        }
        this.fetchAttempts.put(streamKey, Integer.valueOf(iIntValue));
        markChanged();
    }

    @Store3
    public final void handleFetchStart(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.streamKeyToPreviewMap.put(streamKey, StreamPreview.Fetching.INSTANCE);
        markChanged();
    }

    @Store3
    public final void handleFetchSuccess(String streamKey, String url) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(url, "url");
        this.streamKeyToPreviewMap.put(streamKey, new StreamPreview.Resolved(url));
        this.fetchAttempts.remove(streamKey);
        markChanged();
    }

    public final Observable<StreamPreview> observeStreamPreview(ModelApplicationStream applicationStream) {
        Intrinsics3.checkNotNullParameter(applicationStream, "applicationStream");
        return observeStreamPreview(applicationStream.getEncodedStreamKey());
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.streamKeyToPreviewMapSnapshot = new HashMap(this.streamKeyToPreviewMap);
    }

    public final Observable<StreamPreview> observeStreamPreview(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Observable<StreamPreview> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(streamKey), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public StoreApplicationStreamPreviews(Dispatcher dispatcher, Clock clock, RestAPI restAPI, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.streamKeyToPreviewMap = new HashMap();
        this.streamKeyToPreviewMapSnapshot = Maps6.emptyMap();
        this.fetchAttempts = new HashMap<>();
        this.fetchStreamPreviewSubscriptions = new HashMap<>();
    }

    @Store3
    private final void fetchStreamPreviewIfNotFetching(String streamKey) {
        fetchStreamPreviewIfNotFetching(this.streamKeyToPreviewMap.get(streamKey), streamKey);
    }

    private final void fetchStreamPreviewIfNotFetching(StreamPreview preview, String streamKey) {
        if (preview == null || !(preview instanceof StreamPreview.Fetching)) {
            fetchStreamPreview(streamKey);
        }
    }
}
