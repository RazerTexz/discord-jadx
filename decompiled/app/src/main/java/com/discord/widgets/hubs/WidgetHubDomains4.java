package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubDomains.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R%\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/hubs/HubDomainViewHolder;", "Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "Lcom/discord/widgets/hubs/DomainGuildInfo;", "data", "", "bind", "(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", "Lkotlin/Function1;", "onClickListener", "Lkotlin/jvm/functions/Function1;", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "Lcom/discord/databinding/DiscordHubAddServerListItemBinding;", "binding", "Lcom/discord/databinding/DiscordHubAddServerListItemBinding;", "getBinding", "()Lcom/discord/databinding/DiscordHubAddServerListItemBinding;", "<init>", "(Lcom/discord/databinding/DiscordHubAddServerListItemBinding;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubDomainViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDomains4 extends SimpleRecyclerAdapter.ViewHolder<WidgetHubDomains2> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<WidgetHubDomains2, Unit> onClickListener;

    /* compiled from: WidgetHubDomains.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.HubDomainViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubDomains2 $data;

        public AnonymousClass1(WidgetHubDomains2 widgetHubDomains2) {
            this.$data = widgetHubDomains2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubDomains4.this.getOnClickListener().invoke(this.$data);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubDomains4(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super WidgetHubDomains2, Unit> function1) {
        Intrinsics3.checkNotNullParameter(discordHubAddServerListItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        FrameLayout frameLayout = discordHubAddServerListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout);
        this.binding = discordHubAddServerListItemBinding;
        this.onClickListener = function1;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public /* bridge */ /* synthetic */ void bind(WidgetHubDomains2 widgetHubDomains2) {
        bind2(widgetHubDomains2);
    }

    public final DiscordHubAddServerListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<WidgetHubDomains2, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    /* renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(WidgetHubDomains2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.binding.f2098b.b();
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        this.binding.f2098b.a(data.getIcon(), GuildUtils.computeShortName(data.getName()));
        this.binding.c.setOnClickListener(new AnonymousClass1(data));
    }
}
