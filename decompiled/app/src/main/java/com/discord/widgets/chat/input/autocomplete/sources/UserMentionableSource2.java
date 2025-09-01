package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: UserMentionableSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "e", "", "invoke", "(Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$createAutocompletablesForUsers$mentions$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class UserMentionableSource2 extends Lambda implements Function1<Autocompletable, Integer> {
    public final /* synthetic */ int $numPartitions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMentionableSource2(int i) {
        super(1);
        this.$numPartitions = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Autocompletable autocompletable) {
        return Integer.valueOf(invoke2(autocompletable));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(Autocompletable autocompletable) {
        Intrinsics3.checkNotNullParameter(autocompletable, "e");
        if (autocompletable instanceof UserAutocompletable) {
            return (int) ((((UserAutocompletable) autocompletable).getUser().getId() >> 22) % this.$numPartitions);
        }
        return 0;
    }
}
