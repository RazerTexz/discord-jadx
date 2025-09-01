package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/GlobalRoleAutocompletable;", "invoke", "()Lcom/discord/widgets/chat/input/autocomplete/GlobalRoleAutocompletable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GlobalRoleAutocompletable$Companion$everyone$2 extends Lambda implements Function0<GlobalRoleAutocompletable> {
    public static final GlobalRoleAutocompletable$Companion$everyone$2 INSTANCE = new GlobalRoleAutocompletable$Companion$everyone$2();

    public GlobalRoleAutocompletable$Companion$everyone$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GlobalRoleAutocompletable invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GlobalRoleAutocompletable invoke() {
        return new GlobalRoleAutocompletable(ModelGuildMemberListUpdate.EVERYONE_ID);
    }
}
