package com.discord.widgets.bugreports;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.bugreport.BugReportConfig;
import com.discord.api.bugreport.BugReportConfig2;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.file.DownloadUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import d0.c0.Random;
import d0.d0._Ranges;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: BugReportViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003fghB#\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010Z\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010`\u001a\u00020_¢\u0006\u0004\bd\u0010eJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\t¢\u0006\u0004\b$\u0010\u000bJ\r\u0010%\u001a\u00020\t¢\u0006\u0004\b%\u0010\u000bJ\u0017\u0010'\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010\u0007\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u001bR\"\u00102\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010.\u001a\u0004\b3\u00100\"\u0004\b4\u0010\u001bR\u0016\u00105\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0019\u0010>\u001a\u00020=8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00108\u001a\u0004\bC\u0010D\"\u0004\bE\u0010\u0012R:\u0010H\u001a&\u0012\f\u0012\n G*\u0004\u0018\u00010\r0\r G*\u0012\u0012\f\u0012\n G*\u0004\u0018\u00010\r0\r\u0018\u00010F0F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0019\u0010K\u001a\u00020J8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0019\u0010O\u001a\u00020=8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010?\u001a\u0004\bP\u0010AR$\u0010&\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010(R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001b\u0010Z\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bZ\u00108\u001a\u0004\b[\u0010DR$\u0010\\\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u00108\u001a\u0004\b]\u0010D\"\u0004\b^\u0010\u0012R\u0019\u0010`\u001a\u00020_8\u0006@\u0006¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c¨\u0006i"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;", "", "filter", "", "Lcom/discord/api/bugreport/Feature;", "filterFeatures", "(Ljava/lang/String;)Ljava/util/List;", "", "dismissAfterDelay", "()V", "Lrx/Observable;", "Lcom/discord/widgets/bugreports/BugReportViewModel$Event;", "observeEvents", "()Lrx/Observable;", ModelAuditLogEntry.CHANGE_KEY_NAME, "updateReportName", "(Ljava/lang/String;)V", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "updateReportDescription", "", "priority", "updatePriority", "(I)V", "", "useScreenshot", "(Z)V", "Lcom/discord/utilities/error/Error;", "error", "showReport", "(Lcom/discord/utilities/error/Error;)V", "Lokhttp3/RequestBody;", "screenshotBody", "sendReport", "(Lokhttp3/RequestBody;)V", "showFeatureAreas", "loadFeatures", "feature", "selectFeatureArea", "(Lcom/discord/api/bugreport/Feature;)V", "Landroid/content/Context;", "context", "prefetchStickers", "(Landroid/content/Context;)V", "it", "Z", "getUseScreenshot", "()Z", "setUseScreenshot", "stickersPrefetched", "getStickersPrefetched", "setStickersPrefetched", "stickerCharacterIndex", "I", "featureSearchQuery", "Ljava/lang/String;", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/bugreport/BugReportConfig;", "bugReportConfig", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/sticker/Sticker;", "sendingSticker", "Lcom/discord/api/sticker/Sticker;", "getSendingSticker", "()Lcom/discord/api/sticker/Sticker;", "reportName", "getReportName", "()Ljava/lang/String;", "setReportName", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Landroid/net/Uri;", "screenshotUri", "Landroid/net/Uri;", "getScreenshotUri", "()Landroid/net/Uri;", "successSticker", "getSuccessSticker", "Lcom/discord/api/bugreport/Feature;", "getFeature", "()Lcom/discord/api/bugreport/Feature;", "setFeature", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "screenshotName", "getScreenshotName", "reportDescription", "getReportDescription", "setReportDescription", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "getRestApi", "()Lcom/discord/utilities/rest/RestAPI;", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "Event", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BugReportViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<BugReportConfig2> genericFeatureAreas = CollectionsJVM.listOf(new BugReportConfig2(NotificationClient.NOTIF_GENERAL, "Android", null));
    private static final List<Sticker> sendingStickers;
    private static final List<Sticker> successStickers;
    private RestCallState<BugReportConfig> bugReportConfig;
    private final PublishSubject<Event> eventSubject;
    private BugReportConfig2 feature;
    private String featureSearchQuery;
    private Integer priority;
    private String reportDescription;
    private String reportName;
    private final RestAPI restApi;
    private final String screenshotName;
    private final Uri screenshotUri;
    private final Sticker sendingSticker;
    private final int stickerCharacterIndex;
    private boolean stickersPrefetched;
    private final Sticker successSticker;
    private boolean useScreenshot;

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$Companion;", "", "", "Lcom/discord/api/sticker/Sticker;", "successStickers", "Ljava/util/List;", "getSuccessStickers", "()Ljava/util/List;", "sendingStickers", "getSendingStickers", "Lcom/discord/api/bugreport/Feature;", "genericFeatureAreas", "getGenericFeatureAreas", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final List<BugReportConfig2> getGenericFeatureAreas() {
            return BugReportViewModel.access$getGenericFeatureAreas$cp();
        }

        public final List<Sticker> getSendingStickers() {
            return BugReportViewModel.access$getSendingStickers$cp();
        }

        public final List<Sticker> getSuccessStickers() {
            return BugReportViewModel.access$getSuccessStickers$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$Event;", "", "<init>", "()V", "CloseReport", "Lcom/discord/widgets/bugreports/BugReportViewModel$Event$CloseReport;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: BugReportViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$Event$CloseReport;", "Lcom/discord/widgets/bugreports/BugReportViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class CloseReport extends Event {
            public static final CloseReport INSTANCE = new CloseReport();

            private CloseReport() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;", "", "<init>", "()V", "Report", "SelectFeature", "Sending", "Success", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Report;", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Sending;", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Success;", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$SelectFeature;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: BugReportViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J`\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010\u000bR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u0007R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b+\u0010\u0007R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b-\u0010\u000eR\u0019\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b1\u0010\u0004¨\u00064"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Report;", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/lang/Integer;", "Lcom/discord/api/bugreport/Feature;", "component5", "()Lcom/discord/api/bugreport/Feature;", "", "component6", "()Z", "Lcom/discord/utilities/error/Error;", "component7", "()Lcom/discord/utilities/error/Error;", "screenshotUri", "reportName", "reportDescription", "priority", "feature", "useScreenshot", "error", "copy", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/discord/api/bugreport/Feature;ZLcom/discord/utilities/error/Error;)Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Report;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getPriority", "Ljava/lang/String;", "getReportDescription", "Lcom/discord/utilities/error/Error;", "getError", "getReportName", "Lcom/discord/api/bugreport/Feature;", "getFeature", "Z", "getUseScreenshot", "Landroid/net/Uri;", "getScreenshotUri", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/discord/api/bugreport/Feature;ZLcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Report extends ViewState {
            private final Error error;
            private final BugReportConfig2 feature;
            private final Integer priority;
            private final String reportDescription;
            private final String reportName;
            private final Uri screenshotUri;
            private final boolean useScreenshot;

            public /* synthetic */ Report(Uri uri, String str, String str2, Integer num, BugReportConfig2 bugReportConfig2, boolean z2, Error error, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(uri, str, str2, num, bugReportConfig2, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : error);
            }

            public static /* synthetic */ Report copy$default(Report report, Uri uri, String str, String str2, Integer num, BugReportConfig2 bugReportConfig2, boolean z2, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = report.screenshotUri;
                }
                if ((i & 2) != 0) {
                    str = report.reportName;
                }
                String str3 = str;
                if ((i & 4) != 0) {
                    str2 = report.reportDescription;
                }
                String str4 = str2;
                if ((i & 8) != 0) {
                    num = report.priority;
                }
                Integer num2 = num;
                if ((i & 16) != 0) {
                    bugReportConfig2 = report.feature;
                }
                BugReportConfig2 bugReportConfig22 = bugReportConfig2;
                if ((i & 32) != 0) {
                    z2 = report.useScreenshot;
                }
                boolean z3 = z2;
                if ((i & 64) != 0) {
                    error = report.error;
                }
                return report.copy(uri, str3, str4, num2, bugReportConfig22, z3, error);
            }

            /* renamed from: component1, reason: from getter */
            public final Uri getScreenshotUri() {
                return this.screenshotUri;
            }

            /* renamed from: component2, reason: from getter */
            public final String getReportName() {
                return this.reportName;
            }

            /* renamed from: component3, reason: from getter */
            public final String getReportDescription() {
                return this.reportDescription;
            }

            /* renamed from: component4, reason: from getter */
            public final Integer getPriority() {
                return this.priority;
            }

            /* renamed from: component5, reason: from getter */
            public final BugReportConfig2 getFeature() {
                return this.feature;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getUseScreenshot() {
                return this.useScreenshot;
            }

            /* renamed from: component7, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final Report copy(Uri screenshotUri, String reportName, String reportDescription, Integer priority, BugReportConfig2 feature, boolean useScreenshot, Error error) {
                Intrinsics3.checkNotNullParameter(screenshotUri, "screenshotUri");
                return new Report(screenshotUri, reportName, reportDescription, priority, feature, useScreenshot, error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Report)) {
                    return false;
                }
                Report report = (Report) other;
                return Intrinsics3.areEqual(this.screenshotUri, report.screenshotUri) && Intrinsics3.areEqual(this.reportName, report.reportName) && Intrinsics3.areEqual(this.reportDescription, report.reportDescription) && Intrinsics3.areEqual(this.priority, report.priority) && Intrinsics3.areEqual(this.feature, report.feature) && this.useScreenshot == report.useScreenshot && Intrinsics3.areEqual(this.error, report.error);
            }

            public final Error getError() {
                return this.error;
            }

            public final BugReportConfig2 getFeature() {
                return this.feature;
            }

            public final Integer getPriority() {
                return this.priority;
            }

            public final String getReportDescription() {
                return this.reportDescription;
            }

            public final String getReportName() {
                return this.reportName;
            }

            public final Uri getScreenshotUri() {
                return this.screenshotUri;
            }

            public final boolean getUseScreenshot() {
                return this.useScreenshot;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Uri uri = this.screenshotUri;
                int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
                String str = this.reportName;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.reportDescription;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                Integer num = this.priority;
                int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
                BugReportConfig2 bugReportConfig2 = this.feature;
                int iHashCode5 = (iHashCode4 + (bugReportConfig2 != null ? bugReportConfig2.hashCode() : 0)) * 31;
                boolean z2 = this.useScreenshot;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode5 + i) * 31;
                Error error = this.error;
                return i2 + (error != null ? error.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Report(screenshotUri=");
                sbU.append(this.screenshotUri);
                sbU.append(", reportName=");
                sbU.append(this.reportName);
                sbU.append(", reportDescription=");
                sbU.append(this.reportDescription);
                sbU.append(", priority=");
                sbU.append(this.priority);
                sbU.append(", feature=");
                sbU.append(this.feature);
                sbU.append(", useScreenshot=");
                sbU.append(this.useScreenshot);
                sbU.append(", error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Report(Uri uri, String str, String str2, Integer num, BugReportConfig2 bugReportConfig2, boolean z2, Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(uri, "screenshotUri");
                this.screenshotUri = uri;
                this.reportName = str;
                this.reportDescription = str2;
                this.priority = num;
                this.feature = bugReportConfig2;
                this.useScreenshot = z2;
                this.error = error;
            }
        }

        /* compiled from: BugReportViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b¨\u0006!"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$SelectFeature;", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "", "Lcom/discord/api/bugreport/Feature;", "component3", "()Ljava/util/List;", "query", "loadingFeatures", "features", "copy", "(Ljava/lang/String;ZLjava/util/List;)Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$SelectFeature;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getQuery", "Z", "getLoadingFeatures", "Ljava/util/List;", "getFeatures", "<init>", "(Ljava/lang/String;ZLjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SelectFeature extends ViewState {
            private final List<BugReportConfig2> features;
            private final boolean loadingFeatures;
            private final String query;

            public SelectFeature() {
                this(null, false, null, 7, null);
            }

            public /* synthetic */ SelectFeature(String str, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? Collections2.emptyList() : list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectFeature copy$default(SelectFeature selectFeature, String str, boolean z2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selectFeature.query;
                }
                if ((i & 2) != 0) {
                    z2 = selectFeature.loadingFeatures;
                }
                if ((i & 4) != 0) {
                    list = selectFeature.features;
                }
                return selectFeature.copy(str, z2, list);
            }

            /* renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getLoadingFeatures() {
                return this.loadingFeatures;
            }

            public final List<BugReportConfig2> component3() {
                return this.features;
            }

            public final SelectFeature copy(String query, boolean loadingFeatures, List<BugReportConfig2> features) {
                Intrinsics3.checkNotNullParameter(features, "features");
                return new SelectFeature(query, loadingFeatures, features);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectFeature)) {
                    return false;
                }
                SelectFeature selectFeature = (SelectFeature) other;
                return Intrinsics3.areEqual(this.query, selectFeature.query) && this.loadingFeatures == selectFeature.loadingFeatures && Intrinsics3.areEqual(this.features, selectFeature.features);
            }

            public final List<BugReportConfig2> getFeatures() {
                return this.features;
            }

            public final boolean getLoadingFeatures() {
                return this.loadingFeatures;
            }

            public final String getQuery() {
                return this.query;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                String str = this.query;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.loadingFeatures;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                List<BugReportConfig2> list = this.features;
                return i2 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SelectFeature(query=");
                sbU.append(this.query);
                sbU.append(", loadingFeatures=");
                sbU.append(this.loadingFeatures);
                sbU.append(", features=");
                return outline.L(sbU, this.features, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectFeature(String str, boolean z2, List<BugReportConfig2> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "features");
                this.query = str;
                this.loadingFeatures = z2;
                this.features = list;
            }
        }

        /* compiled from: BugReportViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Sending;", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;", "Lcom/discord/api/sticker/Sticker;", "component1", "()Lcom/discord/api/sticker/Sticker;", "sendingSticker", "copy", "(Lcom/discord/api/sticker/Sticker;)Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Sending;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/sticker/Sticker;", "getSendingSticker", "<init>", "(Lcom/discord/api/sticker/Sticker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Sending extends ViewState {
            private final Sticker sendingSticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Sending(Sticker sticker) {
                super(null);
                Intrinsics3.checkNotNullParameter(sticker, "sendingSticker");
                this.sendingSticker = sticker;
            }

            public static /* synthetic */ Sending copy$default(Sending sending, Sticker sticker, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = sending.sendingSticker;
                }
                return sending.copy(sticker);
            }

            /* renamed from: component1, reason: from getter */
            public final Sticker getSendingSticker() {
                return this.sendingSticker;
            }

            public final Sending copy(Sticker sendingSticker) {
                Intrinsics3.checkNotNullParameter(sendingSticker, "sendingSticker");
                return new Sending(sendingSticker);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Sending) && Intrinsics3.areEqual(this.sendingSticker, ((Sending) other).sendingSticker);
                }
                return true;
            }

            public final Sticker getSendingSticker() {
                return this.sendingSticker;
            }

            public int hashCode() {
                Sticker sticker = this.sendingSticker;
                if (sticker != null) {
                    return sticker.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Sending(sendingSticker=");
                sbU.append(this.sendingSticker);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: BugReportViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Success;", "Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState;", "Lcom/discord/api/sticker/Sticker;", "component1", "()Lcom/discord/api/sticker/Sticker;", "successSticker", "copy", "(Lcom/discord/api/sticker/Sticker;)Lcom/discord/widgets/bugreports/BugReportViewModel$ViewState$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/sticker/Sticker;", "getSuccessSticker", "<init>", "(Lcom/discord/api/sticker/Sticker;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Success extends ViewState {
            private final Sticker successSticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Sticker sticker) {
                super(null);
                Intrinsics3.checkNotNullParameter(sticker, "successSticker");
                this.successSticker = sticker;
            }

            public static /* synthetic */ Success copy$default(Success success, Sticker sticker, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = success.successSticker;
                }
                return success.copy(sticker);
            }

            /* renamed from: component1, reason: from getter */
            public final Sticker getSuccessSticker() {
                return this.successSticker;
            }

            public final Success copy(Sticker successSticker) {
                Intrinsics3.checkNotNullParameter(successSticker, "successSticker");
                return new Success(successSticker);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && Intrinsics3.areEqual(this.successSticker, ((Success) other).successSticker);
                }
                return true;
            }

            public final Sticker getSuccessSticker() {
                return this.successSticker;
            }

            public int hashCode() {
                Sticker sticker = this.successSticker;
                if (sticker != null) {
                    return sticker.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Success(successSticker=");
                sbU.append(this.successSticker);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$dismissAfterDelay$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            PublishSubject publishSubjectAccess$getEventSubject$p = BugReportViewModel.access$getEventSubject$p(BugReportViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.CloseReport.INSTANCE);
        }
    }

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/bugreport/BugReportConfig;", "it", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$loadFeatures$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState<? extends BugReportConfig>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends BugReportConfig> restCallState) {
            invoke2((RestCallState<BugReportConfig>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<BugReportConfig> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "it");
            BugReportViewModel.access$setBugReportConfig$p(BugReportViewModel.this, restCallState);
        }
    }

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/file/DownloadUtils$DownloadState;", "it", "", "invoke", "(Lcom/discord/utilities/file/DownloadUtils$DownloadState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$prefetchStickers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<DownloadUtils.DownloadState, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadUtils.DownloadState downloadState) {
            invoke2(downloadState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DownloadUtils.DownloadState downloadState) {
            Intrinsics3.checkNotNullParameter(downloadState, "it");
        }
    }

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/file/DownloadUtils$DownloadState;", "it", "", "invoke", "(Lcom/discord/utilities/file/DownloadUtils$DownloadState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$prefetchStickers$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<DownloadUtils.DownloadState, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadUtils.DownloadState downloadState) {
            invoke2(downloadState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DownloadUtils.DownloadState downloadState) {
            Intrinsics3.checkNotNullParameter(downloadState, "it");
        }
    }

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$sendReport$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            BugReportViewModel bugReportViewModel = BugReportViewModel.this;
            BugReportViewModel.access$updateViewState(bugReportViewModel, new ViewState.Success(bugReportViewModel.getSuccessSticker()));
            BugReportViewModel.access$dismissAfterDelay(BugReportViewModel.this);
        }
    }

    /* compiled from: BugReportViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.bugreports.BugReportViewModel$sendReport$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(error, "error");
            BugReportViewModel.this.showReport(error);
        }
    }

    static {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        sendingStickers = Collections2.listOfNotNull((Object[]) new Sticker[]{companion.getStickers().getStickers().get(754107634172297306L), companion.getStickers().getStickers().get(751606719611928586L), companion.getStickers().getStickers().get(749049128012742676L), companion.getStickers().getStickers().get(761114619137359892L), companion.getStickers().getStickers().get(783788733987815434L)});
        successStickers = Collections2.listOfNotNull((Object[]) new Sticker[]{companion.getStickers().getStickers().get(754109076933443614L), companion.getStickers().getStickers().get(751606065447305216L), companion.getStickers().getStickers().get(749053689419006003L), companion.getStickers().getStickers().get(761108384010862602L), companion.getStickers().getStickers().get(783794979704537108L)});
    }

    public /* synthetic */ BugReportViewModel(Uri uri, String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$dismissAfterDelay(BugReportViewModel bugReportViewModel) {
        bugReportViewModel.dismissAfterDelay();
    }

    public static final /* synthetic */ RestCallState access$getBugReportConfig$p(BugReportViewModel bugReportViewModel) {
        return bugReportViewModel.bugReportConfig;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(BugReportViewModel bugReportViewModel) {
        return bugReportViewModel.eventSubject;
    }

    public static final /* synthetic */ List access$getGenericFeatureAreas$cp() {
        return genericFeatureAreas;
    }

    public static final /* synthetic */ List access$getSendingStickers$cp() {
        return sendingStickers;
    }

    public static final /* synthetic */ List access$getSuccessStickers$cp() {
        return successStickers;
    }

    public static final /* synthetic */ void access$setBugReportConfig$p(BugReportViewModel bugReportViewModel, RestCallState restCallState) {
        bugReportViewModel.bugReportConfig = restCallState;
    }

    public static final /* synthetic */ void access$updateViewState(BugReportViewModel bugReportViewModel, ViewState viewState) {
        bugReportViewModel.updateViewState(viewState);
    }

    private final void dismissAfterDelay() {
        Observable<Long> observableD0 = Observable.d0(1500L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(1500, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    private final List<BugReportConfig2> filterFeatures(String filter) {
        BugReportConfig bugReportConfigInvoke;
        RestCallState<BugReportConfig> restCallState = this.bugReportConfig;
        List<BugReportConfig2> listA = (restCallState == null || (bugReportConfigInvoke = restCallState.invoke()) == null) ? null : bugReportConfigInvoke.a();
        if (listA == null) {
            listA = Collections2.emptyList();
        }
        List<BugReportConfig2> listPlus = _Collections.plus((Collection) listA, (Iterable) genericFeatureAreas);
        if (filter == null) {
            return listPlus;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listPlus) {
            BugReportConfig2 bugReportConfig2 = (BugReportConfig2) obj;
            boolean z2 = true;
            if (!Strings4.contains((CharSequence) bugReportConfig2.getName(), (CharSequence) filter, true) && !Strings4.contains((CharSequence) bugReportConfig2.getSquad(), (CharSequence) filter, true)) {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void showReport$default(BugReportViewModel bugReportViewModel, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = null;
        }
        bugReportViewModel.showReport(error);
    }

    public final BugReportConfig2 getFeature() {
        return this.feature;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final String getReportDescription() {
        return this.reportDescription;
    }

    public final String getReportName() {
        return this.reportName;
    }

    public final RestAPI getRestApi() {
        return this.restApi;
    }

    public final String getScreenshotName() {
        return this.screenshotName;
    }

    public final Uri getScreenshotUri() {
        return this.screenshotUri;
    }

    public final Sticker getSendingSticker() {
        return this.sendingSticker;
    }

    public final boolean getStickersPrefetched() {
        return this.stickersPrefetched;
    }

    public final Sticker getSuccessSticker() {
        return this.successSticker;
    }

    public final boolean getUseScreenshot() {
        return this.useScreenshot;
    }

    public final void loadFeatures() {
        RestCallState5.executeRequest(this.restApi.getBugReportConfig(), new AnonymousClass1());
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void prefetchStickers(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (this.stickersPrefetched) {
            return;
        }
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, this.sendingSticker), false, 1, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, this.successSticker), false, 1, null), BugReportViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 62, (Object) null);
        this.stickersPrefetched = true;
    }

    public final void selectFeatureArea(BugReportConfig2 feature) {
        this.feature = feature;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void sendReport(RequestBody screenshotBody) {
        Integer num;
        String str = this.reportName;
        if (str == null || (num = this.priority) == null) {
            return;
        }
        int iIntValue = num.intValue();
        MultipartBody.Part partB = screenshotBody != null ? MultipartBody.Part.b("screenshot", this.screenshotName, screenshotBody) : null;
        updateViewState(new ViewState.Sending(this.sendingSticker));
        RestAPI restAPI = this.restApi;
        String str2 = this.reportDescription;
        BugReportConfig2 bugReportConfig2 = this.feature;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(restAPI.sendBugReport(str, str2, iIntValue, bugReportConfig2 != null ? bugReportConfig2.getAsanaInboxId() : null, partB), false, 1, null)), BugReportViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    public final void setFeature(BugReportConfig2 bugReportConfig2) {
        this.feature = bugReportConfig2;
    }

    public final void setPriority(Integer num) {
        this.priority = num;
    }

    public final void setReportDescription(String str) {
        this.reportDescription = str;
    }

    public final void setReportName(String str) {
        this.reportName = str;
    }

    public final void setStickersPrefetched(boolean z2) {
        this.stickersPrefetched = z2;
    }

    public final void setUseScreenshot(boolean z2) {
        this.useScreenshot = z2;
    }

    public final void showFeatureAreas() {
        String str = this.featureSearchQuery;
        updateViewState(new ViewState.SelectFeature(str, this.bugReportConfig instanceof RestCallState4, _Collections.sortedWith(filterFeatures(str), new BugReportViewModel$showFeatureAreas$$inlined$sortedBy$1())));
    }

    public final void showReport(Error error) {
        updateViewState(new ViewState.Report(this.screenshotUri, this.reportName, this.reportDescription, this.priority, this.feature, this.useScreenshot, error));
    }

    @MainThread
    public final void updatePriority(int priority) {
        this.priority = Integer.valueOf(priority);
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void updateReportDescription(String description) {
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.reportDescription = description;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void updateReportName(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.reportName = name;
        showReport$default(this, null, 1, null);
    }

    @MainThread
    public final void useScreenshot(boolean useScreenshot) {
        this.useScreenshot = useScreenshot;
        showReport$default(this, null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel(Uri uri, String str, RestAPI restAPI) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(uri, "screenshotUri");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.screenshotUri = uri;
        this.screenshotName = str;
        this.restApi = restAPI;
        List<Sticker> list = sendingStickers;
        int iRandom = _Ranges.random(Collections2.getIndices(list), Random.k);
        this.stickerCharacterIndex = iRandom;
        this.sendingSticker = list.get(iRandom);
        this.successSticker = successStickers.get(iRandom);
        this.useScreenshot = true;
        this.eventSubject = PublishSubject.k0();
        loadFeatures();
    }

    /* renamed from: filterFeatures, reason: collision with other method in class */
    public final void m23filterFeatures(String it) {
        Intrinsics3.checkNotNullParameter(it, "it");
        this.featureSearchQuery = it;
        showFeatureAreas();
    }
}
