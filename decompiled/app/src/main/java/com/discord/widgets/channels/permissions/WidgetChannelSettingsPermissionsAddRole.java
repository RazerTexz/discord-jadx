package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.n;
import b.a.d.o;
import b.a.z.a.a.p;
import b.a.z.a.a.q;
import b.a.z.a.a.u;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.app.AppFragment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.SimpleRolesAdapter;
import d0.z.d.Intrinsics3;
import java.util.List;
import rx.Observable;

/* loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddRole extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private SimpleRolesAdapter rolesAdapter;
    private RecyclerView rolesRecycler;

    public static class Model {
        private final boolean canManage;
        private final Channel channel;
        private final List<SimpleRolesAdapter.RoleItem> roleItems;

        private Model(MeUser meUser, Guild guild, Channel channel, Long l, List<SimpleRolesAdapter.RoleItem> list) {
            this.channel = channel;
            this.roleItems = list;
            boolean mfaEnabled = meUser.getMfaEnabled();
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, mfaEnabled, guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, l, mfaEnabled, guild.getMfaLevel());
        }

        public static /* synthetic */ boolean access$000(Model model) {
            return model.canManage;
        }

        public static /* synthetic */ List access$100(Model model) {
            return model.roleItems;
        }

        public static /* synthetic */ Channel access$200(Model model) {
            return model.channel;
        }

        public static Observable<Model> get(long j) {
            return StoreStream.getChannels().observeChannel(j).Y(new q(j)).k(n.j);
        }

        private static boolean isValid(Guild guild, Channel channel) {
            return (channel == null || guild == null) ? false : true;
        }

        public static /* synthetic */ Model lambda$null$2(Channel channel, Guild guild, MeUser meUser, Long l, List list) {
            if (isValid(guild, channel)) {
                return new Model(meUser, guild, channel, l, list);
            }
            return null;
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Model;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Model)) {
                return false;
            }
            Model model = (Model) obj;
            if (!model.canEqual(this) || this.canManage != model.canManage) {
                return false;
            }
            Channel channel = this.channel;
            Channel channel2 = model.channel;
            if (channel != null ? !channel.equals(channel2) : channel2 != null) {
                return false;
            }
            List<SimpleRolesAdapter.RoleItem> list = this.roleItems;
            List<SimpleRolesAdapter.RoleItem> list2 = model.roleItems;
            return list != null ? list.equals(list2) : list2 == null;
        }

        public int hashCode() {
            int i = this.canManage ? 79 : 97;
            Channel channel = this.channel;
            int iHashCode = ((i + 59) * 59) + (channel == null ? 43 : channel.hashCode());
            List<SimpleRolesAdapter.RoleItem> list = this.roleItems;
            return (iHashCode * 59) + (list != null ? list.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbU = outline.U("WidgetChannelSettingsPermissionsAddRole.Model(channel=");
            sbU.append(this.channel);
            sbU.append(", roleItems=");
            sbU.append(this.roleItems);
            sbU.append(", canManage=");
            return outline.O(sbU, this.canManage, ")");
        }
    }

    public WidgetChannelSettingsPermissionsAddRole() {
        super(R.layout.widget_channel_settings_permissions_add_role);
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(R.string.add_a_role);
        setActionBarSubtitle(ChannelUtils.d(channel, requireContext(), true));
    }

    private void configureUI(Model model) {
        if (model != null && Model.access$000(model) && !Model.access$100(model).isEmpty()) {
            configureToolbar(Model.access$200(model));
            this.rolesAdapter.setData(Model.access$100(model), new u(this, model));
        } else if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public static void create(Context context, long j) {
        Intent intent = new Intent();
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j);
        AppScreen2.d(context, WidgetChannelSettingsPermissionsAddRole.class, intent);
    }

    public static /* synthetic */ void g(WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole, Model model) {
        widgetChannelSettingsPermissionsAddRole.configureUI(model);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled();
        this.rolesRecycler = (RecyclerView) view.findViewById(R.id.channel_settings_permissions_add_role_recycler);
        this.rolesAdapter = (SimpleRolesAdapter) MGRecyclerAdapter.configure(new SimpleRolesAdapter(this.rolesRecycler));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observable = Model.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L));
        Intrinsics3.checkNotNullParameter(this, "appComponent");
        Intrinsics3.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.ui(observable, this, null).k(o.e(new p(this), getClass()));
    }
}
