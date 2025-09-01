package com.discord.widgets.voice.feedback;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FeedbackView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/feedback/FeedbackIssue;", "<anonymous parameter 0>", "", "invoke", "(Lcom/discord/widgets/voice/feedback/FeedbackIssue;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.feedback.FeedbackView$IssuesAdapter$onIssueClick$1, reason: use source file name */
/* loaded from: classes.dex */
public final class FeedbackView3 extends Lambda implements Function1<FeedbackIssue, Unit> {
    public static final FeedbackView3 INSTANCE = new FeedbackView3();

    public FeedbackView3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedbackIssue feedbackIssue) {
        invoke2(feedbackIssue);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FeedbackIssue feedbackIssue) {
        Intrinsics3.checkNotNullParameter(feedbackIssue, "<anonymous parameter 0>");
    }
}
