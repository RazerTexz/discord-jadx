package com.discord.widgets.chat.input.emoji;

import com.discord.models.guild.Guild;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lcom/discord/models/guild/Guild;", "invoke", "(Ljava/lang/Long;)Lcom/discord/models/guild/Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class EmojiPickerViewModel$handleStoreState$unicodeCategoryItems$1 extends FunctionReferenceImpl implements Function1<Long, Guild> {
    public EmojiPickerViewModel$handleStoreState$unicodeCategoryItems$1(LinkedHashMap linkedHashMap) {
        super(1, linkedHashMap, LinkedHashMap.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Guild invoke(Long l) {
        return invoke2(l);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Guild invoke2(Long l) {
        Intrinsics3.checkNotNullParameter(l, "p1");
        return (Guild) ((LinkedHashMap) this.receiver).get(l);
    }
}
