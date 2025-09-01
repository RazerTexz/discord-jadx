package com.discord.utilities.systemlog;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.debug.HistoricalProcessExitReason;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: SystemLogReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/systemlog/SystemLogReport;", "", "Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;", "tombstone", "", "sendReport", "(Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;)V", "", "hash", "", "checkHashChanged", "(Ljava/lang/String;)Z", "reportLastCrash", "()V", "CACHE_KEY_LAST_STORED_TOMBSTONE_HASH", "Ljava/lang/String;", "Landroid/content/SharedPreferences;", "getPrefsSessionDurable", "()Landroid/content/SharedPreferences;", "prefsSessionDurable", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SystemLogReport {
    private static final String CACHE_KEY_LAST_STORED_TOMBSTONE_HASH = "CACHE_KEY_SYSTEM_LOG_STORE_LAST_STORED_TOMBSTONE_HASH";
    public static final SystemLogReport INSTANCE = new SystemLogReport();

    /* compiled from: SystemLogReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.systemlog.SystemLogReport$reportLastCrash$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
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
            error.setShouldLog(false);
            error.setShowErrorToasts(false);
            SystemLogReport.access$sendReport(SystemLogReport.INSTANCE, null);
            AppLog.g.i("Checking tombstone error", error.getThrowable());
        }
    }

    /* compiled from: SystemLogReport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;", "crash", "", "invoke", "(Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.systemlog.SystemLogReport$reportLastCrash$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<SystemLogUtils.Tombstone, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SystemLogUtils.Tombstone tombstone) {
            invoke2(tombstone);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SystemLogUtils.Tombstone tombstone) {
            Intrinsics3.checkNotNullParameter(tombstone, "crash");
            Iterator it = Strings4.split$default((CharSequence) tombstone.getText(), new String[]{"\n"}, false, 0, 6, (Object) null).iterator();
            while (it.hasNext()) {
                AppLog.g.recordBreadcrumb((String) it.next(), "Tombstone");
            }
            AppLog appLog = AppLog.g;
            appLog.recordBreadcrumb(tombstone.getGroupHash(), "Tombstone-Hash");
            SystemLogReport systemLogReport = SystemLogReport.INSTANCE;
            boolean zAccess$checkHashChanged = SystemLogReport.access$checkHashChanged(systemLogReport, tombstone.getTextHash());
            if (zAccess$checkHashChanged) {
                Logger.e$default(appLog, "Tombstone", null, null, 6, null);
            }
            if (!zAccess$checkHashChanged) {
                tombstone = null;
            }
            SystemLogReport.access$sendReport(systemLogReport, tombstone);
        }
    }

    private SystemLogReport() {
    }

    public static final /* synthetic */ boolean access$checkHashChanged(SystemLogReport systemLogReport, String str) {
        return systemLogReport.checkHashChanged(str);
    }

    public static final /* synthetic */ void access$sendReport(SystemLogReport systemLogReport, SystemLogUtils.Tombstone tombstone) {
        systemLogReport.sendReport(tombstone);
    }

    private final boolean checkHashChanged(String hash) {
        if (Intrinsics3.areEqual(getPrefsSessionDurable().getString(CACHE_KEY_LAST_STORED_TOMBSTONE_HASH, null), hash)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString(CACHE_KEY_LAST_STORED_TOMBSTONE_HASH, hash);
        editorEdit.apply();
        return true;
    }

    private final SharedPreferences getPrefsSessionDurable() {
        return SharedPreferencesProvider.INSTANCE.getPrefsSessionDurable();
    }

    private final void sendReport(SystemLogUtils.Tombstone tombstone) {
        boolean zDidCrashOnPreviousExecution = FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution();
        HistoricalProcessExitReason.Reason lastReason = HistoricalProcessExitReason.INSTANCE.getLastReason();
        AnalyticsTracker.INSTANCE.appNativeCrash(zDidCrashOnPreviousExecution, lastReason != null ? lastReason.getReason() : null, lastReason != null ? lastReason.getReason() : null, tombstone != null ? tombstone.getGroupHash() : null, tombstone != null ? tombstone.getCause() : null);
    }

    public final void reportLastCrash() {
        ObservableExtensionsKt.appSubscribe$default(SystemLogUtils.INSTANCE.fetchLastTombstone(), SystemLogReport.class, (Context) null, (Function1) null, AnonymousClass1.INSTANCE, (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 54, (Object) null);
    }
}
