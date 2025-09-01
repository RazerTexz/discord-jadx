package com.discord.widgets.servers.settings.members;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.i.ServerSettingsMembersRoleSpinnerItemBinding;
import b.a.i.ServerSettingsMembersRoleSpinnerItemOpenBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsMembersBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.user.WidgetPruneUsers;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.g0.StringNumberConversions;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* compiled from: WidgetServerSettingsMembers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b.\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010#R\u001c\u0010%\u001a\u00020$8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0017¨\u00061"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembers;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", "model", "", "configureUI", "(Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;)V", "", "Lcom/discord/primitives/RoleId;", "everyoneRoleId", "", "Lcom/discord/api/role/GuildRole;", "guildRoles", "setupRolesSpinner", "(JLjava/util/Map;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lrx/subjects/Subject;", "roleFilterPublisher", "Lrx/subjects/Subject;", "Lcom/discord/databinding/WidgetServerSettingsMembersBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsMembersBinding;", "binding", "guildId$delegate", "Lkotlin/Lazy;", "getGuildId", "()J", "guildId", "Ljava/util/Map;", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersAdapter;", "adapter", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersAdapter;", "", "nameFilterPublisher", "<init>", "Companion", "RolesSpinnerAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsMembers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsMembersBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_MEMBER_LIST = 0;
    private static final int VIEW_INDEX_NO_RESULTS = 1;
    private WidgetServerSettingsMembersAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private Map<Long, GuildRole> guildRoles;
    private final AppLogger2 loggingConfig;
    private final Subject<String, String> nameFilterPublisher;
    private final Subject<Long, Long> roleFilterPublisher;

    /* compiled from: WidgetServerSettingsMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembers$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "create", "(Landroid/content/Context;J)V", "", WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, "Ljava/lang/String;", "", "VIEW_INDEX_MEMBER_LIST", "I", "VIEW_INDEX_NO_RESULTS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsMembers.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsMembers.class, intentPutExtra);
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("MEMBERS", guildId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembers$RolesSpinnerAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/discord/api/role/GuildRole;", "Landroid/widget/TextView;", "label", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "configureLabel", "(Landroid/widget/TextView;I)V", "getCount", "()I", "getItem", "(I)Lcom/discord/api/role/GuildRole;", "", "getItemId", "(I)J", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "getDropDownView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "roles", "Ljava/util/ArrayList;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class RolesSpinnerAdapter extends ArrayAdapter<GuildRole> {
        private final ArrayList<GuildRole> roles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RolesSpinnerAdapter(Context context, ArrayList<GuildRole> arrayList) {
            super(context, R.layout.server_settings_members_role_spinner_item, arrayList);
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(arrayList, "roles");
            this.roles = arrayList;
        }

        private final void configureLabel(TextView label, int position) {
            GuildRole item = getItem(position);
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            label.setTextColor(RoleUtils.getRoleColor$default(item, context, null, 2, null));
            label.setText(item.getName());
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.roles.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            ServerSettingsMembersRoleSpinnerItemOpenBinding serverSettingsMembersRoleSpinnerItemOpenBinding;
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.server_settings_members_role_spinner_item_open, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                serverSettingsMembersRoleSpinnerItemOpenBinding = new ServerSettingsMembersRoleSpinnerItemOpenBinding(textView, textView);
            } else {
                TextView textView2 = (TextView) convertView;
                serverSettingsMembersRoleSpinnerItemOpenBinding = new ServerSettingsMembersRoleSpinnerItemOpenBinding(textView2, textView2);
            }
            Intrinsics3.checkNotNullExpressionValue(serverSettingsMembersRoleSpinnerItemOpenBinding, "if (convertView == null)…bind(convertView)\n      }");
            TextView textView3 = serverSettingsMembersRoleSpinnerItemOpenBinding.f151b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.roleSpinnerItemTextview");
            configureLabel(textView3, position);
            TextView textView4 = serverSettingsMembersRoleSpinnerItemOpenBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.root");
            return textView4;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ServerSettingsMembersRoleSpinnerItemBinding serverSettingsMembersRoleSpinnerItemBinding;
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.server_settings_members_role_spinner_item, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                serverSettingsMembersRoleSpinnerItemBinding = new ServerSettingsMembersRoleSpinnerItemBinding(textView, textView);
            } else {
                TextView textView2 = (TextView) convertView;
                serverSettingsMembersRoleSpinnerItemBinding = new ServerSettingsMembersRoleSpinnerItemBinding(textView2, textView2);
            }
            Intrinsics3.checkNotNullExpressionValue(serverSettingsMembersRoleSpinnerItemBinding, "if (convertView == null)…bind(convertView)\n      }");
            TextView textView3 = serverSettingsMembersRoleSpinnerItemBinding.f145b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.roleSpinnerItemTextview");
            configureLabel(textView3, position);
            TextView textView4 = serverSettingsMembersRoleSpinnerItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.root");
            return textView4;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public GuildRole getItem(int position) {
            GuildRole guildRole = this.roles.get(position);
            Intrinsics3.checkNotNullExpressionValue(guildRole, "roles[position]");
            return guildRole;
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetServerSettingsMembersModel $model;

        public AnonymousClass1(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) {
            this.$model = widgetServerSettingsMembersModel;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_server_settings_members_prune) {
                return;
            }
            WidgetPruneUsers.Companion companion = WidgetPruneUsers.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            FragmentManager parentFragmentManager = WidgetServerSettingsMembers.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.create(id2, parentFragmentManager);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00040\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "", "Lcom/discord/primitives/RoleId;", "userRoles", "", "invoke", "(JLjava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, List<? extends Long>, Unit> {
        public final /* synthetic */ WidgetServerSettingsMembersModel $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) {
            super(2);
            this.$model = widgetServerSettingsMembersModel;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
            invoke(l.longValue(), (List<Long>) list);
            return Unit.a;
        }

        public final void invoke(long j, List<Long> list) {
            Intrinsics3.checkNotNullParameter(list, "userRoles");
            boolean z2 = j == this.$model.getMeUser().getId();
            if (this.$model.getGuild().getOwnerId() == j && !z2) {
                AppToast.i(WidgetServerSettingsMembers.this, R.string.cannot_manage_is_owner, 0, 4);
                return;
            }
            GuildRole highestRole = RoleUtils.getHighestRole(this.$model.getRoles(), list);
            if (!RoleUtils.rankIsHigher(this.$model.getMyHighestRole(), highestRole) && !this.$model.getGuild().isOwner(this.$model.getMeUser().getId()) && !z2) {
                if (RoleUtils.rankEquals(this.$model.getMyHighestRole(), highestRole)) {
                    AppToast.i(WidgetServerSettingsMembers.this, R.string.cannot_manage_same_rank, 0, 4);
                    return;
                } else {
                    AppToast.i(WidgetServerSettingsMembers.this, R.string.cannot_manage_higher_rank, 0, 4);
                    return;
                }
            }
            WidgetServerSettingsEditMember.Companion companion = WidgetServerSettingsEditMember.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            WidgetServerSettingsMembersBinding widgetServerSettingsMembersBindingAccess$getBinding$p = WidgetServerSettingsMembers.access$getBinding$p(WidgetServerSettingsMembers.this);
            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsMembersBindingAccess$getBinding$p, "binding");
            CoordinatorLayout coordinatorLayout = widgetServerSettingsMembersBindingAccess$getBinding$p.a;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
            Context context = coordinatorLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            companion.launch(id2, j, context);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<String> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetServerSettingsMembers.access$getNameFilterPublisher$p(WidgetServerSettingsMembers.this).onNext(str);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "filterString", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullExpressionValue(str, "filterString");
            Long longOrNull = StringNumberConversions.toLongOrNull(str);
            StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), WidgetServerSettingsMembers.access$getGuildId$p(WidgetServerSettingsMembers.this), str, longOrNull != null ? CollectionsJVM.listOf(Long.valueOf(longOrNull.longValue())) : null, null, 8, null);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", "model", "", "invoke", "(Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<WidgetServerSettingsMembersModel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
            invoke2(widgetServerSettingsMembersModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
            WidgetServerSettingsMembers.access$configureUI(WidgetServerSettingsMembers.this, widgetServerSettingsMembersModel);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/discord/widgets/servers/settings/members/WidgetServerSettingsMembers$setupRolesSpinner$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$setupRolesSpinner$1, reason: invalid class name */
    public static final class AnonymousClass1 implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ RolesSpinnerAdapter $rolesSpinnerAdapter;

        public AnonymousClass1(RolesSpinnerAdapter rolesSpinnerAdapter) {
            this.$rolesSpinnerAdapter = rolesSpinnerAdapter;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            Intrinsics3.checkNotNullParameter(view, "view");
            WidgetServerSettingsMembers.access$getRoleFilterPublisher$p(WidgetServerSettingsMembers.this).onNext(Long.valueOf(this.$rolesSpinnerAdapter.getItem(position).getId()));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    public WidgetServerSettingsMembers() {
        super(R.layout.widget_server_settings_members);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsMembers2.INSTANCE, null, 2, null);
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0("");
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.nameFilterPublisher = behaviorSubjectL0;
        BehaviorSubject behaviorSubjectL02 = BehaviorSubject.l0(-1L);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL02, "BehaviorSubject.create(-1L)");
        this.roleFilterPublisher = behaviorSubjectL02;
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsMembers3(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsMembers4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsMembers widgetServerSettingsMembers, WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
        widgetServerSettingsMembers.configureUI(widgetServerSettingsMembersModel);
    }

    public static final /* synthetic */ WidgetServerSettingsMembersBinding access$getBinding$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.getGuildId();
    }

    public static final /* synthetic */ Subject access$getNameFilterPublisher$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.nameFilterPublisher;
    }

    public static final /* synthetic */ Subject access$getRoleFilterPublisher$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.roleFilterPublisher;
    }

    private final void configureUI(WidgetServerSettingsMembersModel model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        AppFragment.setActionBarOptionsMenu$default(this, model.getCanKick() ? R.menu.menu_server_settings_members : R.menu.menu_empty, new AnonymousClass1(model), null, 4, null);
        setActionBarTitle(R.string.member_list);
        setActionBarSubtitle(model.getGuild().getName());
        AppViewFlipper appViewFlipper = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsMembersViewFlipper");
        appViewFlipper.setDisplayedChild((!model.getMemberItems().isEmpty() ? 1 : 0) ^ 1);
        if (!Intrinsics3.areEqual(this.guildRoles, model.getRoles())) {
            this.guildRoles = model.getRoles();
            setupRolesSpinner(model.getGuild().getId(), model.getRoles());
        }
        WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter = this.adapter;
        if (widgetServerSettingsMembersAdapter != null) {
            widgetServerSettingsMembersAdapter.configure(model, new AnonymousClass2(model));
        }
    }

    private final WidgetServerSettingsMembersBinding getBinding() {
        return (WidgetServerSettingsMembersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void setupRolesSpinner(long everyoneRoleId, Map<Long, GuildRole> guildRoles) {
        ArrayList arrayList = new ArrayList(guildRoles.size());
        for (GuildRole guildRole : guildRoles.values()) {
            if (guildRole.getId() != everyoneRoleId) {
                arrayList.add(guildRole);
            } else {
                arrayList.add(0, guildRole);
            }
        }
        RolesSpinnerAdapter rolesSpinnerAdapter = new RolesSpinnerAdapter(requireContext(), arrayList);
        Spinner spinner = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.serverSettingsMembersRolesSpinner");
        spinner.setAdapter((SpinnerAdapter) rolesSpinnerAdapter);
        Spinner spinner2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(spinner2, "binding.serverSettingsMembersRolesSpinner");
        spinner2.setOnItemSelectedListener(new AnonymousClass1(rolesSpinnerAdapter));
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
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsMembersRecycler");
        this.adapter = (WidgetServerSettingsMembersAdapter) companion.configure(new WidgetServerSettingsMembersAdapter(recyclerView));
        if (getIsRecreated()) {
            return;
        }
        this.roleFilterPublisher.onNext(Long.valueOf(getGuildId()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        TextWatcher.Companion companion = TextWatcher.INSTANCE;
        TextInputLayout textInputLayout = getBinding().f2579b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsMembersNameSearch");
        EditText editText = textInputLayout.getEditText();
        Intrinsics3.checkNotNull(editText);
        Intrinsics3.checkNotNullExpressionValue(editText, "binding.serverSettingsMembersNameSearch.editText!!");
        companion.addBindedTextWatcher(this, editText, new AnonymousClass1());
        Subject<String, String> subject = this.nameFilterPublisher;
        TextInputLayout textInputLayout2 = getBinding().f2579b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsMembersNameSearch");
        EditText editText2 = textInputLayout2.getEditText();
        subject.onNext(String.valueOf(editText2 != null ? editText2.getText() : null));
        Observable<String> observableP = this.nameFilterPublisher.p(750L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "nameFilterPublisher\n    …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, WidgetServerSettingsMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsMembersModel.INSTANCE.get(getGuildId(), this.nameFilterPublisher, this.roleFilterPublisher), this, null, 2, null), WidgetServerSettingsMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
