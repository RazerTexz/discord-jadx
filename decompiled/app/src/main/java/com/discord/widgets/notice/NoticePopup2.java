package com.discord.widgets.notice;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: NoticePopup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/widgets/notice/NoticePopup$enqueue$notice$1$3$viewAutoDismissAnimator$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NoticePopup2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ FragmentActivity $activity$inlined;
    public final /* synthetic */ NoticePopup4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticePopup2(NoticePopup4 noticePopup4, FragmentActivity fragmentActivity) {
        super(0);
        this.this$0 = noticePopup4;
        this.$activity$inlined = fragmentActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NoticePopup.access$dismiss(NoticePopup.INSTANCE, this.this$0.$noticeName);
    }
}
