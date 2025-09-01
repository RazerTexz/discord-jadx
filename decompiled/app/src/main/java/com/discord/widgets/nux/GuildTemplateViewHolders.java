package com.discord.widgets.nux;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.nux.GuildTemplatesAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildTemplateViewHolders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/nux/GuildTemplate;", "guildTemplate", "", "bind", "(Lcom/discord/widgets/nux/GuildTemplate;)V", "Lcom/discord/databinding/NuxGuildTemplateCardViewHolderBinding;", "binding", "Lcom/discord/databinding/NuxGuildTemplateCardViewHolderBinding;", "getBinding", "()Lcom/discord/databinding/NuxGuildTemplateCardViewHolderBinding;", "Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;", "callbacks", "Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;", "getCallbacks", "()Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;", "<init>", "(Lcom/discord/databinding/NuxGuildTemplateCardViewHolderBinding;Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.GuildTemplateCardViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildTemplateViewHolders extends RecyclerView.ViewHolder {
    private final NuxGuildTemplateCardViewHolderBinding binding;
    private final GuildTemplatesAdapter.Callbacks callbacks;

    /* compiled from: GuildTemplateViewHolders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.GuildTemplateCardViewHolder$bind$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ GuildTemplates $guildTemplate;

        public AnonymousClass2(GuildTemplates guildTemplates) {
            this.$guildTemplate = guildTemplates;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildTemplateViewHolders.this.getCallbacks().onTemplateClick(this.$guildTemplate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateViewHolders(NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding, GuildTemplatesAdapter.Callbacks callbacks) {
        super(nuxGuildTemplateCardViewHolderBinding.a);
        Intrinsics3.checkNotNullParameter(nuxGuildTemplateCardViewHolderBinding, "binding");
        Intrinsics3.checkNotNullParameter(callbacks, "callbacks");
        this.binding = nuxGuildTemplateCardViewHolderBinding;
        this.callbacks = callbacks;
    }

    public final void bind(GuildTemplates guildTemplate) {
        Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
        TextView textView = this.binding.c;
        textView.setText(guildTemplate.getTitleRes());
        DrawableCompat.setCompoundDrawablesCompat(textView, guildTemplate.getDrawableRes(), 0, R.drawable.icon_carrot, 0);
        this.binding.f2132b.setOnClickListener(new AnonymousClass2(guildTemplate));
    }

    public final NuxGuildTemplateCardViewHolderBinding getBinding() {
        return this.binding;
    }

    public final GuildTemplatesAdapter.Callbacks getCallbacks() {
        return this.callbacks;
    }
}
