package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.VanityUrlResponse;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsVanityUrlBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsVanityUrl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b.\u0010\u001bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u00042\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u001c8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\u000f\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;)V", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "", ModelAuditLogEntry.CHANGE_KEY_USES, "configureInviteCode", "(Ljava/lang/String;I)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "updateVanityUrl", "(JLjava/lang/String;)V", "", "loading", "showLoadingUI", "(Z)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "()V", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "guildId$delegate", "Lkotlin/Lazy;", "getGuildId", "()J", "Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", "binding", "Lcom/discord/utilities/stateful/StatefulViews;", "state", "Lcom/discord/utilities/stateful/StatefulViews;", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl extends AppFragment {
    private static final long ANIMATION_DURATION = 250;
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsVanityUrl.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Companion;", "", "Landroid/view/View;", "", "translateToOriginX", "(Landroid/view/View;)V", "", "distance", "translateLeft", "(Landroid/view/View;I)V", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "create", "(Landroid/content/Context;J)V", "ANIMATION_DURATION", "J", "", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$translateLeft(Companion companion, View view, int i) {
            companion.translateLeft(view, i);
        }

        public static final /* synthetic */ void access$translateToOriginX(Companion companion, View view) {
            companion.translateToOriginX(view);
        }

        private final void translateLeft(View view, int i) {
            view.animate().translationXBy(-i).setDuration(WidgetServerSettingsVanityUrl.ANIMATION_DURATION).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        }

        private final void translateToOriginX(View view) {
            view.animate().translationX(0.0f).setDuration(WidgetServerSettingsVanityUrl.ANIMATION_DURATION).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("VANITY_URL", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsVanityUrl.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b \u0010!J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\u0011\u001a\u00020\u00002\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\bJ\u0010\u0010\u0014\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001d\u0010\bR\u001d\u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005¨\u0006#"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()I", "guildId", "guildName", "vanityUrl", "vanityUrlUses", "copy", "(JLjava/lang/String;Ljava/lang/String;I)Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildName", "I", "getVanityUrlUses", "getVanityUrl", "J", "getGuildId", "<init>", "(JLjava/lang/String;Ljava/lang/String;I)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final String guildName;
        private final String vanityUrl;
        private final int vanityUrlUses;

        /* compiled from: WidgetServerSettingsVanityUrl.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableH = Observable.h(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getVanityUrl(guildId), false, 1, null), new WidgetServerSettingsVanityUrl2(guildId));
                Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…ull\n          }\n        }");
                return observableH;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(long j, String str, String str2, int i) {
            this.guildId = j;
            this.guildName = str;
            this.vanityUrl = str2;
            this.vanityUrlUses = i;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = model.guildId;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                str = model.guildName;
            }
            String str3 = str;
            if ((i2 & 4) != 0) {
                str2 = model.vanityUrl;
            }
            String str4 = str2;
            if ((i2 & 8) != 0) {
                i = model.vanityUrlUses;
            }
            return model.copy(j2, str3, str4, i);
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
        public final String getVanityUrl() {
            return this.vanityUrl;
        }

        /* renamed from: component4, reason: from getter */
        public final int getVanityUrlUses() {
            return this.vanityUrlUses;
        }

        public final Model copy(long guildId, String guildName, String vanityUrl, int vanityUrlUses) {
            return new Model(guildId, guildName, vanityUrl, vanityUrlUses);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && Intrinsics3.areEqual(this.vanityUrl, model.vanityUrl) && this.vanityUrlUses == model.vanityUrlUses;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final String getVanityUrl() {
            return this.vanityUrl;
        }

        public final int getVanityUrlUses() {
            return this.vanityUrlUses;
        }

        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.vanityUrl;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.vanityUrlUses;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guildId=");
            sbU.append(this.guildId);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", vanityUrl=");
            sbU.append(this.vanityUrl);
            sbU.append(", vanityUrlUses=");
            return outline.B(sbU, this.vanityUrlUses, ")");
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl = WidgetServerSettingsVanityUrl.this;
            long guildId = this.$model.getGuildId();
            TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).f2588b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            int length = textOrEmpty.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics3.compare(textOrEmpty.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            WidgetServerSettingsVanityUrl.access$updateVanityUrl(widgetServerSettingsVanityUrl, guildId, textOrEmpty.subSequence(i, length + 1).toString());
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsVanityUrl.access$updateVanityUrl(WidgetServerSettingsVanityUrl.this, this.$model.getGuildId(), "");
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
            super(1, widgetServerSettingsVanityUrl, WidgetServerSettingsVanityUrl.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsVanityUrl.access$configureUI((WidgetServerSettingsVanityUrl) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "hasFocus", "", "onFocusChange", "(Landroid/view/View;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnFocusChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z2) {
            if (!z2) {
                Companion companion = WidgetServerSettingsVanityUrl.INSTANCE;
                TextView textView = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).h;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlPrefix");
                Companion.access$translateToOriginX(companion, textView);
                TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).f2588b;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
                Companion.access$translateToOriginX(companion, textInputLayout);
                return;
            }
            TextView textView2 = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).h;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlPrefix");
            int width = textView2.getWidth();
            Companion companion2 = WidgetServerSettingsVanityUrl.INSTANCE;
            TextView textView3 = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).h;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsVanityUrlPrefix");
            Companion.access$translateLeft(companion2, textView3, width);
            TextInputLayout textInputLayout2 = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).f2588b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
            Companion.access$translateLeft(companion2, textInputLayout2, width);
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl = WidgetServerSettingsVanityUrl.this;
            TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(widgetServerSettingsVanityUrl).f2588b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
            widgetServerSettingsVanityUrl.showKeyboard(textInputLayout);
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/VanityUrlResponse;", "<name for destructuring parameter 0>", "", "invoke", "(Lcom/discord/api/guild/VanityUrlResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$updateVanityUrl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<VanityUrlResponse, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VanityUrlResponse vanityUrlResponse) {
            invoke2(vanityUrlResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VanityUrlResponse vanityUrlResponse) {
            Intrinsics3.checkNotNullParameter(vanityUrlResponse, "<name for destructuring parameter 0>");
            String code = vanityUrlResponse.getCode();
            int uses = vanityUrlResponse.getUses();
            WidgetServerSettingsVanityUrl.access$showLoadingUI(WidgetServerSettingsVanityUrl.this, false);
            AppFragment.hideKeyboard$default(WidgetServerSettingsVanityUrl.this, null, 1, null);
            WidgetServerSettingsVanityUrl.access$configureInviteCode(WidgetServerSettingsVanityUrl.this, code, uses);
            StatefulViews.clear$default(WidgetServerSettingsVanityUrl.access$getState$p(WidgetServerSettingsVanityUrl.this), false, 1, null);
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$updateVanityUrl$2, reason: invalid class name */
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
            WidgetServerSettingsVanityUrl.access$showLoadingUI(WidgetServerSettingsVanityUrl.this, false);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() == 50020) {
                error.setShowErrorToasts(false);
                TextView textView = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlErrorText");
                textView.setVisibility(0);
            }
        }
    }

    public WidgetServerSettingsVanityUrl() {
        super(R.layout.widget_server_settings_vanity_url);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsVanityUrl3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.server_settings_vanity_input);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsVanityUrl4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsVanityUrl5.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureInviteCode(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, String str, int i) {
        widgetServerSettingsVanityUrl.configureInviteCode(str, i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, Model model) {
        widgetServerSettingsVanityUrl.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerSettingsVanityUrlBinding access$getBinding$p(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        return widgetServerSettingsVanityUrl.getBinding();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        return widgetServerSettingsVanityUrl.state;
    }

    public static final /* synthetic */ void access$showLoadingUI(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, boolean z2) {
        widgetServerSettingsVanityUrl.showLoadingUI(z2);
    }

    public static final /* synthetic */ void access$updateVanityUrl(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, long j, String str) {
        widgetServerSettingsVanityUrl.updateVanityUrl(j, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureInviteCode(String code, int uses) {
        boolean z2;
        boolean z3;
        TextInputLayout textInputLayout = getBinding().f2588b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f2588b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), code));
        getBinding().f2588b.clearFocus();
        if (code != null) {
            if (code.length() > 0) {
                String strW = outline.w("https://discord.gg/", code);
                TextView textView = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlCurrentUrl");
                FormatUtils.n(textView, R.string.vanity_url_help_extended, new Object[]{strW}, null, 4);
            }
        }
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlCurrentUrl");
        if (code == null) {
            z2 = false;
        } else {
            if (code.length() > 0) {
                z2 = true;
            }
        }
        textView2.setVisibility(z2 ? 0 : 8);
        TextView textView3 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsVanityUrlRemove");
        if (code == null) {
            z3 = false;
        } else {
            if (code.length() > 0) {
                z3 = true;
            }
        }
        textView3.setVisibility(z3 ? 0 : 8);
        if (code == null) {
            getBinding().e.setText(R.string.vanity_url);
            return;
        }
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.vanity_url_header_uses_uses, uses, Integer.valueOf(uses));
        TextView textView4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.serverSettingsVanityUrlHeader");
        FormatUtils.n(textView4, R.string.vanity_url_header_uses, new Object[]{i18nPluralString}, null, 4);
    }

    private final void configureUI(Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        showLoadingUI(false);
        setActionBarTitle(R.string.vanity_url);
        setActionBarSubtitle(model.getGuildName());
        configureInviteCode(model.getVanityUrl(), model.getVanityUrlUses());
        this.state.configureSaveActionView(getBinding().j);
        getBinding().j.setOnClickListener(new AnonymousClass1(model));
        getBinding().i.setOnClickListener(new AnonymousClass2(model));
    }

    private final WidgetServerSettingsVanityUrlBinding getBinding() {
        return (WidgetServerSettingsVanityUrlBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void showLoadingUI(boolean loading) {
        ProgressBar progressBar = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.serverSettingsVanityUrlLoadingIndicator");
        progressBar.setVisibility(loading ? 0 : 8);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlErrorText");
        textView.setVisibility(8);
        TextView textView2 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlRemove");
        textView2.setEnabled(!loading);
    }

    private final void updateVanityUrl(long guildId, String code) {
        showLoadingUI(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateVanityUrl(guildId, new RestAPIParams.VanityUrl(code)), false, 1, null), this, null, 2, null), WidgetServerSettingsVanityUrl.class, getContext(), (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 52, (Object) null);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        showLoadingUI(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), WidgetServerSettingsVanityUrl.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f2588b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout, new AnonymousClass1());
        getBinding().f.setOnClickListener(new AnonymousClass2());
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().j;
        TextInputLayout textInputLayout2 = getBinding().f2588b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
    }
}
