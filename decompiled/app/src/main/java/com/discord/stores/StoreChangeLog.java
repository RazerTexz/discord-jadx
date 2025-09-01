package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.FragmentActivity;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.time.Clock;
import com.discord.widgets.changelog.WidgetChangeLog;
import com.discord.widgets.changelog.WidgetChangeLogSpecial;
import d0.Result3;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import s.a.CoroutineScope2;
import s.a.Dispatchers;

/* compiled from: StoreChangeLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b@\u0010AJ5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u000b2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\u001bR\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R(\u0010<\u001a\u0004\u0018\u00010\u00072\b\u00108\u001a\u0004\u0018\u00010\u00078B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010!R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/discord/stores/StoreChangeLog;", "Lcom/discord/stores/Store;", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/UserId;", "userId", "", "targetLanguage", "", "experimentBucket", "", "shouldShowChangelog", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Integer;)Z", "isTooYoung", "(J)Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "fallback", "getChangelogExperimentString", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/discord/stores/StoreNotices$Notice;", "createChangeLogNotice", "()Lcom/discord/stores/StoreNotices$Notice;", "Landroid/app/Application;", "app", "", "init", "(Landroid/app/Application;)V", "handleConnectionOpen", "()V", "handlePostConnectionOpen", "currentVersion", "markSeen", "(Ljava/lang/String;)V", "fromSettings", "openChangeLog", "(Landroid/content/Context;Z)V", "Lcom/discord/stores/StoreNotices;", "notices", "Lcom/discord/stores/StoreNotices;", "Lcom/discord/stores/StoreUser;", "users", "Lcom/discord/stores/StoreUser;", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "setApp", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/stores/StoreExperiments;", "experiments", "Lcom/discord/stores/StoreExperiments;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "value", "getLastSeenChangeLogVersion", "()Ljava/lang/String;", "setLastSeenChangeLogVersion", "lastSeenChangeLogVersion", "Lcom/discord/stores/StoreUserSettingsSystem;", "userSettingsSystem", "Lcom/discord/stores/StoreUserSettingsSystem;", "<init>", "(Lcom/discord/utilities/time/Clock;Lcom/discord/stores/StoreNotices;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserSettingsSystem;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/Dispatcher;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreChangeLog extends Store {
    public Application app;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final StoreExperiments experiments;
    private final StoreNotices notices;
    private final StoreUserSettingsSystem userSettingsSystem;
    private final StoreUser users;

    /* compiled from: StoreChangeLog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "appActivity", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChangeLog$createChangeLogNotice$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
            StoreChangeLog.openChangeLog$default(StoreChangeLog.this, fragmentActivity, false, 2, null);
            return true;
        }
    }

    /* compiled from: StoreChangeLog.kt */
    @DebugMetadata(c = "com.discord.stores.StoreChangeLog$handleConnectionOpen$1", f = "StoreChangeLog.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChangeLog$handleConnectionOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: StoreChangeLog.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreChangeLog$handleConnectionOpen$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00991 extends Lambda implements Function0<Unit> {
            public C00991() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreChangeLog.this.handlePostConnectionOpen();
            }
        }

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return StoreChangeLog.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            StoreChangeLog.access$getDispatcher$p(StoreChangeLog.this).schedule(new C00991());
            return Unit.a;
        }
    }

    public StoreChangeLog(Clock clock, StoreNotices storeNotices, StoreUser storeUser, StoreUserSettingsSystem storeUserSettingsSystem, StoreExperiments storeExperiments, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeNotices, "notices");
        Intrinsics3.checkNotNullParameter(storeUser, "users");
        Intrinsics3.checkNotNullParameter(storeUserSettingsSystem, "userSettingsSystem");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experiments");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.clock = clock;
        this.notices = storeNotices;
        this.users = storeUser;
        this.userSettingsSystem = storeUserSettingsSystem;
        this.experiments = storeExperiments;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChangeLog storeChangeLog) {
        return storeChangeLog.dispatcher;
    }

    private final StoreNotices.Notice createChangeLogNotice() {
        return new StoreNotices.Notice("CHANGE_LOG", null, 1337L, 0, true, null, 0L, false, 604800000L, new AnonymousClass1(), 226, null);
    }

    private final String getChangelogExperimentString(Context context, String name, String fallback) {
        int identifier = context.getResources().getIdentifier(name, "string", context.getPackageName());
        if (identifier <= 0) {
            return fallback;
        }
        String string = context.getString(identifier);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(id)");
        return string;
    }

    private final String getLastSeenChangeLogVersion() {
        return getPrefs().getString("CACHE_KEY_VIEWED_CHANGE_LOG_VERSION", "");
    }

    private final boolean isTooYoung(long userId) {
        long j = (userId >>> 22) + SnowflakeUtils.DISCORD_EPOCH + 432000000;
        long firstUseTimestamp = this.notices.getFirstUseTimestamp() + 432000000;
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        return jCurrentTimeMillis < j || jCurrentTimeMillis < firstUseTimestamp;
    }

    public static /* synthetic */ void openChangeLog$default(StoreChangeLog storeChangeLog, Context context, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeChangeLog.openChangeLog(context, z2);
    }

    private final void setLastSeenChangeLogVersion(String str) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString("CACHE_KEY_VIEWED_CHANGE_LOG_VERSION", str);
        editorEdit.apply();
    }

    private final boolean shouldShowChangelog(Context context, long userId, String targetLanguage, Integer experimentBucket) {
        String string;
        int identifier = (experimentBucket != null && experimentBucket.intValue() == 1) ? context.getResources().getIdentifier("change_log_md_experiment_body", "string", context.getPackageName()) : R.string.change_log_md_body;
        CharSequence stringByLocale = StringUtils2.getStringByLocale(context, identifier, "en");
        CharSequence stringByLocale2 = StringUtils2.getStringByLocale(context, identifier, targetLanguage);
        if ((!Intrinsics3.areEqual(targetLanguage, "en")) && Intrinsics3.areEqual(stringByLocale, stringByLocale2)) {
            return false;
        }
        if (experimentBucket != null && experimentBucket.intValue() == 1) {
            String string2 = context.getString(R.string.change_log_md_date);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.change_log_md_date)");
            string = getChangelogExperimentString(context, "change_log_md_experiment_date", string2);
        } else {
            string = context.getString(R.string.change_log_md_date);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.change_log_md_date)");
        }
        String lastSeenChangeLogVersion = getLastSeenChangeLogVersion();
        if (!(lastSeenChangeLogVersion == null || StringsJVM.isBlank(lastSeenChangeLogVersion)) && !isTooYoung(userId)) {
            return !Intrinsics3.areEqual(string, getLastSeenChangeLogVersion());
        }
        markSeen(string);
        return false;
    }

    public final Application getApp() {
        Application application = this.app;
        if (application == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("app");
        }
        return application;
    }

    @Store3
    public final void handleConnectionOpen() {
        f.H0(CoroutineScope2.j, Dispatchers.a, null, new AnonymousClass1(null), 2, null);
    }

    @Store3
    public final void handlePostConnectionOpen() {
        String str = (String) Strings4.split$default((CharSequence) this.userSettingsSystem.getLocale(), new String[]{"-"}, false, 0, 6, (Object) null).get(0);
        long id2 = this.users.getMeSnapshot().getId();
        Application application = this.app;
        if (application == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("app");
        }
        if (shouldShowChangelog(application, id2, str, null)) {
            this.notices.requestToShow(createChangeLogNotice());
        }
    }

    @Store3
    public final void init(Application app) {
        Intrinsics3.checkNotNullParameter(app, "app");
        init((Context) app);
        this.app = app;
    }

    public final void markSeen(String currentVersion) {
        Intrinsics3.checkNotNullParameter(currentVersion, "currentVersion");
        setLastSeenChangeLogVersion(currentVersion);
        StoreNotices.markSeen$default(this.notices, "CHANGE_LOG", 0L, 2, null);
    }

    public final void openChangeLog(Context context, boolean fromSettings) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.change_log_md_date);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.change_log_md_date)");
        String changelogExperimentString = getChangelogExperimentString(context, "change_log_md_experiment_date", string);
        String string2 = context.getString(R.string.change_log_md_revision);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.change_log_md_revision)");
        String changelogExperimentString2 = getChangelogExperimentString(context, "change_log_md_revision", string2);
        String string3 = context.getString(R.string.change_log_md_video);
        Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.string.change_log_md_video)");
        String changelogExperimentString3 = getChangelogExperimentString(context, "change_log_md_experiment_video", string3);
        String string4 = context.getString(R.string.change_log_md_body);
        Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.string.change_log_md_body)");
        String changelogExperimentString4 = getChangelogExperimentString(context, "change_log_md_experiment_body", string4);
        String string5 = context.getString(R.string.back);
        Intrinsics3.checkNotNullExpressionValue(string5, "context.getString(R.string.back)");
        String changelogExperimentString5 = getChangelogExperimentString(context, "change_log_md_experiment_template", string5);
        WidgetChangeLogSpecial.Companion.ExitStyle exitStyle = fromSettings ? WidgetChangeLogSpecial.Companion.ExitStyle.BACK : WidgetChangeLogSpecial.Companion.ExitStyle.CLOSE;
        if (Intrinsics3.areEqual(changelogExperimentString5, "special") && Intrinsics3.areEqual((Object) null, (Object) 1)) {
            WidgetChangeLogSpecial.INSTANCE.launch(context, changelogExperimentString, changelogExperimentString2, changelogExperimentString3, changelogExperimentString4, exitStyle, true);
            return;
        }
        if (Intrinsics3.areEqual((Object) null, (Object) 1)) {
            WidgetChangeLog.INSTANCE.launch(context, changelogExperimentString, changelogExperimentString2, changelogExperimentString3, changelogExperimentString4);
            return;
        }
        WidgetChangeLog.Companion companion = WidgetChangeLog.INSTANCE;
        String string6 = context.getString(R.string.change_log_md_date);
        Intrinsics3.checkNotNullExpressionValue(string6, "context.getString(R.string.change_log_md_date)");
        String string7 = context.getString(R.string.change_log_md_revision);
        Intrinsics3.checkNotNullExpressionValue(string7, "context.getString(R.string.change_log_md_revision)");
        String string8 = context.getString(R.string.change_log_md_video);
        Intrinsics3.checkNotNullExpressionValue(string8, "context.getString(R.string.change_log_md_video)");
        String string9 = context.getString(R.string.change_log_md_body);
        Intrinsics3.checkNotNullExpressionValue(string9, "context.getString(R.string.change_log_md_body)");
        companion.launch(context, string6, string7, string8, string9);
    }

    public final void setApp(Application application) {
        Intrinsics3.checkNotNullParameter(application, "<set-?>");
        this.app = application;
    }
}
