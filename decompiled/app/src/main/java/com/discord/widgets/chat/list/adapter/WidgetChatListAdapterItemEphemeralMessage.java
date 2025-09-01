package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import b.a.d.AppHelpDesk;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemEphemeralMessageBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EphemeralMessageEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemEphemeralMessage;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/databinding/WidgetChatListAdapterItemEphemeralMessageBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemEphemeralMessageBinding;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEphemeralMessage extends WidgetChatListItem {
    private final WidgetChatListAdapterItemEphemeralMessageBinding binding;

    /* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            ImageView imageView = WidgetChatListAdapterItemEphemeralMessage.access$getBinding$p(WidgetChatListAdapterItemEphemeralMessage.this).d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatListAdapterItemIconHelp");
            Context context = imageView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.chatListAdapterItemIconHelp.context");
            UriHandler.handle$default(uriHandler, context, AppHelpDesk.a.a(1500000580222L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Message $message;

        /* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

            /* compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "invoke", "(Ljava/lang/String;Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02731 extends Lambda implements Function2<String, View, Unit> {
                public C02731() {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, View view) {
                    invoke2(str, view);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str, View view) {
                    Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
                    Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 1>");
                    WidgetChatListAdapterItemEphemeralMessage.access$getAdapter$p(WidgetChatListAdapterItemEphemeralMessage.this).getEventHandler().onDismissClicked(AnonymousClass2.this.$message);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                View view = WidgetChatListAdapterItemEphemeralMessage.this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Integer numValueOf = Integer.valueOf(ColorCompat.getColor(view, R.color.brand));
                C02731 c02731 = new C02731();
                Objects.requireNonNull(hook);
                Intrinsics3.checkNotNullParameter(c02731, "onClick");
                hook.clickHandler = new Hook.a(numValueOf, c02731);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("handleDelete", new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEphemeralMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_ephemeral_message, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R.id.chat_list_adapter_item_icon_help;
                ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_adapter_item_icon_help);
                if (imageView != null) {
                    i = R.id.chat_list_adapter_item_text_dismiss;
                    TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_text_dismiss);
                    if (textView != null) {
                        i = R.id.chat_list_adapter_item_visibility_icon;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.chat_list_adapter_item_visibility_icon);
                        if (imageView2 != null) {
                            i = R.id.uikit_chat_guideline;
                            Guideline guideline = (Guideline) view.findViewById(R.id.uikit_chat_guideline);
                            if (guideline != null) {
                                WidgetChatListAdapterItemEphemeralMessageBinding widgetChatListAdapterItemEphemeralMessageBinding = new WidgetChatListAdapterItemEphemeralMessageBinding((ConstraintLayout) view, viewFindViewById, viewFindViewById2, imageView, textView, imageView2, guideline);
                                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemEphemeralMessageBinding, "WidgetChatListAdapterIte…ageBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemEphemeralMessageBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemEphemeralMessage.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemEphemeralMessageBinding access$getBinding$p(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage) {
        return widgetChatListAdapterItemEphemeralMessage.binding;
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
        Message message = ((EphemeralMessageEntry) data).getMessage();
        View view = this.binding.f2318b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListAdapterItemGutterBg");
        View view2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        configureCellHighlight(message, view2, view);
        this.binding.d.setOnClickListener(new AnonymousClass1());
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextDismiss");
        String quantityString = textView.getResources().getQuantityString(R.plurals.only_you_can_see_and_delete_these_count, 1);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "itemDismiss.resources.ge…nd_delete_these_count, 1)");
        String quantityString2 = textView.getResources().getQuantityString(R.plurals.only_you_can_see_and_delete_these_countMessages, 1);
        Intrinsics3.checkNotNullExpressionValue(quantityString2, "itemDismiss.resources.ge…e_these_countMessages, 1)");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(FormatUtils.d(textView, R.string.only_you_can_see_and_delete_these, new Object[]{quantityString, quantityString2}, new AnonymousClass2(message)));
    }
}
