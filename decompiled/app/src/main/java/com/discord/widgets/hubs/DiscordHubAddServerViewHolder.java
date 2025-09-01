package com.discord.widgets.hubs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.databinding.DiscordHubAddServerListItemBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.GuildView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DiscordHubAddServerViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR)\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u00040\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/hubs/DiscordHubAddServerViewHolder;", "Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "Lcom/discord/models/guild/Guild;", "data", "", "bind", "(Lcom/discord/models/guild/Guild;)V", "Lcom/discord/databinding/DiscordHubAddServerListItemBinding;", "binding", "Lcom/discord/databinding/DiscordHubAddServerListItemBinding;", "getBinding", "()Lcom/discord/databinding/DiscordHubAddServerListItemBinding;", "Lkotlin/Function1;", "", "Lcom/discord/primitives/GuildId;", "onClickListener", "Lkotlin/jvm/functions/Function1;", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lcom/discord/databinding/DiscordHubAddServerListItemBinding;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DiscordHubAddServerViewHolder extends SimpleRecyclerAdapter.ViewHolder<Guild> {
    private final DiscordHubAddServerListItemBinding binding;
    private final Function1<Long, Unit> onClickListener;

    /* compiled from: DiscordHubAddServerViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.DiscordHubAddServerViewHolder$bind$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Guild $data;

        public AnonymousClass2(Guild guild) {
            this.$data = guild;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DiscordHubAddServerViewHolder.this.getOnClickListener().invoke(Long.valueOf(this.$data.getId()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public DiscordHubAddServerViewHolder(DiscordHubAddServerListItemBinding discordHubAddServerListItemBinding, Function1<? super Long, Unit> function1) {
        Intrinsics3.checkNotNullParameter(discordHubAddServerListItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        FrameLayout frameLayout = discordHubAddServerListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout);
        this.binding = discordHubAddServerListItemBinding;
        this.onClickListener = function1;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public /* bridge */ /* synthetic */ void bind(Guild guild) {
        bind2(guild);
    }

    public final DiscordHubAddServerListItemBinding getBinding() {
        return this.binding;
    }

    public final Function1<Long, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    /* renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(Guild data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordUAddServerListItemText");
        textView.setText(data.getName());
        GuildView guildView = this.binding.f2098b;
        guildView.b();
        guildView.a(IconUtils.getForGuild$default(data, null, false, null, 14, null), data.getShortName());
        this.binding.c.setOnClickListener(new AnonymousClass2(data));
    }
}
