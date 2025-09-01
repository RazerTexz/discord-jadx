package com.discord.widgets.user;

import com.discord.widgets.user.WidgetUserMentions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$handleLoadError$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetUserMentions.Model.MessageLoader this$0;

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;", "it", "invoke", "(Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;)Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$Model$MessageLoader$handleLoadError$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetUserMentions.Model.MessageLoader.LoadingState, WidgetUserMentions.Model.MessageLoader.LoadingState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ WidgetUserMentions.Model.MessageLoader.LoadingState invoke(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
            return invoke2(loadingState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetUserMentions.Model.MessageLoader.LoadingState invoke2(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
            Intrinsics3.checkNotNullParameter(loadingState, "it");
            return WidgetUserMentions.Model.MessageLoader.LoadingState.copy$default(loadingState, false, false, null, 6, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$handleLoadError$1(WidgetUserMentions.Model.MessageLoader messageLoader) {
        super(0);
        this.this$0 = messageLoader;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.tryLoad(AnonymousClass1.INSTANCE);
    }
}
