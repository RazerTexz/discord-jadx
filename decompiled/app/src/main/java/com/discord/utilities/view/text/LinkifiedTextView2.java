package com.discord.utilities.view.text;

import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* compiled from: LinkifiedTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/Throwable;)V", "com/discord/utilities/view/text/LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class LinkifiedTextView2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Job $this_apply;
    public final /* synthetic */ LinkifiedTextView.ClickableSpanOnTouchListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView2(Job job, LinkifiedTextView.ClickableSpanOnTouchListener clickableSpanOnTouchListener) {
        super(1);
        this.$this_apply = job;
        this.this$0 = clickableSpanOnTouchListener;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        LinkifiedTextView.ClickableSpanOnTouchListener.access$getJob$p(this.this$0).weakCompareAndSet(this.$this_apply, null);
    }
}
