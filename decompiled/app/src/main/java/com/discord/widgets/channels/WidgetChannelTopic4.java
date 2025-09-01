package com.discord.widgets.channels;

import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelTopic.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "p1", "", "invoke", "(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelTopic$getRenderedTopicForTopic$renderContext$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelTopic4 extends FunctionReferenceImpl implements Function1<SpoilerNode<?>, Unit> {
    public WidgetChannelTopic4(WidgetChannelTopicViewModel widgetChannelTopicViewModel) {
        super(1, widgetChannelTopicViewModel, WidgetChannelTopicViewModel.class, "handleOnIndexClicked", "handleOnIndexClicked(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        Intrinsics3.checkNotNullParameter(spoilerNode, "p1");
        ((WidgetChannelTopicViewModel) this.receiver).handleOnIndexClicked(spoilerNode);
    }
}
