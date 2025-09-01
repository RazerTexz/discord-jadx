package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.user.UserProfile;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMutualGuildsBinding;
import com.discord.databinding.WidgetUserProfileAdapterItemServerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserProfileUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.profile.WidgetUserProfileEmptyListItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.e0.KClass;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action0;

/* compiled from: WidgetUserMutualGuilds.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001c\u001b\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;", "data", "", "configureUI", "(Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetUserMutualGuildsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserMutualGuildsBinding;", "binding", "", "getUserId", "()J", "userId", "Lcom/discord/widgets/user/WidgetUserMutualGuilds$Adapter;", "adapter", "Lcom/discord/widgets/user/WidgetUserMutualGuilds$Adapter;", "<init>", "Companion", "Adapter", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserMutualGuilds extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserMutualGuilds.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMutualGuildsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetUserMutualGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lrx/functions/Action0;", "guildSelectedCallback", "Lrx/functions/Action0;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lrx/functions/Action0;)V", "ViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.Item> {
        private final Action0 guildSelectedCallback;

        /* compiled from: WidgetUserMutualGuilds.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds$Adapter$ViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/user/WidgetUserMutualGuilds$Adapter;", "Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/user/WidgetUserMutualGuilds$Model$Item;)V", "Lcom/discord/databinding/WidgetUserProfileAdapterItemServerBinding;", "binding", "Lcom/discord/databinding/WidgetUserProfileAdapterItemServerBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/user/WidgetUserMutualGuilds$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ViewHolder extends MGRecyclerViewHolder<Adapter, Model.Item> {
            private final WidgetUserProfileAdapterItemServerBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                int i2 = R.id.guild_icon_barrier;
                Barrier barrier = (Barrier) view.findViewById(R.id.guild_icon_barrier);
                if (barrier != null) {
                    i2 = R.id.guild_member_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guild_member_avatar);
                    if (simpleDraweeView != null) {
                        i2 = R.id.guild_member_identity_barrier;
                        Barrier barrier2 = (Barrier) view.findViewById(R.id.guild_member_identity_barrier);
                        if (barrier2 != null) {
                            i2 = R.id.user_profile_adapter_item_server_image;
                            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.user_profile_adapter_item_server_image);
                            if (simpleDraweeView2 != null) {
                                i2 = R.id.user_profile_adapter_item_server_name;
                                TextView textView = (TextView) view.findViewById(R.id.user_profile_adapter_item_server_name);
                                if (textView != null) {
                                    i2 = R.id.user_profile_adapter_item_server_text;
                                    TextView textView2 = (TextView) view.findViewById(R.id.user_profile_adapter_item_server_text);
                                    if (textView2 != null) {
                                        i2 = R.id.user_profile_adapter_item_server_wrap;
                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.user_profile_adapter_item_server_wrap);
                                        if (relativeLayout != null) {
                                            i2 = R.id.user_profile_adapter_item_user_display_name;
                                            TextView textView3 = (TextView) view.findViewById(R.id.user_profile_adapter_item_user_display_name);
                                            if (textView3 != null) {
                                                WidgetUserProfileAdapterItemServerBinding widgetUserProfileAdapterItemServerBinding = new WidgetUserProfileAdapterItemServerBinding((ConstraintLayout) view, barrier, simpleDraweeView, barrier2, simpleDraweeView2, textView, textView2, relativeLayout, textView3);
                                                Intrinsics3.checkNotNullExpressionValue(widgetUserProfileAdapterItemServerBinding, "WidgetUserProfileAdapter…verBinding.bind(itemView)");
                                                this.binding = widgetUserProfileAdapterItemServerBinding;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(ViewHolder viewHolder) {
                return (Adapter) viewHolder.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Model.Item item) {
                onConfigure2(i, item);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Model.Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                this.binding.a.setOnClickListener(new WidgetUserMutualGuilds2(this, data));
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Guild guild = data.getGuild();
                simpleDraweeView.setVisibility((guild != null ? guild.getIcon() : null) == null ? 8 : 0);
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "this");
                IconUtils.setIcon$default((ImageView) simpleDraweeView, data.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
                TextView textView = this.binding.e;
                Guild guild2 = data.getGuild();
                textView.setVisibility((guild2 != null ? guild2.getIcon() : null) == null ? 0 : 8);
                Guild guild3 = data.getGuild();
                textView.setText(guild3 != null ? guild3.getShortName() : null);
                TextView textView2 = this.binding.d;
                Guild guild4 = data.getGuild();
                textView2.setText(guild4 != null ? guild4.getName() : null);
                GuildMember guildMember = data.getGuildMember();
                boolean z2 = true;
                boolean z3 = guildMember != null && guildMember.hasAvatar();
                TextView textView3 = this.binding.f;
                String nick = data.getNick();
                if (nick == null) {
                    User user = data.getUser();
                    nick = user != null ? user.getUsername() : null;
                }
                textView3.setText(nick);
                if (data.getNick() == null && !z3) {
                    z2 = false;
                }
                textView3.setVisibility(z2 ? 0 : 8);
                SimpleDraweeView simpleDraweeView2 = this.binding.f2691b;
                simpleDraweeView2.setVisibility(z3 ? 0 : 8);
                if (guildMember != null) {
                    String forGuildMember$default = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, Integer.valueOf(DimenUtils.dpToPixels(16)), false, 4, null);
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "this");
                    IconUtils.setIcon$default(simpleDraweeView2, forGuildMember$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, Action0 action0) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics3.checkNotNullParameter(action0, "guildSelectedCallback");
            this.guildSelectedCallback = action0;
        }

        public static final /* synthetic */ Action0 access$getGuildSelectedCallback$p(Adapter adapter) {
            return adapter.guildSelectedCallback;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, Model.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new WidgetUserProfileEmptyListItem(R.layout.widget_user_profile_adapter_item_empty, this, R.attr.img_no_mutual_servers, R.string.no_mutual_guilds);
            }
            if (viewType == 1) {
                return new ViewHolder(R.layout.widget_user_profile_adapter_item_server, this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* compiled from: WidgetUserMutualGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds$Companion;", "", "Landroid/content/Context;", "context", "", "userId", "", "show", "(Landroid/content/Context;J)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long userId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_USER_ID", userId);
            AppScreen2.d(context, WidgetUserMutualGuilds.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserMutualGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u0000 32\u00020\u0001:\u000234BU\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012&\u0010\u0014\u001a\"\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00050\u0005¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\u0010\u001a\"\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00050\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\tJf\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2(\b\u0002\u0010\u0014\u001a\"\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00050\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010!\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001cR%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\tR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\fR9\u0010\u0014\u001a\"\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u00050\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b*\u0010\tR\u001f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;", "", "Lcom/discord/api/user/UserProfile;", "component1", "()Lcom/discord/api/user/UserProfile;", "", "", "Lcom/discord/models/guild/Guild;", "component2", "()Ljava/util/Map;", "Lcom/discord/models/user/User;", "component3", "()Lcom/discord/models/user/User;", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "component4", "profile", "guilds", "user", "guildMembers", "copy", "(Lcom/discord/api/user/UserProfile;Ljava/util/Map;Lcom/discord/models/user/User;Ljava/util/Map;)Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "numMutualGuilds", "I", "getNumMutualGuilds", "Ljava/util/Map;", "getGuilds", "Lcom/discord/api/user/UserProfile;", "getProfile", "Lcom/discord/models/user/User;", "getUser", "getGuildMembers", "", "Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model$Item;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "<init>", "(Lcom/discord/api/user/UserProfile;Ljava/util/Map;Lcom/discord/models/user/User;Ljava/util/Map;)V", "Companion", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<Long, Map<Long, GuildMember>> guildMembers;
        private final Map<Long, Guild> guilds;
        private final List<Item> list;
        private final int numMutualGuilds;
        private final UserProfile profile;
        private final User user;

        /* compiled from: WidgetUserMutualGuilds.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model$Companion;", "", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/stores/StoreUserProfile;", "storeUserProfile", "Lcom/discord/stores/StoreGuildsSorted;", "storeGuildsSorted", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;", "get", "(JLcom/discord/stores/StoreUserProfile;Lcom/discord/stores/StoreGuildsSorted;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable get$default(Companion companion, long j, StoreUserProfile storeUserProfile, StoreGuildsSorted storeGuildsSorted, StoreUser storeUser, StoreGuilds storeGuilds, int i, Object obj) {
                if ((i & 2) != 0) {
                    storeUserProfile = StoreStream.INSTANCE.getUserProfile();
                }
                StoreUserProfile storeUserProfile2 = storeUserProfile;
                if ((i & 4) != 0) {
                    storeGuildsSorted = StoreStream.INSTANCE.getGuildsSorted();
                }
                StoreGuildsSorted storeGuildsSorted2 = storeGuildsSorted;
                if ((i & 8) != 0) {
                    storeUser = StoreStream.INSTANCE.getUsers();
                }
                StoreUser storeUser2 = storeUser;
                if ((i & 16) != 0) {
                    storeGuilds = StoreStream.INSTANCE.getGuilds();
                }
                return companion.get(j, storeUserProfile2, storeGuildsSorted2, storeUser2, storeGuilds);
            }

            public final Observable<Model> get(long userId, StoreUserProfile storeUserProfile, StoreGuildsSorted storeGuildsSorted, StoreUser storeUser, StoreGuilds storeGuilds) {
                Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
                Intrinsics3.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
                Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
                Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
                Observable<Model> observableR = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{storeUserProfile, storeGuildsSorted, storeUser, storeGuilds}, false, null, null, new WidgetUserMutualGuilds3(storeUserProfile, userId, storeGuildsSorted, storeUser, storeGuilds), 14, null).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.… }.distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(UserProfile userProfile, Map<Long, Guild> map, User user, Map<Long, ? extends Map<Long, GuildMember>> map2) {
            GuildMember guildMember;
            Intrinsics3.checkNotNullParameter(userProfile, "profile");
            Intrinsics3.checkNotNullParameter(map, "guilds");
            Intrinsics3.checkNotNullParameter(map2, "guildMembers");
            this.profile = userProfile;
            this.guilds = map;
            this.user = user;
            this.guildMembers = map2;
            this.list = new ArrayList(userProfile.d().size());
            for (Guild guild : map.values()) {
                UserProfile.GuildReference guildReference = (UserProfile.GuildReference) outline.e(guild, UserProfileUtils.getMutualGuildsById(this.profile));
                if (guildReference != null) {
                    List<Item> list = this.list;
                    User user2 = this.user;
                    String nick = guildReference.getNick();
                    Map map3 = (Map) outline.e(guild, this.guildMembers);
                    if (map3 != null) {
                        User user3 = this.user;
                        guildMember = (GuildMember) map3.get(user3 != null ? Long.valueOf(user3.getId()) : null);
                    } else {
                        guildMember = null;
                    }
                    list.add(new Item(1, guild, nick, user2, guildMember));
                }
            }
            this.numMutualGuilds = this.list.size();
            if (this.list.isEmpty()) {
                this.list.add(new Item(0, null, null, null, null));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, UserProfile userProfile, Map map, User user, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                userProfile = model.profile;
            }
            if ((i & 2) != 0) {
                map = model.guilds;
            }
            if ((i & 4) != 0) {
                user = model.user;
            }
            if ((i & 8) != 0) {
                map2 = model.guildMembers;
            }
            return model.copy(userProfile, map, user, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final UserProfile getProfile() {
            return this.profile;
        }

        public final Map<Long, Guild> component2() {
            return this.guilds;
        }

        /* renamed from: component3, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final Map<Long, Map<Long, GuildMember>> component4() {
            return this.guildMembers;
        }

        public final Model copy(UserProfile profile, Map<Long, Guild> guilds, User user, Map<Long, ? extends Map<Long, GuildMember>> guildMembers) {
            Intrinsics3.checkNotNullParameter(profile, "profile");
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            return new Model(profile, guilds, user, guildMembers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.profile, model.profile) && Intrinsics3.areEqual(this.guilds, model.guilds) && Intrinsics3.areEqual(this.user, model.user) && Intrinsics3.areEqual(this.guildMembers, model.guildMembers);
        }

        public final Map<Long, Map<Long, GuildMember>> getGuildMembers() {
            return this.guildMembers;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public final List<Item> getList() {
            return this.list;
        }

        public final int getNumMutualGuilds() {
            return this.numMutualGuilds;
        }

        public final UserProfile getProfile() {
            return this.profile;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            UserProfile userProfile = this.profile;
            int iHashCode = (userProfile != null ? userProfile.hashCode() : 0) * 31;
            Map<Long, Guild> map = this.guilds;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            User user = this.user;
            int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
            Map<Long, Map<Long, GuildMember>> map2 = this.guildMembers;
            return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(profile=");
            sbU.append(this.profile);
            sbU.append(", guilds=");
            sbU.append(this.guilds);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(", guildMembers=");
            return outline.M(sbU, this.guildMembers, ")");
        }

        /* compiled from: WidgetUserMutualGuilds.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-B9\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\rR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\nR\u001c\u0010'\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\nR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u0010¨\u0006."}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "component1", "()I", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "", "component3", "()Ljava/lang/String;", "Lcom/discord/models/user/User;", "component4", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component5", "()Lcom/discord/models/member/GuildMember;", "type", "guild", ModelAuditLogEntry.CHANGE_KEY_NICK, "user", "guildMember", "copy", "(ILcom/discord/models/guild/Guild;Ljava/lang/String;Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model$Item;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getType", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/models/user/User;", "getUser", "Ljava/lang/String;", "getNick", "key", "getKey", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "<init>", "(ILcom/discord/models/guild/Guild;Ljava/lang/String;Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Item implements MGRecyclerDataPayload {
            public static final int TYPE_EMPTY = 0;
            public static final int TYPE_MUTUAL_SERVER = 1;
            private final Guild guild;
            private final GuildMember guildMember;
            private final String key;
            private final String nick;
            private final int type;
            private final User user;

            public Item(int i, Guild guild, String str, User user, GuildMember guildMember) {
                this.type = i;
                this.guild = guild;
                this.nick = str;
                this.user = user;
                this.guildMember = guildMember;
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(getType()));
                sb.append(String.valueOf(guild != null ? guild.getId() : 0L));
                this.key = sb.toString();
            }

            public static /* synthetic */ Item copy$default(Item item, int i, Guild guild, String str, User user, GuildMember guildMember, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = item.getType();
                }
                if ((i2 & 2) != 0) {
                    guild = item.guild;
                }
                Guild guild2 = guild;
                if ((i2 & 4) != 0) {
                    str = item.nick;
                }
                String str2 = str;
                if ((i2 & 8) != 0) {
                    user = item.user;
                }
                User user2 = user;
                if ((i2 & 16) != 0) {
                    guildMember = item.guildMember;
                }
                return item.copy(i, guild2, str2, user2, guildMember);
            }

            public final int component1() {
                return getType();
            }

            /* renamed from: component2, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component3, reason: from getter */
            public final String getNick() {
                return this.nick;
            }

            /* renamed from: component4, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component5, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final Item copy(int type, Guild guild, String nick, User user, GuildMember guildMember) {
                return new Item(type, guild, nick, user, guildMember);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return getType() == item.getType() && Intrinsics3.areEqual(this.guild, item.guild) && Intrinsics3.areEqual(this.nick, item.nick) && Intrinsics3.areEqual(this.user, item.user) && Intrinsics3.areEqual(this.guildMember, item.guildMember);
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getNick() {
                return this.nick;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                int type = getType() * 31;
                Guild guild = this.guild;
                int iHashCode = (type + (guild != null ? guild.hashCode() : 0)) * 31;
                String str = this.nick;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                User user = this.user;
                int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
                GuildMember guildMember = this.guildMember;
                return iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Item(type=");
                sbU.append(getType());
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", nick=");
                sbU.append(this.nick);
                sbU.append(", user=");
                sbU.append(this.user);
                sbU.append(", guildMember=");
                sbU.append(this.guildMember);
                sbU.append(")");
                return sbU.toString();
            }

            public /* synthetic */ Item(int i, Guild guild, String str, User user, GuildMember guildMember, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? 0 : i, guild, str, user, guildMember);
            }
        }
    }

    /* compiled from: WidgetUserMutualGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMutualGuilds$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Action0 {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action0
        public final void call() {
            Context contextRequireContext = WidgetUserMutualGuilds.this.requireContext();
            List<KClass<? extends AppFragment>> list = AppScreen2.a;
            Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            AppScreen2.c(contextRequireContext, false, intent, 2);
        }
    }

    /* compiled from: WidgetUserMutualGuilds.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;", "data", "", "invoke", "(Lcom/discord/widgets/user/WidgetUserMutualGuilds$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMutualGuilds$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "data");
            WidgetUserMutualGuilds.access$configureUI(WidgetUserMutualGuilds.this, model);
        }
    }

    public WidgetUserMutualGuilds() {
        super(R.layout.widget_user_mutual_guilds);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserMutualGuilds4.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserMutualGuilds widgetUserMutualGuilds, Model model) {
        widgetUserMutualGuilds.configureUI(model);
    }

    private final void configureUI(Model data) {
        int numMutualGuilds = data.getNumMutualGuilds();
        setActionBarTitle(StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.user_profile_mutual_guilds_count, R.string.mutual_guilds, Integer.valueOf(numMutualGuilds), Integer.valueOf(numMutualGuilds)));
        User user = data.getUser();
        setActionBarSubtitle(user != null ? user.getUsername() : null);
        Adapter adapter = this.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        adapter.setData(data.getList());
    }

    private final WidgetUserMutualGuildsBinding getBinding() {
        return (WidgetUserMutualGuildsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getUserId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_USER_ID", 0L);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2685b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userMutualGuildsRecyclerView");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, new AnonymousClass1()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreUserProfile.fetchProfile$default(StoreStream.INSTANCE.getUserProfile(), getUserId(), null, true, null, 10, null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.Companion.get$default(Model.INSTANCE, getUserId(), null, null, null, null, 30, null), this, null, 2, null), WidgetUserMutualGuilds.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
