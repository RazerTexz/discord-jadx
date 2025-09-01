package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import d0.z.d.AdaptedFunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetHubAddServer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/ViewGroup;", "parent", "Lcom/discord/widgets/hubs/DiscordHubAddServerViewHolder;", "invoke", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/discord/widgets/hubs/DiscordHubAddServerViewHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$adapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddServer4 extends Lambda implements Function2<LayoutInflater, ViewGroup, DiscordHubAddServerViewHolder> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    /* compiled from: WidgetHubAddServer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "p1", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$adapter$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<Long, Unit> {
        public AnonymousClass1(WidgetHubAddServer widgetHubAddServer) {
            super(1, widgetHubAddServer, WidgetHubAddServer.class, "onServerClickListener", "onServerClickListener(JZ)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetHubAddServer.onServerClickListener$default((WidgetHubAddServer) this.receiver, j, false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServer4(WidgetHubAddServer widgetHubAddServer) {
        super(2);
        this.this$0 = widgetHubAddServer;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ DiscordHubAddServerViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DiscordHubAddServerViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingA = DiscordHubAddServerListItemBinding.a(layoutInflater, viewGroup, false);
        Intrinsics3.checkNotNullExpressionValue(discordHubAddServerListItemBindingA, "DiscordHubAddServerListI…tInflater, parent, false)");
        return new DiscordHubAddServerViewHolder(discordHubAddServerListItemBindingA, new AnonymousClass1(this.this$0));
    }
}
