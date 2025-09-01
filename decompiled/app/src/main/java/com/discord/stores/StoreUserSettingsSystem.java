package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import b.d.b.a.outline;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.models.domain.auth.ModelLoginResult2;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.cache.SharedPreferenceExtensions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: StoreUserSettingsSystem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0002DEB#\u0012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070:\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\bB\u0010CJ1\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\nJ\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b \u0010\u0019J1\u0010!\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b!\u0010\nJ\r\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\u001cJ\u0015\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u001fJ\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0017¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0007H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b9\u0010\u000eR\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006F"}, d2 = {"Lcom/discord/stores/StoreUserSettingsSystem;", "Lcom/discord/stores/StoreV2;", "", "theme", "", "apiSync", "Lkotlin/Function0;", "", "onRequestApiSync", "setThemeInternal", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "Lcom/discord/models/domain/ModelUserSettings;", "userSettings", "handleUserSettings", "(Lcom/discord/models/domain/ModelUserSettings;)V", "handleUserSettingsThemeUpdate", "(Ljava/lang/String;)V", "locale", "handleUserSettingsLocaleUpdate", "sample", "Lrx/Observable;", "Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "observeSettings", "(Z)Lrx/Observable;", "getTheme", "()Ljava/lang/String;", "setTheme", "getIsThemeSyncEnabled", "()Z", "isSyncThemeEnabled", "setIsSyncThemeEnabled", "(Z)V", "getLocale", "setLocale", "getIsLocaleSyncEnabled", "isLocaleSyncEnabled", "setIsLocaleSyncEnabled", "", "getFontScale", "()I", "fontScale", "setFontScale", "(I)V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "handlePreLogout", "()V", "Lcom/discord/models/domain/auth/ModelLoginResult;", "loginResult", "handleLoginResult", "(Lcom/discord/models/domain/auth/ModelLoginResult;)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleUserSettingsUpdate", "Lkotlin/Function1;", "onFontScaleUpdated", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "settings", "Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "<init>", "(Lkotlin/jvm/functions/Function1;Lcom/discord/stores/Dispatcher;)V", "Companion", "Settings", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUserSettingsSystem extends StoreV2 {
    private static final boolean DEFAULT_IS_CLIENT_SYNC_ENABLED = true;
    private final Dispatcher dispatcher;
    private final Function1<Integer, Unit> onFontScaleUpdated;
    private Settings settings;

    /* compiled from: StoreUserSettingsSystem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u0013\u0010\u0019\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "theme", "_locale", "fontScale", "copy", "(Ljava/lang/String;Ljava/lang/String;I)Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "get_locale", "I", "getFontScale", "getLocale", "locale", "getTheme", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Settings {
        private final String _locale;
        private final int fontScale;
        private final String theme;

        public Settings(String str, String str2, int i) {
            Intrinsics3.checkNotNullParameter(str, "theme");
            this.theme = str;
            this._locale = str2;
            this.fontScale = i;
        }

        public static /* synthetic */ Settings copy$default(Settings settings, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = settings.theme;
            }
            if ((i2 & 2) != 0) {
                str2 = settings._locale;
            }
            if ((i2 & 4) != 0) {
                i = settings.fontScale;
            }
            return settings.copy(str, str2, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTheme() {
            return this.theme;
        }

        /* renamed from: component2, reason: from getter */
        public final String get_locale() {
            return this._locale;
        }

        /* renamed from: component3, reason: from getter */
        public final int getFontScale() {
            return this.fontScale;
        }

        public final Settings copy(String theme, String _locale, int fontScale) {
            Intrinsics3.checkNotNullParameter(theme, "theme");
            return new Settings(theme, _locale, fontScale);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Settings)) {
                return false;
            }
            Settings settings = (Settings) other;
            return Intrinsics3.areEqual(this.theme, settings.theme) && Intrinsics3.areEqual(this._locale, settings._locale) && this.fontScale == settings.fontScale;
        }

        public final int getFontScale() {
            return this.fontScale;
        }

        public final String getLocale() {
            String str = this._locale;
            if (str != null) {
                return str;
            }
            String defaultLocale = ModelUserSettings.getDefaultLocale();
            Intrinsics3.checkNotNullExpressionValue(defaultLocale, "ModelUserSettings.getDefaultLocale()");
            return defaultLocale;
        }

        public final String getTheme() {
            return this.theme;
        }

        public final String get_locale() {
            return this._locale;
        }

        public int hashCode() {
            String str = this.theme;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this._locale;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.fontScale;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Settings(theme=");
            sbU.append(this.theme);
            sbU.append(", _locale=");
            sbU.append(this._locale);
            sbU.append(", fontScale=");
            return outline.B(sbU, this.fontScale, ")");
        }
    }

    /* compiled from: StoreUserSettingsSystem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "invoke", "()Lcom/discord/stores/StoreUserSettingsSystem$Settings;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettingsSystem$observeSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Settings> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Settings invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Settings invoke() {
            return StoreUserSettingsSystem.access$getSettings$p(StoreUserSettingsSystem.this);
        }
    }

    /* compiled from: StoreUserSettingsSystem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettingsSystem$setFontScale$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $fontScale;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i) {
            super(0);
            this.$fontScale = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserSettingsSystem storeUserSettingsSystem = StoreUserSettingsSystem.this;
            StoreUserSettingsSystem.access$setSettings$p(storeUserSettingsSystem, Settings.copy$default(StoreUserSettingsSystem.access$getSettings$p(storeUserSettingsSystem), null, null, this.$fontScale, 3, null));
            StoreUserSettingsSystem.this.markChanged();
            StoreUserSettingsSystem.access$getOnFontScaleUpdated$p(StoreUserSettingsSystem.this).invoke(Integer.valueOf(this.$fontScale));
        }
    }

    /* compiled from: StoreUserSettingsSystem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreUserSettingsSystem$setTheme$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $apiSync;
        public final /* synthetic */ Function0 $onRequestApiSync;
        public final /* synthetic */ String $theme;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, boolean z2, Function0 function0) {
            super(0);
            this.$theme = str;
            this.$apiSync = z2;
            this.$onRequestApiSync = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUserSettingsSystem.access$setThemeInternal(StoreUserSettingsSystem.this, this.$theme, this.$apiSync, this.$onRequestApiSync);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUserSettingsSystem(Function1<? super Integer, Unit> function1, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(function1, "onFontScaleUpdated");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.onFontScaleUpdated = function1;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ Function1 access$getOnFontScaleUpdated$p(StoreUserSettingsSystem storeUserSettingsSystem) {
        return storeUserSettingsSystem.onFontScaleUpdated;
    }

    public static final /* synthetic */ Settings access$getSettings$p(StoreUserSettingsSystem storeUserSettingsSystem) {
        Settings settings = storeUserSettingsSystem.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        return settings;
    }

    public static final /* synthetic */ void access$setSettings$p(StoreUserSettingsSystem storeUserSettingsSystem, Settings settings) {
        storeUserSettingsSystem.settings = settings;
    }

    public static final /* synthetic */ void access$setThemeInternal(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0) {
        storeUserSettingsSystem.setThemeInternal(str, z2, function0);
    }

    @Store3
    private final void handleUserSettings(ModelUserSettings userSettings) {
        handleUserSettingsThemeUpdate(userSettings.getTheme());
        handleUserSettingsLocaleUpdate(userSettings.getLocale());
    }

    private final void handleUserSettingsLocaleUpdate(String locale) {
        if (locale == null || !getIsLocaleSyncEnabled()) {
            return;
        }
        setLocale$default(this, locale, false, null, 4, null);
    }

    @Store3
    private final void handleUserSettingsThemeUpdate(String theme) {
        if (theme == null || !getIsThemeSyncEnabled()) {
            return;
        }
        setThemeInternal$default(this, theme, false, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setLocale$default(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        storeUserSettingsSystem.setLocale(str, z2, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setTheme$default(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        storeUserSettingsSystem.setTheme(str, z2, function0);
    }

    @Store3
    private final void setThemeInternal(String theme, boolean apiSync, Function0<Unit> onRequestApiSync) {
        if (getIsThemeSyncEnabled() && apiSync && (onRequestApiSync == null || onRequestApiSync.invoke() == null)) {
            throw new IllegalArgumentException("API callback required.");
        }
        if (Intrinsics3.areEqual(getTheme(), ModelUserSettings.THEME_PURE_EVIL) && Intrinsics3.areEqual(theme, ModelUserSettings.THEME_DARK)) {
            theme = ModelUserSettings.THEME_PURE_EVIL;
        }
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        this.settings = Settings.copy$default(settings, theme, null, 0, 6, null);
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString("CACHE_KEY_THEME", theme);
        editorEdit.apply();
        markChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setThemeInternal$default(StoreUserSettingsSystem storeUserSettingsSystem, String str, boolean z2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        storeUserSettingsSystem.setThemeInternal(str, z2, function0);
    }

    public final int getFontScale() {
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        return settings.getFontScale();
    }

    public final boolean getIsLocaleSyncEnabled() {
        return getPrefs().getBoolean("CACHE_KEY_LOCALE_SYNC", true);
    }

    public final boolean getIsThemeSyncEnabled() {
        return getPrefsSessionDurable().getBoolean("CACHE_KEY_THEME_SYNC", true);
    }

    public final String getLocale() {
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        return settings.getLocale();
    }

    public final String getTheme() {
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        return settings.getTheme();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelUserSettings userSettings = payload.getUserSettings();
        Intrinsics3.checkNotNullExpressionValue(userSettings, "payload.userSettings");
        handleUserSettings(userSettings);
    }

    @Store3
    public final void handleLoginResult(ModelLoginResult loginResult) {
        Intrinsics3.checkNotNullParameter(loginResult, "loginResult");
        ModelLoginResult2 userSettings = loginResult.getUserSettings();
        handleUserSettingsThemeUpdate(userSettings != null ? userSettings.getTheme() : null);
        ModelLoginResult2 userSettings2 = loginResult.getUserSettings();
        handleUserSettingsLocaleUpdate(userSettings2 != null ? userSettings2.getLocale() : null);
    }

    @Store3
    public final void handlePreLogout() {
        setIsSyncThemeEnabled(true);
        setIsLocaleSyncEnabled(true);
        setLocale$default(this, null, false, null, 4, null);
        setFontScale(-1);
    }

    @Store3
    public final void handleUserSettingsUpdate(ModelUserSettings userSettings) {
        Intrinsics3.checkNotNullParameter(userSettings, "userSettings");
        handleUserSettings(userSettings);
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        this.settings = new Settings(SharedPreferenceExtensions.getStringNonNull(getPrefsSessionDurable(), "CACHE_KEY_THEME", (resources.getConfiguration().uiMode & 48) != 32 ? ModelUserSettings.THEME_LIGHT : ModelUserSettings.THEME_DARK), getPrefs().getString("CACHE_KEY_LOCALE", null), getPrefs().getInt("CACHE_KEY_FONT_SCALE", -1));
    }

    public final Observable<Settings> observeSettings(boolean sample) {
        Observable observableConnectRx$default = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
        if (sample) {
            observableConnectRx$default = observableConnectRx$default.P(1500L, TimeUnit.MILLISECONDS);
        }
        Observable<Settings> observableR = observableConnectRx$default.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider\n…  .distinctUntilChanged()");
        return observableR;
    }

    public final void setFontScale(int fontScale) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putInt("CACHE_KEY_FONT_SCALE", fontScale);
        editorEdit.apply();
        this.dispatcher.schedule(new AnonymousClass2(fontScale));
    }

    public final void setIsLocaleSyncEnabled(boolean isLocaleSyncEnabled) {
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("CACHE_KEY_LOCALE_SYNC", isLocaleSyncEnabled);
        editorEdit.apply();
    }

    public final void setIsSyncThemeEnabled(boolean isSyncThemeEnabled) {
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean("CACHE_KEY_THEME_SYNC", isSyncThemeEnabled);
        editorEdit.apply();
    }

    public final void setLocale(String locale, boolean apiSync, Function0<Unit> onRequestApiSync) {
        if (getIsLocaleSyncEnabled() && apiSync && (onRequestApiSync == null || onRequestApiSync.invoke() == null)) {
            throw new IllegalArgumentException("API callback required.");
        }
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("settings");
        }
        this.settings = Settings.copy$default(settings, null, locale, 0, 5, null);
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString("CACHE_KEY_LOCALE", locale);
        editorEdit.apply();
        markChanged();
    }

    public final void setTheme(String theme, boolean apiSync, Function0<Unit> onRequestApiSync) {
        Intrinsics3.checkNotNullParameter(theme, "theme");
        this.dispatcher.schedule(new AnonymousClass1(theme, apiSync, onRequestApiSync));
    }
}
