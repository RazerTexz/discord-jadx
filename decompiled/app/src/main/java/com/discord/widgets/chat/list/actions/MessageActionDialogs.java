package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.PublishActionDialog;
import com.discord.widgets.notice.WidgetNoticeDialog;
import d0.Tuples;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: MessageActionDialogs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/list/actions/MessageActionDialogs;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroid/content/Context;", "context", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/app/AppComponent;", "appComponent", "Lkotlin/Function0;", "", "onSuccess", "showPinMessageConfirmation", "(Landroidx/fragment/app/FragmentManager;Landroid/content/Context;Lcom/discord/models/message/Message;Lcom/discord/app/AppComponent;Lkotlin/jvm/functions/Function0;)V", "showPublishMessageConfirmation", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/models/message/Message;Lkotlin/jvm/functions/Function0;)V", "showDeleteMessageConfirmation", "(Landroidx/fragment/app/FragmentManager;Landroid/content/Context;Lcom/discord/models/message/Message;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MessageActionDialogs {
    public static final MessageActionDialogs INSTANCE = new MessageActionDialogs();

    /* compiled from: MessageActionDialogs.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showDeleteMessageConfirmation$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Message $message;
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message, Function0 function0) {
            super(1);
            this.$message = message;
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            StoreStream.INSTANCE.getMessages().deleteMessage(this.$message);
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: MessageActionDialogs.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showPinMessageConfirmation$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isPinned;
        public final /* synthetic */ Message $message;
        public final /* synthetic */ Function0 $onSuccess;

        /* compiled from: MessageActionDialogs.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.actions.MessageActionDialogs$showPinMessageConfirmation$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02611 extends Lambda implements Function1<Void, Unit> {
            public C02611() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r5) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                AppToast.g(anonymousClass1.$context, anonymousClass1.$isPinned ? R.string.message_unpinned : R.string.message_pinned, 0, null, 12);
                AnonymousClass1.this.$onSuccess.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message, boolean z2, AppComponent appComponent, Context context, Function0 function0) {
            super(1);
            this.$message = message;
            this.$isPinned = z2;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            long channelId = this.$message.getChannelId();
            long id2 = this.$message.getId();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.$isPinned ? RestAPI.INSTANCE.getApi().deleteChannelPin(channelId, id2) : RestAPI.INSTANCE.getApi().addChannelPin(channelId, id2), false, 1, null), this.$appComponent, null, 2, null), MessageActionDialogs.INSTANCE.getClass(), view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C02611(), 60, (Object) null);
        }
    }

    private MessageActionDialogs() {
    }

    public final void showDeleteMessageConfirmation(FragmentManager fragmentManager, Context context, Message message, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = context.getString(R.string.delete_message);
        String string2 = context.getString(R.string.delete_message_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.delete_message_body)");
        WidgetNoticeDialog.Companion.show$default(companion, fragmentManager, string, string2, context.getString(R.string.delete), context.getString(R.string.cancel), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1(message, onSuccess))), null, null, null, Integer.valueOf(R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    public final void showPinMessageConfirmation(FragmentManager fragmentManager, Context context, Message message, AppComponent appComponent, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        boolean zAreEqual = Intrinsics3.areEqual(message.getPinned(), Boolean.TRUE);
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = context.getString(zAreEqual ? R.string.unpin_message_title : R.string.pin_message_title);
        String string2 = context.getString(zAreEqual ? R.string.unpin_message_body : R.string.pin_message_body_mobile);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(\n     …age_body_mobile\n        )");
        WidgetNoticeDialog.Companion.show$default(companion, fragmentManager, string, string2, context.getString(zAreEqual ? R.string.unpin : R.string.pin), context.getString(R.string.cancel), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1(message, zAreEqual, appComponent, context, onSuccess))), null, null, null, null, null, null, 0, null, 16320, null);
    }

    public final void showPublishMessageConfirmation(FragmentManager fragmentManager, Message message, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        PublishActionDialog.Companion.show$default(PublishActionDialog.INSTANCE, fragmentManager, message.getId(), message.getChannelId(), onSuccess, null, 16, null);
    }
}
