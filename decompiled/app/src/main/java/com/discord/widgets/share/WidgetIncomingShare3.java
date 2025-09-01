package com.discord.widgets.share;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: WidgetIncomingShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "data", "", "isLongPress", "", "invoke", "(Landroid/view/View;ILcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;Z)V", "com/discord/widgets/share/WidgetIncomingShare$configureUi$3$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.share.WidgetIncomingShare$configureUi$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare3 extends Lambda implements Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> {
    public final /* synthetic */ WidgetIncomingShare.Model $this_configureUi$inlined;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* compiled from: WidgetIncomingShare.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "run", "()V", "com/discord/widgets/share/WidgetIncomingShare$configureUi$3$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.share.WidgetIncomingShare$configureUi$$inlined$apply$lambda$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            WidgetIncomingShare.access$getBinding$p(WidgetIncomingShare3.this.this$0).j.scrollTo(0, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare3(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare.Model model) {
        super(4);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), itemDataPayload, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(itemDataPayload, "data");
        if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemUser) && z2) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = ((WidgetGlobalSearchModel.ItemUser) itemDataPayload).getUser().getId();
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
        if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemHeader) || z2) {
            return;
        }
        WidgetIncomingShare.access$getBinding$p(this.this$0).j.post(new AnonymousClass1());
        WidgetIncomingShare.access$getSelectedReceiverPublisher$p(this.this$0).onNext(itemDataPayload);
    }
}
