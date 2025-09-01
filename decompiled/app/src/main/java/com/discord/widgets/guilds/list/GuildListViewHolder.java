package com.discord.widgets.guilds.list;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ViewServerFolderBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.f.g.e.FadeDrawable;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildsListItemDmBinding;
import com.discord.databinding.WidgetGuildsListItemFolderBinding;
import com.discord.databinding.WidgetGuildsListItemGuildBinding;
import com.discord.databinding.WidgetGuildsListItemGuildVerticalBinding;
import com.discord.databinding.WidgetGuildsListItemHubVerificationBinding;
import com.discord.databinding.WidgetGuildsListItemProfileBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.tooltips.SparkleView;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.GuildView;
import com.discord.views.ServerFolderView;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildsDragAndDropCallback;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildListViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\r\u0010\u000e\u0082\u0001\u0007\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "onDragStarted", "()V", "", "wasMerge", "onDragEnded", "(Z)V", "Landroid/widget/TextView;", "textView", "", "count", "configureMentionsCount", "(Landroid/widget/TextView;I)V", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "DiscordHubViewHolder", "FolderViewHolder", "FriendsViewHolder", "GuildViewHolder", "PrivateChannelViewHolder", "SimpleViewHolder", "SpaceViewHolder", "Lcom/discord/widgets/guilds/list/GuildListViewHolder$GuildViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder$FriendsViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder$PrivateChannelViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder$FolderViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder$SpaceViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder$SimpleViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder$DiscordHubViewHolder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GuildListViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: GuildListViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListViewHolder$DiscordHubViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListItem$HubItem;", "item", "", "configure", "(Lcom/discord/widgets/guilds/list/GuildListItem$HubItem;)V", "Lcom/discord/databinding/WidgetGuildsListItemHubVerificationBinding;", "binding", "Lcom/discord/databinding/WidgetGuildsListItemHubVerificationBinding;", "getBinding", "()Lcom/discord/databinding/WidgetGuildsListItemHubVerificationBinding;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DiscordHubViewHolder extends GuildListViewHolder {
        private final WidgetGuildsListItemHubVerificationBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DiscordHubViewHolder(View view) {
            super(view, null);
            Intrinsics3.checkNotNullParameter(view, "view");
            SparkleView sparkleView = (SparkleView) view.findViewById(R.id.guild_item_sparkle);
            if (sparkleView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.guild_item_sparkle)));
            }
            WidgetGuildsListItemHubVerificationBinding widgetGuildsListItemHubVerificationBinding = new WidgetGuildsListItemHubVerificationBinding((FrameLayout) view, sparkleView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemHubVerificationBinding, "WidgetGuildsListItemHubV…icationBinding.bind(view)");
            this.binding = widgetGuildsListItemHubVerificationBinding;
        }

        public final void configure(GuildListItem.HubItem item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            SparkleView sparkleView = this.binding.f2463b;
            if (!item.getShowSparkle()) {
                sparkleView.b();
            }
            sparkleView.setVisibility(item.getShowSparkle() ? 0 : 8);
        }

        public final WidgetGuildsListItemHubVerificationBinding getBinding() {
            return this.binding;
        }
    }

    /* compiled from: GuildListViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010'\u001a\u00020&\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u0016\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0018¨\u0006*"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListViewHolder$FolderViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder;", "Lcom/discord/widgets/guilds/list/GuildsDragAndDropCallback$DraggableViewHolder;", "", "canDrag", "()Z", "", "getNumChildren", "()I", "", "onDragStarted", "()V", "wasMerge", "onDragEnded", "(Z)V", "shouldDrawDecoration", "Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", "data", "configure", "(Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;)V", "isDragging", "Z", "Lkotlin/Function1;", "onClicked", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/databinding/WidgetGuildsListItemFolderBinding;", "binding", "Lcom/discord/databinding/WidgetGuildsListItemFolderBinding;", "Lcom/discord/widgets/guilds/list/GuildListItem$FolderItem;", ModelAuditLogEntry.CHANGE_KEY_COLOR, "Ljava/lang/Integer;", "getColor", "()Ljava/lang/Integer;", "setColor", "(Ljava/lang/Integer;)V", "numChildren", "I", "onLongPressed", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class FolderViewHolder extends GuildListViewHolder implements GuildsDragAndDropCallback.DraggableViewHolder {
        private final WidgetGuildsListItemFolderBinding binding;

        @ColorInt
        private Integer color;
        private GuildListItem.FolderItem data;
        private boolean isDragging;
        private int numChildren;
        private final Function1<GuildListItem.FolderItem, Unit> onClicked;
        private final Function1<GuildListItem.FolderItem, Unit> onLongPressed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FolderViewHolder(View view, Function1<? super GuildListItem.FolderItem, Unit> function1, Function1<? super GuildListItem.FolderItem, Unit> function12) {
            super(view, null);
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(function1, "onClicked");
            Intrinsics3.checkNotNullParameter(function12, "onLongPressed");
            this.onClicked = function1;
            this.onLongPressed = function12;
            int i = R.id.guilds_item_folder;
            ServerFolderView serverFolderView = (ServerFolderView) view.findViewById(R.id.guilds_item_folder);
            if (serverFolderView != null) {
                i = R.id.guilds_item_folder_container;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.guilds_item_folder_container);
                if (frameLayout != null) {
                    i = R.id.guilds_item_highlight;
                    View viewFindViewById = view.findViewById(R.id.guilds_item_highlight);
                    if (viewFindViewById != null) {
                        i = R.id.guilds_item_mentions;
                        TextView textView = (TextView) view.findViewById(R.id.guilds_item_mentions);
                        if (textView != null) {
                            i = R.id.guilds_item_selected;
                            View viewFindViewById2 = view.findViewById(R.id.guilds_item_selected);
                            if (viewFindViewById2 != null) {
                                i = R.id.guilds_item_unread;
                                ImageView imageView = (ImageView) view.findViewById(R.id.guilds_item_unread);
                                if (imageView != null) {
                                    i = R.id.guilds_item_voice;
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.guilds_item_voice);
                                    if (imageView2 != null) {
                                        WidgetGuildsListItemFolderBinding widgetGuildsListItemFolderBinding = new WidgetGuildsListItemFolderBinding((RelativeLayout) view, serverFolderView, frameLayout, viewFindViewById, textView, viewFindViewById2, imageView, imageView2);
                                        Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemFolderBinding, "WidgetGuildsListItemFolderBinding.bind(view)");
                                        this.binding = widgetGuildsListItemFolderBinding;
                                        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.guildsItemFolderContainer");
                                        frameLayout.setClipToOutline(true);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ Function1 access$getOnClicked$p(FolderViewHolder folderViewHolder) {
            return folderViewHolder.onClicked;
        }

        public static final /* synthetic */ Function1 access$getOnLongPressed$p(FolderViewHolder folderViewHolder) {
            return folderViewHolder.onLongPressed;
        }

        @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback.DraggableViewHolder
        public boolean canDrag() {
            GuildListItem.FolderItem folderItem;
            GuildListItem.FolderItem folderItem2 = this.data;
            return (folderItem2 == null || folderItem2.isOpen() || ((folderItem = this.data) != null && folderItem.getIsPendingGuildsFolder())) ? false : true;
        }

        public final void configure(GuildListItem.FolderItem data) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.data = data;
            this.color = data.getColor() != null ? Integer.valueOf((int) (r2.intValue() + 4278190080L)) : null;
            this.numChildren = data.isOpen() ? data.getGuilds().size() : 0;
            this.binding.a.setOnClickListener(new GuildListViewHolder2(this, data));
            ServerFolderView serverFolderView = this.binding.f2460b;
            boolean isPendingGuildsFolder = data.getIsPendingGuildsFolder();
            long folderId = data.getFolderId();
            boolean zIsOpen = data.isOpen();
            List<Guild> guilds = data.getGuilds();
            Integer color = data.getColor();
            Objects.requireNonNull(serverFolderView);
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            if (isPendingGuildsFolder) {
                serverFolderView.folderId = Long.valueOf(folderId);
                serverFolderView.isOpen = zIsOpen;
                GridLayout gridLayout = serverFolderView.binding.g;
                Intrinsics3.checkNotNullExpressionValue(gridLayout, "binding.guildViews");
                gridLayout.setVisibility(zIsOpen ? 0 : 8);
                serverFolderView.binding.f126b.setImageDrawable(ContextCompat.getDrawable(serverFolderView.getContext(), R.drawable.ic_guild_list_pending_folder));
            } else {
                Long l = serverFolderView.folderId;
                boolean z2 = (l == null || l.longValue() != folderId || serverFolderView.isOpen == zIsOpen) ? false : true;
                serverFolderView.folderId = Long.valueOf(folderId);
                if (zIsOpen) {
                    serverFolderView.isOpen = true;
                    if (z2) {
                        serverFolderView.b(R.anim.anim_folder_slide_in_down);
                    } else {
                        serverFolderView.a();
                    }
                    ImageViewCompat.setImageTintList(serverFolderView.binding.f126b, ColorStateList.valueOf((int) ((color != null ? color.intValue() : ColorCompat.getThemedColor(serverFolderView.getContext(), R.attr.color_brand_500)) + 4278190080L)));
                } else {
                    serverFolderView.isOpen = false;
                    if (z2) {
                        serverFolderView.b(R.anim.anim_folder_slide_out_up);
                    } else {
                        serverFolderView.a();
                    }
                    ViewServerFolderBinding viewServerFolderBinding = serverFolderView.binding;
                    int i = 0;
                    for (Object obj : Collections2.listOf((Object[]) new GuildView[]{viewServerFolderBinding.c, viewServerFolderBinding.d, viewServerFolderBinding.e, viewServerFolderBinding.f})) {
                        int i2 = i + 1;
                        if (i < 0) {
                            Collections2.throwIndexOverflow();
                        }
                        GuildView guildView = (GuildView) obj;
                        if (Collections2.getLastIndex(guilds) >= i) {
                            Guild guild = guilds.get(i);
                            String forGuild$default = guild.hasIcon() ? IconUtils.getForGuild$default(guild, IconUtils.DEFAULT_ICON, false, null, 12, null) : null;
                            Intrinsics3.checkNotNullExpressionValue(guildView, "guildView");
                            guildView.setVisibility(0);
                            guildView.a(forGuild$default, guild.getShortName());
                        } else {
                            Intrinsics3.checkNotNullExpressionValue(guildView, "guildView");
                            guildView.setVisibility(8);
                        }
                        i = i2;
                    }
                }
            }
            View view = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.guildsItemSelected");
            view.setVisibility(!data.isOpen() && data.isAnyGuildSelected() ? 0 : 8);
            ImageView imageView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildsItemUnread");
            imageView.setVisibility(!data.isOpen() && data.getIsUnread() ? 0 : 8);
            ImageView imageView2 = this.binding.h;
            imageView2.setActivated(data.isAnyGuildConnectedToVoice());
            imageView2.setVisibility(!data.isOpen() && data.isAnyGuildConnectedToVoice() ? 0 : 8);
            imageView2.setImageResource(data.isAnyGuildConnectedToStageChannel() ? R.drawable.ic_channel_stage_24dp_white : R.drawable.ic_volume_up_white_24dp);
            View view2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildsItemHighlight");
            view2.setVisibility(data.isTargetedForFolderAddition() ? 0 : 8);
            int mentionCount = data.getMentionCount();
            String i18nPluralString = mentionCount > 0 ? StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.guild_folder_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
            View view3 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
            CharSequence charSequenceJ = FormatUtils.j(view3, data.isOpen() ? R.string.expanded : R.string.collapsed, new Object[0], null, 4);
            View view4 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view4, "itemView");
            View view5 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view5, "itemView");
            view4.setContentDescription(FormatUtils.j(view5, R.string.guild_folder_tooltip_a11y_label_with_expanded_state, new Object[]{data.getName(), i18nPluralString, charSequenceJ}, null, 4));
            View view6 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view6, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view6, new GuildListViewHolder3(this, data));
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildsItemMentions");
            configureMentionsCount(textView, data.isOpen() ? 0 : data.getMentionCount());
        }

        public final Integer getColor() {
            return this.color;
        }

        public final int getNumChildren() {
            return this.numChildren;
        }

        @Override // com.discord.widgets.guilds.list.GuildListViewHolder
        public void onDragEnded(boolean wasMerge) {
            this.isDragging = false;
            ServerFolderView serverFolderView = this.binding.f2460b;
            Intrinsics3.checkNotNullExpressionValue(serverFolderView, "binding.guildsItemFolder");
            serverFolderView.setBackground(null);
        }

        @Override // com.discord.widgets.guilds.list.GuildListViewHolder
        public void onDragStarted() {
            this.isDragging = true;
            ServerFolderView serverFolderView = this.binding.f2460b;
            Intrinsics3.checkNotNullExpressionValue(serverFolderView, "binding.guildsItemFolder");
            ServerFolderView serverFolderView2 = this.binding.f2460b;
            Intrinsics3.checkNotNullExpressionValue(serverFolderView2, "binding.guildsItemFolder");
            serverFolderView.setBackground(ContextCompat.getDrawable(serverFolderView2.getContext(), R.drawable.drawable_squircle_primary_600));
        }

        public final void setColor(Integer num) {
            this.color = num;
        }

        public final boolean shouldDrawDecoration() {
            return !this.isDragging;
        }
    }

    /* compiled from: GuildListViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListViewHolder$FriendsViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListItem$FriendsItem;", "data", "", "configure", "(Lcom/discord/widgets/guilds/list/GuildListItem$FriendsItem;)V", "Lcom/discord/databinding/WidgetGuildsListItemProfileBinding;", "binding", "Lcom/discord/databinding/WidgetGuildsListItemProfileBinding;", "Lkotlin/Function1;", "onClicked", "Lkotlin/jvm/functions/Function1;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class FriendsViewHolder extends GuildListViewHolder {
        private final WidgetGuildsListItemProfileBinding binding;
        private final Function1<GuildListItem.FriendsItem, Unit> onClicked;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FriendsViewHolder(View view, Function1<? super GuildListItem.FriendsItem, Unit> function1) {
            super(view, null);
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(function1, "onClicked");
            this.onClicked = function1;
            int i = R.id.guilds_item_profile_avatar;
            ImageView imageView = (ImageView) view.findViewById(R.id.guilds_item_profile_avatar);
            if (imageView != null) {
                i = R.id.guilds_item_profile_avatar_wrap;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.guilds_item_profile_avatar_wrap);
                if (frameLayout != null) {
                    i = R.id.guilds_item_profile_selected;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.guilds_item_profile_selected);
                    if (imageView2 != null) {
                        WidgetGuildsListItemProfileBinding widgetGuildsListItemProfileBinding = new WidgetGuildsListItemProfileBinding((RelativeLayout) view, imageView, frameLayout, imageView2);
                        Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemProfileBinding, "WidgetGuildsListItemProfileBinding.bind(view)");
                        this.binding = widgetGuildsListItemProfileBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ Function1 access$getOnClicked$p(FriendsViewHolder friendsViewHolder) {
            return friendsViewHolder.onClicked;
        }

        public final void configure(GuildListItem.FriendsItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            ImageView imageView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildsItemProfileSelected");
            imageView.setVisibility(data.isSelected() ? 0 : 8);
            this.binding.a.setOnClickListener(new GuildListViewHolder4(this, data));
            if (data.isSelected()) {
                this.binding.c.setBackgroundResource(R.drawable.drawable_squircle_brand_500);
                FrameLayout frameLayout = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.guildsItemProfileAvatarWrap");
                frameLayout.setBackgroundTintList(null);
            } else {
                this.binding.c.setBackgroundResource(R.drawable.drawable_circle_black);
                FrameLayout frameLayout2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.guildsItemProfileAvatarWrap");
                int themedColor = ColorCompat.getThemedColor(frameLayout2, R.attr.colorBackgroundSecondary);
                FrameLayout frameLayout3 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.guildsItemProfileAvatarWrap");
                frameLayout3.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            }
            if (data.isSelected()) {
                ImageView imageView2 = this.binding.f2464b;
                Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildsItemProfileAvatar");
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getColor(view, R.color.white)));
                return;
            }
            ImageView imageView3 = this.binding.f2464b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.guildsItemProfileAvatar");
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            imageView3.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(view2, R.attr.primary_300)));
        }
    }

    /* compiled from: GuildListViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@BK\u0012\u0006\u0010=\u001a\u00020<\u0012\b\b\u0001\u0010:\u001a\u00020*\u0012\b\b\u0001\u0010+\u001a\u00020*\u0012\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0'\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0'¢\u0006\u0004\b>\u0010?J)\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\"\u0010#J\r\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u001dJ\u000f\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010\fJ\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0017R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010,R\u0016\u00105\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010)R\u0016\u00108\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010,R\u0016\u00109\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010,R\u0016\u0010:\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010,R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010;¨\u0006A"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListViewHolder$GuildViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder;", "Lcom/discord/widgets/guilds/list/GuildsDragAndDropCallback$DraggableViewHolder;", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "applicationStatus", "", "isInFolder", "hasMentions", "", "configureApplicationStatus", "(Lcom/discord/api/guildjoinrequest/ApplicationStatus;ZZ)V", "configureDraggingAlpha", "()V", "isSelected", "guildHasIcon", "configureGuildIconBackground", "(ZZZ)V", "Lcom/discord/models/guild/Guild;", "guild", "configureGuildIconImage", "(Lcom/discord/models/guild/Guild;Z)V", "isTargetedForFolderCreation", "configureGuildIconPositioning", "(Z)V", "Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "data", "configure", "(Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;)V", "canDrag", "()Z", "", "Lcom/discord/primitives/FolderId;", "getFolderId", "()Ljava/lang/Long;", "isLastGuildInFolder", "()Ljava/lang/Boolean;", "onDragStarted", "wasMerge", "onDragEnded", "Lkotlin/Function1;", "onLongPressed", "Lkotlin/jvm/functions/Function1;", "", "overlayColorInFolder", "I", "Lcom/discord/databinding/WidgetGuildsListItemGuildBinding;", "bindingGuild", "Lcom/discord/databinding/WidgetGuildsListItemGuildBinding;", "defaultAvatarSize", "Lcom/discord/databinding/WidgetGuildsListItemGuildVerticalBinding;", "binding", "Lcom/discord/databinding/WidgetGuildsListItemGuildVerticalBinding;", "imageRequestSize", "isDragging", "Z", "onClicked", "targetedAvatarMargin", "targetedAvatarSize", "overlayColor", "Lcom/discord/widgets/guilds/list/GuildListItem$GuildItem;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GuildViewHolder extends GuildListViewHolder implements GuildsDragAndDropCallback.DraggableViewHolder {
        private static final float DEFAULT_AVATAR_TEXT_SIZE_SP = 14.0f;
        private static final float TARGETED_AVATAR_TEXT_SIZE_DP = 8.0f;
        private final WidgetGuildsListItemGuildVerticalBinding binding;
        private final WidgetGuildsListItemGuildBinding bindingGuild;
        private GuildListItem.GuildItem data;
        private final int defaultAvatarSize;
        private final int imageRequestSize;
        private boolean isDragging;
        private final Function1<GuildListItem.GuildItem, Unit> onClicked;
        private final Function1<GuildListItem.GuildItem, Unit> onLongPressed;
        private final int overlayColor;
        private final int overlayColorInFolder;
        private final int targetedAvatarMargin;
        private final int targetedAvatarSize;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ApplicationStatus.values();
                int[] iArr = new int[5];
                $EnumSwitchMapping$0 = iArr;
                iArr[ApplicationStatus.APPROVED.ordinal()] = 1;
                iArr[ApplicationStatus.REJECTED.ordinal()] = 2;
                iArr[ApplicationStatus.PENDING.ordinal()] = 3;
                iArr[ApplicationStatus.STARTED.ordinal()] = 4;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildViewHolder(View view, @ColorInt int i, @ColorInt int i2, Function1<? super GuildListItem.GuildItem, Unit> function1, Function1<? super GuildListItem.GuildItem, Unit> function12) {
            super(view, null);
            Intrinsics3.checkNotNullParameter(view, "itemView");
            Intrinsics3.checkNotNullParameter(function1, "onClicked");
            Intrinsics3.checkNotNullParameter(function12, "onLongPressed");
            this.overlayColor = i;
            this.overlayColorInFolder = i2;
            this.onClicked = function1;
            this.onLongPressed = function12;
            int i3 = R.id.guilds_item_selected;
            ImageView imageView = (ImageView) view.findViewById(R.id.guilds_item_selected);
            if (imageView != null) {
                i3 = R.id.guilds_item_unread;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.guilds_item_unread);
                if (imageView2 != null) {
                    WidgetGuildsListItemGuildVerticalBinding widgetGuildsListItemGuildVerticalBinding = new WidgetGuildsListItemGuildVerticalBinding((RelativeLayout) view, imageView, imageView2);
                    Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemGuildVerticalBinding, "WidgetGuildsListItemGuil…calBinding.bind(itemView)");
                    this.binding = widgetGuildsListItemGuildVerticalBinding;
                    WidgetGuildsListItemGuildBinding widgetGuildsListItemGuildBindingA = WidgetGuildsListItemGuildBinding.a(view);
                    Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemGuildBindingA, "WidgetGuildsListItemGuildBinding.bind(itemView)");
                    this.bindingGuild = widgetGuildsListItemGuildBindingA;
                    this.defaultAvatarSize = view.getResources().getDimensionPixelSize(R.dimen.avatar_size_large);
                    this.targetedAvatarSize = view.getResources().getDimensionPixelSize(R.dimen.folder_guild_size);
                    this.targetedAvatarMargin = view.getResources().getDimensionPixelSize(R.dimen.folder_guild_outer_margin);
                    FrameLayout frameLayout = widgetGuildsListItemGuildBindingA.f;
                    Intrinsics3.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
                    frameLayout.setClipToOutline(true);
                    SimpleDraweeView simpleDraweeView = widgetGuildsListItemGuildBindingA.d;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
                    this.imageRequestSize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().height);
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
        }

        public static final /* synthetic */ Function1 access$getOnClicked$p(GuildViewHolder guildViewHolder) {
            return guildViewHolder.onClicked;
        }

        public static final /* synthetic */ Function1 access$getOnLongPressed$p(GuildViewHolder guildViewHolder) {
            return guildViewHolder.onLongPressed;
        }

        private final void configureApplicationStatus(ApplicationStatus applicationStatus, boolean isInFolder, boolean hasMentions) {
            if (applicationStatus == null || hasMentions) {
                ImageView imageView = this.bindingGuild.f2461b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "bindingGuild.guildsItemApplicationStatus");
                imageView.setVisibility(8);
                return;
            }
            int i = isInFolder ? R.attr.colorBackgroundSecondary : R.attr.colorBackgroundTertiary;
            ImageView imageView2 = this.bindingGuild.f2461b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "bindingGuild.guildsItemApplicationStatus");
            int themedColor = ColorCompat.getThemedColor(imageView2, i);
            ImageView imageView3 = this.bindingGuild.f2461b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "bindingGuild.guildsItemApplicationStatus");
            imageView3.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            ImageView imageView4 = this.bindingGuild.f2461b;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "bindingGuild.guildsItemApplicationStatus");
            imageView4.setVisibility(0);
            int iOrdinal = applicationStatus.ordinal();
            if (iOrdinal == 0) {
                this.bindingGuild.f2461b.setImageResource(R.drawable.ic_application_status_started);
                return;
            }
            if (iOrdinal == 1) {
                this.bindingGuild.f2461b.setImageResource(R.drawable.ic_application_status_pending);
                return;
            }
            if (iOrdinal == 2) {
                this.bindingGuild.f2461b.setImageResource(R.drawable.ic_application_status_rejected);
            } else {
                if (iOrdinal == 3) {
                    this.bindingGuild.f2461b.setImageResource(R.drawable.ic_application_status_approved);
                    return;
                }
                ImageView imageView5 = this.bindingGuild.f2461b;
                Intrinsics3.checkNotNullExpressionValue(imageView5, "bindingGuild.guildsItemApplicationStatus");
                imageView5.setVisibility(8);
            }
        }

        private final void configureDraggingAlpha() {
            if (this.isDragging) {
                FrameLayout frameLayout = this.bindingGuild.f;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
                frameLayout.setAlpha(0.5f);
            } else {
                FrameLayout frameLayout2 = this.bindingGuild.f;
                Intrinsics3.checkNotNullExpressionValue(frameLayout2, "bindingGuild.guildsItemAvatarWrap");
                frameLayout2.setAlpha(1.0f);
            }
        }

        private final void configureGuildIconBackground(boolean isSelected, boolean isInFolder, boolean guildHasIcon) {
            SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            float dimensionPixelSize = simpleDraweeView.getResources().getDimensionPixelSize(R.dimen.guild_icon_radius);
            SimpleDraweeView simpleDraweeView2 = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
            MGImages.setRoundingParams$default(simpleDraweeView2, dimensionPixelSize, !isSelected, Integer.valueOf(isInFolder ? this.overlayColorInFolder : this.overlayColor), null, null, 48, null);
            if (guildHasIcon) {
                if (isSelected) {
                    this.bindingGuild.f.setBackgroundResource(R.drawable.drawable_squircle_transparent);
                } else {
                    this.bindingGuild.f.setBackgroundResource(R.drawable.drawable_circle_transparent);
                }
                FrameLayout frameLayout = this.bindingGuild.f;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "bindingGuild.guildsItemAvatarWrap");
                frameLayout.setBackgroundTintList(null);
                return;
            }
            if (isSelected) {
                this.bindingGuild.f.setBackgroundResource(R.drawable.drawable_squircle_brand_500);
                FrameLayout frameLayout2 = this.bindingGuild.f;
                Intrinsics3.checkNotNullExpressionValue(frameLayout2, "bindingGuild.guildsItemAvatarWrap");
                frameLayout2.setBackgroundTintList(null);
                return;
            }
            this.bindingGuild.f.setBackgroundResource(R.drawable.drawable_circle_black);
            int i = isInFolder ? R.attr.colorBackgroundSecondary : R.attr.colorBackgroundPrimary;
            FrameLayout frameLayout3 = this.bindingGuild.f;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "bindingGuild.guildsItemAvatarWrap");
            int themedColor = ColorCompat.getThemedColor(frameLayout3, i);
            FrameLayout frameLayout4 = this.bindingGuild.f;
            Intrinsics3.checkNotNullExpressionValue(frameLayout4, "bindingGuild.guildsItemAvatarWrap");
            frameLayout4.setBackgroundTintList(ColorStateList.valueOf(themedColor));
        }

        private final void configureGuildIconImage(Guild guild, boolean isSelected) {
            boolean zContains;
            String icon;
            try {
                zContains = guild.getFeatures().contains(GuildFeature.ANIMATED_ICON);
            } catch (Exception e) {
                AppLog.g.e("Guild is missing feature set", e, MapsJVM.mapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, String.valueOf(guild.getId()))));
                zContains = false;
            }
            if (zContains && (icon = guild.getIcon()) != null && StringsJVM.startsWith$default(icon, "a", false, 2, null)) {
                SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
                simpleDraweeView.getHierarchy().o(1, null);
                SimpleDraweeView simpleDraweeView2 = this.bindingGuild.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
                GenericDraweeHierarchy hierarchy = simpleDraweeView2.getHierarchy();
                Intrinsics3.checkNotNullExpressionValue(hierarchy, "bindingGuild.guildsItemAvatar.hierarchy");
                FadeDrawable fadeDrawable = hierarchy.e;
                fadeDrawable.w = 0;
                if (fadeDrawable.v == 1) {
                    fadeDrawable.v = 0;
                }
            } else {
                SimpleDraweeView simpleDraweeView3 = this.bindingGuild.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "bindingGuild.guildsItemAvatar");
                simpleDraweeView3.getHierarchy().p(R.drawable.asset_default_avatar_64dp);
                SimpleDraweeView simpleDraweeView4 = this.bindingGuild.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "bindingGuild.guildsItemAvatar");
                GenericDraweeHierarchy hierarchy2 = simpleDraweeView4.getHierarchy();
                Intrinsics3.checkNotNullExpressionValue(hierarchy2, "bindingGuild.guildsItemAvatar.hierarchy");
                FadeDrawable fadeDrawable2 = hierarchy2.e;
                fadeDrawable2.w = 50;
                if (fadeDrawable2.v == 1) {
                    fadeDrawable2.v = 0;
                }
            }
            if (!guild.hasIcon()) {
                SimpleDraweeView simpleDraweeView5 = this.bindingGuild.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "bindingGuild.guildsItemAvatar");
                simpleDraweeView5.setVisibility(8);
                return;
            }
            String forGuild$default = IconUtils.getForGuild$default(guild, null, isSelected, null, 10, null);
            StringBuilder sbU = outline.U("?size=");
            sbU.append(this.imageRequestSize);
            String strStringPlus = Intrinsics3.stringPlus(forGuild$default, sbU.toString());
            SimpleDraweeView simpleDraweeView6 = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "bindingGuild.guildsItemAvatar");
            int i = this.imageRequestSize;
            MGImages.setImage$default(simpleDraweeView6, strStringPlus, i, i, false, null, null, 112, null);
            SimpleDraweeView simpleDraweeView7 = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView7, "bindingGuild.guildsItemAvatar");
            simpleDraweeView7.setVisibility(0);
        }

        private final void configureGuildIconPositioning(boolean isTargetedForFolderCreation) {
            SimpleDraweeView simpleDraweeView = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "bindingGuild.guildsItemAvatar");
            ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            SimpleDraweeView simpleDraweeView2 = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "bindingGuild.guildsItemAvatar");
            ViewGroup.LayoutParams layoutParams3 = simpleDraweeView2.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            if (isTargetedForFolderCreation) {
                int i = this.targetedAvatarMargin;
                layoutParams2.setMargins(i, i, 0, 0);
                int i2 = this.targetedAvatarSize;
                layoutParams2.height = i2;
                layoutParams2.width = i2;
            } else {
                layoutParams2.setMargins(0, 0, 0, 0);
                int i3 = this.defaultAvatarSize;
                layoutParams2.height = i3;
                layoutParams2.width = i3;
            }
            if (isTargetedForFolderCreation) {
                this.bindingGuild.e.setTextSize(1, TARGETED_AVATAR_TEXT_SIZE_DP);
                int i4 = this.targetedAvatarMargin;
                layoutParams4.setMargins(i4, i4, 0, 0);
                int i5 = this.targetedAvatarSize;
                layoutParams4.height = i5;
                layoutParams4.width = i5;
            } else {
                this.bindingGuild.e.setTextSize(2, DEFAULT_AVATAR_TEXT_SIZE_SP);
                layoutParams4.setMargins(0, 0, 0, 0);
                layoutParams4.height = -1;
                layoutParams4.width = -1;
            }
            SimpleDraweeView simpleDraweeView3 = this.bindingGuild.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "bindingGuild.guildsItemAvatar");
            simpleDraweeView3.setLayoutParams(layoutParams2);
            TextView textView = this.bindingGuild.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
            textView.setLayoutParams(layoutParams4);
        }

        @Override // com.discord.widgets.guilds.list.GuildsDragAndDropCallback.DraggableViewHolder
        public boolean canDrag() {
            GuildListItem.GuildItem guildItem;
            GuildListItem.GuildItem guildItem2 = this.data;
            return (guildItem2 == null || guildItem2.isLurkingGuild() || ((guildItem = this.data) != null && guildItem.isPendingGuild())) ? false : true;
        }

        public final void configure(GuildListItem.GuildItem data) {
            int themedColor;
            GuildListItem.GuildItem guildItem;
            Guild guild;
            Intrinsics3.checkNotNullParameter(data, "data");
            GuildListItem.GuildItem guildItem2 = this.data;
            String icon = (guildItem2 == null || (guild = guildItem2.getGuild()) == null) ? null : guild.getIcon();
            GuildListItem.GuildItem guildItem3 = this.data;
            boolean z2 = guildItem3 == null || guildItem3.isSelected() != data.isSelected();
            boolean z3 = icon == null || (Intrinsics3.areEqual(icon, data.getGuild().getIcon()) ^ true);
            GuildListItem.GuildItem guildItem4 = this.data;
            boolean z4 = (guildItem4 != null ? Boolean.valueOf(guildItem4.isTargetedForFolderCreation()) : null) != null && ((guildItem = this.data) == null || guildItem.isTargetedForFolderCreation() != data.isTargetedForFolderCreation());
            this.data = data;
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            view.setVisibility(0);
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            view2.setSelected(data.isSelected());
            this.itemView.setOnClickListener(new GuildListViewHolder5(this, data));
            View view3 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view3, new GuildListViewHolder6(this, data));
            boolean z5 = data.getFolderId() != null || data.isTargetedForFolderCreation();
            configureGuildIconBackground(data.isSelected(), z5, data.getGuild().hasIcon());
            if (z4) {
                configureGuildIconPositioning(data.isTargetedForFolderCreation());
            }
            if (z3 || z2) {
                configureGuildIconImage(data.getGuild(), data.isSelected());
            }
            configureDraggingAlpha();
            TextView textView = this.bindingGuild.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "bindingGuild.guildsItemAvatarText");
            textView.setText(data.getGuild().hasIcon() ? null : data.getGuild().getShortName());
            if (z2) {
                if (data.isSelected()) {
                    TextView textView2 = this.bindingGuild.e;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "bindingGuild.guildsItemAvatarText");
                    themedColor = ColorCompat.getColor(textView2.getContext(), R.color.white);
                } else {
                    TextView textView3 = this.bindingGuild.e;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "bindingGuild.guildsItemAvatarText");
                    themedColor = ColorCompat.getThemedColor(textView3.getContext(), R.attr.colorHeaderPrimary);
                }
                this.bindingGuild.e.setTextColor(themedColor);
            }
            TextView textView4 = this.bindingGuild.h;
            Intrinsics3.checkNotNullExpressionValue(textView4, "bindingGuild.guildsItemMentions");
            configureMentionsCount(textView4, data.getMentionCount());
            int mentionCount = data.getMentionCount();
            String i18nPluralString = mentionCount > 0 ? StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.guild_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
            View view4 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view4, "itemView");
            View view5 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view5, "itemView");
            view4.setContentDescription(FormatUtils.j(view5, R.string.guild_tooltip_a11y_label, new Object[]{i18nPluralString, data.getGuild().getName()}, null, 4));
            ImageView imageView = this.bindingGuild.i;
            imageView.setVisibility(data.isConnectedToVoice() || (data.getHasActiveStageChannel() && !data.getHasActiveScheduledEvent()) ? 0 : 8);
            imageView.setActivated(data.isConnectedToVoice());
            imageView.setImageResource((!data.isConnectedToVoice() || data.isConnectedToStageChannel()) ? R.drawable.ic_channel_stage_24dp_white : R.drawable.ic_volume_up_white_24dp);
            ImageView imageView2 = this.bindingGuild.g;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "bindingGuild.guildsItemEventStatus");
            imageView2.setVisibility(!data.isConnectedToVoice() && data.getHasActiveScheduledEvent() ? 0 : 8);
            ImageView imageView3 = this.bindingGuild.c;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "bindingGuild.guildsItemApplicationStream");
            imageView3.setVisibility(!data.isConnectedToVoice() && data.getHasOngoingApplicationStream() ? 0 : 8);
            ImageView imageView4 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.guildsItemUnread");
            imageView4.setVisibility(data.getIsUnread() ? 0 : 8);
            ImageView imageView5 = this.binding.f2462b;
            Intrinsics3.checkNotNullExpressionValue(imageView5, "binding.guildsItemSelected");
            imageView5.setVisibility(data.isSelected() ? 0 : 8);
            configureApplicationStatus(null, z5, mentionCount > 0);
        }

        public final Long getFolderId() {
            GuildListItem.GuildItem guildItem = this.data;
            if (guildItem != null) {
                return guildItem.getFolderId();
            }
            return null;
        }

        public final Boolean isLastGuildInFolder() {
            GuildListItem.GuildItem guildItem = this.data;
            if (guildItem != null) {
                return guildItem.isLastGuildInFolder();
            }
            return null;
        }

        public final boolean isTargetedForFolderCreation() {
            GuildListItem.GuildItem guildItem = this.data;
            return guildItem != null && guildItem.isTargetedForFolderCreation();
        }

        @Override // com.discord.widgets.guilds.list.GuildListViewHolder
        public void onDragEnded(boolean wasMerge) {
            super.onDragEnded(wasMerge);
            if (wasMerge) {
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                view.setVisibility(8);
            }
            this.isDragging = false;
            configureDraggingAlpha();
        }

        @Override // com.discord.widgets.guilds.list.GuildListViewHolder
        public void onDragStarted() {
            super.onDragStarted();
            this.isDragging = true;
            configureDraggingAlpha();
        }
    }

    /* compiled from: GuildListViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListViewHolder$PrivateChannelViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListItem$PrivateChannelItem;", "data", "", "configure", "(Lcom/discord/widgets/guilds/list/GuildListItem$PrivateChannelItem;)V", "Lkotlin/Function1;", "onLongPressed", "Lkotlin/jvm/functions/Function1;", "onClicked", "Lcom/discord/databinding/WidgetGuildsListItemDmBinding;", "binding", "Lcom/discord/databinding/WidgetGuildsListItemDmBinding;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PrivateChannelViewHolder extends GuildListViewHolder {
        private final WidgetGuildsListItemDmBinding binding;
        private final Function1<GuildListItem.PrivateChannelItem, Unit> onClicked;
        private final Function1<GuildListItem.PrivateChannelItem, Unit> onLongPressed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PrivateChannelViewHolder(View view, Function1<? super GuildListItem.PrivateChannelItem, Unit> function1, Function1<? super GuildListItem.PrivateChannelItem, Unit> function12) {
            super(view, null);
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(function1, "onClicked");
            Intrinsics3.checkNotNullParameter(function12, "onLongPressed");
            this.onClicked = function1;
            this.onLongPressed = function12;
            WidgetGuildsListItemDmBinding widgetGuildsListItemDmBindingA = WidgetGuildsListItemDmBinding.a(view);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildsListItemDmBindingA, "WidgetGuildsListItemDmBinding.bind(view)");
            this.binding = widgetGuildsListItemDmBindingA;
        }

        public static final /* synthetic */ Function1 access$getOnClicked$p(PrivateChannelViewHolder privateChannelViewHolder) {
            return privateChannelViewHolder.onClicked;
        }

        public static final /* synthetic */ Function1 access$getOnLongPressed$p(PrivateChannelViewHolder privateChannelViewHolder) {
            return privateChannelViewHolder.onLongPressed;
        }

        public final void configure(GuildListItem.PrivateChannelItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            int mentionCount = data.getMentionCount();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildsItemDmCount");
            configureMentionsCount(textView, mentionCount);
            String i18nPluralString = mentionCount > 0 ? StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.dm_tooltip_a11y_label_mentions, mentionCount, Integer.valueOf(mentionCount)) : "";
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            view.setContentDescription(FormatUtils.j(view2, R.string.dm_tooltip_a11y_label, new Object[]{ChannelUtils.c(data.getChannel()), i18nPluralString}, null, 4));
            SimpleDraweeView simpleDraweeView = this.binding.f2459b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildsItemDmAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getChannel(), R.dimen.avatar_size_large, (MGImages.ChangeDetector) null, 8, (Object) null);
            this.itemView.setOnClickListener(new GuildListViewHolder7(this, data));
            View view3 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view3, new GuildListViewHolder8(this, data));
        }
    }

    /* compiled from: GuildListViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListViewHolder$SimpleViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SimpleViewHolder extends GuildListViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimpleViewHolder(View view) {
            super(view, null);
            Intrinsics3.checkNotNullParameter(view, "view");
        }
    }

    /* compiled from: GuildListViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guilds/list/GuildListViewHolder$SpaceViewHolder;", "Lcom/discord/widgets/guilds/list/GuildListViewHolder;", "", "height", "", "configure", "(I)V", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SpaceViewHolder extends GuildListViewHolder {
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpaceViewHolder(View view) {
            super(view, null);
            Intrinsics3.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final void configure(int height) {
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            layoutParams.height = height;
            this.view.setLayoutParams(layoutParams);
        }

        public final View getView() {
            return this.view;
        }
    }

    public /* synthetic */ GuildListViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    public final void configureMentionsCount(TextView textView, int count) {
        Intrinsics3.checkNotNullParameter(textView, "textView");
        if (count < 1) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(String.valueOf(count));
        }
    }

    public void onDragEnded(boolean wasMerge) {
    }

    public void onDragStarted() {
    }

    private GuildListViewHolder(View view) {
        super(view);
    }
}
