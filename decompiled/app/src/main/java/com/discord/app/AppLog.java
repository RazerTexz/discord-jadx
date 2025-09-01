package com.discord.app;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.systemlog.SystemLogReport;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.Strings4;
import d0.g0._Strings;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.q.ReplaySubject;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.webrtc.Logging;
import rx.subjects.SerializedSubject;

/* compiled from: AppLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001AB\t\b\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\f\u001a\u00020\u00042\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJ?\u0010\u0014\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0019J!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0005\u0010\u0017J)\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0005\u0010\u0019J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J)\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J!\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J7\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u001eJG\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00040 ¢\u0006\u0004\b\"\u0010#J\u001d\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010*R2\u00100\u001a\u001e\u0012\f\u0012\n .*\u0004\u0018\u00010-0-\u0012\f\u0012\n .*\u0004\u0018\u00010-0-0,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010/R\"\u00107\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00108\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010*R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010:R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010=¨\u0006B"}, d2 = {"Lcom/discord/app/AppLog;", "Lcom/discord/utilities/logging/Logger;", "", "message", "", "i", "(Ljava/lang/String;)V", "", "Lcom/discord/primitives/UserId;", "userId", "userLogin", "username", "g", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "", "priority", "", "throwable", "", "metadata", "b", "(Ljava/lang/String;ILjava/lang/Throwable;Ljava/util/Map;)V", "w", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "tag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", "v", "e", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "category", "Lkotlin/Function2;", "loggingFn", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lkotlin/jvm/functions/Function2;)V", "from", "to", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "recordBreadcrumb", "", "Z", "hasReportedTombstone", "Lrx/subjects/SerializedSubject;", "Lcom/discord/app/AppLog$LoggedItem;", "kotlin.jvm.PlatformType", "Lrx/subjects/SerializedSubject;", "logsSubject", "a", "I", "getMinLoggingPriority", "()I", "setMinLoggingPriority", "(I)V", "minLoggingPriority", "initCalled", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "cache", "", "[Ljava/lang/String;", "PACKAGE_MARKERS", "<init>", "()V", "LoggedItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AppLog extends Logger {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static boolean initCalled;

    /* renamed from: c, reason: from kotlin metadata */
    public static SharedPreferences cache;

    /* renamed from: e, reason: from kotlin metadata */
    public static boolean hasReportedTombstone;
    public static final AppLog g = new AppLog();

    /* renamed from: a, reason: from kotlin metadata */
    public static int minLoggingPriority = 99;

    /* renamed from: d, reason: from kotlin metadata */
    public static final SerializedSubject<LoggedItem, LoggedItem> logsSubject = new SerializedSubject<>(new ReplaySubject(new ReplaySubject.d(new ReplaySubject.c(5000))));

    /* renamed from: f, reason: from kotlin metadata */
    public static final String[] PACKAGE_MARKERS = {BuildConfig.APPLICATION_ID, "co.discord"};

    /* compiled from: AppLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/discord/app/AppLog$LoggedItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "j", "Ljava/lang/String;", "getKey", "key", "k", "getPriority", "priority", "l", "getMessage", "message", "", "m", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "throwable", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class LoggedItem implements MGRecyclerDataPayload {

        /* renamed from: j, reason: from kotlin metadata */
        public final String key;

        /* renamed from: k, reason: from kotlin metadata */
        public final int priority;

        /* renamed from: l, reason: from kotlin metadata */
        public final String message;

        /* renamed from: m, reason: from kotlin metadata */
        public final Throwable throwable;

        public LoggedItem(int i, String str, Throwable th) {
            Intrinsics3.checkNotNullParameter(str, "message");
            this.priority = i;
            this.message = str;
            this.throwable = th;
            String string = UUID.randomUUID().toString();
            Intrinsics3.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
            this.key = string;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoggedItem)) {
                return false;
            }
            LoggedItem loggedItem = (LoggedItem) other;
            return this.priority == loggedItem.priority && Intrinsics3.areEqual(this.message, loggedItem.message) && Intrinsics3.areEqual(this.throwable, loggedItem.throwable);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return 0;
        }

        public int hashCode() {
            int i = this.priority * 31;
            String str = this.message;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Throwable th = this.throwable;
            return iHashCode + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("LoggedItem(priority=");
            sbU.append(this.priority);
            sbU.append(", message=");
            sbU.append(this.message);
            sbU.append(", throwable=");
            sbU.append(this.throwable);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: AppLog.kt */
    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Map $metadata;
        public final /* synthetic */ int $priority;
        public final /* synthetic */ Throwable $throwable;

        /* compiled from: AppLog.kt */
        /* renamed from: com.discord.app.AppLog$a$a, reason: collision with other inner class name */
        public static final class C0064a extends Lambda implements Function2<String, Integer, Unit> {
            public C0064a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                invoke(str, num.intValue());
                return Unit.a;
            }

            public final void invoke(String str, int i) {
                Intrinsics3.checkNotNullParameter(str, "message");
                Iterator<T> it = _Strings.chunked(str, i).iterator();
                while (it.hasNext()) {
                    Log.println(a.this.$priority, AppLog.g.getDefaultTag(), (String) it.next());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Map map, Throwable th) {
            super(1);
            this.$priority = i;
            this.$metadata = map;
            this.$throwable = th;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Set setEntrySet;
            String strJoinToString$default;
            Intrinsics3.checkNotNullParameter(str, "message");
            C0064a c0064a = new C0064a();
            c0064a.invoke(str, 1000);
            Map map = this.$metadata;
            if (map != null && (setEntrySet = map.entrySet()) != null && (strJoinToString$default = _Collections.joinToString$default(setEntrySet, "\n\t", null, null, 0, null, null, 62, null)) != null) {
                c0064a.invoke("Metadata: " + strJoinToString$default, Integer.MAX_VALUE);
            }
            String stackTraceString = Log.getStackTraceString(this.$throwable);
            Intrinsics3.checkNotNullExpressionValue(stackTraceString, "Log.getStackTraceString(throwable)");
            c0064a.invoke(stackTraceString, 1000);
        }
    }

    /* compiled from: AppLog.kt */
    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Map $metadata;
        public final /* synthetic */ Throwable $throwable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Throwable th, Map map) {
            super(1);
            this.$throwable = th;
            this.$metadata = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Set<Map.Entry> setEntrySet;
            Intrinsics3.checkNotNullParameter(str, "message");
            try {
                if (this.$throwable != null) {
                    AppLog.g.recordBreadcrumb("Message " + str, "Error");
                }
                Map map = this.$metadata;
                if (map != null && (setEntrySet = map.entrySet()) != null) {
                    for (Map.Entry entry : setEntrySet) {
                        AppLog.g.recordBreadcrumb("Metadata: " + ((String) entry.getKey()) + ", " + ((String) entry.getValue()), "Error");
                    }
                }
                Exception exc = new Exception(str, this.$throwable);
                AppLog appLog = AppLog.g;
                StackTraceElement[] stackTrace = exc.getStackTrace();
                Intrinsics3.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                exc.setStackTrace(AppLog.a(appLog, stackTrace, str));
                Throwable cause = exc.getCause();
                if (cause != null) {
                    StackTraceElement[] stackTrace2 = cause.getStackTrace();
                    Intrinsics3.checkNotNullExpressionValue(stackTrace2, "cause.stackTrace");
                    cause.setStackTrace(AppLog.a(appLog, stackTrace2, str));
                }
                FirebaseCrashlytics.getInstance().recordException(exc);
            } catch (Exception e) {
                AppLog.g.w("Unable to notify error logging.", e);
            }
            if (this.$throwable != null) {
                try {
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.$throwable.getClass().toString());
                    sb.append(":\n");
                    StackTraceElement[] stackTrace3 = this.$throwable.getStackTrace();
                    Intrinsics3.checkNotNullExpressionValue(stackTrace3, "throwable.stackTrace");
                    sb.append(_Arrays.joinToString$default(stackTrace3, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                    analyticsTracker.appExceptionThrown(sb.toString());
                } catch (Exception e2) {
                    AppLog.g.w("Unable to report to analytics.", e2);
                }
            }
        }
    }

    /* compiled from: AppLog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function2<String, Throwable, Unit> {
        public c(AppLog appLog) {
            super(2, appLog, AppLog.class, "v", "v(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, Throwable th) {
            String str2 = str;
            Intrinsics3.checkNotNullParameter(str2, "p1");
            ((AppLog) this.receiver).v(str2, th);
            return Unit.a;
        }
    }

    public AppLog() {
        super("Discord");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final StackTraceElement[] a(AppLog appLog, StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        boolean z2;
        String className;
        Objects.requireNonNull(appLog);
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            i = -1;
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            String className2 = stackTraceElement.getClassName();
            Intrinsics3.checkNotNullExpressionValue(className2, "stackTraceElement.className");
            boolean z3 = Strings4.contains$default((CharSequence) className2, (CharSequence) "MediaEngineLegacy", false, 2, (Object) null) && Intrinsics3.areEqual(stackTraceElement.getMethodName(), "e");
            String className3 = stackTraceElement.getClassName();
            Intrinsics3.checkNotNullExpressionValue(className3, "stackTraceElement.className");
            String name = Logger.class.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "Logger::class.java.name");
            if (!Strings4.contains$default((CharSequence) className3, (CharSequence) name, false, 2, (Object) null)) {
                String className4 = stackTraceElement.getClassName();
                Intrinsics3.checkNotNullExpressionValue(className4, "stackTraceElement.className");
                String name2 = Logging.class.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "Logging::class.java.name");
                if (!Strings4.contains$default((CharSequence) className4, (CharSequence) name2, false, 2, (Object) null)) {
                    String className5 = stackTraceElement.getClassName();
                    Intrinsics3.checkNotNullExpressionValue(className5, "stackTraceElement.className");
                    String name3 = AppLog.class.getName();
                    Intrinsics3.checkNotNullExpressionValue(name3, "AppLog::class.java.name");
                    boolean z4 = Strings4.contains$default((CharSequence) className5, (CharSequence) name3, false, 2, (Object) null);
                    if ((z4 || z3) ? false : true) {
                        break;
                    }
                    i2++;
                }
            }
        }
        int length2 = stackTraceElementArr.length - i2;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[length2];
        System.arraycopy(stackTraceElementArr, i2, stackTraceElementArr2, 0, length2);
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                break;
            }
            StackTraceElement stackTraceElement2 = stackTraceElementArr2[i3];
            String[] strArr = PACKAGE_MARKERS;
            int length3 = strArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    z2 = false;
                    break;
                }
                if ((stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null || !Strings4.contains$default((CharSequence) className, (CharSequence) strArr[i4], false, 2, (Object) null)) ? false : true) {
                    z2 = true;
                    break;
                }
                i4++;
            }
            if (z2) {
                i = i3;
                break;
            }
            i3++;
        }
        int i5 = i > 0 ? i : 0;
        StackTraceElement stackTraceElement3 = stackTraceElementArr2[i5];
        stackTraceElementArr2[i5] = stackTraceElement3 != null ? new StackTraceElement(stackTraceElement3.getClassName(), stackTraceElement3.getMethodName(), outline.y(stackTraceElement3.getFileName(), ", ", str), stackTraceElement3.getLineNumber()) : null;
        return stackTraceElementArr2;
    }

    public static final void g(Long userId, String userLogin, String username) {
        String strValueOf;
        if (initCalled) {
            SharedPreferences sharedPreferences = cache;
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
                if (userId != null) {
                    userId.longValue();
                    editorEdit.putString("LOG_CACHE_KEY_USER_ID", String.valueOf(userId));
                }
                if (userLogin != null) {
                    editorEdit.putString("LOG_CACHE_KEY_USER_LOGIN", userLogin);
                }
                if (username != null) {
                    editorEdit.putString("LOG_CACHE_KEY_USER_NAME", username);
                }
                editorEdit.apply();
            }
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            if (userId == null || (strValueOf = String.valueOf(userId.longValue())) == null) {
                strValueOf = "";
            }
            firebaseCrashlytics.setUserId(strValueOf);
            if (userLogin != null) {
                FirebaseCrashlytics.getInstance().setCustomKey("userLogin", userLogin);
            }
            if (username != null) {
                FirebaseCrashlytics.getInstance().setCustomKey("userName", username);
            }
            if (userId == null || hasReportedTombstone) {
                return;
            }
            hasReportedTombstone = true;
            SystemLogReport.INSTANCE.reportLastCrash();
        }
    }

    public final void b(String str, int i, Throwable th, Map<String, String> map) {
        if (i < minLoggingPriority) {
            return;
        }
        a aVar = new a(i, map, th);
        logsSubject.k.onNext(new LoggedItem(i, str, th));
        b bVar = new b(th, map);
        if (i == 6) {
            bVar.invoke2(str);
        }
        aVar.invoke2(str);
    }

    public final void c(String message, String category, Throwable throwable, Function2<? super String, ? super Throwable, Unit> loggingFn) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(category, "category");
        Intrinsics3.checkNotNullParameter(loggingFn, "loggingFn");
        if (initCalled) {
            String str = '[' + category + "]: " + message;
            loggingFn.invoke("Breadcrumb, " + str, throwable);
            FirebaseCrashlytics.getInstance().log(str);
        }
    }

    @Override // com.discord.utilities.logging.Logger
    public void d(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        d(tag + " -> " + message, throwable);
    }

    @Override // com.discord.utilities.logging.Logger
    public void e(String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 6, throwable, metadata);
    }

    public final void f(String from, String to) {
        Intrinsics3.checkNotNullParameter(from, "from");
        Intrinsics3.checkNotNullParameter(to, "to");
        recordBreadcrumb("Navigation [" + from + "] > [" + to + ']', NotificationCompat.CATEGORY_NAVIGATION);
    }

    @Override // com.discord.utilities.logging.Logger
    public void i(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        i(tag + " -> " + message, throwable);
    }

    @Override // com.discord.utilities.logging.Logger
    public void recordBreadcrumb(String message, String category) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(category, "category");
        c(message, category, null, new c(this));
    }

    @Override // com.discord.utilities.logging.Logger
    public void v(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 2, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void w(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        w(tag + " -> " + message, throwable);
    }

    public static final void i(String message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        g.i(message, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void d(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 3, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void e(String tag, String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        e(tag + " -> " + message, throwable, metadata);
    }

    @Override // com.discord.utilities.logging.Logger
    public void w(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 5, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void i(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 4, throwable, null);
    }
}
