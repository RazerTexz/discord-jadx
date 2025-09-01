package com.discord.widgets.chat.input.autocomplete;

import com.discord.R;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* compiled from: InputAutocomplete.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel;", "invoke", "()Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocomplete2 extends Lambda implements Function0<AutocompleteViewModel> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete2(InputAutocomplete inputAutocomplete) {
        super(0);
        this.this$0 = inputAutocomplete;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AutocompleteViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AutocompleteViewModel invoke() {
        return new AutocompleteViewModel(InputAutocomplete.access$getChannel$p(this.this$0), InputAutocomplete.access$getFlexInputViewModel$p(this.this$0), null, StoreStream.INSTANCE.getExperiments(), ColorCompat.getThemedColor(InputAutocomplete.access$getEditText$p(this.this$0), R.attr.theme_chat_mention_foreground), ColorCompat.getThemedColor(InputAutocomplete.access$getEditText$p(this.this$0), R.attr.colorBackgroundFloating), ColorCompat.getColor(InputAutocomplete.access$getEditText$p(this.this$0), R.color.status_red_500), null, Opcodes.IINC, null);
    }
}
