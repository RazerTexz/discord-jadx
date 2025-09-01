package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.AutoModSystemMessageEmbedEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemAutoModSystemMessageEmbed;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Landroid/content/Context;", "context", "Lcom/discord/widgets/chat/list/entries/AutoModSystemMessageEmbedEntry;", "messageEntry", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "getMessageRenderContext", "(Landroid/content/Context;Lcom/discord/widgets/chat/list/entries/AutoModSystemMessageEmbedEntry;)Lcom/discord/utilities/textprocessing/MessageRenderContext;", "", "userId", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/stores/StoreMessageState$State;", "messageState", "Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "getMessagePreprocessor", "(JLcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;)Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;", "textView", "Lcom/discord/api/message/embed/MessageEmbed;", "embed", "", "processMessageText", "(Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;Lcom/discord/widgets/chat/list/entries/AutoModSystemMessageEmbedEntry;Lcom/discord/api/message/embed/MessageEmbed;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/utilities/channel/ChannelSelector;", "channelSelector", "Lcom/discord/utilities/channel/ChannelSelector;", "Lcom/discord/databinding/WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed extends WidgetChatListItem {
    private final WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding binding;
    private final ChannelSelector channelSelector;

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Context;", "clickContext", "", "url", "mask", "", "invoke", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Context, String, String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            Intrinsics3.checkNotNullParameter(context, "clickContext");
            Intrinsics3.checkNotNullParameter(str, "url");
            UriHandler.handleOrUntrusted(context, str, str2);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "url", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(str, "url");
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onUrlLongClicked(str);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "it", "", "invoke", "(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<SpoilerNode<?>, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            Intrinsics3.checkNotNullParameter(spoilerNode, "it");
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "userId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getData();
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "channelId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$getMessageRenderContext$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(this.$context, j);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;

        public AnonymousClass1(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
            this.$messageEntry = autoModSystemMessageEmbedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onMessageAuthorLongClicked(this.$messageEntry.getMessage(), this.$messageEntry.getMessage().getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;

        public AnonymousClass2(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
            this.$messageEntry = autoModSystemMessageEmbedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onMessageAuthorLongClicked(this.$messageEntry.getMessage(), this.$messageEntry.getMessage().getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ int $channelNameLength;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(int i) {
            super(1);
            this.$channelNameLength = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("channelHook", new AnonymousClass1());
        }

        /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new SimpleRoundedBackgroundSpan(0, AnonymousClass3.this.$channelNameLength, DimenUtils.dpToPixels(4), 0, ColorCompat.getThemedColor(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), R.attr.colorBackgroundModifierSelected), DimenUtils.dpToPixels(4), Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), R.attr.colorHeaderPrimary)), false, null, 0, 896, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass4(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelSelector.selectChannel$default(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getChannelSelector$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this), this.$channel, null, StoreChannelsSelected3.THREAD_BROWSER, 2, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;

        public AnonymousClass5(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
            this.$messageEntry = autoModSystemMessageEmbedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler().onReportIssueWithAutoMod(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getContext(), this.$messageEntry.getMessage());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;

        public AnonymousClass6(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
            this.$messageEntry = autoModSystemMessageEmbedEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed.this).getEventHandler();
            Message message = this.$messageEntry.getMessage();
            GuildMember author = this.$messageEntry.getAuthor();
            eventHandler.onMessageAuthorLongClicked(message, author != null ? Long.valueOf(author.getGuildId()) : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModSystemMessageEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_auto_mod_system_message_embed, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.actions_button;
        TextView textView = (TextView) view.findViewById(R.id.actions_button);
        if (textView != null) {
            i = R.id.blocked_message_background;
            ImageView imageView = (ImageView) view.findViewById(R.id.blocked_message_background);
            if (imageView != null) {
                i = R.id.blue_shield;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.blue_shield);
                if (imageView2 != null) {
                    i = R.id.chat_list_adapter_item_text_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.chat_list_adapter_item_text_avatar);
                    if (simpleDraweeView != null) {
                        i = R.id.dot_separator;
                        TextView textView2 = (TextView) view.findViewById(R.id.dot_separator);
                        if (textView2 != null) {
                            i = R.id.footer_text;
                            TextView textView3 = (TextView) view.findViewById(R.id.footer_text);
                            if (textView3 != null) {
                                i = R.id.message_content;
                                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.message_content);
                                if (simpleDraweeSpanTextView != null) {
                                    i = R.id.report_button;
                                    TextView textView4 = (TextView) view.findViewById(R.id.report_button);
                                    if (textView4 != null) {
                                        i = R.id.username;
                                        TextView textView5 = (TextView) view.findViewById(R.id.username);
                                        if (textView5 != null) {
                                            WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding widgetChatListAdapterItemAutoModSystemMessageEmbedBinding = new WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding((ConstraintLayout) view, textView, imageView, imageView2, simpleDraweeView, textView2, textView3, simpleDraweeSpanTextView, textView4, textView5);
                                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemAutoModSystemMessageEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                            this.binding = widgetChatListAdapterItemAutoModSystemMessageEmbedBinding;
                                            this.channelSelector = ChannelSelector.INSTANCE.getInstance();
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemAutoModSystemMessageEmbed.adapter;
    }

    public static final /* synthetic */ ChannelSelector access$getChannelSelector$p(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed) {
        return widgetChatListAdapterItemAutoModSystemMessageEmbed.channelSelector;
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, true, (Integer) null);
    }

    private final MessageRenderContext getMessageRenderContext(Context context, AutoModSystemMessageEmbedEntry messageEntry) {
        return new MessageRenderContext(context, ((WidgetChatListAdapter) this.adapter).getData().getUserId(), messageEntry.getAnimateEmojis(), messageEntry.getNickOrUsernames(), ((WidgetChatListAdapter) this.adapter).getData().getChannelNames(), messageEntry.getRoles(), R.attr.colorTextLink, AnonymousClass1.INSTANCE, new AnonymousClass2(), ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg_visible), AnonymousClass3.INSTANCE, new AnonymousClass4(), new AnonymousClass5(context));
    }

    private final void processMessageText(SimpleDraweeSpanTextView textView, AutoModSystemMessageEmbedEntry messageEntry, MessageEmbed embed) {
        Context context = textView.getContext();
        Message message = messageEntry.getMessage();
        UtcDateTime editedTimestamp = message.getEditedTimestamp();
        boolean z2 = (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0;
        String description = embed.getDescription();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(((WidgetChatListAdapter) this.adapter).getData().getUserId(), message, messageEntry.getMessageState());
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, description, getMessageRenderContext(context, messageEntry), messagePreprocessor, DiscordParser.ParserOptions.DEFAULT, z2);
        textView.setVisibility(channelMessage.length() > 0 ? 0 : 8);
        textView.setDraweeSpanStringBuilder(channelMessage);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry = (AutoModSystemMessageEmbedEntry) data;
        int themedColor = ColorCompat.getThemedColor(((WidgetChatListAdapter) this.adapter).getContext(), R.attr.colorHeaderPrimary);
        GuildMember.Companion companion = GuildMember.INSTANCE;
        int color = companion.getColor(autoModSystemMessageEmbedEntry.getAuthor(), themedColor);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.messageContent");
        processMessageText(simpleDraweeSpanTextView, autoModSystemMessageEmbedEntry, autoModSystemMessageEmbedEntry.getEmbed());
        if (autoModSystemMessageEmbedEntry.getMessage().getAuthor() != null) {
            CoreUser coreUser = new CoreUser(autoModSystemMessageEmbedEntry.getMessage().getAuthor());
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.chatListAdapterItemTextAvatar");
            IconUtils.setIcon$default(simpleDraweeView, new CoreUser(autoModSystemMessageEmbedEntry.getMessage().getAuthor()), R.dimen.avatar_size_chat, null, null, autoModSystemMessageEmbedEntry.getAuthor(), 24, null);
            TextView textView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.username");
            FormatUtils.o(textView, companion.getNickOrUsername(autoModSystemMessageEmbedEntry.getAuthor(), coreUser), new Object[0], null, 4);
            String nickOrUsername = companion.getNickOrUsername(autoModSystemMessageEmbedEntry.getAuthor(), coreUser);
            TextView textView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.username");
            FormatUtils.o(textView2, nickOrUsername, new Object[0], null, 4);
            this.binding.g.setTextColor(color);
        }
        this.binding.g.setOnClickListener(new AnonymousClass1(autoModSystemMessageEmbedEntry));
        this.binding.c.setOnClickListener(new AnonymousClass2(autoModSystemMessageEmbedEntry));
        AutoModUtils autoModUtils = AutoModUtils.INSTANCE;
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(Long.parseLong(autoModUtils.getEmbedFieldValue(autoModSystemMessageEmbedEntry.getEmbed(), WidgetChatListAdapterItemAutoModSystemMessageEmbed2.getAUTOMOD_EMBED_FIELD_CHANNEL_ID())));
        String strE = channel != null ? ChannelUtils.e(channel, ((WidgetChatListAdapter) this.adapter).getContext(), false, 2) : null;
        int length = strE != null ? strE.length() : 0;
        TextView textView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.footerText");
        FormatUtils.m(textView3, R.string.guild_automod_channel_rule_subtext, new Object[]{strE, autoModUtils.getEmbedFieldValue(autoModSystemMessageEmbedEntry.getEmbed(), WidgetChatListAdapterItemAutoModSystemMessageEmbed2.getAUTOMOD_EMBED_FIELD_RULE_NAME())}, new AnonymousClass3(length));
        this.binding.d.setOnClickListener(new AnonymousClass4(channel));
        this.binding.f.setOnClickListener(new AnonymousClass5(autoModSystemMessageEmbedEntry));
        this.binding.f2311b.setOnClickListener(new AnonymousClass6(autoModSystemMessageEmbedEntry));
    }
}
