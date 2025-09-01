package com.discord.widgets.chat.list.adapter;

import android.text.style.StyleSpan;
import android.view.View;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.message.Message;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemApplicationCommand2 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorTextColor;
    public final /* synthetic */ int $cmdColor;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemApplicationCommand this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemApplicationCommand2(WidgetChatListAdapterItemApplicationCommand widgetChatListAdapterItemApplicationCommand, int i, Message message, int i2) {
        super(1);
        this.this$0 = widgetChatListAdapterItemApplicationCommand;
        this.$authorTextColor = i;
        this.$message = message;
        this.$cmdColor = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameOnClick", new AnonymousClass1());
        renderContext.a("commandNameOnClick", new AnonymousClass2());
    }

    /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

        /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02691 extends Lambda implements Function1<View, Unit> {
            public C02691() {
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
                WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemApplicationCommand.access$getAdapter$p(WidgetChatListAdapterItemApplicationCommand2.this.this$0).getEventHandler();
                WidgetChatListAdapterItemApplicationCommand2 widgetChatListAdapterItemApplicationCommand2 = WidgetChatListAdapterItemApplicationCommand2.this;
                eventHandler.onMessageAuthorAvatarClicked(widgetChatListAdapterItemApplicationCommand2.$message, WidgetChatListAdapterItemApplicationCommand.access$getAdapter$p(widgetChatListAdapterItemApplicationCommand2.this$0).getData().getGuildId());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(WidgetChatListAdapterItemApplicationCommand2.this.$authorTextColor), false, null, new C02691(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Hook, Unit> {

        /* compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2$1, reason: invalid class name */
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
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(WidgetChatListAdapterItemApplicationCommand2.this.$cmdColor), false, null, AnonymousClass1.INSTANCE, 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }
}
