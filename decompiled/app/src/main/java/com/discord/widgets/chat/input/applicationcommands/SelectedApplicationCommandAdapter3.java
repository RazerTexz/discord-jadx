package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import com.discord.models.commands.ApplicationCommandOption;
import kotlin.Metadata;

/* compiled from: SelectedApplicationCommandAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/chat/input/applicationcommands/SelectedAppCommandOptionAdapterItem$onConfigure$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedAppCommandOptionAdapterItem$onConfigure$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter3 implements View.OnClickListener {
    public final /* synthetic */ SelectedApplicationCommandAdapter8 $data$inlined;
    public final /* synthetic */ ApplicationCommandOption $option;
    public final /* synthetic */ SelectedApplicationCommandAdapter2 this$0;

    public SelectedApplicationCommandAdapter3(ApplicationCommandOption applicationCommandOption, SelectedApplicationCommandAdapter2 selectedApplicationCommandAdapter2, SelectedApplicationCommandAdapter8 selectedApplicationCommandAdapter8) {
        this.$option = applicationCommandOption;
        this.this$0 = selectedApplicationCommandAdapter2;
        this.$data$inlined = selectedApplicationCommandAdapter8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SelectedApplicationCommandAdapter2.access$getAdapter$p(this.this$0).onParamClicked(this.$option);
    }
}
