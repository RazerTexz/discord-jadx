package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.databinding.WidgetChatListAdapterItemThreadEmbedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreMessageState;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.ViewReplySpline;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ThreadEmbedEntry;
import com.discord.widgets.chat.list.utils.EmbeddedMessageParser;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemThreadEmbed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00015B\u000f\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJS\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u000b0\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018JU\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ;\u0010\u001f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u000b0\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020'2\b\b\u0002\u0010&\u001a\u00020\u001bH\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020+H\u0014¢\u0006\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00066"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemThreadEmbed;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "", "count", "", "configureMessageCount", "(I)V", "Lcom/discord/widgets/chat/list/entries/ThreadEmbedEntry;", "data", "configureMostRecentMessageText", "(Lcom/discord/widgets/chat/list/entries/ThreadEmbedEntry;)V", "", "messageText", "Lcom/discord/models/message/Message;", "mostRecentMessage", "", "", "Lcom/discord/primitives/UserId;", "nickOrUsernames", "Lcom/discord/models/member/GuildMember;", "mostRecentMessageAuthorGuildMember", "Landroid/graphics/drawable/Drawable;", "icon", "setNoMostRecentMessage", "(Ljava/lang/String;Lcom/discord/models/message/Message;Ljava/util/Map;Lcom/discord/models/member/GuildMember;Landroid/graphics/drawable/Drawable;)V", "Lcom/discord/api/role/GuildRole;", "roleMentions", "", "animateEmojis", "setMostRecentMessage", "(Lcom/discord/models/message/Message;Ljava/util/Map;Ljava/util/Map;ZLcom/discord/models/member/GuildMember;)V", "setAuthorAndAvatar", "(Lcom/discord/models/message/Message;Ljava/util/Map;Lcom/discord/models/member/GuildMember;)V", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "member", "getAuthorTextColor", "(Lcom/discord/models/member/GuildMember;)I", "showAuthor", "Landroid/text/style/LeadingMarginSpan;", "getLeadingMarginSpan", "(Z)Landroid/text/style/LeadingMarginSpan;", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/databinding/WidgetChatListAdapterItemThreadEmbedBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemThreadEmbedBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadEmbed extends WidgetChatListItem {
    public static final int MAX_THREAD_MESSAGE_AST_NODES = 50;
    private final WidgetChatListAdapterItemThreadEmbedBinding binding;

    /* compiled from: WidgetChatListAdapterItemThreadEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadEmbed$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ChatListEntry $data;

        public AnonymousClass1(ChatListEntry chatListEntry) {
            this.$data = chatListEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemThreadEmbed.access$getAdapter$p(WidgetChatListAdapterItemThreadEmbed.this).onThreadClicked(((ThreadEmbedEntry) this.$data).getThread());
        }
    }

    /* compiled from: WidgetChatListAdapterItemThreadEmbed.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onLongClick", "(Landroid/view/View;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadEmbed$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnLongClickListener {
        public final /* synthetic */ ChatListEntry $data;

        public AnonymousClass2(ChatListEntry chatListEntry) {
            this.$data = chatListEntry;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            WidgetChatListAdapterItemThreadEmbed.access$getAdapter$p(WidgetChatListAdapterItemThreadEmbed.this).onThreadLongClicked(((ThreadEmbedEntry) this.$data).getThread());
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_thread_embed, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.thread_embed_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.thread_embed_icon);
                if (imageView != null) {
                    i = R.id.thread_embed_message_center_guideline;
                    View viewFindViewById3 = view.findViewById(R.id.thread_embed_message_center_guideline);
                    if (viewFindViewById3 != null) {
                        i = R.id.thread_embed_messages_count;
                        TextView textView = (TextView) view.findViewById(R.id.thread_embed_messages_count);
                        if (textView != null) {
                            i = R.id.thread_embed_messages_count_chevron;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.thread_embed_messages_count_chevron);
                            if (imageView2 != null) {
                                i = R.id.thread_embed_most_recent_message_avatar;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.thread_embed_most_recent_message_avatar);
                                if (simpleDraweeView != null) {
                                    i = R.id.thread_embed_most_recent_message_content;
                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.thread_embed_most_recent_message_content);
                                    if (simpleDraweeSpanTextView != null) {
                                        i = R.id.thread_embed_most_recent_message_header;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.thread_embed_most_recent_message_header);
                                        if (constraintLayout2 != null) {
                                            i = R.id.thread_embed_most_recent_message_name;
                                            TextView textView2 = (TextView) view.findViewById(R.id.thread_embed_most_recent_message_name);
                                            if (textView2 != null) {
                                                i = R.id.thread_embed_name;
                                                TextView textView3 = (TextView) view.findViewById(R.id.thread_embed_name);
                                                if (textView3 != null) {
                                                    i = R.id.thread_embed_selectable_background;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.thread_embed_selectable_background);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.thread_embed_spine;
                                                        ViewReplySpline viewReplySpline = (ViewReplySpline) view.findViewById(R.id.thread_embed_spine);
                                                        if (viewReplySpline != null) {
                                                            i = R.id.uikit_chat_guideline;
                                                            Guideline guideline = (Guideline) view.findViewById(R.id.uikit_chat_guideline);
                                                            if (guideline != null) {
                                                                WidgetChatListAdapterItemThreadEmbedBinding widgetChatListAdapterItemThreadEmbedBinding = new WidgetChatListAdapterItemThreadEmbedBinding(constraintLayout, viewFindViewById, viewFindViewById2, constraintLayout, imageView, viewFindViewById3, textView, imageView2, simpleDraweeView, simpleDraweeSpanTextView, constraintLayout2, textView2, textView3, constraintLayout3, viewReplySpline, guideline);
                                                                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemThreadEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                                                this.binding = widgetChatListAdapterItemThreadEmbedBinding;
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemThreadEmbed.adapter;
    }

    private final void configureMessageCount(int count) {
        TextView textView = this.binding.f;
        if (count == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(count >= 50 ? "50+" : String.valueOf(count));
        }
        ImageView imageView = this.binding.g;
        imageView.setImageTintList(count == 0 ? ColorStateList.valueOf(ColorCompat.getThemedColor(imageView.getContext(), R.attr.colorInteractiveNormal)) : ColorStateList.valueOf(ColorCompat.getThemedColor(imageView.getContext(), R.attr.colorTextLink)));
    }

    private final void configureMostRecentMessageText(ThreadEmbedEntry data) throws Resources.NotFoundException {
        ConstraintLayout constraintLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.threadEmbedContainer");
        Context context = constraintLayout.getContext();
        Message mostRecentMessage = data.getMostRecentMessage();
        ConstraintLayout constraintLayout2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.threadEmbedMostRecentMessageHeader");
        constraintLayout2.setVisibility(8);
        ThreadMetadata threadMetadata = data.getThread().getThreadMetadata();
        if (threadMetadata != null && threadMetadata.getArchived()) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Drawable drawable = ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes(context, R.attr.ic_thread_archived_clock, 0));
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            String string = view.getResources().getString(R.string.thread_archived);
            Intrinsics3.checkNotNullExpressionValue(string, "itemView.resources.getSt…R.string.thread_archived)");
            setNoMostRecentMessage$default(this, string, null, data.getNickOrUsernames(), null, drawable, 10, null);
            return;
        }
        if (data.getThreadMessageCount() == 0) {
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            String string2 = view2.getResources().getString(R.string.no_thread_messages);
            Intrinsics3.checkNotNullExpressionValue(string2, "itemView.resources.getSt…tring.no_thread_messages)");
            setNoMostRecentMessage$default(this, string2, null, data.getNickOrUsernames(), null, null, 26, null);
            return;
        }
        if ((mostRecentMessage != null ? mostRecentMessage.getContent() : null) == null || mostRecentMessage.getAuthor() == null || data.getMostRecentMessageGuildMember() == null) {
            View view3 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
            String string3 = view3.getResources().getString(R.string.no_recent_thread_messages);
            Intrinsics3.checkNotNullExpressionValue(string3, "itemView.resources.getSt…o_recent_thread_messages)");
            setNoMostRecentMessage$default(this, string3, null, data.getNickOrUsernames(), null, null, 26, null);
            return;
        }
        if (mostRecentMessage.hasStickers()) {
            View view4 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view4, "itemView");
            String string4 = view4.getResources().getString(R.string.reply_quote_sticker_mobile);
            Intrinsics3.checkNotNullExpressionValue(string4, "itemView.resources.getSt…ply_quote_sticker_mobile)");
            setNoMostRecentMessage$default(this, string4, mostRecentMessage, data.getNickOrUsernames(), data.getMostRecentMessageGuildMember(), null, 16, null);
            return;
        }
        if (!mostRecentMessage.hasAttachments() && !mostRecentMessage.hasEmbeds()) {
            setMostRecentMessage(mostRecentMessage, data.getRoleMentions(), data.getNickOrUsernames(), data.getAnimateEmojis(), data.getMostRecentMessageGuildMember());
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        Drawable drawable2 = ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes(context, R.attr.ic_flex_input_image, 0));
        View view5 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view5, "itemView");
        String string5 = view5.getResources().getString(R.string.reply_quote_no_text_content_mobile);
        Intrinsics3.checkNotNullExpressionValue(string5, "itemView.resources.getSt…e_no_text_content_mobile)");
        setNoMostRecentMessage(string5, mostRecentMessage, data.getNickOrUsernames(), data.getMostRecentMessageGuildMember(), drawable2);
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), R.attr.colorHeaderPrimary));
    }

    private final LeadingMarginSpan getLeadingMarginSpan(boolean showAuthor) {
        int measuredWidth;
        this.binding.j.measure(0, 0);
        if (showAuthor) {
            ConstraintLayout constraintLayout = this.binding.j;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.threadEmbedMostRecentMessageHeader");
            measuredWidth = constraintLayout.getMeasuredWidth();
        } else {
            measuredWidth = 0;
        }
        return new LeadingMarginSpan.Standard(measuredWidth, 0);
    }

    public static /* synthetic */ LeadingMarginSpan getLeadingMarginSpan$default(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return widgetChatListAdapterItemThreadEmbed.getLeadingMarginSpan(z2);
    }

    private final void setAuthorAndAvatar(Message mostRecentMessage, Map<Long, String> nickOrUsernames, GuildMember mostRecentMessageAuthorGuildMember) {
        if (mostRecentMessage == null || mostRecentMessage.getAuthor() == null || mostRecentMessageAuthorGuildMember == null) {
            return;
        }
        ConstraintLayout constraintLayout = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.threadEmbedMostRecentMessageHeader");
        constraintLayout.setVisibility(0);
        TextView textView = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadEmbedMostRecentMessageName");
        textView.setText(nickOrUsernames.get(Long.valueOf(mostRecentMessage.getAuthor().getId())));
        this.binding.k.setTextColor(getAuthorTextColor(mostRecentMessageAuthorGuildMember));
        CoreUser coreUser = new CoreUser(mostRecentMessage.getAuthor());
        SimpleDraweeView simpleDraweeView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.threadEmbedMostRecentMessageAvatar");
        IconUtils.setIcon$default(simpleDraweeView, coreUser, R.dimen.avatar_size_small, null, null, mostRecentMessageAuthorGuildMember, 24, null);
    }

    private final void setIcon(Drawable icon) {
        ImageView imageView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.threadEmbedIcon");
        imageView.setVisibility(icon != null ? 0 : 8);
        this.binding.e.setImageDrawable(icon);
    }

    public static /* synthetic */ void setIcon$default(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = null;
        }
        widgetChatListAdapterItemThreadEmbed.setIcon(drawable);
    }

    private final void setMostRecentMessage(Message mostRecentMessage, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, GuildMember mostRecentMessageAuthorGuildMember) {
        DraweeSpanStringBuilder draweeSpanStringBuilder = EmbeddedMessageParser.INSTANCE.parse(new EmbeddedMessageParser.ParserData(outline.x(this.itemView, "itemView", "itemView.context"), roleMentions, nickOrUsernames, animateEmojis, new StoreMessageState.State(null, null, 3, null), 50, mostRecentMessage, (WidgetChatListAdapter) this.adapter));
        setAuthorAndAvatar(mostRecentMessage, nickOrUsernames, mostRecentMessageAuthorGuildMember);
        draweeSpanStringBuilder.setSpan(getLeadingMarginSpan$default(this, false, 1, null), 0, draweeSpanStringBuilder.length(), 33);
        this.binding.i.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.i;
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = simpleDraweeSpanTextView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        simpleDraweeSpanTextView.setTypeface(fontUtils.getThemedFont(context, R.attr.font_primary_normal), 0);
        setIcon$default(this, null, 1, null);
    }

    private final void setNoMostRecentMessage(String messageText, Message mostRecentMessage, Map<Long, String> nickOrUsernames, GuildMember mostRecentMessageAuthorGuildMember, Drawable icon) {
        SpannableString spannableString = new SpannableString(messageText + (char) 160);
        setAuthorAndAvatar(mostRecentMessage, nickOrUsernames, mostRecentMessageAuthorGuildMember);
        spannableString.setSpan(getLeadingMarginSpan((mostRecentMessage == null || mostRecentMessageAuthorGuildMember == null) ? false : true), 0, spannableString.length(), 33);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.threadEmbedMostRecentMessageContent");
        simpleDraweeSpanTextView.setText(spannableString);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.i;
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = simpleDraweeSpanTextView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        simpleDraweeSpanTextView2.setTypeface(fontUtils.getThemedFont(context, R.attr.font_primary_normal), 2);
        setIcon(icon);
    }

    public static /* synthetic */ void setNoMostRecentMessage$default(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed, String str, Message message, Map map, GuildMember guildMember, Drawable drawable, int i, Object obj) {
        widgetChatListAdapterItemThreadEmbed.setNoMostRecentMessage(str, (i & 2) != 0 ? null : message, map, (i & 8) != 0 ? null : guildMember, (i & 16) != 0 ? null : drawable);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) throws Resources.NotFoundException {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof ThreadEmbedEntry) {
            TextView textView = this.binding.l;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadEmbedName");
            ThreadEmbedEntry threadEmbedEntry = (ThreadEmbedEntry) data;
            textView.setText(threadEmbedEntry.getThread().getName());
            this.binding.d.setOnClickListener(new AnonymousClass1(data));
            this.binding.a.setOnLongClickListener(new AnonymousClass2(data));
            configureMessageCount(threadEmbedEntry.getThreadMessageCount());
            configureMostRecentMessageText(threadEmbedEntry);
            Message parentMessage = threadEmbedEntry.getParentMessage();
            View view = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListAdapterItemHighlightedBg");
            View view2 = this.binding.f2341b;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemGutterBg");
            configureCellHighlight(parentMessage, view, view2);
        }
    }
}
