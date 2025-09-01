package com.discord.widgets.chat.list.adapter;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.ViewKt;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;

/* compiled from: WidgetChatListAdapterItemInviteBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014Jr\u0010\r\u001a\u00020\f2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042$\b\u0002\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00062$\b\u0002\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0004ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInviteBase;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Ljava/lang/Class;", "javaClass", "Lcom/discord/models/domain/ModelInvite;", "invite", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "onInvitePostSuccess", "onInviteFlowFinished", "Lkotlinx/coroutines/Job;", "joinServerOrDM", "(Ljava/lang/Class;Lcom/discord/models/domain/ModelInvite;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "", "layoutResId", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(ILcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class WidgetChatListAdapterItemInviteBase extends WidgetChatListItem {

    /* compiled from: WidgetChatListAdapterItemInviteBase.kt */
    @DebugMetadata(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$1", f = "WidgetChatListAdapterItemInviteBase.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* compiled from: WidgetChatListAdapterItemInviteBase.kt */
    @DebugMetadata(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$2", f = "WidgetChatListAdapterItemInviteBase.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInviteBase(@LayoutRes int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job joinServerOrDM$default(WidgetChatListAdapterItemInviteBase widgetChatListAdapterItemInviteBase, Class cls, ModelInvite modelInvite, Function2 function2, Function2 function22, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinServerOrDM");
        }
        if ((i & 4) != 0) {
            function2 = new AnonymousClass1(null);
        }
        if ((i & 8) != 0) {
            function22 = new AnonymousClass2(null);
        }
        return widgetChatListAdapterItemInviteBase.joinServerOrDM(cls, modelInvite, function2, function22);
    }

    public final Job joinServerOrDM(Class<?> javaClass, ModelInvite invite, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished) {
        Intrinsics3.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        InviteJoinHelper inviteJoinHelper = InviteJoinHelper.INSTANCE;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return InviteJoinHelper.joinViaInvite$default(inviteJoinHelper, invite, javaClass, (AppFragment) ViewKt.findFragment(view), "Invite Button Embed", null, onInvitePostSuccess, onInviteFlowFinished, null, Opcodes.D2F, null);
    }
}
