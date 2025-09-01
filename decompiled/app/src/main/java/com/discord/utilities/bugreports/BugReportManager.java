package com.discord.utilities.bugreports;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.bugreports.WidgetBugReport;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: BugReportManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0019\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b&\u0010'J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/discord/utilities/bugreports/BugReportManager;", "", "Landroid/content/Context;", "context", "Lcom/discord/screenshot_detection/ScreenshotDetector$Screenshot;", "screenshot", "", "onScreenshot", "(Landroid/content/Context;Lcom/discord/screenshot_detection/ScreenshotDetector$Screenshot;)V", "", "isStaff", "setUserIsStaff", "(Z)V", "enabled", "setBugReportingSettingEnabled", "isEnabled", "()Z", "isBugReportSettingEnabled", "setupSubscriptions", "()V", "Lcom/discord/screenshot_detection/ScreenshotDetector;", "screenshotDetector$delegate", "Lkotlin/Lazy;", "getScreenshotDetector", "()Lcom/discord/screenshot_detection/ScreenshotDetector;", "screenshotDetector", "settingsEnabled", "Z", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "getStoreUser", "()Lcom/discord/stores/StoreUser;", "Landroid/content/SharedPreferences;", "cache", "Landroid/content/SharedPreferences;", "getCache", "()Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;Lcom/discord/stores/StoreUser;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BugReportManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED = "prefs_ss_bug_reporting_enabled";
    private static BugReportManager bugReportManager;
    private final SharedPreferences cache;
    private boolean isStaff;

    /* renamed from: screenshotDetector$delegate, reason: from kotlin metadata */
    private final Lazy screenshotDetector;
    private boolean settingsEnabled;
    private final StoreUser storeUser;

    /* compiled from: BugReportManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/bugreports/BugReportManager$Companion;", "", "", "init", "()V", "Lcom/discord/utilities/bugreports/BugReportManager;", "get", "()Lcom/discord/utilities/bugreports/BugReportManager;", "", "PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED", "Ljava/lang/String;", "bugReportManager", "Lcom/discord/utilities/bugreports/BugReportManager;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final BugReportManager get() {
            BugReportManager bugReportManagerAccess$getBugReportManager$cp = BugReportManager.access$getBugReportManager$cp();
            if (bugReportManagerAccess$getBugReportManager$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("bugReportManager");
            }
            return bugReportManagerAccess$getBugReportManager$cp;
        }

        public final void init() {
            BugReportManager.access$setBugReportManager$cp(new BugReportManager(SharedPreferencesProvider.INSTANCE.get(), null, 2, null));
            BugReportManager bugReportManagerAccess$getBugReportManager$cp = BugReportManager.access$getBugReportManager$cp();
            if (bugReportManagerAccess$getBugReportManager$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("bugReportManager");
            }
            bugReportManagerAccess$getBugReportManager$cp.setupSubscriptions();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BugReportManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.bugreports.BugReportManager$setupSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<MeUser, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            UserUtils userUtils = UserUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "it");
            return Boolean.valueOf(userUtils.isStaff(meUser));
        }
    }

    /* compiled from: BugReportManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isStaff", "", "invoke", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.bugreports.BugReportManager$setupSubscriptions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            BugReportManager bugReportManager = BugReportManager.this;
            Intrinsics3.checkNotNullExpressionValue(bool, "isStaff");
            bugReportManager.setUserIsStaff(bool.booleanValue());
        }
    }

    public BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "cache");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        this.cache = sharedPreferences;
        this.storeUser = storeUser;
        this.settingsEnabled = true;
        this.screenshotDetector = LazyJVM.lazy(BugReportManager2.INSTANCE);
        this.settingsEnabled = sharedPreferences.getBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, true);
    }

    public static final /* synthetic */ BugReportManager access$getBugReportManager$cp() {
        return bugReportManager;
    }

    public static final /* synthetic */ void access$setBugReportManager$cp(BugReportManager bugReportManager2) {
        bugReportManager = bugReportManager2;
    }

    private final ScreenshotDetector getScreenshotDetector() {
        return (ScreenshotDetector) this.screenshotDetector.getValue();
    }

    public final SharedPreferences getCache() {
        return this.cache;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    /* renamed from: isBugReportSettingEnabled, reason: from getter */
    public final boolean getSettingsEnabled() {
        return this.settingsEnabled;
    }

    public final boolean isEnabled() {
        return this.isStaff && this.settingsEnabled;
    }

    public final void onScreenshot(Context context, ScreenshotDetector.Screenshot screenshot) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(screenshot, "screenshot");
        if (isEnabled()) {
            WidgetBugReport.INSTANCE.launch(context, screenshot);
        }
    }

    public final void setBugReportingSettingEnabled(boolean enabled) {
        SharedPreferences.Editor editorEdit = this.cache.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(PREFS_SS_BUG_REPORTING_SETTINGS_ENABLED, enabled);
        editorEdit.apply();
        this.settingsEnabled = enabled;
        getScreenshotDetector().a(isEnabled());
    }

    public final void setUserIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
        getScreenshotDetector().a(isEnabled());
    }

    public final void setupSubscriptions() {
        Observable observableR = this.storeUser.observeMe(true).G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeUser.observeMe(emit… }.distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, BugReportManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public /* synthetic */ BugReportManager(SharedPreferences sharedPreferences, StoreUser storeUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser);
    }
}
