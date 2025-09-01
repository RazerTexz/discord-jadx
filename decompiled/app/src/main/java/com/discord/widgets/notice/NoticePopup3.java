package com.discord.widgets.notice;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

/* compiled from: NoticePopup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/notice/NoticePopup$enqueue$notice$1$3$4", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$$special$$inlined$also$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class NoticePopup3 implements View.OnClickListener {
    public final /* synthetic */ FragmentActivity $activity$inlined;
    public final /* synthetic */ View $view;
    public final /* synthetic */ NoticePopup4 this$0;

    public NoticePopup3(View view, NoticePopup4 noticePopup4, FragmentActivity fragmentActivity) {
        this.$view = view;
        this.this$0 = noticePopup4;
        this.$activity$inlined = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NoticePopup.access$dismiss(NoticePopup.INSTANCE, this.this$0.$noticeName);
        this.this$0.$onClickTopRightIcon.invoke(this.$view);
    }
}
