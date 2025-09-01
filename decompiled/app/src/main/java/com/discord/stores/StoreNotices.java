package com.discord.stores;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.outline;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.LazyJVM;
import d0.e0.KClass;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreNotices.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 F2\u00020\u0001:\u0005FGHIJB\u0017\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\bD\u0010EJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u00060\u000bj\u0002`\f0\t0\u0005¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u0011J#\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\f\b\u0002\u0010\u001a\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0015\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001b\u0010 J\u0015\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b$\u0010#R&\u0010&\u001a\u0012\u0012\u0004\u0012\u00020%\u0012\b\u0012\u00060\u000bj\u0002`\f0\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R,\u00103\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u00060\u000bj\u0002`\f0\t028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u0006088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=R!\u0010C\u001a\u00060\u000bj\u0002`\f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B¨\u0006K"}, d2 = {"Lcom/discord/stores/StoreNotices;", "Lcom/discord/stores/Store;", "", "processNextNotice", "()V", "Lrx/Observable;", "Lcom/discord/stores/StoreNotices$Notice;", "getNotices", "()Lrx/Observable;", "Ljava/util/HashMap;", "", "", "Lcom/discord/primitives/Timestamp;", "observeNoticesSeen", "noticeName", "", "hasSeen", "(Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "notice", "requestToShow", "(Lcom/discord/stores/StoreNotices$Notice;)V", "hasBeenSeen", "seenAtMs", "markSeen", "(Ljava/lang/String;J)V", "markInAppSeen", "Lcom/discord/stores/StoreNotices$Dialog$Type;", "type", "(Lcom/discord/stores/StoreNotices$Dialog$Type;)V", "noticeDialogType", "markDialogSeen", "(Ljava/lang/String;)V", "clearSeen", "", "lastShownTimes", "Ljava/util/HashMap;", "value", "pollRateMs", "J", "setPollRateMs", "(J)V", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "getStream", "()Lcom/discord/stores/StoreStream;", "Lcom/discord/utilities/persister/Persister;", "noticesSeenCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Ljava/util/PriorityQueue;", "noticeQueue", "Ljava/util/PriorityQueue;", "Lrx/subjects/BehaviorSubject;", "processTrigger", "Lrx/subjects/BehaviorSubject;", "noticePublisher", "firstUseTimestamp$delegate", "Lkotlin/Lazy;", "getFirstUseTimestamp", "()J", "firstUseTimestamp", "<init>", "(Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreStream;)V", "Companion", "Dialog", "InputDialog", "Notice", "PassiveNotice", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNotices extends Store {
    public static final String IN_APP_NOTICE_TAG = "InAppNotif";
    public static final String NOTICE_POPUP_TAG = "Popup";
    public static final int PRIORITY_HIGH = 0;
    public static final int PRIORITY_INAPP_NOTIFICATION = 1;
    public static final int PRIORITY_PASSIVE_NOTICE = 10;
    public static final int PRIORITY_USER_SURVEY = 5;
    public static final long PROCESS_PERIOD_MS = 30000;
    public static final long PROCESS_THROTTLE_MS = 50;
    private final Clock clock;

    /* renamed from: firstUseTimestamp$delegate, reason: from kotlin metadata */
    private final Lazy firstUseTimestamp;
    private HashMap<Integer, Long> lastShownTimes;
    private final BehaviorSubject<Notice> noticePublisher;
    private final PriorityQueue<Notice> noticeQueue;
    private final Persister<HashMap<String, Long>> noticesSeenCache;
    private long pollRateMs;
    private final BehaviorSubject<Unit> processTrigger;
    private final StoreStream stream;

    /* compiled from: StoreNotices.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R'\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/discord/stores/StoreNotices$Dialog;", "", "Lcom/discord/stores/StoreNotices$Dialog$Type;", "component1", "()Lcom/discord/stores/StoreNotices$Dialog$Type;", "", "", "component2", "()Ljava/util/Map;", "type", "metadata", "copy", "(Lcom/discord/stores/StoreNotices$Dialog$Type;Ljava/util/Map;)Lcom/discord/stores/StoreNotices$Dialog;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreNotices$Dialog$Type;", "getType", "Ljava/util/Map;", "getMetadata", "<init>", "(Lcom/discord/stores/StoreNotices$Dialog$Type;Ljava/util/Map;)V", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Dialog {
        private final Map<String, Object> metadata;
        private final Type type;

        /* compiled from: StoreNotices.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/stores/StoreNotices$Dialog$Type;", "", "", "priority", "", "sinceLastPeriodMs", "delayPeriodMs", "", "persist", "Lcom/discord/stores/StoreNotices$PassiveNotice;", "buildPassiveNotice", "(IJJZ)Lcom/discord/stores/StoreNotices$PassiveNotice;", "<init>", "(Ljava/lang/String;I)V", "REQUEST_RATING_MODAL", "DELETE_CONNECTION_MODAL", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            REQUEST_RATING_MODAL,
            DELETE_CONNECTION_MODAL;

            public static /* synthetic */ PassiveNotice buildPassiveNotice$default(Type type, int i, long j, long j2, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = 10;
                }
                if ((i2 & 2) != 0) {
                    j = 31536000000L;
                }
                long j3 = j;
                if ((i2 & 4) != 0) {
                    j2 = 21600000;
                }
                return type.buildPassiveNotice(i, j3, j2, (i2 & 8) != 0 ? false : z2);
            }

            public final PassiveNotice buildPassiveNotice(int priority, long sinceLastPeriodMs, long delayPeriodMs, boolean persist) {
                return new PassiveNotice(name(), priority, persist, sinceLastPeriodMs, delayPeriodMs, new StoreNotices2(this));
            }
        }

        public Dialog(Type type, Map<String, ? extends Object> map) {
            Intrinsics3.checkNotNullParameter(type, "type");
            this.type = type;
            this.metadata = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Dialog copy$default(Dialog dialog, Type type, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                type = dialog.type;
            }
            if ((i & 2) != 0) {
                map = dialog.metadata;
            }
            return dialog.copy(type, map);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final Map<String, Object> component2() {
            return this.metadata;
        }

        public final Dialog copy(Type type, Map<String, ? extends Object> metadata) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new Dialog(type, metadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dialog)) {
                return false;
            }
            Dialog dialog = (Dialog) other;
            return Intrinsics3.areEqual(this.type, dialog.type) && Intrinsics3.areEqual(this.metadata, dialog.metadata);
        }

        public final Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            int iHashCode = (type != null ? type.hashCode() : 0) * 31;
            Map<String, Object> map = this.metadata;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Dialog(type=");
            sbU.append(this.type);
            sbU.append(", metadata=");
            return outline.M(sbU, this.metadata, ")");
        }

        public /* synthetic */ Dialog(Type type, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(type, (i & 2) != 0 ? null : map);
        }
    }

    /* compiled from: StoreNotices.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreNotices$InputDialog;", "", "Lcom/discord/stores/StoreNotices$InputDialog$Type;", "component1", "()Lcom/discord/stores/StoreNotices$InputDialog$Type;", "type", "copy", "(Lcom/discord/stores/StoreNotices$InputDialog$Type;)Lcom/discord/stores/StoreNotices$InputDialog;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreNotices$InputDialog$Type;", "getType", "<init>", "(Lcom/discord/stores/StoreNotices$InputDialog$Type;)V", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class InputDialog {
        private final Type type;

        /* compiled from: StoreNotices.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/stores/StoreNotices$InputDialog$Type;", "", "<init>", "(Ljava/lang/String;I)V", "PASSWORD", "TEXT_NO_SUGGESTIONS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            PASSWORD,
            TEXT_NO_SUGGESTIONS
        }

        public InputDialog(Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public static /* synthetic */ InputDialog copy$default(InputDialog inputDialog, Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                type = inputDialog.type;
            }
            return inputDialog.copy(type);
        }

        /* renamed from: component1, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final InputDialog copy(Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new InputDialog(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof InputDialog) && Intrinsics3.areEqual(this.type, ((InputDialog) other).type);
            }
            return true;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            Type type = this.type;
            if (type != null) {
                return type.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("InputDialog(type=");
            sbU.append(this.type);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreNotices.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010-\u001a\u00020\u0014\u0012\b\b\u0002\u0010=\u001a\u00020<\u0012\f\b\u0002\u0010\"\u001a\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u00108\u001a\u00020\f\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020)¢\u0006\u0004\bA\u0010BJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\u00022\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R)\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\"\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010'\u001a\u00020\u00068\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!R(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020)8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010-\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0016R(\u00100\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0004\b0\u0010%\u0012\u0004\b4\u00105\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u00103R\u0019\u00106\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010\u0004R\u0019\u00108\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010=\u001a\u00020<8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/discord/stores/StoreNotices$Notice;", "", "", "isInAppNotification", "()Z", "isPopup", "", "Lcom/discord/primitives/Timestamp;", "lastSeenMs", "canShow", "(Ljava/lang/Long;)Z", "", "", "lastShownTimes", "shouldShow", "(Ljava/util/Map;)Z", "Landroidx/fragment/app/FragmentActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "show", "(Landroidx/fragment/app/FragmentActivity;)Z", "", "toString", "()Ljava/lang/String;", "", "Ld0/e0/c;", "Lcom/discord/app/AppComponent;", "validScreens", "Ljava/util/List;", "getValidScreens", "()Ljava/util/List;", "delayPeriodMs", "J", "getDelayPeriodMs", "()J", "requestedShowTimestamp", "getRequestedShowTimestamp", "autoMarkSeen", "Z", "getAutoMarkSeen", "sinceLastPeriodMs", "getSinceLastPeriodMs", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getShow", "()Lkotlin/jvm/functions/Function1;", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "getName", "hasShown", "getHasShown", "setHasShown", "(Z)V", "getHasShown$annotations", "()V", "persist", "getPersist", "priority", "I", "getPriority", "()I", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getClock", "()Lcom/discord/utilities/time/Clock;", "<init>", "(Ljava/lang/String;Lcom/discord/utilities/time/Clock;JIZLjava/util/List;JZJLkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static class Notice {
        private final boolean autoMarkSeen;
        private final Clock clock;
        private final long delayPeriodMs;
        private boolean hasShown;
        private final String name;
        private final boolean persist;
        private final int priority;
        private final long requestedShowTimestamp;
        private final Function1<FragmentActivity, Boolean> show;
        private final long sinceLastPeriodMs;
        private final List<KClass<? extends AppComponent>> validScreens;

        /* JADX WARN: Multi-variable type inference failed */
        public Notice(String str, Clock clock, long j, int i, boolean z2, List<? extends KClass<? extends AppComponent>> list, long j2, boolean z3, long j3, Function1<? super FragmentActivity, Boolean> function1) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(clock, "clock");
            Intrinsics3.checkNotNullParameter(function1, "show");
            this.name = str;
            this.clock = clock;
            this.requestedShowTimestamp = j;
            this.priority = i;
            this.persist = z2;
            this.validScreens = list;
            this.delayPeriodMs = j2;
            this.autoMarkSeen = z3;
            this.sinceLastPeriodMs = j3;
            this.show = function1;
        }

        public static /* synthetic */ void getHasShown$annotations() {
        }

        public boolean canShow(Long lastSeenMs) {
            return lastSeenMs == null || this.clock.currentTimeMillis() - lastSeenMs.longValue() > this.sinceLastPeriodMs;
        }

        public final boolean getAutoMarkSeen() {
            return this.autoMarkSeen;
        }

        public final Clock getClock() {
            return this.clock;
        }

        public final long getDelayPeriodMs() {
            return this.delayPeriodMs;
        }

        public final boolean getHasShown() {
            return this.hasShown;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getPersist() {
            return this.persist;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final long getRequestedShowTimestamp() {
            return this.requestedShowTimestamp;
        }

        public final Function1<FragmentActivity, Boolean> getShow() {
            return this.show;
        }

        public final long getSinceLastPeriodMs() {
            return this.sinceLastPeriodMs;
        }

        public final List<KClass<? extends AppComponent>> getValidScreens() {
            return this.validScreens;
        }

        public final boolean isInAppNotification() {
            return Strings4.contains((CharSequence) this.name, (CharSequence) StoreNotices.IN_APP_NOTICE_TAG, true);
        }

        public final boolean isPopup() {
            return Strings4.contains((CharSequence) this.name, (CharSequence) StoreNotices.NOTICE_POPUP_TAG, true);
        }

        public final void setHasShown(boolean z2) {
            this.hasShown = z2;
        }

        public boolean shouldShow(Map<Integer, Long> lastShownTimes) {
            Intrinsics3.checkNotNullParameter(lastShownTimes, "lastShownTimes");
            Long l = lastShownTimes.get(Integer.valueOf(this.priority));
            return this.delayPeriodMs < this.clock.currentTimeMillis() - (l != null ? l.longValue() : 0L);
        }

        @MainThread
        public final boolean show(FragmentActivity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (this.hasShown || activity.isFinishing()) {
                return false;
            }
            Boolean boolInvoke = this.show.invoke(activity);
            this.hasShown = boolInvoke.booleanValue();
            return boolInvoke.booleanValue();
        }

        public String toString() {
            StringBuilder sbU = outline.U("Notice<");
            sbU.append(this.name);
            sbU.append(">(pri=");
            sbU.append(this.priority);
            sbU.append(", ts=");
            sbU.append(this.requestedShowTimestamp);
            sbU.append(')');
            return sbU.toString();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Notice(String str, Clock clock, long j, int i, boolean z2, List list, long j2, boolean z3, long j3, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            Clock clock2 = (i2 & 2) != 0 ? ClockFactory.get() : clock;
            this(str, clock2, (i2 & 4) != 0 ? clock2.currentTimeMillis() : j, (i2 & 8) != 0 ? 10 : i, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetHome.class), Reflection2.getOrCreateKotlinClass(WidgetCallFullscreen.class)}) : list, (i2 & 64) != 0 ? 15000L : j2, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? 31536000000L : j3, function1);
        }
    }

    /* compiled from: StoreNotices.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/discord/stores/StoreNotices$PassiveNotice;", "Lcom/discord/stores/StoreNotices$Notice;", "", "", "", "Lcom/discord/primitives/Timestamp;", "lastShownTimes", "", "shouldShow", "(Ljava/util/Map;)Z", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "priority", "persist", "sinceLastPeriodMs", "delayPeriodMs", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentActivity;", "show", "<init>", "(Ljava/lang/String;IZJJLkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static class PassiveNotice extends Notice {
        public /* synthetic */ PassiveNotice(String str, int i, boolean z2, long j, long j2, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? 31536000000L : j, (i2 & 16) != 0 ? 21600000L : j2, function1);
        }

        @Override // com.discord.stores.StoreNotices.Notice
        public boolean shouldShow(Map<Integer, Long> lastShownTimes) {
            Intrinsics3.checkNotNullParameter(lastShownTimes, "lastShownTimes");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<Integer, Long>> it = lastShownTimes.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, Long> next = it.next();
                if (next.getKey().intValue() <= getPriority()) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            Long l = (Long) _Collections.maxOrNull((Iterable) linkedHashMap.values());
            return getDelayPeriodMs() < getClock().currentTimeMillis() - (l != null ? l.longValue() : 0L);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PassiveNotice(String str, int i, boolean z2, long j, long j2, Function1<? super FragmentActivity, Boolean> function1) {
            super(str, null, 0L, i, z2, null, j2, false, j, function1, Opcodes.IF_ACMPNE, null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(function1, "show");
        }
    }

    /* compiled from: StoreNotices.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/util/HashMap;", "", "", "Lcom/discord/primitives/Timestamp;", "cache", "invoke", "(Ljava/util/HashMap;)Ljava/util/HashMap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotices$clearSeen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<HashMap<String, Long>, HashMap<String, Long>> {
        public final /* synthetic */ String $noticeName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$noticeName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ HashMap<String, Long> invoke(HashMap<String, Long> map) {
            return invoke2(map);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final HashMap<String, Long> invoke2(HashMap<String, Long> map) {
            Intrinsics3.checkNotNullParameter(map, "cache");
            map.remove(this.$noticeName);
            return map;
        }
    }

    /* compiled from: StoreNotices.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Unit;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotices$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Unit, Observable<? extends Long>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(Unit unit) {
            return call2(unit);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(Unit unit) {
            return Observable.E(0L, StoreNotices.access$getPollRateMs$p(StoreNotices.this), TimeUnit.MILLISECONDS);
        }
    }

    /* compiled from: StoreNotices.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotices$init$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreNotices.access$processNextNotice(StoreNotices.this);
        }
    }

    /* compiled from: StoreNotices.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreNotices$init$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Could not process next notice: ");
            sbU.append(StoreNotices.access$getNoticeQueue$p(StoreNotices.this));
            Logger.e$default(appLog, sbU.toString(), error.getThrowable(), null, 4, null);
        }
    }

    public StoreNotices(Clock clock, StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.noticesSeenCache = new Persister<>("NOTICES_SHOWN_V2", new HashMap());
        this.noticeQueue = new PriorityQueue<>(11, a.compareBy(StoreNotices4.INSTANCE, StoreNotices5.INSTANCE, StoreNotices6.INSTANCE));
        this.pollRateMs = 30000L;
        this.lastShownTimes = new HashMap<>();
        BehaviorSubject<Unit> behaviorSubjectK0 = BehaviorSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.processTrigger = behaviorSubjectK0;
        BehaviorSubject<Notice> behaviorSubjectL0 = BehaviorSubject.l0(null);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(null as Notice?)");
        this.noticePublisher = behaviorSubjectL0;
        this.firstUseTimestamp = LazyJVM.lazy(new StoreNotices3(this));
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreNotices storeNotices) {
        return storeNotices.clock;
    }

    public static final /* synthetic */ PriorityQueue access$getNoticeQueue$p(StoreNotices storeNotices) {
        return storeNotices.noticeQueue;
    }

    public static final /* synthetic */ long access$getPollRateMs$p(StoreNotices storeNotices) {
        return storeNotices.pollRateMs;
    }

    public static final /* synthetic */ void access$processNextNotice(StoreNotices storeNotices) {
        storeNotices.processNextNotice();
    }

    public static final /* synthetic */ void access$setPollRateMs$p(StoreNotices storeNotices, long j) {
        storeNotices.setPollRateMs(j);
    }

    public static /* synthetic */ void markSeen$default(StoreNotices storeNotices, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = storeNotices.clock.currentTimeMillis();
        }
        storeNotices.markSeen(str, j);
    }

    private final synchronized void processNextNotice() {
        Object next;
        Iterator<T> it = this.noticeQueue.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Notice) next).shouldShow(this.lastShownTimes)) {
                    break;
                }
            }
        }
        this.noticePublisher.onNext((Notice) next);
    }

    private final void setPollRateMs(long j) {
        this.pollRateMs = Math.max(500L, j);
    }

    public final synchronized void clearSeen(String noticeName) {
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        this.noticesSeenCache.getAndSet(true, new AnonymousClass1(noticeName));
    }

    public final long getFirstUseTimestamp() {
        return ((Number) this.firstUseTimestamp.getValue()).longValue();
    }

    public final Observable<Notice> getNotices() {
        Observable<Notice> observableR = this.noticePublisher.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "noticePublisher.distinctUntilChanged()");
        return observableR;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    public final synchronized boolean hasBeenSeen(String noticeName) {
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        return this.noticesSeenCache.get().get(noticeName) != null;
    }

    public final synchronized boolean hasSeen(String noticeName) {
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        return this.noticesSeenCache.get().containsKey(noticeName);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        AppLog appLog = AppLog.g;
        Logger.d$default(appLog, "Notices init", null, 2, null);
        Logger.d$default(appLog, "Notices prev seen: " + this.noticesSeenCache.get().entrySet(), null, 2, null);
        Observable observableP = this.processTrigger.Y(new AnonymousClass1()).p(50L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "processTrigger\n        .…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableP), StoreNotices.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final void markDialogSeen(String noticeDialogType) {
        Intrinsics3.checkNotNullParameter(noticeDialogType, "noticeDialogType");
        try {
            markSeen(Dialog.Type.valueOf(noticeDialogType));
        } catch (IllegalArgumentException unused) {
            markSeen$default(this, noticeDialogType, 0L, 2, null);
        }
    }

    public final synchronized void markInAppSeen() {
        PriorityQueue<Notice> priorityQueue = this.noticeQueue;
        ArrayList arrayList = new ArrayList();
        for (Object obj : priorityQueue) {
            if (Strings4.contains$default((CharSequence) ((Notice) obj).getName(), (CharSequence) IN_APP_NOTICE_TAG, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            markSeen$default(this, ((Notice) it.next()).getName(), 0L, 2, null);
        }
    }

    public final synchronized void markSeen(String noticeName, long seenAtMs) {
        Object next;
        Object next2;
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        AppLog.i("Notice seen: " + noticeName + " @ " + seenAtMs);
        Iterator<T> it = this.noticeQueue.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics3.areEqual(((Notice) next).getName(), noticeName)) {
                    break;
                }
            }
        }
        Notice notice = (Notice) next;
        if (notice != null) {
            this.noticeQueue.remove(notice);
            if (notice.getDelayPeriodMs() <= this.pollRateMs) {
                Iterator<T> it2 = this.noticeQueue.iterator();
                if (it2.hasNext()) {
                    next2 = it2.next();
                    if (it2.hasNext()) {
                        long delayPeriodMs = ((Notice) next2).getDelayPeriodMs();
                        do {
                            Object next3 = it2.next();
                            long delayPeriodMs2 = ((Notice) next3).getDelayPeriodMs();
                            if (delayPeriodMs > delayPeriodMs2) {
                                next2 = next3;
                                delayPeriodMs = delayPeriodMs2;
                            }
                        } while (it2.hasNext());
                    }
                } else {
                    next2 = null;
                }
                Notice notice2 = (Notice) next2;
                setPollRateMs(notice2 != null ? notice2.getDelayPeriodMs() : 30000L);
            }
            this.lastShownTimes.put(Integer.valueOf(notice.getPriority()), Long.valueOf(seenAtMs));
            if (notice.getPersist()) {
                HashMap<String, Long> map = this.noticesSeenCache.get();
                map.put(notice.getName(), Long.valueOf(seenAtMs));
                this.noticesSeenCache.set(map, true);
                Logger.v$default(AppLog.g, "Notice seen saved: " + noticeName + " @ " + seenAtMs, null, 2, null);
            }
            this.noticePublisher.onNext(null);
        }
        this.processTrigger.onNext(Unit.a);
    }

    public final Observable<HashMap<String, Long>> observeNoticesSeen() {
        return this.noticesSeenCache.getObservable();
    }

    public final synchronized void requestToShow(Notice notice) {
        Intrinsics3.checkNotNullParameter(notice, "notice");
        if (notice.canShow(this.noticesSeenCache.get().get(notice.getName()))) {
            PriorityQueue<Notice> priorityQueue = this.noticeQueue;
            boolean z2 = true;
            if (!(priorityQueue instanceof Collection) || !priorityQueue.isEmpty()) {
                Iterator<T> it = priorityQueue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (Intrinsics3.areEqual(((Notice) it.next()).getName(), notice.getName())) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                this.noticeQueue.add(notice);
                AppLog.i("Notice Request: " + notice.getName());
                Logger.d$default(AppLog.g, "Notice queues: " + this.noticeQueue, null, 2, null);
                long delayPeriodMs = notice.getDelayPeriodMs();
                if (delayPeriodMs < this.pollRateMs) {
                    setPollRateMs(delayPeriodMs);
                }
                this.processTrigger.onNext(Unit.a);
            }
        }
    }

    public final void markSeen(Dialog.Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        markSeen$default(this, type.name(), 0L, 2, null);
    }
}
