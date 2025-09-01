package com.discord.widgets.hubs;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.y.SelectorBottomSheet;
import b.a.y.SelectorBottomSheet2;
import com.discord.R;
import com.discord.i18n.RenderContext;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* compiled from: WidgetHubEmailFlow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$learnMore$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEmailFlow5 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* compiled from: WidgetHubEmailFlow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$learnMore$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
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
            SelectorBottomSheet.Companion companion = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetHubEmailFlow5.this.this$0.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetHubEmailFlow5.this.this$0.getString(R.string.hub_email_connection_sidebar_learn_more_header);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.hub_e…idebar_learn_more_header)");
            SelectorBottomSheet.Companion.b(companion, childFragmentManager, string, CollectionsJVM.listOf(new SelectorBottomSheet2(null, WidgetHubEmailFlow5.this.this$0.getString(R.string.hub_email_connection_sidebar_description), null, null, null, null, null, Opcodes.LUSHR)), false, null, 16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow5(WidgetHubEmailFlow widgetHubEmailFlow) {
        super(1);
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("{helpdeskArticle}", new AnonymousClass1());
    }
}
