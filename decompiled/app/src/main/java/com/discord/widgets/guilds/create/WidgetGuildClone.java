package com.discord.widgets.guilds.create;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.role.GuildRole;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.create.GuildCreateCloneViews;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.guilds.create.WidgetGuildCreateViewModel;
import com.discord.widgets.roles.RolesListView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildClone.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildClone;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreate;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel;", "createViewModelFactory", "()Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;)V", "Lcom/discord/databinding/WidgetGuildCloneBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildCloneBinding;", "binding", "Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "getViews", "()Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "views", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildClone extends WidgetGuildCreate {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildClone.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCloneBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_GUILD_TEMPLATE_CODE = "guild_template_code";
    private static final int VIEW_INDEX_INVALID_TEMPLATE = 1;
    private static final int VIEW_INDEX_LOADING_TEMPLATE = 0;
    private static final int VIEW_INDEX_READY = 2;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetGuildClone.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildClone$Companion;", "", "Landroid/content/Context;", "context", "", "guildTemplateCode", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "INTENT_GUILD_TEMPLATE_CODE", "Ljava/lang/String;", "", "VIEW_INDEX_INVALID_TEMPLATE", "I", "VIEW_INDEX_LOADING_TEMPLATE", "VIEW_INDEX_READY", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.show(context, str, str2);
        }

        public final void show(Context context, String guildTemplateCode, String location) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildCreate.EXTRA_OPTIONS, new WidgetGuildCreate.Options(location, null, false, null, false, 30, null));
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(EXTRA_OPTIONS, options)");
            if (guildTemplateCode != null) {
                intentPutExtra.putExtra(WidgetGuildClone.INTENT_GUILD_TEMPLATE_CODE, guildTemplateCode);
            }
            AppScreen2.d(context, WidgetGuildClone.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetGuildClone() {
        super(R.layout.widget_guild_clone);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildClone2.INSTANCE, null, 2, null);
    }

    private final WidgetGuildCloneBinding getBinding() {
        return (WidgetGuildCloneBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public void configureUI(WidgetGuildCreateViewModel.ViewState viewState) {
        List<Channel> listEmptyList;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        super.configureUI(viewState);
        StoreStream.INSTANCE.getGuildTemplates().clearDynamicLinkGuildTemplateCode();
        if (Intrinsics3.areEqual(viewState, WidgetGuildCreateViewModel.ViewState.Uninitialized.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildCreateFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (viewState instanceof WidgetGuildCreateViewModel.ViewState.Initialized) {
            WidgetGuildCreateViewModel.ViewState.Initialized initialized = (WidgetGuildCreateViewModel.ViewState.Initialized) viewState;
            StoreGuildTemplates.GuildTemplateState guildTemplate = initialized.getGuildTemplate();
            if (Intrinsics3.areEqual(guildTemplate, StoreGuildTemplates.GuildTemplateState.None.INSTANCE) || Intrinsics3.areEqual(guildTemplate, StoreGuildTemplates.GuildTemplateState.Invalid.INSTANCE) || Intrinsics3.areEqual(guildTemplate, StoreGuildTemplates.GuildTemplateState.LoadFailed.INSTANCE)) {
                AppViewFlipper appViewFlipper2 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.guildCreateFlipper");
                appViewFlipper2.setDisplayedChild(1);
                return;
            }
            if (Intrinsics3.areEqual(guildTemplate, StoreGuildTemplates.GuildTemplateState.Loading.INSTANCE)) {
                AppViewFlipper appViewFlipper3 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.guildCreateFlipper");
                appViewFlipper3.setDisplayedChild(0);
                return;
            }
            if (guildTemplate instanceof StoreGuildTemplates.GuildTemplateState.Resolved) {
                ModelGuildTemplate guildTemplate2 = ((StoreGuildTemplates.GuildTemplateState.Resolved) initialized.getGuildTemplate()).getGuildTemplate();
                Guild serializedSourceGuild = guildTemplate2.getSerializedSourceGuild();
                if (serializedSourceGuild == null) {
                    AppViewFlipper appViewFlipper4 = getBinding().c;
                    Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.guildCreateFlipper");
                    appViewFlipper4.setDisplayedChild(1);
                    return;
                }
                AppViewFlipper appViewFlipper5 = getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper5, "binding.guildCreateFlipper");
                appViewFlipper5.setDisplayedChild(2);
                TextView textView = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildTemplateName");
                int themedColor = ColorCompat.getThemedColor(textView, R.attr.colorHeaderSecondary);
                TextView textView2 = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildTemplateName");
                ColorCompat2.setDrawableColor(textView2, themedColor);
                TextView textView3 = getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildTemplateName");
                textView3.setText(guildTemplate2.getName());
                GuildTemplateChannelsView guildTemplateChannelsView = getBinding().h;
                List<Channel> listG = serializedSourceGuild.g();
                if (listG == null || (listEmptyList = _Collections.sortedWith(listG, new WidgetGuildClone$configureUI$$inlined$sortedBy$1())) == null) {
                    listEmptyList = Collections2.emptyList();
                }
                guildTemplateChannelsView.updateView(listEmptyList);
                List<GuildRole> listG2 = serializedSourceGuild.G();
                if (listG2 == null) {
                    listG2 = Collections2.emptyList();
                }
                List listSortedWith = _Collections.sortedWith(listG2, new WidgetGuildClone$configureUI$$inlined$sortedBy$2());
                ArrayList arrayList = new ArrayList();
                for (Object obj : listSortedWith) {
                    if (!Intrinsics3.areEqual(((GuildRole) obj).getName(), "@everyone")) {
                        arrayList.add(obj);
                    }
                }
                LinearLayout linearLayout = getBinding().j;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guildTemplatePreviewRolesLayout");
                linearLayout.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
                RolesListView rolesListView = getBinding().i;
                RolesListView rolesListView2 = getBinding().i;
                Intrinsics3.checkNotNullExpressionValue(rolesListView2, "binding.guildTemplatePreviewRoles");
                rolesListView.updateView(arrayList, ColorCompat.getThemedColor(rolesListView2.getContext(), R.attr.primary_300), serializedSourceGuild.getId());
            }
        }
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public WidgetGuildCreateViewModel createViewModelFactory() {
        return new WidgetGuildCreateViewModel(R.string.create_server_default_server_name_format, null, getMostRecentIntent().getStringExtra(INTENT_GUILD_TEMPLATE_CODE), false, getArgs().getAnalyticsLocation(), null, false, null, null, null, 962, null);
    }

    @Override // com.discord.widgets.guilds.create.WidgetGuildCreate
    public GuildCreateCloneViews getViews() {
        GuildCreateCloneViews.Companion companion = GuildCreateCloneViews.INSTANCE;
        WidgetGuildCloneBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        return companion.from(binding);
    }
}
