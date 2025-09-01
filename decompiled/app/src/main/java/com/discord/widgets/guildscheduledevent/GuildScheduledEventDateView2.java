package com.discord.widgets.guildscheduledevent;

import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventDateView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "com/discord/widgets/guildscheduledevent/GuildScheduledEventDateView$configureCompleteTimeString$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDateView2 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CharSequence $eventEndingTimeString$inlined;
    public final /* synthetic */ CharSequence $eventStartingTimeString$inlined;
    public final /* synthetic */ GuildScheduledEventUtilities2 $timing$inlined;
    public final /* synthetic */ GuildScheduledEventDateView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView2(GuildScheduledEventDateView guildScheduledEventDateView, CharSequence charSequence, CharSequence charSequence2, GuildScheduledEventUtilities2 guildScheduledEventUtilities2) {
        super(1);
        this.this$0 = guildScheduledEventDateView;
        this.$eventStartingTimeString$inlined = charSequence;
        this.$eventEndingTimeString$inlined = charSequence2;
        this.$timing$inlined = guildScheduledEventUtilities2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* compiled from: GuildScheduledEventDateView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "com/discord/widgets/guildscheduledevent/GuildScheduledEventDateView$configureCompleteTimeString$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            List<Object> list = hook.styles;
            GuildScheduledEventDateView2 guildScheduledEventDateView2 = GuildScheduledEventDateView2.this;
            list.add(new ForegroundColorSpan(GuildScheduledEventDateView.access$getTextColorViaTiming(guildScheduledEventDateView2.this$0, guildScheduledEventDateView2.$timing$inlined)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("startHook", new AnonymousClass1());
    }
}
