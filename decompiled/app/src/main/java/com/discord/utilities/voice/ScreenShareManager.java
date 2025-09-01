package com.discord.utilities.voice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.j.FloatingViewManager;
import b.a.v.AcknowledgedTooltipsCache;
import b.d.b.a.outline;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.stores.StoreUser;
import com.discord.tooltips.TooltipManager;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.images.ImageEncoder;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.EmptyObservableHolder;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.CompositeSubscription;

/* compiled from: ScreenShareManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u0001:\u0003DEFBq\u0012\u0006\u0010*\u001a\u00020)\u0012\n\u0010;\u001a\u00060\u001dj\u0002`:\u0012\u000e\u0010\u001f\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e\u0012\b\b\u0002\u0010@\u001a\u00020?\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u00106\u001a\u000205\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010-\u001a\u00020,\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\fJ\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR!\u0010\u001f\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010;\u001a\u00060\u001dj\u0002`:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/discord/utilities/voice/ScreenShareManager;", "", "", "subscribeToStores", "()V", "Lcom/discord/utilities/voice/ScreenShareManager$State;", "state", "handleStateUpdate", "(Lcom/discord/utilities/voice/ScreenShareManager$State;)V", "Landroid/content/Intent;", "intent", "handleStartStream", "(Landroid/content/Intent;)V", "uploadScreenSharePreviews", "Lcom/discord/rtcconnection/mediaengine/ThumbnailEmitter;", "createThumbnailEmitter", "()Lcom/discord/rtcconnection/mediaengine/ThumbnailEmitter;", "startStream", "stopStream", "release", "Lcom/discord/stores/StoreRtcConnection;", "storeRtcConnection", "Lcom/discord/stores/StoreRtcConnection;", "Lcom/discord/tooltips/TooltipManager;", "tooltipManager", "Lcom/discord/tooltips/TooltipManager;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "Lcom/discord/primitives/GuildId;", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "Lcom/discord/stores/StoreStreamRtcConnection;", "storeStreamRtcConnection", "Lcom/discord/stores/StoreStreamRtcConnection;", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "Lrx/subscriptions/CompositeSubscription;", "Lcom/discord/app/AppComponent;", "appComponent", "Lcom/discord/app/AppComponent;", "Lcom/discord/utilities/images/ImageEncoder;", "imageEncoder", "Lcom/discord/utilities/images/ImageEncoder;", "previousState", "Lcom/discord/utilities/voice/ScreenShareManager$State;", "Lrx/subjects/BehaviorSubject;", "Landroid/graphics/Bitmap;", "thumbnailBitmapSubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "screenshareIntent", "Landroid/content/Intent;", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "Lcom/discord/stores/StoreApplicationStreaming;", "storeApplicationStreaming", "Lcom/discord/stores/StoreApplicationStreaming;", "<init>", "(Lcom/discord/app/AppComponent;JLjava/lang/Long;Lcom/discord/stores/StoreApplicationStreaming;Lcom/discord/stores/StoreRtcConnection;Lcom/discord/stores/StoreStreamRtcConnection;Lcom/discord/stores/StoreUser;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/utilities/images/ImageEncoder;Lcom/discord/tooltips/TooltipManager;)V", "Companion", "RtcConnectionListener", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ScreenShareManager {
    public static final int JPEG_QUALITY = 92;
    public static final long PREVIEW_DELAY_MS = 5000;
    public static final long PREVIEW_INTERVAL_MS = 300000;
    public static final int THUMBNAIL_HEIGHT_PX = 288;
    public static final int THUMBNAIL_WIDTH_PX = 512;
    private final AppComponent appComponent;
    private final long channelId;
    private final CompositeSubscription compositeSubscription;
    private final Long guildId;
    private final ImageEncoder imageEncoder;
    private State previousState;
    private final RestAPI restAPI;
    private Intent screenshareIntent;
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreRtcConnection storeRtcConnection;
    private final StoreStreamRtcConnection storeStreamRtcConnection;
    private final StoreUser storeUser;
    private final BehaviorSubject<Bitmap> thumbnailBitmapSubject;
    private final TooltipManager tooltipManager;

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/voice/ScreenShareManager$RtcConnectionListener;", "Lcom/discord/rtcconnection/RtcConnection$b;", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "stateChange", "", "onStateChange", "(Lcom/discord/rtcconnection/RtcConnection$StateChange;)V", "<init>", "(Lcom/discord/utilities/voice/ScreenShareManager;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class RtcConnectionListener extends RtcConnection.b {
        public RtcConnectionListener() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onStateChange(RtcConnection.StateChange stateChange) {
            Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
            RtcConnection.State state = stateChange.state;
            if (!Intrinsics3.areEqual(state, RtcConnection.State.f.a)) {
                if (state instanceof RtcConnection.State.d) {
                    ScreenShareManager.this.stopStream();
                }
            } else {
                State stateAccess$getPreviousState$p = ScreenShareManager.access$getPreviousState$p(ScreenShareManager.this);
                RtcConnection rtcConnection = stateAccess$getPreviousState$p != null ? stateAccess$getPreviousState$p.getRtcConnection() : null;
                if (rtcConnection != null) {
                    rtcConnection.t(ScreenShareManager.access$getScreenshareIntent$p(ScreenShareManager.this), ScreenShareManager.access$createThumbnailEmitter(ScreenShareManager.this));
                    ScreenShareManager.access$uploadScreenSharePreviews(ScreenShareManager.this);
                }
            }
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R!\u0010\u000e\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/discord/utilities/voice/ScreenShareManager$State;", "", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "component1", "()Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "Lcom/discord/rtcconnection/RtcConnection;", "component2", "()Lcom/discord/rtcconnection/RtcConnection;", "", "Lcom/discord/primitives/UserId;", "component3", "()Ljava/lang/Long;", "activeStream", "rtcConnection", "meId", "copy", "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/rtcconnection/RtcConnection;Ljava/lang/Long;)Lcom/discord/utilities/voice/ScreenShareManager$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/rtcconnection/RtcConnection;", "getRtcConnection", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "getActiveStream", "Ljava/lang/Long;", "getMeId", "<init>", "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/rtcconnection/RtcConnection;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private final StoreApplicationStreaming.ActiveApplicationStream activeStream;
        private final Long meId;
        private final RtcConnection rtcConnection;

        public State(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection rtcConnection, Long l) {
            this.activeStream = activeApplicationStream;
            this.rtcConnection = rtcConnection;
            this.meId = l;
        }

        public static /* synthetic */ State copy$default(State state, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection rtcConnection, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                activeApplicationStream = state.activeStream;
            }
            if ((i & 2) != 0) {
                rtcConnection = state.rtcConnection;
            }
            if ((i & 4) != 0) {
                l = state.meId;
            }
            return state.copy(activeApplicationStream, rtcConnection, l);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
            return this.activeStream;
        }

        /* renamed from: component2, reason: from getter */
        public final RtcConnection getRtcConnection() {
            return this.rtcConnection;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getMeId() {
            return this.meId;
        }

        public final State copy(StoreApplicationStreaming.ActiveApplicationStream activeStream, RtcConnection rtcConnection, Long meId) {
            return new State(activeStream, rtcConnection, meId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.activeStream, state.activeStream) && Intrinsics3.areEqual(this.rtcConnection, state.rtcConnection) && Intrinsics3.areEqual(this.meId, state.meId);
        }

        public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
            return this.activeStream;
        }

        public final Long getMeId() {
            return this.meId;
        }

        public final RtcConnection getRtcConnection() {
            return this.rtcConnection;
        }

        public int hashCode() {
            StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeStream;
            int iHashCode = (activeApplicationStream != null ? activeApplicationStream.hashCode() : 0) * 31;
            RtcConnection rtcConnection = this.rtcConnection;
            int iHashCode2 = (iHashCode + (rtcConnection != null ? rtcConnection.hashCode() : 0)) * 31;
            Long l = this.meId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(activeStream=");
            sbU.append(this.activeStream);
            sbU.append(", rtcConnection=");
            sbU.append(this.rtcConnection);
            sbU.append(", meId=");
            return outline.G(sbU, this.meId, ")");
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/Bitmap;", "thumbnailBitmap", "", "invoke", "(Landroid/graphics/Bitmap;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$createThumbnailEmitter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Bitmap, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
            invoke2(bitmap);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Bitmap bitmap) {
            Intrinsics3.checkNotNullParameter(bitmap, "thumbnailBitmap");
            ScreenShareManager.access$getThumbnailBitmapSubject$p(ScreenShareManager.this).onNext(bitmap);
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$Metadata;", "rtcConnectionMetadata", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/rtcconnection/RtcConnection$Metadata;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$startStream$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<RtcConnection.Metadata, Boolean> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(RtcConnection.Metadata metadata) {
            return call2(metadata);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(RtcConnection.Metadata metadata) {
            Long l = metadata != null ? metadata.channelId : null;
            return Boolean.valueOf(l != null && l.longValue() == ScreenShareManager.this.getChannelId() && Intrinsics3.areEqual(metadata.guildId, ScreenShareManager.this.getGuildId()));
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$startStream$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.access$getCompositeSubscription$p(ScreenShareManager.this).a(subscription);
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$Metadata;", "it", "", "invoke", "(Lcom/discord/rtcconnection/RtcConnection$Metadata;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$startStream$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RtcConnection.Metadata, Unit> {
        public final /* synthetic */ Intent $intent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Intent intent) {
            super(1);
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RtcConnection.Metadata metadata) {
            invoke2(metadata);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RtcConnection.Metadata metadata) {
            ScreenShareManager.access$handleStartStream(ScreenShareManager.this, this.$intent);
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00070\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "activeStream", "Lcom/discord/rtcconnection/RtcConnection;", "rtcConnection", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "Lcom/discord/utilities/voice/ScreenShareManager$State;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;Lcom/discord/rtcconnection/RtcConnection;Lcom/discord/models/user/MeUser;)Lcom/discord/utilities/voice/ScreenShareManager$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$subscribeToStores$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<StoreApplicationStreaming.ActiveApplicationStream, RtcConnection, MeUser, State> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ State call(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection rtcConnection, MeUser meUser) {
            return call2(activeApplicationStream, rtcConnection, meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final State call2(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection rtcConnection, MeUser meUser) {
            return new State(activeApplicationStream, rtcConnection, meUser != null ? Long.valueOf(meUser.getId()) : null);
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$subscribeToStores$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.access$getCompositeSubscription$p(ScreenShareManager.this).a(subscription);
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/voice/ScreenShareManager$State;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/utilities/voice/ScreenShareManager$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$subscribeToStores$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<State, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State state) {
            ScreenShareManager screenShareManager = ScreenShareManager.this;
            Intrinsics3.checkNotNullExpressionValue(state, "it");
            ScreenShareManager.access$handleStateUpdate(screenShareManager, state);
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "thumbnailBitmap", "Lrx/Observable;", "Ljava/lang/Void;", NotificationCompat.CATEGORY_CALL, "(Landroid/graphics/Bitmap;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$uploadScreenSharePreviews$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Bitmap, Observable<? extends Void>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Void> call(Bitmap bitmap) {
            return call2(bitmap);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Void> call2(Bitmap bitmap) {
            State stateAccess$getPreviousState$p = ScreenShareManager.access$getPreviousState$p(ScreenShareManager.this);
            StoreApplicationStreaming.ActiveApplicationStream activeStream = stateAccess$getPreviousState$p != null ? stateAccess$getPreviousState$p.getActiveStream() : null;
            if (activeStream == null) {
                return EmptyObservableHolder.k;
            }
            ImageEncoder imageEncoderAccess$getImageEncoder$p = ScreenShareManager.access$getImageEncoder$p(ScreenShareManager.this);
            Intrinsics3.checkNotNullExpressionValue(bitmap, "thumbnailBitmap");
            return ScreenShareManager.access$getRestAPI$p(ScreenShareManager.this).postStreamPreview(activeStream.getStream().getEncodedStreamKey(), imageEncoderAccess$getImageEncoder$p.encodeBitmapAsJpegDataUrl(bitmap, 92));
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$uploadScreenSharePreviews$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.access$getCompositeSubscription$p(ScreenShareManager.this).a(subscription);
        }
    }

    /* compiled from: ScreenShareManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.ScreenShareManager$uploadScreenSharePreviews$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
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

    public ScreenShareManager(AppComponent appComponent, long j, Long l, StoreApplicationStreaming storeApplicationStreaming, StoreRtcConnection storeRtcConnection, StoreStreamRtcConnection storeStreamRtcConnection, StoreUser storeUser, RestAPI restAPI, ImageEncoder imageEncoder, TooltipManager tooltipManager) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        Intrinsics3.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
        Intrinsics3.checkNotNullParameter(storeStreamRtcConnection, "storeStreamRtcConnection");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(imageEncoder, "imageEncoder");
        Intrinsics3.checkNotNullParameter(tooltipManager, "tooltipManager");
        this.appComponent = appComponent;
        this.channelId = j;
        this.guildId = l;
        this.storeApplicationStreaming = storeApplicationStreaming;
        this.storeRtcConnection = storeRtcConnection;
        this.storeStreamRtcConnection = storeStreamRtcConnection;
        this.storeUser = storeUser;
        this.restAPI = restAPI;
        this.imageEncoder = imageEncoder;
        this.tooltipManager = tooltipManager;
        BehaviorSubject<Bitmap> behaviorSubjectK0 = BehaviorSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.thumbnailBitmapSubject = behaviorSubjectK0;
        this.compositeSubscription = new CompositeSubscription();
        subscribeToStores();
    }

    public static final /* synthetic */ ThumbnailEmitter access$createThumbnailEmitter(ScreenShareManager screenShareManager) {
        return screenShareManager.createThumbnailEmitter();
    }

    public static final /* synthetic */ CompositeSubscription access$getCompositeSubscription$p(ScreenShareManager screenShareManager) {
        return screenShareManager.compositeSubscription;
    }

    public static final /* synthetic */ ImageEncoder access$getImageEncoder$p(ScreenShareManager screenShareManager) {
        return screenShareManager.imageEncoder;
    }

    public static final /* synthetic */ State access$getPreviousState$p(ScreenShareManager screenShareManager) {
        return screenShareManager.previousState;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(ScreenShareManager screenShareManager) {
        return screenShareManager.restAPI;
    }

    public static final /* synthetic */ Intent access$getScreenshareIntent$p(ScreenShareManager screenShareManager) {
        return screenShareManager.screenshareIntent;
    }

    public static final /* synthetic */ BehaviorSubject access$getThumbnailBitmapSubject$p(ScreenShareManager screenShareManager) {
        return screenShareManager.thumbnailBitmapSubject;
    }

    public static final /* synthetic */ void access$handleStartStream(ScreenShareManager screenShareManager, Intent intent) {
        screenShareManager.handleStartStream(intent);
    }

    public static final /* synthetic */ void access$handleStateUpdate(ScreenShareManager screenShareManager, State state) {
        screenShareManager.handleStateUpdate(state);
    }

    public static final /* synthetic */ void access$setPreviousState$p(ScreenShareManager screenShareManager, State state) {
        screenShareManager.previousState = state;
    }

    public static final /* synthetic */ void access$setScreenshareIntent$p(ScreenShareManager screenShareManager, Intent intent) {
        screenShareManager.screenshareIntent = intent;
    }

    public static final /* synthetic */ void access$uploadScreenSharePreviews(ScreenShareManager screenShareManager) {
        screenShareManager.uploadScreenSharePreviews();
    }

    private final ThumbnailEmitter createThumbnailEmitter() {
        return new ThumbnailEmitter(512, THUMBNAIL_HEIGHT_PX, 300000L, 5000L, null, new AnonymousClass1(), 16);
    }

    @MainThread
    private final void handleStartStream(Intent intent) {
        StoreApplicationStreaming.createStream$default(this.storeApplicationStreaming, this.channelId, this.guildId, null, 4, null);
        this.screenshareIntent = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStateUpdate(State state) {
        boolean z2;
        RtcConnection rtcConnection;
        ModelApplicationStream stream;
        RtcConnection rtcConnection2;
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        ModelApplicationStream stream2;
        ModelApplicationStream stream3;
        State state2 = this.previousState;
        boolean z3 = false;
        if ((state2 != null ? state2.getActiveStream() : null) == null) {
            z2 = false;
        } else {
            StoreApplicationStreaming.ActiveApplicationStream activeStream2 = state.getActiveStream();
            String encodedStreamKey = (activeStream2 == null || (stream3 = activeStream2.getStream()) == null) ? null : stream3.getEncodedStreamKey();
            State state3 = this.previousState;
            if (!Intrinsics3.areEqual(encodedStreamKey, (state3 == null || (activeStream = state3.getActiveStream()) == null || (stream2 = activeStream.getStream()) == null) ? null : stream2.getEncodedStreamKey())) {
                z2 = true;
            }
        }
        if (z2 && (rtcConnection2 = state.getRtcConnection()) != null) {
            rtcConnection2.t(null, null);
        }
        StoreApplicationStreaming.ActiveApplicationStream activeStream3 = state.getActiveStream();
        if (Intrinsics3.areEqual((activeStream3 == null || (stream = activeStream3.getStream()) == null) ? null : Long.valueOf(stream.getOwnerId()), state.getMeId())) {
            State state4 = this.previousState;
            if ((state4 != null ? state4.getRtcConnection() : null) == null && state.getRtcConnection() != null) {
                z3 = true;
            }
            if (z3 && (rtcConnection = state.getRtcConnection()) != null) {
                rtcConnection.c(new RtcConnectionListener());
            }
            this.previousState = state;
        }
    }

    private final void subscribeToStores() {
        Observable observableR = Observable.i(this.storeApplicationStreaming.observeActiveStream(), this.storeStreamRtcConnection.observeRtcConnection(), StoreUser.observeMe$default(this.storeUser, false, 1, null), AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this.appComponent, null, 2, null), ScreenShareManager.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 58, (Object) null);
    }

    private final void uploadScreenSharePreviews() {
        Observable<R> observableA = this.thumbnailBitmapSubject.A(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableA, "thumbnailBitmapSubject\n …>()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableA, this.appComponent, null, 2, null), false, 1, null), ScreenShareManager.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, AnonymousClass3.INSTANCE, 58, (Object) null);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final void release() {
        this.compositeSubscription.unsubscribe();
    }

    public final void startStream(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Observable<RtcConnection.Metadata> observableZ = this.storeRtcConnection.observeRtcConnectionMetadata().y(new AnonymousClass1()).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "storeRtcConnection.obser…       }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableZ, this.appComponent, null, 2, null), ScreenShareManager.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(intent), 58, (Object) null);
    }

    public final void stopStream() {
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        State state = this.previousState;
        if (state == null || (activeStream = state.getActiveStream()) == null) {
            return;
        }
        this.storeApplicationStreaming.stopStream(activeStream.getStream().getEncodedStreamKey());
        this.screenshareIntent = null;
    }

    public ScreenShareManager(AppComponent appComponent, long j, Long l, StoreApplicationStreaming storeApplicationStreaming, StoreRtcConnection storeRtcConnection, StoreStreamRtcConnection storeStreamRtcConnection, StoreUser storeUser, RestAPI restAPI, ImageEncoder imageEncoder, TooltipManager tooltipManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TooltipManager tooltipManager2;
        StoreApplicationStreaming applicationStreaming = (i & 8) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming;
        StoreRtcConnection rtcConnection = (i & 16) != 0 ? StoreStream.INSTANCE.getRtcConnection() : storeRtcConnection;
        StoreStreamRtcConnection streamRtcConnection = (i & 32) != 0 ? StoreStream.INSTANCE.getStreamRtcConnection() : storeStreamRtcConnection;
        StoreUser users = (i & 64) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        RestAPI api = (i & 128) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        ImageEncoder imageEncoder2 = (i & 256) != 0 ? new ImageEncoder() : imageEncoder;
        if ((i & 512) != 0) {
            AppLog appLog = AppLog.g;
            Intrinsics3.checkNotNullParameter(appLog, "logger");
            WeakReference<FloatingViewManager> weakReference = FloatingViewManager.b.a;
            FloatingViewManager floatingViewManager = weakReference != null ? weakReference.get() : null;
            if (floatingViewManager == null) {
                floatingViewManager = new FloatingViewManager(appLog);
                FloatingViewManager.b.a = new WeakReference<>(floatingViewManager);
            }
            TooltipManager.a aVar = TooltipManager.a.d;
            Intrinsics3.checkNotNullParameter(floatingViewManager, "floatingViewManager");
            WeakReference<TooltipManager> weakReference2 = TooltipManager.a.a;
            TooltipManager tooltipManager3 = weakReference2 != null ? weakReference2.get() : null;
            if (tooltipManager3 == null) {
                TooltipManager tooltipManager4 = new TooltipManager((AcknowledgedTooltipsCache) TooltipManager.a.f2815b.getValue(), (Set) TooltipManager.a.c.getValue(), 0, floatingViewManager, 4);
                TooltipManager.a.a = new WeakReference<>(tooltipManager4);
                tooltipManager3 = tooltipManager4;
            }
            tooltipManager2 = tooltipManager3;
        } else {
            tooltipManager2 = tooltipManager;
        }
        this(appComponent, j, l, applicationStreaming, rtcConnection, streamRtcConnection, users, api, imageEncoder2, tooltipManager2);
    }
}
