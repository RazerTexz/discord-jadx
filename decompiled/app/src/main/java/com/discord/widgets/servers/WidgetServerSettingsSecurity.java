package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsSecurityBinding;
import com.discord.databinding.WidgetServerSettingsSecurityDialogBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsSecurity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001f !B\u0007¢\u0006\u0004\b\u001e\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsSecurity;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetServerSettingsSecurityBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsSecurityBinding;", "binding", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "", "guildId$delegate", "Lkotlin/Lazy;", "getGuildId", "()J", "guildId", "<init>", "Companion", ExifInterface.TAG_MODEL, "ToggleMfaDialog", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsSecurity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String TAG_TOGGLE_MFA_DIALOG = "TAG_TOGGLE_MFA_DIALOG";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsSecurity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", WidgetServerSettingsSecurity.TAG_TOGGLE_MFA_DIALOG, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("SECURITY", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsSecurity.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsSecurity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0082\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u000e\u0010\u000b¨\u0006 "}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "guildId", "guildName", "isMfaEnabled", "copy", "(JLjava/lang/String;Z)Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildName", "J", "getGuildId", "Z", "<init>", "(JLjava/lang/String;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final String guildName;
        private final boolean isMfaEnabled;

        /* compiled from: WidgetServerSettingsSecurity.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableJ = Observable.j(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), WidgetServerSettingsSecurity$Model$Companion$get$1.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n             …        )\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableJ).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(long j, String str, boolean z2) {
            this.guildId = j;
            this.guildName = str;
            this.isMfaEnabled = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = model.guildId;
            }
            if ((i & 2) != 0) {
                str = model.guildName;
            }
            if ((i & 4) != 0) {
                z2 = model.isMfaEnabled;
            }
            return model.copy(j, str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMfaEnabled() {
            return this.isMfaEnabled;
        }

        public final Model copy(long guildId, String guildName, boolean isMfaEnabled) {
            return new Model(guildId, guildName, isMfaEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && this.isMfaEnabled == model.isMfaEnabled;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isMfaEnabled;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isMfaEnabled() {
            return this.isMfaEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guildId=");
            sbU.append(this.guildId);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", isMfaEnabled=");
            return outline.O(sbU, this.isMfaEnabled, ")");
        }
    }

    /* compiled from: WidgetServerSettingsSecurity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\u00022\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\r\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u000b\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$ToggleMfaDialog;", "Lcom/discord/app/AppDialog;", "", "onViewBoundOrOnResume", "()V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "mfaEnabled", "configure", "(JZ)V", "mfaEnabled$delegate", "Lkotlin/Lazy;", "getMfaEnabled", "()Z", "Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", "binding", "guildId$delegate", "getGuildId", "()J", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ToggleMfaDialog extends AppDialog {
        private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
        private static final String ARG_MFA_ENABLED = "ARG_MFA_ENABLED";

        /* renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        /* renamed from: guildId$delegate, reason: from kotlin metadata */
        private final Lazy guildId;

        /* renamed from: mfaEnabled$delegate, reason: from kotlin metadata */
        private final Lazy mfaEnabled;
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(ToggleMfaDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", 0)};

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: WidgetServerSettingsSecurity.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$ToggleMfaDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "mfaEnabled", "", "show", "(Landroidx/fragment/app/FragmentManager;JZ)V", "", ToggleMfaDialog.ARG_GUILD_ID, "Ljava/lang/String;", ToggleMfaDialog.ARG_MFA_ENABLED, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final void show(FragmentManager fragmentManager, long guildId, boolean mfaEnabled) {
                Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
                ToggleMfaDialog toggleMfaDialog = new ToggleMfaDialog();
                Bundle bundle = new Bundle();
                bundle.putLong(ToggleMfaDialog.ARG_GUILD_ID, guildId);
                bundle.putBoolean(ToggleMfaDialog.ARG_MFA_ENABLED, mfaEnabled);
                toggleMfaDialog.setArguments(bundle);
                toggleMfaDialog.show(fragmentManager, WidgetServerSettingsSecurity.TAG_TOGGLE_MFA_DIALOG);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ToggleMfaDialog() {
            super(R.layout.widget_server_settings_security_dialog);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2.INSTANCE, null, 2, null);
            this.guildId = LazyJVM.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$guildId$2(this));
            this.mfaEnabled = LazyJVM.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$mfaEnabled$2(this));
        }

        public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(ToggleMfaDialog toggleMfaDialog) {
            return toggleMfaDialog.getArgumentsOrDefault();
        }

        public static final /* synthetic */ WidgetServerSettingsSecurityDialogBinding access$getBinding$p(ToggleMfaDialog toggleMfaDialog) {
            return toggleMfaDialog.getBinding();
        }

        private final WidgetServerSettingsSecurityDialogBinding getBinding() {
            return (WidgetServerSettingsSecurityDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final long getGuildId() {
            return ((Number) this.guildId.getValue()).longValue();
        }

        private final boolean getMfaEnabled() {
            return ((Boolean) this.mfaEnabled.getValue()).booleanValue();
        }

        public final void configure(long guildId, boolean mfaEnabled) {
            if (guildId <= 0) {
                dismiss();
            }
            getBinding().c.setText(mfaEnabled ? R.string.disable : R.string.enable);
            MaterialButton materialButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityDialogConfirm");
            WidgetServerSettingsSecurityDialogBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            LinearLayout linearLayout = binding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(linearLayout.getContext(), mfaEnabled ? R.color.status_red_500 : R.color.status_green_600)));
            getBinding().c.setOnClickListener(new WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1(this, mfaEnabled, guildId));
            getBinding().f2587b.setOnClickListener(new WidgetServerSettingsSecurity$ToggleMfaDialog$configure$2(this));
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            Intrinsics3.checkNotNullParameter(dialog, "dialog");
            super.onDismiss(dialog);
            AppDialog.hideKeyboard$default(this, null, 1, null);
        }

        @Override // com.discord.app.AppDialog
        public void onViewBoundOrOnResume() {
            super.onViewBoundOrOnResume();
            configure(getGuildId(), getMfaEnabled());
        }
    }

    /* compiled from: WidgetServerSettingsSecurity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ToggleMfaDialog.Companion companion = ToggleMfaDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettingsSecurity.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$model.getGuildId(), this.$model.isMfaEnabled());
        }
    }

    /* compiled from: WidgetServerSettingsSecurity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsSecurity widgetServerSettingsSecurity) {
            super(1, widgetServerSettingsSecurity, WidgetServerSettingsSecurity.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsSecurity.access$configureUI((WidgetServerSettingsSecurity) this.receiver, model);
        }
    }

    public WidgetServerSettingsSecurity() {
        super(R.layout.widget_server_settings_security);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsSecurity$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsSecurity$guildId$2(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsSecurity$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsSecurity widgetServerSettingsSecurity, Model model) throws Exception {
        widgetServerSettingsSecurity.configureUI(model);
    }

    private final void configureUI(Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarTitle(R.string.security);
        setActionBarSubtitle(model.getGuildName());
        if (model.isMfaEnabled()) {
            getBinding().c.setText(R.string.guild_security_req_mfa_turn_off);
            MaterialButton materialButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityToggleMfaButton");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), R.color.status_red_500)));
        } else {
            getBinding().c.setText(R.string.guild_security_req_mfa_turn_on);
            MaterialButton materialButton2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.serverSettingsSecurityToggleMfaButton");
            materialButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), R.color.status_green_600)));
        }
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(TAG_TOGGLE_MFA_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            ((ToggleMfaDialog) fragmentFindFragmentByTag).configure(model.getGuildId(), model.isMfaEnabled());
        }
        getBinding().c.setOnClickListener(new AnonymousClass1(model));
    }

    private final WidgetServerSettingsSecurityBinding getBinding() {
        return (WidgetServerSettingsSecurityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(TAG_TOGGLE_MFA_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            getParentFragmentManager().beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        TextView textView = getBinding().f2586b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mfaDescriptionText");
        FormatUtils.n(textView, R.string.guild_security_req_mfa_body, new Object[0], null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), WidgetServerSettingsSecurity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
