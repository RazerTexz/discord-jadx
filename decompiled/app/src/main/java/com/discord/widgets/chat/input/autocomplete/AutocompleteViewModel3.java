package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.input.autocomplete.commands.AutocompleteCommandUtils;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: AutocompleteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Ljava/lang/String;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel$applyCommandOptionSpans$1$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AutocompleteViewModel3 extends Lambda implements Function1<String, String> {
    public static final AutocompleteViewModel3 INSTANCE = new AutocompleteViewModel3();

    public AutocompleteViewModel3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        return AutocompleteCommandUtils.INSTANCE.transformParameterSpannableString(str);
    }
}
