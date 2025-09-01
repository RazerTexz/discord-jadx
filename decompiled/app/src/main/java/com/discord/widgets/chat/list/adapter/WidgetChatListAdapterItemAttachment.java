package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetChatListAdapterItemAttachmentBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.AttachmentEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.media.WidgetMedia;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemAttachment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0002'(B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemAttachment;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/widgets/chat/list/FragmentLifecycleListener;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemAttachment$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemAttachment$Model;)V", "Lcom/discord/api/message/attachment/MessageAttachment;", "data", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "renderContext", "configureFileData", "(Lcom/discord/api/message/attachment/MessageAttachment;Lcom/discord/utilities/textprocessing/MessageRenderContext;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "onResume", "()V", "onPause", "Lcom/discord/stores/StoreUserSettings;", "userSettings", "Lcom/discord/stores/StoreUserSettings;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Lcom/discord/databinding/WidgetChatListAdapterItemAttachmentBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemAttachmentBinding;", "maxAttachmentImageWidth", "I", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment extends WidgetChatListItem implements FragmentLifecycleListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WidgetChatListAdapterItemAttachmentBinding binding;
    private final int maxAttachmentImageWidth;
    private Subscription subscription;
    private final StoreUserSettings userSettings;

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t*\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemAttachment$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/api/message/attachment/MessageAttachment;", "attachment", "", "navigateToAttachment", "(Landroid/content/Context;Lcom/discord/api/message/attachment/MessageAttachment;)V", "", "isInlinedAttachment", "(Lcom/discord/api/message/attachment/MessageAttachment;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                MessageAttachmentType.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
                iArr[MessageAttachmentType.IMAGE.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ boolean access$isInlinedAttachment$p(Companion companion, MessageAttachment messageAttachment) {
            return companion.isInlinedAttachment(messageAttachment);
        }

        public static final /* synthetic */ void access$navigateToAttachment(Companion companion, Context context, MessageAttachment messageAttachment) {
            companion.navigateToAttachment(context, messageAttachment);
        }

        private final boolean isInlinedAttachment(MessageAttachment messageAttachment) {
            return messageAttachment.e() != MessageAttachmentType.FILE;
        }

        private final void navigateToAttachment(Context context, MessageAttachment attachment) {
            int iOrdinal = attachment.e().ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                WidgetMedia.INSTANCE.launch(context, attachment);
            } else {
                UriHandler.handleOrUntrusted$default(context, attachment.getUrl(), null, 4, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureFileData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            TextView textView = (TextView) view;
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            CharSequence text = textView.getText();
            Intrinsics3.checkNotNullExpressionValue(text, "it.text");
            AppToast.c(context, text, 0, 4);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureFileData$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ MessageAttachment $data;

        public AnonymousClass2(MessageAttachment messageAttachment) {
            this.$data = messageAttachment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getEventHandler();
            Uri uri = Uri.parse(this.$data.getUrl());
            Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(data.url)");
            boolean zOnQuickDownloadClicked = eventHandler.onQuickDownloadClicked(uri, this.$data.getFilename());
            ImageView imageView = WidgetChatListAdapterItemAttachment.access$getBinding$p(WidgetChatListAdapterItemAttachment.this).f;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatListItemAttachmentDownload");
            imageView.setEnabled(!zOnQuickDownloadClicked);
            ImageView imageView2 = WidgetChatListAdapterItemAttachment.access$getBinding$p(WidgetChatListAdapterItemAttachment.this).f;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.chatListItemAttachmentDownload");
            imageView2.setAlpha(0.3f);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "invoke", "(Landroid/view/ViewPropertyAnimator;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "invoke", "(Landroid/view/ViewPropertyAnimator;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(0.9f);
            viewPropertyAnimator.scaleY(0.9f);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ AttachmentEntry $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AttachmentEntry attachmentEntry) {
            super(1);
            this.$data = attachmentEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getEventHandler();
            Message message = this.$data.getMessage();
            String content = this.$data.getMessage().getContent();
            if (content == null) {
                content = "";
            }
            eventHandler.onMessageLongClicked(message, content, this.$data.isThreadStarterMessage());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ AttachmentEntry $data;

        public AnonymousClass4(AttachmentEntry attachmentEntry) {
            this.$data = attachmentEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getEventHandler().onMessageClicked(this.$data.getMessage(), this.$data.isThreadStarterMessage());
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ AttachmentEntry $data;
        public final /* synthetic */ Model $model;

        public AnonymousClass5(Model model, AttachmentEntry attachmentEntry) {
            this.$model = model;
            this.$data = attachmentEntry;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getData().getIsSpoilerClickAllowed()) {
                StoreStream.INSTANCE.getMessageState().revealSpoilerEmbed(this.$model.getAttachmentEntry().getMessage().getId(), this.$data.getEmbedIndex());
            } else {
                WidgetChatListAdapterItemAttachment.access$getAdapter$p(WidgetChatListAdapterItemAttachment.this).getEventHandler().onMessageClicked(this.$model.getAttachmentEntry().getMessage(), this.$data.isThreadStarterMessage());
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ MessageAttachment $attachment;

        public AnonymousClass6(MessageAttachment messageAttachment) {
            this.$attachment = messageAttachment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Companion.access$navigateToAttachment(WidgetChatListAdapterItemAttachment.INSTANCE, outline.x(view, "it", "it.context"), this.$attachment);
        }
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemAttachment$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ MessageAttachment $attachment;

        public AnonymousClass7(MessageAttachment messageAttachment) {
            this.$attachment = messageAttachment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Companion.access$navigateToAttachment(WidgetChatListAdapterItemAttachment.INSTANCE, outline.x(view, "it", "it.context"), this.$attachment);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAttachment(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_attachment, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
        this.maxAttachmentImageWidth = embedResourceUtils.computeMaximumImageWidthPx(context);
        View view2 = this.itemView;
        int i = R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view2.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view2.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R.id.chat_list_item_attachment_barrier;
                Barrier barrier = (Barrier) view2.findViewById(R.id.chat_list_item_attachment_barrier);
                if (barrier != null) {
                    i = R.id.chat_list_item_attachment_card;
                    MaterialCardView materialCardView = (MaterialCardView) view2.findViewById(R.id.chat_list_item_attachment_card);
                    if (materialCardView != null) {
                        i = R.id.chat_list_item_attachment_description;
                        TextView textView = (TextView) view2.findViewById(R.id.chat_list_item_attachment_description);
                        if (textView != null) {
                            i = R.id.chat_list_item_attachment_download;
                            ImageView imageView = (ImageView) view2.findViewById(R.id.chat_list_item_attachment_download);
                            if (imageView != null) {
                                i = R.id.chat_list_item_attachment_icon;
                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.chat_list_item_attachment_icon);
                                if (imageView2 != null) {
                                    i = R.id.chat_list_item_attachment_inline_media;
                                    InlineMediaView inlineMediaView = (InlineMediaView) view2.findViewById(R.id.chat_list_item_attachment_inline_media);
                                    if (inlineMediaView != null) {
                                        i = R.id.chat_list_item_attachment_name;
                                        TextView textView2 = (TextView) view2.findViewById(R.id.chat_list_item_attachment_name);
                                        if (textView2 != null) {
                                            i = R.id.chat_list_item_attachment_spoiler;
                                            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.chat_list_item_attachment_spoiler);
                                            if (frameLayout != null) {
                                                i = R.id.uikit_chat_guideline;
                                                Guideline guideline = (Guideline) view2.findViewById(R.id.uikit_chat_guideline);
                                                if (guideline != null) {
                                                    WidgetChatListAdapterItemAttachmentBinding widgetChatListAdapterItemAttachmentBinding = new WidgetChatListAdapterItemAttachmentBinding((ConstraintLayout) view2, viewFindViewById, viewFindViewById2, barrier, materialCardView, textView, imageView, imageView2, inlineMediaView, textView2, frameLayout, guideline);
                                                    Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemAttachmentBinding, "WidgetChatListAdapterIte…entBinding.bind(itemView)");
                                                    this.binding = widgetChatListAdapterItemAttachmentBinding;
                                                    this.userSettings = StoreStream.INSTANCE.getUserSettings();
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
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemAttachment widgetChatListAdapterItemAttachment) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemAttachment.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemAttachmentBinding access$getBinding$p(WidgetChatListAdapterItemAttachment widgetChatListAdapterItemAttachment) {
        return widgetChatListAdapterItemAttachment.binding;
    }

    private final void configureFileData(MessageAttachment data, MessageRenderContext renderContext) {
        TextView textView = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListItemAttachmentName");
        textView.setText(data.getFilename());
        TextView textView2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListItemAttachmentName");
        ViewExtensions.setOnLongClickListenerConsumeClick(textView2, AnonymousClass1.INSTANCE);
        TextView textView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListItemAttachmentDescription");
        textView3.setText(Formatter.formatFileSize(renderContext.getContext(), data.getSize()));
        this.binding.g.setImageResource(EmbedResourceUtils.INSTANCE.getFileDrawable(data.getFilename()));
        ImageView imageView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatListItemAttachmentDownload");
        imageView.setEnabled(true);
        ImageView imageView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.chatListItemAttachmentDownload");
        imageView2.setAlpha(1.0f);
        this.binding.f.setOnClickListener(new AnonymousClass2(data));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(Model model) {
        boolean z2;
        boolean z3;
        AttachmentEntry attachmentEntry = model.getAttachmentEntry();
        MessageAttachment attachment = attachmentEntry.getAttachment();
        MessageRenderContext messageRenderContextCreateRenderContext = model.createRenderContext(outline.x(this.itemView, "itemView", "itemView.context"), ((WidgetChatListAdapter) this.adapter).getEventHandler());
        boolean autoPlayGifs = attachmentEntry.getAutoPlayGifs();
        if (model.getIsSpoilerHidden()) {
            ViewExtensions.fadeIn$default(this.binding.j, 50L, null, AnonymousClass1.INSTANCE, null, 10, null);
        } else {
            ViewExtensions.fadeOut$default(this.binding.j, 200L, AnonymousClass2.INSTANCE, null, 4, null);
        }
        ConstraintLayout constraintLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout, new AnonymousClass3(attachmentEntry));
        this.binding.a.setOnClickListener(new AnonymousClass4(attachmentEntry));
        this.binding.j.setOnClickListener(new AnonymousClass5(model, attachmentEntry));
        boolean z4 = Companion.access$isInlinedAttachment$p(INSTANCE, attachment) && this.userSettings.getIsAttachmentMediaInline();
        if (attachment.getHeight() != null) {
            Integer height = attachment.getHeight();
            Intrinsics3.checkNotNull(height);
            z2 = height.intValue() > 0;
        }
        if (attachment.getWidth() != null) {
            Integer width = attachment.getWidth();
            Intrinsics3.checkNotNull(width);
            z3 = width.intValue() > 0;
        }
        if (z4 && (z3 || z2)) {
            EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
            Integer width2 = attachment.getWidth();
            Intrinsics3.checkNotNull(width2);
            int iIntValue = width2.intValue();
            Integer height2 = attachment.getHeight();
            Intrinsics3.checkNotNull(height2);
            int iIntValue2 = height2.intValue();
            int i = this.maxAttachmentImageWidth;
            int max_image_view_height_px = embedResourceUtils.getMAX_IMAGE_VIEW_HEIGHT_PX();
            InlineMediaView inlineMediaView = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(inlineMediaView, "binding.chatListItemAttachmentInlineMedia");
            Resources resources = inlineMediaView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "binding.chatListItemAtta…mentInlineMedia.resources");
            Tuples2 tuples2CalculateScaledSize$default = EmbedResourceUtils.calculateScaledSize$default(embedResourceUtils, iIntValue, iIntValue2, i, max_image_view_height_px, resources, 0, 32, null);
            int iIntValue3 = ((Number) tuples2CalculateScaledSize$default.component1()).intValue();
            int iIntValue4 = ((Number) tuples2CalculateScaledSize$default.component2()).intValue();
            MaterialCardView materialCardView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.chatListItemAttachmentCard");
            materialCardView.setVisibility(8);
            InlineMediaView inlineMediaView2 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(inlineMediaView2, "binding.chatListItemAttachmentInlineMedia");
            inlineMediaView2.setVisibility(0);
            this.binding.h.updateUIWithAttachment(attachment, Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue4), autoPlayGifs);
        } else {
            MaterialCardView materialCardView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialCardView2, "binding.chatListItemAttachmentCard");
            materialCardView2.setVisibility(0);
            InlineMediaView inlineMediaView3 = this.binding.h;
            Intrinsics3.checkNotNullExpressionValue(inlineMediaView3, "binding.chatListItemAttachmentInlineMedia");
            inlineMediaView3.setVisibility(8);
            InlineMediaView.updateUIWithAttachment$default(this.binding.h, attachment, null, null, autoPlayGifs, 6, null);
        }
        configureFileData(attachment, messageRenderContextCreateRenderContext);
        this.binding.h.setOnClickListener(new AnonymousClass6(attachment));
        this.binding.d.setOnClickListener(new AnonymousClass7(attachment));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onPause() {
        this.binding.h.onPause();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        this.binding.h.onResume();
    }

    /* compiled from: WidgetChatListAdapterItemAttachment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f\u0012\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f\u0012\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b6\u00107J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0010\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0013\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\"\u0010\u0016\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0011J\u0010\u0010\u0017\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018Jx\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\t2\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f2\b\b\u0002\u0010\u001d\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010\u000bR\u001a\u0010+\u001a\u00020&*\u00020\t8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0019\u0010-\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/R+\u0010\u001a\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b1\u0010\u0011R+\u0010\u001b\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u0012\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b2\u0010\u0011R+\u0010\u001c\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b3\u0010\u0011R\u0019\u0010\u001d\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u0010\u0018¨\u00068"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemAttachment$Model;", "", "Landroid/content/Context;", "androidContext", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "eventHandler", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "createRenderContext", "(Landroid/content/Context;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;)Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/chat/list/entries/AttachmentEntry;", "component1", "()Lcom/discord/widgets/chat/list/entries/AttachmentEntry;", "", "", "Lcom/discord/primitives/ChannelId;", "", "component2", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "component3", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component4", "component5", "()J", "attachmentEntry", "channelNames", "userNames", "roles", "myId", "copy", "(Lcom/discord/widgets/chat/list/entries/AttachmentEntry;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;J)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemAttachment$Model;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/list/entries/AttachmentEntry;", "getAttachmentEntry", "isSpoilerEmbedRevealed", "(Lcom/discord/widgets/chat/list/entries/AttachmentEntry;)Z", "isSpoilerHidden", "Z", "()Z", "Ljava/util/Map;", "getChannelNames", "getUserNames", "getRoles", "J", "getMyId", "<init>", "(Lcom/discord/widgets/chat/list/entries/AttachmentEntry;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {
        private final AttachmentEntry attachmentEntry;
        private final Map<Long, String> channelNames;
        private final boolean isSpoilerHidden;
        private final long myId;
        private final Map<Long, GuildRole> roles;
        private final Map<Long, String> userNames;

        public Model(AttachmentEntry attachmentEntry, Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3, long j) {
            Intrinsics3.checkNotNullParameter(attachmentEntry, "attachmentEntry");
            this.attachmentEntry = attachmentEntry;
            this.channelNames = map;
            this.userNames = map2;
            this.roles = map3;
            this.myId = j;
            this.isSpoilerHidden = attachmentEntry.getAttachment().h() && !isSpoilerEmbedRevealed(attachmentEntry);
        }

        public static /* synthetic */ Model copy$default(Model model, AttachmentEntry attachmentEntry, Map map, Map map2, Map map3, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                attachmentEntry = model.attachmentEntry;
            }
            if ((i & 2) != 0) {
                map = model.channelNames;
            }
            Map map4 = map;
            if ((i & 4) != 0) {
                map2 = model.userNames;
            }
            Map map5 = map2;
            if ((i & 8) != 0) {
                map3 = model.roles;
            }
            Map map6 = map3;
            if ((i & 16) != 0) {
                j = model.myId;
            }
            return model.copy(attachmentEntry, map4, map5, map6, j);
        }

        private final boolean isSpoilerEmbedRevealed(AttachmentEntry attachmentEntry) {
            Map<Integer, Set<String>> visibleSpoilerEmbedMap;
            StoreMessageState.State messageState = attachmentEntry.getMessageState();
            return (messageState == null || (visibleSpoilerEmbedMap = messageState.getVisibleSpoilerEmbedMap()) == null || !visibleSpoilerEmbedMap.containsKey(Integer.valueOf(attachmentEntry.getEmbedIndex()))) ? false : true;
        }

        /* renamed from: component1, reason: from getter */
        public final AttachmentEntry getAttachmentEntry() {
            return this.attachmentEntry;
        }

        public final Map<Long, String> component2() {
            return this.channelNames;
        }

        public final Map<Long, String> component3() {
            return this.userNames;
        }

        public final Map<Long, GuildRole> component4() {
            return this.roles;
        }

        /* renamed from: component5, reason: from getter */
        public final long getMyId() {
            return this.myId;
        }

        public final Model copy(AttachmentEntry attachmentEntry, Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles, long myId) {
            Intrinsics3.checkNotNullParameter(attachmentEntry, "attachmentEntry");
            return new Model(attachmentEntry, channelNames, userNames, roles, myId);
        }

        public final MessageRenderContext createRenderContext(Context androidContext, WidgetChatListAdapter.EventHandler eventHandler) {
            Intrinsics3.checkNotNullParameter(androidContext, "androidContext");
            Intrinsics3.checkNotNullParameter(eventHandler, "eventHandler");
            return new MessageRenderContext(androidContext, this.myId, this.attachmentEntry.getAllowAnimatedEmojis(), this.userNames, this.channelNames, this.roles, 0, null, new WidgetChatListAdapterItemAttachment2(eventHandler), 0, 0, null, null, null, 16064, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.attachmentEntry, model.attachmentEntry) && Intrinsics3.areEqual(this.channelNames, model.channelNames) && Intrinsics3.areEqual(this.userNames, model.userNames) && Intrinsics3.areEqual(this.roles, model.roles) && this.myId == model.myId;
        }

        public final AttachmentEntry getAttachmentEntry() {
            return this.attachmentEntry;
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final long getMyId() {
            return this.myId;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, String> getUserNames() {
            return this.userNames;
        }

        public int hashCode() {
            AttachmentEntry attachmentEntry = this.attachmentEntry;
            int iHashCode = (attachmentEntry != null ? attachmentEntry.hashCode() : 0) * 31;
            Map<Long, String> map = this.channelNames;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, String> map2 = this.userNames;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map3 = this.roles;
            return b.a(this.myId) + ((iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31);
        }

        /* renamed from: isSpoilerHidden, reason: from getter */
        public final boolean getIsSpoilerHidden() {
            return this.isSpoilerHidden;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(attachmentEntry=");
            sbU.append(this.attachmentEntry);
            sbU.append(", channelNames=");
            sbU.append(this.channelNames);
            sbU.append(", userNames=");
            sbU.append(this.userNames);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", myId=");
            return outline.C(sbU, this.myId, ")");
        }

        public /* synthetic */ Model(AttachmentEntry attachmentEntry, Map map, Map map2, Map map3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(attachmentEntry, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2, (i & 8) == 0 ? map3 : null, (i & 16) != 0 ? 0L : j);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        AttachmentEntry attachmentEntry = (AttachmentEntry) data;
        Message message = attachmentEntry.getMessage();
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListAdapterItemHighlightedBg");
        View view2 = this.binding.f2309b;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemGutterBg");
        configureCellHighlight(message, view, view2);
        configureUI(new Model(attachmentEntry, null, null, null, 0L, 30, null));
    }
}
