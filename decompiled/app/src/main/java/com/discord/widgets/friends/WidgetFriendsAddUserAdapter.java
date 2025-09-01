package com.discord.widgets.friends;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetAddFriendUserListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetFriendsAddUserAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003,-.B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\n2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\n¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\u000f2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\u00020\u000f2\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u000f0\u0017¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001b\u001a\u00020\u000f2\u001c\u0010\u0014\u001a\u0018\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0004\b\u001b\u0010\u0016J%\u0010\u001d\u001a\u00020\u000f2\u0016\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u000f0\u0017¢\u0006\u0004\b\u001d\u0010\u0019R.\u0010\u001e\u001a\u001a\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR&\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u000f0\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010 R.\u0010#\u001a\u001a\u0012\b\u0012\u00060\u000bj\u0002`\f0!j\f\u0012\b\u0012\u00060\u000bj\u0002`\f`\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R*\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001fR(\u0010&\u001a\u0014\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010 R.\u0010'\u001a\u001a\u0012\b\u0012\u00060\u000bj\u0002`\f0!j\f\u0012\b\u0012\u00060\u000bj\u0002`\f`\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010$¨\u0006/"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$UserViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$UserViewHolder;", "", "", "Lcom/discord/primitives/UserId;", "outgoingIds", "incomingIds", "", "addFriendRequestUserIds", "(Ljava/util/Collection;Ljava/util/Collection;)V", "Lkotlin/Function2;", "", "handler", "setSendHandler", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "setAcceptHandler", "(Lkotlin/jvm/functions/Function1;)V", "", "setDeclineHandler", "onItemClick", "setOnItemClick", "declineHandler", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "incomingRequestUserIds", "Ljava/util/HashSet;", "sendHandler", "acceptHandler", "outgoingRequestUserIds", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "ItemUser", "UserViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter extends MGRecyclerAdapterSimple<ItemUser> {
    private static final int TYPE_USER = 1;
    private Function1<? super Long, Unit> acceptHandler;
    private Function2<? super Long, ? super Boolean, Unit> declineHandler;
    private final HashSet<Long> incomingRequestUserIds;
    private Function1<? super Long, Unit> onItemClick;
    private final HashSet<Long> outgoingRequestUserIds;
    private Function2<? super String, ? super Integer, Unit> sendHandler;

    /* compiled from: WidgetFriendsAddUserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$UserViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter;", "Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser;)V", "Lcom/discord/databinding/WidgetAddFriendUserListItemBinding;", "binding", "Lcom/discord/databinding/WidgetAddFriendUserListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class UserViewHolder extends MGRecyclerViewHolder<WidgetFriendsAddUserAdapter, ItemUser> {
        private final WidgetAddFriendUserListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserViewHolder(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
            super(R.layout.widget_add_friend_user_list_item, widgetFriendsAddUserAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsAddUserAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.add_friend_user_accept_button;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.add_friend_user_accept_button);
            if (appCompatImageView != null) {
                i = R.id.add_friend_user_check_image;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.add_friend_user_check_image);
                if (appCompatImageView2 != null) {
                    i = R.id.add_friend_user_decline_button;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(R.id.add_friend_user_decline_button);
                    if (appCompatImageView3 != null) {
                        i = R.id.add_friend_user_item_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.add_friend_user_item_avatar);
                        if (simpleDraweeView != null) {
                            i = R.id.add_friend_user_item_buttons;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.add_friend_user_item_buttons);
                            if (linearLayout != null) {
                                i = R.id.add_friend_user_item_name;
                                TextView textView = (TextView) view.findViewById(R.id.add_friend_user_item_name);
                                if (textView != null) {
                                    i = R.id.add_friend_user_item_name_secondary;
                                    TextView textView2 = (TextView) view.findViewById(R.id.add_friend_user_item_name_secondary);
                                    if (textView2 != null) {
                                        i = R.id.add_friend_user_item_status;
                                        StatusView statusView = (StatusView) view.findViewById(R.id.add_friend_user_item_status);
                                        if (statusView != null) {
                                            i = R.id.add_friend_user_item_text;
                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.add_friend_user_item_text);
                                            if (linearLayout2 != null) {
                                                i = R.id.add_friend_user_send_button;
                                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) view.findViewById(R.id.add_friend_user_send_button);
                                                if (appCompatImageView4 != null) {
                                                    WidgetAddFriendUserListItemBinding widgetAddFriendUserListItemBinding = new WidgetAddFriendUserListItemBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, simpleDraweeView, linearLayout, textView, textView2, statusView, linearLayout2, appCompatImageView4);
                                                    Intrinsics3.checkNotNullExpressionValue(widgetAddFriendUserListItemBinding, "WidgetAddFriendUserListItemBinding.bind(itemView)");
                                                    this.binding = widgetAddFriendUserListItemBinding;
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetFriendsAddUserAdapter access$getAdapter$p(UserViewHolder userViewHolder) {
            return (WidgetFriendsAddUserAdapter) userViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ItemUser itemUser) {
            onConfigure2(i, itemUser);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ItemUser data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            User user = data.getUser();
            SimpleDraweeView simpleDraweeView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.addFriendUserItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, null, 60, null);
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.addFriendUserItemName");
            CharSequence username = (CharSequence) _Collections.lastOrNull((List) data.getAliases());
            if (username == null) {
                username = user.getUsername();
            }
            textView.setText(username);
            TextView textView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.addFriendUserItemNameSecondary");
            textView2.setText(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            this.binding.h.setPresence(data.getPresence());
            StatusView statusView = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(statusView, "binding.addFriendUserItemStatus");
            boolean z2 = true;
            statusView.setVisibility(data.getPresence() != null ? 0 : 8);
            long id2 = data.getUser().getId();
            boolean zContains = WidgetFriendsAddUserAdapter.access$getOutgoingRequestUserIds$p((WidgetFriendsAddUserAdapter) this.adapter).contains(Long.valueOf(id2));
            boolean zContains2 = WidgetFriendsAddUserAdapter.access$getIncomingRequestUserIds$p((WidgetFriendsAddUserAdapter) this.adapter).contains(Long.valueOf(id2));
            this.binding.f2223b.setOnClickListener(new WidgetFriendsAddUserAdapter2(this, id2));
            this.binding.d.setOnClickListener(new WidgetFriendsAddUserAdapter3(this, id2, zContains2));
            this.binding.i.setOnClickListener(new WidgetFriendsAddUserAdapter4(this, user));
            this.binding.a.setOnClickListener(new WidgetFriendsAddUserAdapter5(this, id2));
            AppCompatImageView appCompatImageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.addFriendUserCheckImage");
            appCompatImageView.setVisibility(data.isFriend() ? 0 : 8);
            AppCompatImageView appCompatImageView2 = this.binding.i;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.addFriendUserSendButton");
            appCompatImageView2.setVisibility(!data.isFriend() && !zContains && !zContains2 ? 0 : 8);
            AppCompatImageView appCompatImageView3 = this.binding.f2223b;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageView3, "binding.addFriendUserAcceptButton");
            appCompatImageView3.setVisibility(!data.isFriend() && zContains2 ? 0 : 8);
            AppCompatImageView appCompatImageView4 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageView4, "binding.addFriendUserDeclineButton");
            if (data.isFriend() || (!zContains && !zContains2)) {
                z2 = false;
            }
            appCompatImageView4.setVisibility(z2 ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddUserAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.outgoingRequestUserIds = new HashSet<>();
        this.incomingRequestUserIds = new HashSet<>();
        this.onItemClick = WidgetFriendsAddUserAdapter6.INSTANCE;
    }

    public static final /* synthetic */ Function1 access$getAcceptHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.acceptHandler;
    }

    public static final /* synthetic */ Function2 access$getDeclineHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.declineHandler;
    }

    public static final /* synthetic */ HashSet access$getIncomingRequestUserIds$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.incomingRequestUserIds;
    }

    public static final /* synthetic */ Function1 access$getOnItemClick$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.onItemClick;
    }

    public static final /* synthetic */ HashSet access$getOutgoingRequestUserIds$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.outgoingRequestUserIds;
    }

    public static final /* synthetic */ Function2 access$getSendHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.sendHandler;
    }

    public static final /* synthetic */ void access$setAcceptHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function1 function1) {
        widgetFriendsAddUserAdapter.acceptHandler = function1;
    }

    public static final /* synthetic */ void access$setDeclineHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function2 function2) {
        widgetFriendsAddUserAdapter.declineHandler = function2;
    }

    public static final /* synthetic */ void access$setOnItemClick$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function1 function1) {
        widgetFriendsAddUserAdapter.onItemClick = function1;
    }

    public static final /* synthetic */ void access$setSendHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function2 function2) {
        widgetFriendsAddUserAdapter.sendHandler = function2;
    }

    public final void addFriendRequestUserIds(Collection<Long> outgoingIds, Collection<Long> incomingIds) {
        Intrinsics3.checkNotNullParameter(outgoingIds, "outgoingIds");
        Intrinsics3.checkNotNullParameter(incomingIds, "incomingIds");
        this.outgoingRequestUserIds.clear();
        this.outgoingRequestUserIds.addAll(outgoingIds);
        this.incomingRequestUserIds.clear();
        this.incomingRequestUserIds.addAll(incomingIds);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setAcceptHandler(Function1<? super Long, Unit> handler) {
        Intrinsics3.checkNotNullParameter(handler, "handler");
        this.acceptHandler = handler;
    }

    public final void setDeclineHandler(Function2<? super Long, ? super Boolean, Unit> handler) {
        Intrinsics3.checkNotNullParameter(handler, "handler");
        this.declineHandler = handler;
    }

    public final void setOnItemClick(Function1<? super Long, Unit> onItemClick) {
        Intrinsics3.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
    }

    public final void setSendHandler(Function2<? super String, ? super Integer, Unit> handler) {
        Intrinsics3.checkNotNullParameter(handler, "handler");
        this.sendHandler = handler;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new UserViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: WidgetFriendsAddUserAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00188\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001aR\u001c\u0010\"\u001a\u00020\u00158\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0017R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b\u0012\u0010\u000eR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b+\u0010\b¨\u0006/"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "", "component2", "()Ljava/util/List;", "Lcom/discord/models/presence/Presence;", "component3", "()Lcom/discord/models/presence/Presence;", "", "component4", "()Z", "user", "aliases", "presence", "isFriend", "copy", "(Lcom/discord/models/user/User;Ljava/util/List;Lcom/discord/models/presence/Presence;Z)Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/presence/Presence;", "getPresence", "Lcom/discord/models/user/User;", "getUser", "Z", "Ljava/util/List;", "getAliases", "<init>", "(Lcom/discord/models/user/User;Ljava/util/List;Lcom/discord/models/presence/Presence;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ItemUser implements MGRecyclerDataPayload {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<CharSequence> aliases;
        private final boolean isFriend;
        private final String key;
        private final Presence presence;
        private final int type;
        private final User user;

        /* compiled from: WidgetFriendsAddUserAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser$Companion;", "", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;", "item", "Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser;", "create", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemUser;)Lcom/discord/widgets/friends/WidgetFriendsAddUserAdapter$ItemUser;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final ItemUser create(WidgetGlobalSearchModel.ItemUser item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                return new ItemUser(item.getUser(), item.getAliases(), item.getPresence(), item.isFriend());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ItemUser(User user, List<? extends CharSequence> list, Presence presence, boolean z2) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(list, "aliases");
            this.user = user;
            this.aliases = list;
            this.presence = presence;
            this.isFriend = z2;
            this.type = 1;
            this.key = String.valueOf(user.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemUser copy$default(ItemUser itemUser, User user, List list, Presence presence, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = itemUser.user;
            }
            if ((i & 2) != 0) {
                list = itemUser.aliases;
            }
            if ((i & 4) != 0) {
                presence = itemUser.presence;
            }
            if ((i & 8) != 0) {
                z2 = itemUser.isFriend;
            }
            return itemUser.copy(user, list, presence, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final List<CharSequence> component2() {
            return this.aliases;
        }

        /* renamed from: component3, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsFriend() {
            return this.isFriend;
        }

        public final ItemUser copy(User user, List<? extends CharSequence> aliases, Presence presence, boolean isFriend) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(aliases, "aliases");
            return new ItemUser(user, aliases, presence, isFriend);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemUser)) {
                return false;
            }
            ItemUser itemUser = (ItemUser) other;
            return Intrinsics3.areEqual(this.user, itemUser.user) && Intrinsics3.areEqual(this.aliases, itemUser.aliases) && Intrinsics3.areEqual(this.presence, itemUser.presence) && this.isFriend == itemUser.isFriend;
        }

        public final List<CharSequence> getAliases() {
            return this.aliases;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            List<CharSequence> list = this.aliases;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Presence presence = this.presence;
            int iHashCode3 = (iHashCode2 + (presence != null ? presence.hashCode() : 0)) * 31;
            boolean z2 = this.isFriend;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isFriend() {
            return this.isFriend;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ItemUser(user=");
            sbU.append(this.user);
            sbU.append(", aliases=");
            sbU.append(this.aliases);
            sbU.append(", presence=");
            sbU.append(this.presence);
            sbU.append(", isFriend=");
            return outline.O(sbU, this.isFriend, ")");
        }

        public /* synthetic */ ItemUser(User user, List list, Presence presence, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(user, list, (i & 4) != 0 ? null : presence, z2);
        }
    }
}
