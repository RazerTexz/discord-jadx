package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventDescriptionParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$MessageRenderContextModel;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$MessageRenderContextModel;)V", "com/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$configureDescription$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser2 extends Lambda implements Function1<GuildScheduledEventDescriptionParser.MessageRenderContextModel, Unit> {
    public final /* synthetic */ List $descriptionAst$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ LinkifiedTextView $this_apply;
    public final /* synthetic */ GuildScheduledEventDescriptionParser this$0;

    /* compiled from: GuildScheduledEventDescriptionParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "spoilerNode", "", "invoke", "(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", "com/discord/widgets/guildscheduledevent/GuildScheduledEventDescriptionParser$configureDescription$1$1$renderContext$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDescriptionParser$configureDescription$$inlined$apply$lambda$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<SpoilerNode<?>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
            GuildScheduledEventDescriptionParser2 guildScheduledEventDescriptionParser2 = GuildScheduledEventDescriptionParser2.this;
            GuildScheduledEventDescriptionParser.access$handleSpoilerClicked(guildScheduledEventDescriptionParser2.this$0, spoilerNode, guildScheduledEventDescriptionParser2.$guildId$inlined);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDescriptionParser2(LinkifiedTextView linkifiedTextView, GuildScheduledEventDescriptionParser guildScheduledEventDescriptionParser, List list, long j) {
        super(1);
        this.$this_apply = linkifiedTextView;
        this.this$0 = guildScheduledEventDescriptionParser;
        this.$descriptionAst$inlined = list;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDescriptionParser.MessageRenderContextModel messageRenderContextModel) {
        invoke2(messageRenderContextModel);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildScheduledEventDescriptionParser.MessageRenderContextModel messageRenderContextModel) {
        Context context = this.$this_apply.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.$this_apply.setDraweeSpanStringBuilder(AstRenderer.render(this.$descriptionAst$inlined, new MessageRenderContext(context, 0L, false, messageRenderContextModel.getUserNames(), messageRenderContextModel.getChannelNames(), messageRenderContextModel.getRoles(), 0, null, null, 0, 0, anonymousClass1, null, null, 14272, null)));
    }
}
