package com.discord.widgets.hubs;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetHubDomainSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Lcom/discord/widgets/hubs/HubDomainViewHolder;", "invoke", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/discord/widgets/hubs/HubDomainViewHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$adapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDomainSearch2 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetHubDomains4> {
    public final /* synthetic */ WidgetHubDomainSearch this$0;

    /* compiled from: WidgetHubDomainSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/hubs/DomainGuildInfo;", "p1", "", "invoke", "(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDomainSearch$adapter$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubDomains2, Unit> {
        public AnonymousClass1(WidgetHubDomainSearch widgetHubDomainSearch) {
            super(1, widgetHubDomainSearch, WidgetHubDomainSearch.class, "onServerClickListener", "onServerClickListener(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDomains2 widgetHubDomains2) {
            invoke2(widgetHubDomains2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDomains2 widgetHubDomains2) {
            Intrinsics3.checkNotNullParameter(widgetHubDomains2, "p1");
            ((WidgetHubDomainSearch) this.receiver).onServerClickListener(widgetHubDomains2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomainSearch2(WidgetHubDomainSearch widgetHubDomainSearch) {
        super(2);
        this.this$0 = widgetHubDomainSearch;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetHubDomains4 invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDomains4 invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        DiscordHubAddServerListItemBinding discordHubAddServerListItemBindingA = DiscordHubAddServerListItemBinding.a(layoutInflater, viewGroup, false);
        Intrinsics3.checkNotNullExpressionValue(discordHubAddServerListItemBindingA, "DiscordHubAddServerListI…(inflater, parent, false)");
        return new WidgetHubDomains4(discordHubAddServerListItemBindingA, new AnonymousClass1(this.this$0));
    }
}
