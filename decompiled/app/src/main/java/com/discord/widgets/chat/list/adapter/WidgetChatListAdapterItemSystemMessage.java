package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.MessageReference;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.message.role_subscription.RoleSubscriptionData;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemSystemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J{\u0010\u0015\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0007*\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemSystemMessage;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/models/message/Message;", "Landroid/content/Context;", "context", "", "authorName", "", "authorRoleColor", "", "Lcom/discord/primitives/UserId;", "firstMentionedUserId", "firstMentionedUserName", "otherRoleColor", "guildName", "", "isFlagged", "Lcom/discord/primitives/GuildId;", "guildId", "roleSubscriptionListingId", "", "getSystemMessage", "(Lcom/discord/models/message/Message;Landroid/content/Context;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;)Ljava/lang/CharSequence;", "getIcon", "(Lcom/discord/models/message/Message;)I", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/databinding/WidgetChatListAdapterItemSystemBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemSystemBinding;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage extends WidgetChatListItem {
    private final WidgetChatListAdapterItemSystemBinding binding;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/Context;", "", "invoke", "(Landroid/content/Context;)Ljava/lang/CharSequence;", "getString"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Context, CharSequence> {
        public final /* synthetic */ Function1 $actorRenderContext;
        public final /* synthetic */ String $authorName;
        public final /* synthetic */ Function1 $autoModRenderContext;
        public final /* synthetic */ int $autoModSystemMessage;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Long $firstMentionedUserId;
        public final /* synthetic */ String $firstMentionedUserName;
        public final /* synthetic */ String $guildName;
        public final /* synthetic */ Function1 $roleSubscriptionPurchaseContext;
        public final /* synthetic */ Message $this_getSystemMessage;
        public final /* synthetic */ Function1 $usernameRenderContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message, String str, String str2, Function1 function1, Long l, Context context, String str3, Function1 function12, int i, Function1 function13, Function1 function14) {
            super(1);
            this.$this_getSystemMessage = message;
            this.$authorName = str;
            this.$firstMentionedUserName = str2;
            this.$usernameRenderContext = function1;
            this.$firstMentionedUserId = l;
            this.$context = context;
            this.$guildName = str3;
            this.$actorRenderContext = function12;
            this.$autoModSystemMessage = i;
            this.$autoModRenderContext = function13;
            this.$roleSubscriptionPurchaseContext = function14;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Context context) {
            return invoke2(context);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(Context context) {
            Intrinsics3.checkNotNullParameter(context, "$this$getString");
            Integer type = this.$this_getSystemMessage.getType();
            if (type != null && type.intValue() == 1) {
                return FormatUtils.b(context, R.string.system_message_recipient_add, new Object[]{this.$authorName, this.$firstMentionedUserName}, this.$usernameRenderContext);
            }
            if (type != null && type.intValue() == 2) {
                Long l = this.$firstMentionedUserId;
                User author = this.$this_getSystemMessage.getAuthor();
                return Intrinsics3.areEqual(l, author != null ? Long.valueOf(author.getId()) : null) ? FormatUtils.b(context, R.string.system_message_recipient_remove_self, new Object[]{this.$authorName}, this.$usernameRenderContext) : FormatUtils.b(context, R.string.system_message_recipient_remove, new Object[]{this.$authorName, this.$firstMentionedUserName}, this.$usernameRenderContext);
            }
            if (type != null && type.intValue() == 4) {
                return FormatUtils.b(context, R.string.system_message_channel_name_change, new Object[]{this.$authorName, this.$this_getSystemMessage.getContent()}, this.$usernameRenderContext);
            }
            if (type != null && type.intValue() == 5) {
                return FormatUtils.b(context, R.string.system_message_channel_icon_change, new Object[]{this.$authorName}, this.$usernameRenderContext);
            }
            if (type != null && type.intValue() == 6) {
                return FormatUtils.b(context, R.string.system_message_pinned_message_no_cta, new Object[]{this.$authorName}, this.$usernameRenderContext);
            }
            if (type != null && type.intValue() == 7) {
                return FormatUtils.b(context, MessageUtils.INSTANCE.getSystemMessageUserJoin(this.$context, this.$this_getSystemMessage.getId()), new Object[]{this.$authorName}, this.$usernameRenderContext);
            }
            if (type == null || type.intValue() != 8) {
                return (type != null && type.intValue() == 9) ? FormatUtils.b(context, R.string.system_message_guild_member_subscribed_achieved_tier, new Object[]{this.$authorName, this.$guildName, FormatUtils.h(context, R.string.premium_guild_tier_1, new Object[0], null, 4)}, this.$usernameRenderContext) : (type != null && type.intValue() == 10) ? FormatUtils.b(context, R.string.system_message_guild_member_subscribed_achieved_tier, new Object[]{this.$authorName, this.$guildName, FormatUtils.h(context, R.string.premium_guild_tier_2, new Object[0], null, 4)}, this.$usernameRenderContext) : (type != null && type.intValue() == 11) ? FormatUtils.b(context, R.string.system_message_guild_member_subscribed_achieved_tier, new Object[]{this.$authorName, this.$guildName, FormatUtils.h(context, R.string.premium_guild_tier_3, new Object[0], null, 4)}, this.$usernameRenderContext) : (type != null && type.intValue() == 12) ? FormatUtils.b(context, R.string.system_message_channel_follow_add, new Object[]{this.$authorName, this.$this_getSystemMessage.getContent()}, this.$usernameRenderContext) : (type != null && type.intValue() == 14) ? FormatUtils.h(context, R.string.system_message_guild_discovery_disqualified_mobile, new Object[0], null, 4) : (type != null && type.intValue() == 15) ? FormatUtils.h(context, R.string.system_message_guild_discovery_requalified, new Object[0], null, 4) : (type != null && type.intValue() == 16) ? FormatUtils.h(context, R.string.system_message_guild_discovery_grace_period_initial_warning, new Object[0], null, 4) : (type != null && type.intValue() == 17) ? FormatUtils.h(context, R.string.system_message_guild_discovery_grace_period_final_warning, new Object[0], null, 4) : (type != null && type.intValue() == 18) ? FormatUtils.b(context, R.string.system_message_thread_created_mobile, new Object[]{this.$authorName, this.$this_getSystemMessage.getContent()}, this.$actorRenderContext) : (type != null && type.intValue() == -7) ? FormatUtils.h(context, R.string.thread_starter_message_not_loaded, new Object[0], null, 4) : (type != null && type.intValue() == 24) ? FormatUtils.b(context, this.$autoModSystemMessage, new Object[0], this.$autoModRenderContext) : (type != null && type.intValue() == 25) ? MessageUtils.INSTANCE.getSystemMessageRoleSubscriptionPurchase(this.$context, this.$guildName, this.$authorName, this.$this_getSystemMessage.getRoleSubscriptionData(), this.$roleSubscriptionPurchaseContext) : FormatUtils.h(context, R.string.reply_quote_message_not_loaded, new Object[0], null, 4);
            }
            String content = this.$this_getSystemMessage.getContent();
            int i = content == null || content.length() == 0 ? 1 : Integer.parseInt(this.$this_getSystemMessage.getContent());
            return i > 1 ? FormatUtils.b(context, R.string.system_message_guild_member_subscribed_many, new Object[]{this.$authorName, String.valueOf(i)}, this.$usernameRenderContext) : FormatUtils.b(context, R.string.system_message_guild_member_subscribed, new Object[]{this.$authorName}, this.$usernameRenderContext);
        }
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Message $message;

        public AnonymousClass1(Message message) {
            this.$message = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Integer type = this.$message.getType();
            if (type != null && type.intValue() == 7) {
                WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getEventHandler().onMessageAuthorNameClicked(this.$message, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getData().getGuildId());
                return;
            }
            if ((type != null && type.intValue() == 8) || ((type != null && type.intValue() == 9) || ((type != null && type.intValue() == 10) || (type != null && type.intValue() == 11)))) {
                AnalyticsTracker.guildBoostPromotionOpened$default(AnalyticsTracker.INSTANCE, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getData().getGuildId(), new Traits.Location(null, Traits.Location.Section.CHANNEL_TEXT_AREA, Traits.Location.Obj.BOOST_GEM_ICON, null, null, 25, null), null, 4, null);
                WidgetGuildBoost.Companion companion = WidgetGuildBoost.INSTANCE;
                LinkifiedTextView linkifiedTextView = WidgetChatListAdapterItemSystemMessage.access$getBinding$p(WidgetChatListAdapterItemSystemMessage.this).h;
                Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.systemText");
                Context context = linkifiedTextView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.systemText.context");
                companion.create(context, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getData().getGuildId());
                return;
            }
            if (type != null && type.intValue() == 12) {
                WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getEventHandler().onMessageAuthorNameClicked(this.$message, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getData().getGuildId());
                return;
            }
            if (type != null && type.intValue() == 6) {
                WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getEventHandler().onOpenPinsClicked(this.$message);
                return;
            }
            if (type != null && type.intValue() == 18) {
                MessageReference messageReference = this.$message.getMessageReference();
                Long channelId = messageReference != null ? messageReference.getChannelId() : null;
                if (channelId != null) {
                    ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getData().getGuildId(), channelId.longValue(), null, null, 12, null);
                }
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getEventHandler();
            Message message = this.$message;
            LinkifiedTextView linkifiedTextView = WidgetChatListAdapterItemSystemMessage.access$getBinding$p(WidgetChatListAdapterItemSystemMessage.this).h;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.systemText");
            CharSequence text = linkifiedTextView.getText();
            Intrinsics3.checkNotNullExpressionValue(text, "binding.systemText.text");
            eventHandler.onMessageLongClicked(message, text, false);
        }
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ ChatListEntry $data;
        public final /* synthetic */ Message $message;

        public AnonymousClass3(Message message, ChatListEntry chatListEntry) {
            this.$message = message;
            this.$data = chatListEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getEventHandler().onSystemMessageCtaClicked(this.$message, ((MessageEntry) this.$data).getCtaData().getChannel(), ((MessageEntry) this.$data).getCtaData().getSticker());
        }
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$onConfigure$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ Message $message;

        public AnonymousClass4(Long l, Message message) {
            this.$guildId = l;
            this.$message = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Long l = this.$guildId;
            if (l != null) {
                l.longValue();
                WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage.this).getEventHandler().onMessageAuthorAvatarClicked(this.$message, this.$guildId.longValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_system, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_thread_embed_spine;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.chat_list_adapter_item_thread_embed_spine);
        if (appCompatImageView != null) {
            i = R.id.role_subscription_badge_dummy_view;
            View viewFindViewById = view.findViewById(R.id.role_subscription_badge_dummy_view);
            if (viewFindViewById != null) {
                i = R.id.role_subscription_purchase_badge;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.role_subscription_purchase_badge);
                if (appCompatImageView2 != null) {
                    i = R.id.role_subscription_purchase_lanyard;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(R.id.role_subscription_purchase_lanyard);
                    if (appCompatImageView3 != null) {
                        i = R.id.role_subscription_purchase_welcome;
                        TextView textView = (TextView) view.findViewById(R.id.role_subscription_purchase_welcome);
                        if (textView != null) {
                            i = R.id.role_subscription_purchase_welcome_card;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.role_subscription_purchase_welcome_card);
                            if (constraintLayout != null) {
                                i = R.id.role_subscription_purchaser_avatar;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.role_subscription_purchaser_avatar);
                                if (simpleDraweeView != null) {
                                    i = R.id.role_subscription_purchaser_username;
                                    TextView textView2 = (TextView) view.findViewById(R.id.role_subscription_purchaser_username);
                                    if (textView2 != null) {
                                        i = R.id.system_icon;
                                        ImageView imageView = (ImageView) view.findViewById(R.id.system_icon);
                                        if (imageView != null) {
                                            i = R.id.system_icon_automod;
                                            ImageView imageView2 = (ImageView) view.findViewById(R.id.system_icon_automod);
                                            if (imageView2 != null) {
                                                i = R.id.system_text;
                                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.system_text);
                                                if (linkifiedTextView != null) {
                                                    i = R.id.system_timestamp;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.system_timestamp);
                                                    if (textView3 != null) {
                                                        i = R.id.system_welcome_cta_button;
                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.system_welcome_cta_button);
                                                        if (linearLayout != null) {
                                                            i = R.id.system_welcome_cta_button_sticker;
                                                            StickerView stickerView = (StickerView) view.findViewById(R.id.system_welcome_cta_button_sticker);
                                                            if (stickerView != null) {
                                                                i = R.id.uikit_chat_guideline;
                                                                Guideline guideline = (Guideline) view.findViewById(R.id.uikit_chat_guideline);
                                                                if (guideline != null) {
                                                                    WidgetChatListAdapterItemSystemBinding widgetChatListAdapterItemSystemBinding = new WidgetChatListAdapterItemSystemBinding((ConstraintLayout) view, appCompatImageView, viewFindViewById, appCompatImageView2, appCompatImageView3, textView, constraintLayout, simpleDraweeView, textView2, imageView, imageView2, linkifiedTextView, textView3, linearLayout, stickerView, guideline);
                                                                    Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemSystemBinding, "WidgetChatListAdapterIte…temBinding.bind(itemView)");
                                                                    this.binding = widgetChatListAdapterItemSystemBinding;
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemSystemMessage.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemSystemBinding access$getBinding$p(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage) {
        return widgetChatListAdapterItemSystemMessage.binding;
    }

    private final int getIcon(Message message) {
        Integer type = message.getType();
        if (type == null || type.intValue() != 1) {
            if (type != null && type.intValue() == 2) {
                return R.drawable.ic_group_leave;
            }
            if ((type != null && type.intValue() == 4) || (type != null && type.intValue() == 5)) {
                return R.drawable.ic_group_edit;
            }
            if (type != null && type.intValue() == 6) {
                return R.drawable.ic_channel_pinned_message;
            }
            if ((type == null || type.intValue() != 7) && (type == null || type.intValue() != 25)) {
                if ((type != null && type.intValue() == 8) || ((type != null && type.intValue() == 9) || ((type != null && type.intValue() == 10) || (type != null && type.intValue() == 11)))) {
                    return R.drawable.ic_user_premium_guild_subscription;
                }
                if (type == null || type.intValue() != 12) {
                    if (type == null || type.intValue() != 14) {
                        if (type != null && type.intValue() == 15) {
                            return R.drawable.ic_check_green_24dp;
                        }
                        if (type != null && type.intValue() == 16) {
                            return R.drawable.ic_warning_circle_24dp;
                        }
                        if (type != null && type.intValue() == 17) {
                            return R.drawable.ic_warning_circle_24dp;
                        }
                        if (type != null && type.intValue() == 18) {
                            return R.drawable.ic_thread;
                        }
                        if (type != null) {
                            type.intValue();
                        }
                    }
                    return R.drawable.ic_x_red_24dp;
                }
            }
        }
        return R.drawable.ic_group_join;
    }

    private final CharSequence getSystemMessage(Message message, Context context, String str, int i, Long l, String str2, int i2, String str3, boolean z2, Long l2, Long l3) {
        int i3;
        if (z2) {
            i3 = R.string.guild_automod_system_message_text_flagged;
        } else {
            if (z2) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = R.string.guild_automod_system_message_text;
        }
        return new AnonymousClass1(message, str, str2, new WidgetChatListAdapterItemSystemMessage5(i, i2), l, context, str3, new WidgetChatListAdapterItemSystemMessage2(i), i3, new WidgetChatListAdapterItemSystemMessage3(context), new WidgetChatListAdapterItemSystemMessage4(this, message, i, context, l3)).invoke2(context);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        MessageEmbed messageEmbed;
        User user;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MessageEntry messageEntry = (MessageEntry) data;
        Message messageComponent1 = messageEntry.getMessage();
        GuildMember guildMemberComponent3 = messageEntry.getAuthor();
        GuildMember guildMemberComponent4 = messageEntry.getFirstMentionedUser();
        Map<Long, String> mapComponent6 = messageEntry.component6();
        User author = messageComponent1.getAuthor();
        String str = mapComponent6.get(author != null ? Long.valueOf(author.getId()) : null);
        Guild guild = ((WidgetChatListAdapter) this.adapter).getData().getGuild();
        String name = guild != null ? guild.getName() : null;
        List<User> mentions = messageComponent1.getMentions();
        Long lValueOf = (mentions == null || (user = (User) _Collections.firstOrNull((List) mentions)) == null) ? null : Long.valueOf(user.getId());
        String str2 = lValueOf != null ? mapComponent6.get(Long.valueOf(lValueOf.longValue())) : null;
        LinkifiedTextView linkifiedTextView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.systemText");
        int themedColor = ColorCompat.getThemedColor(linkifiedTextView.getContext(), R.attr.colorHeaderPrimary);
        GuildMember.Companion companion = GuildMember.INSTANCE;
        int color = companion.getColor(guildMemberComponent3, themedColor);
        int color2 = companion.getColor(guildMemberComponent4, themedColor);
        List<MessageEmbed> embeds = messageComponent1.getEmbeds();
        boolean z2 = (embeds == null || (messageEmbed = (MessageEmbed) _Collections.firstOrNull((List) embeds)) == null) ? false : !Intrinsics3.areEqual(AutoModUtils.INSTANCE.getEmbedFieldValue(messageEmbed, WidgetChatListAdapterItemAutoModSystemMessageEmbed2.getAUTOMOD_EMBED_FLAGGED_MESSAGE_ID()), "");
        RoleSubscriptionData roleSubscriptionData = messageComponent1.getRoleSubscriptionData();
        Long lValueOf2 = roleSubscriptionData != null ? Long.valueOf(roleSubscriptionData.getRoleSubscriptionListingId()) : null;
        Guild guild2 = ((WidgetChatListAdapter) this.adapter).getData().getGuild();
        Long lValueOf3 = guild2 != null ? Long.valueOf(guild2.getId()) : null;
        LinkifiedTextView linkifiedTextView2 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.systemText");
        Context context = linkifiedTextView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.systemText.context");
        Long l = lValueOf3;
        CharSequence systemMessage = getSystemMessage(messageComponent1, context, str, color, lValueOf, str2, color2, name, z2, l, lValueOf2);
        this.binding.a.setOnClickListener(new AnonymousClass1(messageComponent1));
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout, new AnonymousClass2(messageComponent1));
        TextView textView = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.systemTimestamp");
        Context contextX = outline.x(this.itemView, "itemView", "itemView.context");
        UtcDateTime timestamp = messageComponent1.getTimestamp();
        textView.setText(TimeUtils.toReadableTimeString$default(contextX, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null));
        LinkifiedTextView linkifiedTextView3 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.systemText");
        linkifiedTextView3.setText(systemMessage);
        this.binding.f.setImageResource(getIcon(messageComponent1));
        ImageView imageView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.systemIconAutomod");
        Integer type = messageEntry.getMessage().getType();
        imageView.setVisibility(type != null && type.intValue() == 24 ? 0 : 8);
        AppCompatImageView appCompatImageView = this.binding.f2337b;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.chatListAdapterItemThreadEmbedSpine");
        appCompatImageView.setVisibility(messageComponent1.hasThread() && !messageEntry.isThreadStarterMessage() ? 0 : 8);
        LinearLayout linearLayout = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.systemWelcomeCtaButton");
        linearLayout.setVisibility(messageEntry.getCtaData() != null ? 0 : 8);
        if (messageEntry.getCtaData() != null) {
            StickerView.e(this.binding.k, messageEntry.getCtaData().getSticker(), null, 2);
            this.binding.k.b();
            this.binding.j.setOnClickListener(new AnonymousClass3(messageComponent1, data));
        }
        boolean z3 = messageComponent1.getRoleSubscriptionData() != null && messageComponent1.getRoleSubscriptionData().getTotalMonthsSubscribed() <= 1;
        ConstraintLayout constraintLayout2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.roleSubscriptionPurchaseWelcomeCard");
        constraintLayout2.setVisibility(z3 ? 0 : 8);
        if (z3) {
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.roleSubscriptionPurchaserUsername");
            textView2.setText(str);
            if (messageComponent1.getAuthor() != null) {
                SimpleDraweeView simpleDraweeView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.roleSubscriptionPurchaserAvatar");
                IconUtils.setIcon$default(simpleDraweeView, new CoreUser(messageComponent1.getAuthor()), R.dimen.avatar_size_large, null, null, messageEntry.getAuthor(), 24, null);
                this.binding.d.setOnClickListener(new AnonymousClass4(l, messageComponent1));
            }
        }
    }
}
