package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.z.a.a.a;
import b.a.z.a.a.b;
import b.a.z.a.a.c;
import b.a.z.a.a.e;
import b.a.z.a.a.i;
import b.a.z.a.a.n;
import b.a.z.a.a.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddMember extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_MEMBER_LIST = 0;
    private static final int VIEW_INDEX_NO_RESULTS = 1;
    public static final /* synthetic */ int j = 0;
    private SimpleMembersAdapter membersAdapter;
    private RecyclerView membersRecycler;
    private final Subject<String, String> nameFilterPublisher;
    private TextInputLayout searchBox;
    private ViewFlipper viewFlipper;

    public static class Model {
        private final boolean canManage;
        private final Channel channel;
        private final List<SimpleMembersAdapter.MemberItem> memberItems;

        private Model(MeUser meUser, Guild guild, Channel channel, Long l, List<SimpleMembersAdapter.MemberItem> list) {
            this.channel = channel;
            this.memberItems = list;
            boolean mfaEnabled = meUser.getMfaEnabled();
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, mfaEnabled, guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, l, mfaEnabled, guild.getMfaLevel());
        }

        public static /* synthetic */ boolean access$000(Model model) {
            return model.canManage;
        }

        public static /* synthetic */ Channel access$100(Model model) {
            return model.channel;
        }

        public static /* synthetic */ List access$200(Model model) {
            return model.memberItems;
        }

        public static Observable<Model> get(long j, long j2, Observable<String> observable) {
            return StoreStream.getChannels().observeChannel(j2).Y(new e(j, j2, observable));
        }

        private static Observable<List<SimpleMembersAdapter.MemberItem>> getMemberItems(long j, @Nullable List<PermissionOverwrite> list, String str) {
            return StoreStream.getGuilds().observeComputed(j).Y(new i(list, str.toLowerCase(Locale.getDefault())));
        }

        private static boolean isValid(MeUser meUser, Guild guild, Channel channel, List<SimpleMembersAdapter.MemberItem> list) {
            return (channel == null || guild == null || meUser == null || list == null) ? false : true;
        }

        public static /* synthetic */ Observable lambda$null$0(long j, Channel channel, String str) {
            return getMemberItems(j, channel.v(), str);
        }

        public static /* synthetic */ Model lambda$null$1(Channel channel, MeUser meUser, Guild guild, Long l, List list) {
            if (isValid(meUser, guild, channel, list)) {
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
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            List<SimpleMembersAdapter.MemberItem> list2 = model.memberItems;
            return list != null ? list.equals(list2) : list2 == null;
        }

        public int hashCode() {
            int i = this.canManage ? 79 : 97;
            Channel channel = this.channel;
            int iHashCode = ((i + 59) * 59) + (channel == null ? 43 : channel.hashCode());
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            return (iHashCode * 59) + (list != null ? list.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbU = outline.U("WidgetChannelSettingsPermissionsAddMember.Model(channel=");
            sbU.append(this.channel);
            sbU.append(", memberItems=");
            sbU.append(this.memberItems);
            sbU.append(", canManage=");
            return outline.O(sbU, this.canManage, ")");
        }
    }

    public WidgetChannelSettingsPermissionsAddMember() {
        super(R.layout.widget_channel_settings_permissions_add_member);
        this.nameFilterPublisher = BehaviorSubject.l0("");
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(R.string.add_a_member);
        setActionBarSubtitle(ChannelUtils.d(channel, requireContext(), true));
    }

    private void configureUI(Model model) {
        if (model == null || !Model.access$000(model)) {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        } else {
            configureToolbar(Model.access$100(model));
            this.membersAdapter.setData(Model.access$200(model), new c(this, model));
            ViewFlipper viewFlipper = this.viewFlipper;
            if (viewFlipper != null) {
                viewFlipper.setDisplayedChild(Model.access$200(model).isEmpty() ? 1 : 0);
            }
        }
    }

    public static void create(Context context, long j2, long j3) {
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_GUILD_ID", j2);
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j3);
        AppScreen2.d(context, WidgetChannelSettingsPermissionsAddMember.class, intent);
    }

    public static /* synthetic */ void g(WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember, Model model) {
        widgetChannelSettingsPermissionsAddMember.configureUI(model);
    }

    public /* synthetic */ Unit h(Editable editable) {
        this.nameFilterPublisher.onNext(editable.toString());
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        this.membersRecycler = (RecyclerView) view.findViewById(R.id.channel_settings_permissions_add_member_recycler);
        this.searchBox = (TextInputLayout) view.findViewById(R.id.channel_settings_permissions_add_member_name_search);
        this.viewFlipper = (ViewFlipper) view.findViewById(R.id.channel_settings_permissions_add_member_view_flipper);
        setActionBarDisplayHomeAsUpEnabled();
        this.membersAdapter = (SimpleMembersAdapter) MGRecyclerAdapter.configure(new SimpleMembersAdapter(this.membersRecycler));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L);
        ViewExtensions.addBindedTextWatcher(this.searchBox, this, new n(this));
        this.nameFilterPublisher.onNext(ViewExtensions.getTextOrEmpty(this.searchBox));
        this.nameFilterPublisher.p(750L, TimeUnit.MILLISECONDS).y(o.j).k(b.a.d.o.e(new b(longExtra), getClass()));
        Observable<Model> observable = Model.get(longExtra, longExtra2, this.nameFilterPublisher);
        Intrinsics3.checkNotNullParameter(this, "appComponent");
        Intrinsics3.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.ui(observable, this, null).k(b.a.d.o.e(new a(this), getClass()));
    }
}
